package org.example.controller;

import org.example.dao.HtmlReader;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.example.repo.Article;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;

public class BotUpdate {
    public static void runUpdate(Update update){
        Bot bot = new Bot();
        if(update.hasCallbackQuery()){

            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            User user = callbackQuery.getFrom();
            Message message1 = callbackQuery.getMessage();

            switch (data) {
                case "/top10" :
                    bot.sendMsgNoReplyNoButton(message1, "вывожу статистику:");
                    List<Article> list = HtmlReader.getOfficialTable();
                    for(int i = 0; i < 10; i++) {
                        bot.sendMsgNoReplyNoButton(message1,list.get(i).toString());
                    }
                    bot.sendMsgNoReply(message1, "\u2063                                Меню                 \u2063");
                    break;
                case "/kyrgyzstan" :
                    bot.sendMsgNoReplyNoButton(message1, "Статистика по Кыргызстану:");
                    bot.sendMsgNoReply(message1, HtmlReader.getKyrgyzOfficialTable().toString());
                    break;
                case "/russia" :
                    bot.sendMsgNoReplyNoButton(message1, "Статистика по России:");
                    bot.sendMsgNoReply(message1, HtmlReader.getRussiaOfficialTable().toString());
                    break;
            }
        } else {
            if (update.getMessage().getText().contains("Меню") ||
                    update.getMessage().getText().contains("меню") ||
                    update.getMessage().getText().contains("Menu") ||
                    update.getMessage().getText().contains("menu") ||
                    update.getMessage().getText().contains("/start")){
                bot.sendMsgNoReply(update.getMessage(),"\u2063                                Меню                 \u2063");
            }
        }
    }
}
