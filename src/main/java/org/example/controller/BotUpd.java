//public static void runUpdate(Update update){
//        Bot bot = new Bot();
//        Message message = update.getMessage();
//        if(message != null && message.hasText()){
//        switch (message.getText()) {
//        case "/top10" :
//        bot.sendMsgWithReply(message, "вывожу статистику:");
//        List<Article> list = HtmlReader.getOfficialTable();
//        for(int i = 0; i < 10; i++) {
//        bot.sendMsgWithReply(message,list.get(i).toString());
//        }
//        break;
//        case "/kyrgyzstan" :
//        bot.sendMsgWithReply(message, "Статистика по Кыргызстану:");
//        bot.sendMsgWithReply(message, HtmlReader.getKyrgyzOfficialTable().toString());
//        break;
//        case "/start" :
//        bot.sendMsgWithReply(message, "Здравствуйте");
//        break;
//        case "/russia" :
//        bot.sendMsgWithReply(message, "Статистика по России:");
//        bot.sendMsgWithReply(message, HtmlReader.getRussiaOfficialTable().toString());
//default:
//        }
//        if (message.getText().contains("пидр")){
//        bot.sendMsgWithReply(message, "Сам(а) ты пидр");
//        }
//        if (message.getText().contains("Пидр")){
//        bot.sendMsgWithReply(message, "Сам(а) ты пидр");
//        }
//        }
//        System.out.println(message.getText());
//        }


//static void setButtons(SendMessage sendMessage){
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        sendMessage.setReplyMarkup(replyKeyboardMarkup);
//        replyKeyboardMarkup.setSelective(true);
//        replyKeyboardMarkup.setResizeKeyboard(true);
//        replyKeyboardMarkup.setOneTimeKeyboard(false);
//
//        List<KeyboardRow> keyboardRowList = new ArrayList<>();
//        KeyboardRow keyboardFirstRow = new KeyboardRow();
//        KeyboardRow keyboardSecondRow = new KeyboardRow();
//
//        keyboardFirstRow.add(new KeyboardButton("/top10"));
//        keyboardFirstRow.add(new KeyboardButton("/kyrgyzstan"));
//        keyboardSecondRow.add(new KeyboardButton("/russia"));
//
//        keyboardRowList.add(keyboardFirstRow);
//        keyboardRowList.add(keyboardSecondRow);
//        replyKeyboardMarkup.setKeyboard(keyboardRowList);
//}