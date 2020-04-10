package org.example.dao;

import org.example.repo.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;

public class Changer {
    static List kyrgyzstanList(){
        Document doc = null;
        try { doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get(); }
        catch (IOException e) { e.printStackTrace(); }

        LinkedList<String> list = new LinkedList<>();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        String s = doc.getElementsByTag("td").text();
        String sub = s.substring(s.indexOf("Kyrgyzstan"), s.length());
        String sub1 = sub.substring(sub.indexOf("Kyrgyzstan"), sub.indexOf("Asia"));
        String[] sub2 = sub1.split(" ");
        for (int i = 0; i < sub2.length; i++){
            set.add(sub2[i]);
        }
        set.forEach(x -> list.add(x));
        return list;
    }

    static List russiaList(){
        Document doc = null;
        try { doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get(); }
        catch (IOException e) { e.printStackTrace(); }

        LinkedList<String> list = new LinkedList<>();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        String s = doc.getElementsByTag("td").text();
        String sub = s.substring(s.indexOf("Russia"), s.length());
        String sub1 = sub.substring(sub.indexOf("Russia"), sub.indexOf("Europe"));
        String[] sub2 = sub1.split(" ");
        for (int i = 0; i < sub2.length; i++){
            set.add(sub2[i]);
        }
        set.forEach(x -> list.add(x));
        return list;
    }
}
