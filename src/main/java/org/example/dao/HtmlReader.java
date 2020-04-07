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

        int country = 12;
        int totalCases = 13;
        int newCases = 14;
        int totalDeaths = 15;
        int newDeaths = 16;
        int totalRecovered = 17;
        int activeCases = 18;

        while (0 < 1) {
            articles.add(new Article(
                    doc.getElementsByTag("td").get(country).text(),
                    checkForNull(doc.getElementsByTag("td").get(totalCases).text()),
                    checkForNull(doc.getElementsByTag("td").get(newCases).text()),
                    checkForNull(doc.getElementsByTag("td").get(totalDeaths).text()),
                    checkForNull(doc.getElementsByTag("td").get(newDeaths).text()),
                    checkForNull(doc.getElementsByTag("td").get(totalRecovered).text()),
                    checkForNull(doc.getElementsByTag("td").get(activeCases).text())));
            country += 12;
            totalCases += 12;
            newCases += 12;
            totalDeaths += 12;
            newDeaths += 12;
            totalRecovered += 12;
            activeCases += 12;
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
