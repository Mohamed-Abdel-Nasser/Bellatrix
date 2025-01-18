package util;

import com.github.javafaker.Faker;

import java.util.Random;

public class Utility {

    public Integer selectRandomInteger(int totalNumbers) {
        Random random = new Random();
        int index = random.nextInt(totalNumbers);
        System.out.println("The selected Random index is " + index);
        return index;
    }

    Faker faker;

    public String enterFirstName() {
        faker = new Faker();
        return faker.name().firstName();
    }

    public String enterLastName() {
        return faker.name().lastName();
    }

    public String enterPostalCode() {
        return faker.address().zipCode();
    }
}
