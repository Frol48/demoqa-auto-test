package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class RandomDataUtils {

    public static Faker faker = new Faker(new Locale("us"));

    String streetAddress = faker.address().streetAddress();

    public String randomFirstName() {return randomFirstNames();}
    public String randomLastName() {return randomLastNames();}
    public String randomEmail() {return randomEmails();}
    public String randomGender() {return randomGenders();}
    public String randomPhoneNumber() {return randomPhoneNumbers();}
    public String randomBirthDay() {return randomDays();}
    public String randomBirthMonth() {return randomMonths();}
    public String randomBirthYear() {return randomYears();}
    public String randomSubject() {return randomSubjects();}
    public String randomHobbie() {return randomHobbies();}
    public String randomAddres() {return randomAddress();}
    public String randomSate() {return randomStates();}
    public String randomCity(String state) {return randomCities(state);}


    private static String randomFirstNames() {
        return faker.name().firstName();
    }

    private static String randomLastNames() {
        return faker.name().lastName();
    }

    private static String randomEmails() {
        return faker.internet().emailAddress();
    }

    private static String randomGenders() {
        String[] gender = {"Male", "Female", "Other"};
        return faker.options().option(gender);
    }

    private static String randomPhoneNumbers() {
        return faker.phoneNumber().subscriberNumber(10);
    }
    private static String randomDays() {
        int day = faker.number().numberBetween(1, 28);
        return day < 10 ? "0" + day : String.valueOf(day);
    }
    private static String randomMonths() {
        String[] month = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"};
        return faker.options().option(month);
    }

    private static String randomYears() {
        int year = faker.number().numberBetween(1900, 2100);
        return String.valueOf(year);
    }

    private static String randomSubjects() {
        String[] subjects = {"Maths", "Chemistry", "Computer Science", "Economics"};
        return faker.options().option(subjects);
    }
    private static String randomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    private static String randomAddress() {
        return faker.address().streetAddress();
    }

    private String randomStates() {
        return faker.options().option(statesAndCities.keySet().toArray(new String[0]));
    }

    private String randomCities(String state) {
        return faker.options().option(statesAndCities.get(state));
    }

    private final Map<String, String[]> statesAndCities = new HashMap<>();

    {
        statesAndCities.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        statesAndCities.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        statesAndCities.put("Haryana", new String[]{"Karnal", "Panipat"});
        statesAndCities.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }


}

