package org.example.controller;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

//import java.util.List;

import static org.example.controller.BotButtons.setButtons;
import static org.example.controller.BotUpdate.runUpdate;

public class Bot extends TelegramLongPollingBot {
    public void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            setButtons(sendMessage);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        runUpdate(update);
    }

//    public void onUpdatesReceived(List<Update> updates) {
//
//    }

    public String getBotUsername() {
        return "SabiraBot";
    }

    public String getBotToken() {
        return "1129590039:AAEEuPV4kVjkrxuVVtC-b_T6nlRZSChOGWE";
    }
}
