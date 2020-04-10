package org.example.dao;

import org.example.repo.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
    public static Article getCountryOfficialTable(String country, String region){
        List<String> list = Changer.getOneCountryList(country, region);
        Article article = new Article(
                list.get(0),
                list.get(1),
                checkForNull(list.get(2)),
                list.get(3),
                checkForNull(list.get(4)),
                list.get(5),
                list.get(6)
        );
        return article;
    }


    public static Article getRussiaOfficialTable() {
        List<String> list = Changer.getOneCountryList("Russia", "Europe");
        Article article = new Article(
                list.get(0),
                list.get(1),
                checkForNull(list.get(2)),
                list.get(3),
                checkForNull(list.get(4)),
                list.get(5),
                list.get(6)
        );
        return article;
    }

    public static Article getKazakhstanOfficialTable() {
        List<String> list = Changer.getOneCountryList("Kazakhstan", "Asia");
        Article article = new Article(
                list.get(0),
                list.get(1),
                checkForNull(list.get(2)),
                list.get(3),
                checkForNull(list.get(4)),
                list.get(5),
                list.get(6)
        );
        return article;
    }

    public static Article getUzbekistanOfficialTable() {
        List<String> list = Changer.getOneCountryList("Uzbekistan", "Asia");
        Article article = new Article(
                list.get(0),
                list.get(1),
                checkForNull(list.get(2)),
                list.get(3),
                checkForNull(list.get(4)),
                list.get(5),
                list.get(6)
        );
        return article;
    }

    public static Article getTurkeyOfficialTable() {
        List<String> list = Changer.getOneCountryList("Turkey", "Asia");
        Article article = new Article(
                list.get(0),
                list.get(1),
                checkForNull(list.get(2)),
                list.get(3),
                checkForNull(list.get(4)),
                list.get(5),
                list.get(6)
        );
        return article;
    }

    public static Article getChinaOfficialTable() {
        List<String> list = Changer.getOneCountryList("China", "Asia");
        Article article = new Article(
                list.get(0),
                list.get(1),
                checkForNull(list.get(2)),
                list.get(3),
                checkForNull(list.get(4)),
                list.get(5),
                list.get(6)
        );
        return article;
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
