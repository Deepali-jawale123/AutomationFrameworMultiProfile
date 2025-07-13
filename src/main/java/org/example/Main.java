package org.example;

import org.testng.TestNG;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.setProperty("env", System.getProperty("env", "dev"));
        Config.load();

        TestNG testng = new TestNG();
        testng.setTestSuites(Collections.singletonList("testng.xml"));
        testng.run();
    }
}
