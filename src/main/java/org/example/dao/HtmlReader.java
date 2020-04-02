package org.example.dao;

import org.example.repo.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlReader {
    public static List<Article> getOfficialTable() {
        List<Article> articles = new ArrayList<>();
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int country = 0;
        int totalCases = 1;
        int newCases = 2;
        int totalDeaths = 3;
        int newDeaths = 4;
        int totalRecovered = 5;
        int activeCases = 6;

        while (0 < 1) {
            articles.add(new Article(
                    doc.getElementsByTag("td").get(country).text(),
                    checkForNull(doc.getElementsByTag("td").get(totalCases).text()),
                    checkForNull(doc.getElementsByTag("td").get(newCases).text()),
                    checkForNull(doc.getElementsByTag("td").get(totalDeaths).text()),
                    checkForNull(doc.getElementsByTag("td").get(newDeaths).text()),
                    checkForNull(doc.getElementsByTag("td").get(totalRecovered).text()),
                    checkForNull(doc.getElementsByTag("td").get(activeCases).text())));
            country += 10;
            totalCases += 10;
            newCases += 10;
            totalDeaths += 10;
            newDeaths += 10;
            totalRecovered += 10;
            activeCases += 10;
            if (doc.getElementsByTag("td").get(country).text().contains("Total:")){
                break;
            }
        }
        for (Article a: articles){
            System.out.println(a);
        }
        return articles;
    }

    public static Article kyrgystanStat(){
        for (Article a : getOfficialTable()){
            if (a.getCountry().equals("Kyrgyzstan"))
                return a;
        }
        return null;
    }
    public static String checkForNull(String str){
        if (str.equals("")){
            return "0";
        }
        return str;
    }
}
