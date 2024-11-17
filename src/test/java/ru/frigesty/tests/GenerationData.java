package ru.frigesty.tests;

import com.github.javafaker.Faker;

import static ru.frigesty.tests.TestData.*;
import static ru.frigesty.utils.DateUtils.getDaysInMonth;
import static ru.frigesty.utils.RandomUtils.getRandomCity;

public class GenerationData {

    Faker faker = new Faker();

    public final String firstName,
                        lastName,
                        userEmail,
                        userGender,
                        userNumber,
                        monthOfBirth,
                        subject,
                        hobbies,
                        pictures,
                        currentAddress,
                        randomState,
                        randomCity;
    public final int    yearOfBirth,
                        dayOfBirth;

    public GenerationData () {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        userGender = faker.options().option(gender);
        userNumber = "89" + faker.phoneNumber().subscriberNumber(8);
        monthOfBirth = faker.options().option(months);
        yearOfBirth = faker.number().numberBetween(1901, 2023);
        dayOfBirth = generateValidDay(monthOfBirth, yearOfBirth);
        subject = faker.options().option(subjects);
        hobbies = faker.options().option(TestData.hobbies);
        pictures = faker.options().option(morePictures);
        currentAddress = faker.address().streetAddress();
        randomState = faker.options().option(states);
        randomCity = getRandomCity(randomState);
    }

    private int generateValidDay(String month, int year) {
        int daysInMonth = getDaysInMonth(month, year);
        return faker.number().numberBetween(1, daysInMonth + 1);
    }
}