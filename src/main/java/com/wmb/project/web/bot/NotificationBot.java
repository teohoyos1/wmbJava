package com.wmb.project.web.bot;

import com.wmb.project.domain.dto.BotConfiguration;
import com.wmb.project.persistence.IntegrationRepository;
import com.wmb.project.persistence.PersonRepository;
import com.wmb.project.persistence.entity.Integration;
import com.wmb.project.persistence.entity.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;

@Component
public class NotificationBot extends TelegramLongPollingBot {

    @Autowired
    private BotConfiguration botConfiguration;

    @Autowired
    private IntegrationRepository integrationRepository;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public String getBotUsername() {
        return botConfiguration.getUsername();
    }

    @Override
    public String getBotToken() {
        return botConfiguration.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update != null){
            if(update.hasMessage()){
                this.processMessage(update);
            } else if (update.hasCallbackQuery()) {
                this.processCallBack(update);
            }
        }
    }

    private void processMessage(Update update) {

        if(update != null && update.hasMessage()){
            Message message = update.getMessage();

            if(processRegisterUser(message)){
                BotUtils.sendMessage(this, "Hola soy WMBot en que puedo ayudarte?", message.getChatId());
            }else{
                String text = message.getText();
                if (text.equalsIgnoreCase("/start")){
                    this.processStartCommand(message);
                } else if (text.equalsIgnoreCase("/register")) {
                    this.processRegisterUser(message);
                }
            }
        }
    }

    private boolean processRegisterUser(Message message) {

        Integration integrationUser = integrationRepository.getByChatId(message.getChatId());
        if(integrationUser == null){
            integrationUser = new Integration();
            integrationUser.setChatId(message.getChatId());
            integrationUser.setLogId(message.getFrom().getUserName()!=null ? message.getFrom().getUserName(): message.getFrom().getFirstName()+" "+message.getFrom().getLastName());
            integrationUser.setCreation_date(LocalDateTime.now());
            integrationUser.setStep(Step.HOME);//step 1

            integrationRepository.saveOrUpdate(integrationUser);
            return true;
        }else{
            BotUtils.sendMessage(this, "Ya se ha creado este usuario "+integrationUser.getLogId(), message.getChatId());
            return false;
        }

    }

    private void processStartCommand(Message message) {
        BotUtils.sendMessage(this, "Bienvenido a  WMB_PROJECT mediante el command /start", message.getChatId());

    }

    private void processCallBack(Update update) {
    }

}
