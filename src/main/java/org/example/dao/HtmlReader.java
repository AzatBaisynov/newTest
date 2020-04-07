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


        while (country <= 120) {
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
//            if (doc.getElementsByTag("td").get(country).text().contains("Total:")){
//                break;
//            }
        }
        for (Article a: articles){
            System.out.println(a);
        }
        return articles;
    }


    public static Article getKyrgyzOfficialTable() {
        int country = 12;
        int totalCases = 13;
        int newCases = 14;
        int totalDeaths = 15;
        int newDeaths = 16;
        int totalRecovered = 17;
        int activeCases = 18;
        List<Article> articles = new ArrayList<>();
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

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


//        kyrgystan.setCountry(doc.getElementsByTag("td").get(country).text());
//        kyrgystan.setTotalCases(checkForNull(doc.getElementsByTag("td").get(country+1).text()));
//        kyrgystan.setNewCases(checkForNull(doc.getElementsByTag("td").get(country+2).text()));
//        kyrgystan.setTotalDeaths(checkForNull(doc.getElementsByTag("td").get(country+3).text()));
//        kyrgystan.setNewDeaths(checkForNull(doc.getElementsByTag("td").get(country+4).text()));
//        kyrgystan.setTotalRecovered(checkForNull(doc.getElementsByTag("td").get(country+5).text()));
//        kyrgystan.setActiveCases(checkForNull(doc.getElementsByTag("td").get(country+6).text()));
        for (Article a: articles){
            if(a.getCountry().contains("Kyrgyzstan"))
                return a;
        }
        return null;
    }

    public static Article getRussiaOfficialTable() {
        int country = 12;
        int totalCases = 13;
        int newCases = 14;
        int totalDeaths = 15;
        int newDeaths = 16;
        int totalRecovered = 17;
        int activeCases = 18;
        List<Article> articles = new ArrayList<>();
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

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


//        kyrgystan.setCountry(doc.getElementsByTag("td").get(country).text());
//        kyrgystan.setTotalCases(checkForNull(doc.getElementsByTag("td").get(country+1).text()));
//        kyrgystan.setNewCases(checkForNull(doc.getElementsByTag("td").get(country+2).text()));
//        kyrgystan.setTotalDeaths(checkForNull(doc.getElementsByTag("td").get(country+3).text()));
//        kyrgystan.setNewDeaths(checkForNull(doc.getElementsByTag("td").get(country+4).text()));
//        kyrgystan.setTotalRecovered(checkForNull(doc.getElementsByTag("td").get(country+5).text()));
//        kyrgystan.setActiveCases(checkForNull(doc.getElementsByTag("td").get(country+6).text()));
        for (Article a: articles){
            if(a.getCountry().contains("Russia"))
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
