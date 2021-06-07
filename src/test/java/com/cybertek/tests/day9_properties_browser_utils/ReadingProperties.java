package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void readingFromPropertiesFile() throws IOException {
        //1. Create object of Properties class - comes from java library
        Properties properties = new Properties();

        //2. Open the file using FileInputStream
        //We are trying to open a file, so we need to pass the path
        FileInputStream file = new FileInputStream("configuration.properties");
        //loading file into java memory

        //3. Load the properties object with our file
        properties.load(file);

        //reading from configuration.properties
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("environment - " + properties.getProperty("env"));
    }
    @Test
    public void usingPropertiesMethod(){
        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"env\") = " + ConfigurationReader.getProperty("env"));
        System.out.println("ConfigurationReader.getProperty(\"username\") = " + ConfigurationReader.getProperty("username"));

    }

    }

