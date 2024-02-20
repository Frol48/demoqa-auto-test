package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setUserEmail("AlexEgorov@example.com")
                .setGender("Male")
                .setUserNumber("9005001020")
                .setBirthDay("10", "November", "1999")
                .setSubjects("en")
                .setHobbies("Sports")
                .setHobbies("Music")
                .uploadPicture("test.jpg")
                .setCurrentAddress("test 123 testtset")
                .setState("NCR")
                .setCity("Noida")
                .setSubmit();

        registrationPage.checkResultRegistration("Student Name", "Alex Egorov")
                .checkResultRegistration("Student Email","AlexEgorov@example.com")
                .checkResultRegistration("Gender","Male")
                .checkResultRegistration("Mobile","9005001020")
                .checkResultRegistration("Date of Birth","10 November,1999")
                .checkResultRegistration("Subjects","English")
                .checkResultRegistration("Hobbies","Sports, Music")
                .checkResultRegistration("Picture","test.jpg")
                .checkResultRegistration("Address","test 123 testtset")
                .checkResultRegistration("State and City","NCR Noida");
    }
}


