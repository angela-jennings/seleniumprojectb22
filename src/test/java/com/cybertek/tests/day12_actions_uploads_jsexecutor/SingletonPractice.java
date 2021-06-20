package com.cybertek.tests.day12_actions_uploads_jsexecutor;

import org.testng.annotations.Test;

public class SingletonPractice {
    @Test (priority = 2)
    public void understandingSingletonTC1(){
        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);
    }

    @Test (priority = 1)
    public void understandingSingletonTC2(){
        String str4 = Singleton.getWord();
        System.out.println("str4 = " + str4);
    }
}
