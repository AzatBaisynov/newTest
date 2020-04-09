package org.example.dao;

public class Changer {
    static String stringChanger(String str){
        str.replaceAll("<>tr<>", "");
        return str;
    }
}
