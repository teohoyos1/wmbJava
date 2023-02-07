package com.wmb.project.web.bot;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotUtils {

    public static void sendMessage(DefaultAbsSender defaultAbsSender, String text, Long chatId){
        sendMessage(defaultAbsSender, text, chatId, null);
    }
    public static void sendMessage(DefaultAbsSender defaultAbsSender, String text, Long chatId, String parseMode){
        SendMessage message1 = new SendMessage();
        message1.setParseMode(parseMode);
        message1.setText(text);
        message1.setChatId(chatId.toString());

        sendMessage(defaultAbsSender, message1);

    }

    private static void sendMessage(DefaultAbsSender defaultAbsSender, SendMessage message){
        try {
            defaultAbsSender.execute(message);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
