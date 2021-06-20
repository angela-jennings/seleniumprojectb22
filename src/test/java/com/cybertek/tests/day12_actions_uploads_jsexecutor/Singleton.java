package com.cybertek.tests.day12_actions_uploads_jsexecutor;

public class Singleton {
    /*
    We will create similar logic we created in Driver utility class.
    But it will be for a String
     */

    //Create private constructor
    private Singleton(){
    }
    //by making the string word private, we ensure that access is only through getter method
    private static String word;

    //Create static getter method
    //allow user access to 'word' in the way we want - by only allowing use of getter method
    public static String getWord(){
        if(word == null){
            System.out.println("First time call. Word object is null. Assigning value to it now");
            word = "something";
        }else{
            System.out.println("word already has a value");
        }

        return word;
    }
}
