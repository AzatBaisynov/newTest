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


        int country = 104;
        int totalCases = 105;
        int newCases = 106;
        int totalDeaths = 107;
        int newDeaths = 108;
        int totalRecovered = 109;
        int activeCases = 110;


        while (country <= 224) {
            articles.add(new Article(
                    doc.getElementsByTag("td").get(country).text(),
                    checkForNull(doc.getElementsByTag("td").get(totalCases).text()),
                    checkForNull(doc.getElementsByTag("td").get(newCases).text()),
                    checkForNull(doc.getElementsByTag("td").get(totalDeaths).text()),
                    checkForNull(doc.getElementsByTag("td").get(newDeaths).text()),
                    checkForNull(doc.getElementsByTag("td").get(totalRecovered).text()),
                    checkForNull(doc.getElementsByTag("td").get(activeCases).text())));
            country += 13;
            totalCases += 13;
            newCases += 13;
            totalDeaths += 13;
            newDeaths += 13;
            totalRecovered += 13;
            activeCases += 13;
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
        int country = 104;
        int totalCases = 105;
        int newCases = 106;
        int totalDeaths = 107;
        int newDeaths = 108;
        int totalRecovered = 109;
        int activeCases = 110;
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
            country += 13;
            totalCases += 13;
            newCases += 13;
            totalDeaths += 13;
            newDeaths += 13;
            totalRecovered += 13;
            activeCases += 13;
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
        int country = 104;
        int totalCases = 105;
        int newCases = 106;
        int totalDeaths = 107;
        int newDeaths = 108;
        int totalRecovered = 109;
        int activeCases = 110;
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
            country += 13;
            totalCases += 13;
            newCases += 13;
            totalDeaths += 13;
            newDeaths += 13;
            totalRecovered += 13;
            activeCases += 13;
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
    public static Document docMaker(){
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
