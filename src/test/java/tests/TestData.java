package tests;

import utils.RandomDataUtils;

public class TestData {

    RandomDataUtils rd = new RandomDataUtils();
    public final String firstName = rd.randomFirstName(),
                        lastName = rd.randomLastName(),
                        email = rd.randomEmail(),
                        gender = rd.randomGender(),
                        phone = rd.randomPhoneNumber(),
                        day = rd.randomBirthDay(),
                        month = rd.randomBirthMonth(),
                        year = rd.randomBirthYear(),
                        subjet = rd.randomSubject(),
                        hobbies = rd.randomHobbie(),
                        image = "test.jpg",
                        address = rd.randomAddres(),
                        state = rd.randomSate(),
                        city = rd.randomCity(state);



}
