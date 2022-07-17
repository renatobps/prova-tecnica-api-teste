package br.com.sicredi.test.utils;


import org.json.JSONObject;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static br.com.sicredi.test.restAssured.UtilsREST.readJsonSimpleDemo;

public class Utils {
    public Utils() {
    }

    public static JSONObject getJson(String nameJson) throws Exception {
        return  readJsonSimpleDemo("src/test/resources/json/"+nameJson+".json");
    }
    public static String getProperties(String propertie) {
        try {
            InputStream inputStream = new FileInputStream("setup.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(propertie);
        } catch (IOException var3) {
            var3.printStackTrace();
            Assert.fail("Error to load properties");
            return "";
        }
    }

    public static void setProperties(String propertie, String valor) {
        try {
            FileInputStream in = new FileInputStream("setup.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream("setup.properties");
            props.setProperty(propertie, valor);
            props.store(out, "Data essencials");
            out.close();
        } catch (IOException var5) {
            var5.printStackTrace();
            Assert.fail("Error to load properties");
        }

    }





}
