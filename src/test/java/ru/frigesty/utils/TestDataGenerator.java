package ru.frigesty.utils;

import com.github.javafaker.Faker;
import java.util.HashMap;
import java.util.Map;

public class TestDataGenerator {

    public String firstName;
    public String lastName;
    public String userEmail;
    public String userGender;
    public String userNumber;
    public String monthOfBirth;
    public String subject;
    public String hobbies;
    public String pictures;
    public String currentAddress;
    public String randomState;
    public String  randomCity;
    public int yearOfBirth;
    public int dayOfBirth;

    Faker faker = new Faker();

    public TestDataGenerator () {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        userGender = faker.options().option(gender);
        userNumber = "89" + faker.phoneNumber().subscriberNumber(8);
        monthOfBirth = faker.options().option(months);
        yearOfBirth = faker.number().numberBetween(1901, 2023);
        dayOfBirth = generateValidDay(monthOfBirth, yearOfBirth);
        subject = faker.options().option(subjects);
        hobbies = faker.options().option(hobbyOptions);
        pictures = faker.options().option(morePictures);
        currentAddress = faker.address().streetAddress();
        randomState = faker.options().option(stateCities.keySet().toArray(new String[0]));
        randomCity = getRandomCity(randomState);
    }

    public static String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    public static String[] subjects = {"Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
            "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology"};

    public static String[] hobbyOptions = {"Reading", "Sports", "Music"};

    public static String[] gender = {"Male", "Female", "Other"};

    public static String[] morePictures = {"Duck.png", "marina.png", "mem.png"};

    private static final Map<String, String[]> stateCities = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );

    public static String getRandomCity(String state) {
        String[] cities = stateCities.get(state);

        return new Faker().options().option(cities);
    }

    public static int getDaysInMonth(String month, int year) {
        Map<String, Integer> monthDays = new HashMap<>();
        monthDays.put("January", 31);
        monthDays.put("February", isLeapYear(year) ? 29 : 28);
        monthDays.put("March", 31);
        monthDays.put("April", 30);
        monthDays.put("May", 31);
        monthDays.put("June", 30);
        monthDays.put("July", 31);
        monthDays.put("August", 31);
        monthDays.put("September", 30);
        monthDays.put("October", 31);
        monthDays.put("November", 30);
        monthDays.put("December", 31);

        return monthDays.getOrDefault(month, 0);
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private int generateValidDay(String month, int year) {
        int daysInMonth = getDaysInMonth(month, year);
        return faker.number().numberBetween(1, daysInMonth + 1);
    }
}