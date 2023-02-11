package com.wmb.project.web.bot;

import com.wmb.project.domain.dto.BotConfiguration;
import com.wmb.project.domain.dto.NumberUtils;
import com.wmb.project.persistence.IntegrationRepository;
import com.wmb.project.persistence.PersonRepository;
import com.wmb.project.persistence.entity.Integration;
import com.wmb.project.persistence.entity.Person;
import com.wmb.project.persistence.entity.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.servlet.http.HttpSession;
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

            Integration request = processRegisterUser(message);
            showCurrentMenu(message,request);

            //TODO
            if(request.getStep().equals("") && false){
                String text = message.getText();
                if (text.equalsIgnoreCase("/start")){
                    this.processStartCommand(message);
                } else if (text.equalsIgnoreCase("/register")) {
                    this.processRegisterUser(message);
                }
            }
        }
    }

    private Integration processRegisterUser(Message message) {

        Integration integrationUser = integrationRepository.getByChatId(message.getChatId());
        if(integrationUser == null){
            integrationUser = new Integration();
            integrationUser.setChatId(message.getChatId());
            integrationUser.setLogId(message.getFrom().getUserName()!=null ? message.getFrom().getUserName(): message.getFrom().getFirstName()+" "+message.getFrom().getLastName());
            integrationUser.setCreation_date(LocalDateTime.now());
            integrationUser.setStep("");//step 1

            integrationRepository.saveOrUpdate(integrationUser);
            BotUtils.sendMessage(this, "Hola soy WMBot en que puedo ayudarte?", message.getChatId());
            return integrationUser;
        }else{
            //selectCurrentStep(message,integrationUser);
            //BotUtils.sendMessage(this, "Ya se ha creado este usuario "+integrationUser.getLogId(), message.getChatId());
            //showCurrentMenu(message,integrationUser);
            return integrationUser;
        }

    }

    private void processStartCommand(Message message) {
        BotUtils.sendMessage(this, "Bienvenido a  WMB_PROJECT mediante el command /start", message.getChatId());

    }

    private void processCallBack(Update update) {
    }

    private void showCurrentMenu(Message message, Integration integration){
        Person person = personRepository.getByChatId(message.getChatId());


        if(message.getText().equals(Step.HOME)){
            //TODO parameter person will be used after user register
            setStep(integration,Step.HOME,null);
            System.out.println("ENTRO EN EL SWITCHE PADRE NOVE");
        }
        if(person == null){
            //TODO
            String stepSwitchFather = integration.getStep() != null && !integration.getStep().isEmpty() ? integration.getStep().substring(0,1): integration.getStep();

            switch (stepSwitchFather){

                case Step.REGISTER:
                    if(integration.getStep().length() == 1){
                        BotUtils.sendMessage(this,"A continuación ingresaras la información solicitada para registart en WMB...", message.getChatId());
                        BotUtils.sendMessage(this,"Ingresa el nombre", message.getChatId());
                        setStep(integration,Step.REGISTER_USERNAME,null);
                        System.out.println("pa paso algo acá");
                    }else{
                        //String stepSwitchChild = integration.getStep().substring(2);
                        switch (integration.getStep()){
                            case Step.REGISTER_USERNAME:
                                if(message.getText().equals("")){
                                    emptyMessageInFormMethod(message);
                                }

                                person = new Person();
                                person.setUsername(message.getText());
                                personRepository.saveOrUpdate(person);
                                setStep(integration,Step.REGISTER_PASSWORD,null);
                                BotUtils.sendMessage(this,"Ingresa el Password", message.getChatId());
                                BotUtils.sendMessage(this,"Luego de terminar el formulario por seguridad deberias borrar el historial o los mensajes relacionados a este registro", message.getChatId());
                                //String step = message.getText().substring(2);
                                break;
                            case Step.REGISTER_PASSWORD:
                                if(message.getText().equals("")){
                                    emptyMessageInFormMethod(message);
                                }
                                break;
                            case Step.REGISTER_NAME:
                                break;
                            case Step.REGISTER_LAST_NAME:
                                break;
                            case Step.REGISTER_EMAIL:
                                break;
                            case Step.REGISTER_PHONE:
                                break;

                        }
                    }

                    break;
                case Step.LOGIN:
                    break;
                case Step.WEB_PAGE:
                    break;
                default:

                    switch (message.getText()){
                        case Step.REGISTER:
                            setStep(integration,Step.REGISTER,message);
                            break;
                        case Step.LOGIN:
                            setStep(integration,Step.LOGIN,message);
                            break;
                        case Step.WEB_PAGE:
                            setStep(integration,Step.WEB_PAGE,message);
                            break;
                        default:
                            //
                            if(!integration.getStep().equals("") && !message.getText().equals(Step.HOME)){
                                //404 only if is not first message OR message be text 0 (home)
                                defaultMessage404(message);
                            }
                            //first message
                            setStep(integration,Step.HOME,null);


                    }
                    //Only step "" (first interaction) or when user be or wants be in home
                    if (integration.getStep().equals("") || integration.getStep().equals(Step.HOME)){
                        BotUtils.sendMessage(this,
                                "Menú:\n" +
                                        "1. Registrarse\n" +
                                        "2. Iniciar sesión\n" +
                                        "3. Pagina Web", message.getChatId());
                    }

            }


        }else{
            BotUtils.sendMessage(this,"Construyendo menú cuando se registre el usuario a la tabla personas... ", message.getChatId());
        }
    }

    private void emptyMessageInFormMethod(Message message) {
        System.out.println("Envió un texto vacio al register username");
        defaultMessage404(message);
        return;
    }

    private void defaultMessage404(Message message){
        String text = message.getText() != null ? message.getText() : "";
        BotUtils.sendMessage(this, "\""+text+"\" No es una opción correcta", message.getChatId());
    }

    private void setStep(Integration integration, String step, Message message){
        integration.setStep(step);//Paso 1
        integrationRepository.saveOrUpdate(integration);
        if (message != null){
            showCurrentMenu(message,integration);
        }
    }

}