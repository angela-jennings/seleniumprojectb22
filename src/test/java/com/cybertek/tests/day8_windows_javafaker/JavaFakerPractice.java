package com.cybertek.tests.day8_windows_javafaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {
    @Test
    public void test1(){
        Faker faker = new Faker();
        String character = faker.harryPotter().character();
        System.out.println(character);

        String location = faker.harryPotter().location();
        System.out.println(location);

        String spell = faker.harryPotter().spell();
        System.out.println(spell);

        String hobbit = faker.hobbit().character();
        System.out.println(hobbit);

        String fact = faker.chuckNorris().fact();
        System.out.println("fact = " + fact);
    }
}
