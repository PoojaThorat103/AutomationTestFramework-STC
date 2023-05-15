package com.demo.utils;

import com.demo.utils.DriverFactory;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
    public String getProperties(String key) {
        Properties prop = new Properties();
        String value = null;
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop.load(resourceAsStream);
            value = prop.getProperty(key);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return value;
    }
}
