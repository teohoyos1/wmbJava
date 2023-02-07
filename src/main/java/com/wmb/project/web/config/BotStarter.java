package com.wmb.project.web.config;

import com.wmb.project.web.bot.NotificationBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotStarter implements CommandLineRunner {

    @Autowired
    private NotificationBot notificationBot;

    @Override
    public void run(String... args) throws Exception {
        try {
            //Create a instance bot
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

            telegramBotsApi.registerBot(notificationBot);
        }catch (TelegramApiException e){
            e.printStackTrace();

        }
    }
}
