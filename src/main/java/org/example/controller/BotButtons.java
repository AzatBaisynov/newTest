package org.example.controller;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BotButtons {
    static void setButtons(SendMessage sendMessage){
        //button
        InlineKeyboardButton topButton = new InlineKeyboardButton();
        topButton.setText("            Топ 10            ");
        topButton.setCallbackData("/top10");

        InlineKeyboardButton kyrButton = new InlineKeyboardButton();
        kyrButton.setText("       Кыргызстан        ");
        kyrButton.setCallbackData("/kyrgyzstan");

        InlineKeyboardButton russButton = new InlineKeyboardButton();
        russButton.setText("  Россия  ");
        russButton.setCallbackData("/russia");
        //
        //row
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(topButton);
        row.add(kyrButton);

        List<InlineKeyboardButton> row1 = new LinkedList<>();
        row1.add(russButton);
        //ROW COLLECTION
        List<List<InlineKeyboardButton>> rowCollection = new LinkedList<>();
        rowCollection.add(row);
        rowCollection.add(row1);
        //keyboard
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowCollection);

        //
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
    }
}
