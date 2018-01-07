package com.AdidasTask.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static String base_url="";
    public static String browser_type="";


    static{

        Properties p=new Properties();

        try {
            p.load(new FileInputStream((System.getProperty("user.dir")+"/src/test/resources/config.properties")));
            base_url=p.getProperty("base_url");
            browser_type=p.getProperty("browser");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
