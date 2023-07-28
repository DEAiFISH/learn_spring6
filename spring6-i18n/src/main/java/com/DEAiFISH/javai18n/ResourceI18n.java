package com.DEAiFISH.javai18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceI18n {
    public static void main(String[] args) {
        ResourceBundle bundle1 = ResourceBundle.getBundle("messages",
                new Locale("zh", "CH"));

        String value1 = bundle1.getString("test");
        System.out.println(value1);

        ResourceBundle bundle2 = ResourceBundle.getBundle("messages",
                new Locale("en", "GB"));

        String value2 = bundle2.getString("test");
        System.out.println(value2);
    }
}
