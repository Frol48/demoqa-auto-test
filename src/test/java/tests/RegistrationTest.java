package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import utils.RandomDataUtils;

public class RegistrationTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    TestData td = new TestData();



    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(td.firstName)
                .setLastName(td.lastName)
                .setUserEmail(td.email)
                .setGender(td.gender)
                .setUserNumber(td.phone)
                .setBirthDay(td.day, td.month, td.year)
                .setSubjects(td.subjet)
                .setHobbies(td.hobbies)
                .uploadPicture(td.image)
                .setCurrentAddress(td.address)
                .setState(td.state)
                .setCity(td.city)
                .setSubmit();

        registrationPage.checkResultRegistration("Student Name", td.firstName + " " + td.lastName)
                .checkResultRegistration("Student Email",td.email)
                .checkResultRegistration("Gender",td.gender)
                .checkResultRegistration("Mobile",td.phone)
                .checkResultRegistration("Date of Birth",td.day + " " + td.month + "," + td.year)
                .checkResultRegistration("Subjects",td.subjet)
                .checkResultRegistration("Hobbies",td.hobbies)
                .checkResultRegistration("Picture",td.image)
                .checkResultRegistration("Address",td.address)
                .checkResultRegistration("State and City",td.state + " " + td.city);
    }
}


