package org.example.controller;

import org.example.dao.HtmlReader;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.example.repo.Article;
import java.util.List;

public class BotUpdate {
    public static void runUpdate(Update update){
        Bot bot = new Bot();
        Message message = update.getMessage();
        if(message != null && message.hasText()){
            switch (message.getText()) {
                case "/top10" :
                    bot.sendMsg(message, "вывожу статистику:");
                    List<Article> list = HtmlReader.getOfficialTable();
                    for(int i = 0; i < 10; i++) {
                        bot.sendMsg(message,list.get(i).toString());
                    }
                    break;
                case "/kyrgyzstan" :
                    bot.sendMsg(message, "Статистика по кыргызстану:");
                    bot.sendMsg(message, HtmlReader.kyrgystanStat().toString());
                    break;
                case "/start" :
                    bot.sendMsg(message, "Здравствуйте");
                    break;
                default:
            }
            if (message.getText().contains("пидр")){
                bot.sendMsg(message, "Сам(а) ты пидр");
            }
            if (message.getText().contains("Пидр")){
                bot.sendMsg(message, "Сам(а) ты пидр");
            }
        }
        System.out.println(message.getText());
    }
}
