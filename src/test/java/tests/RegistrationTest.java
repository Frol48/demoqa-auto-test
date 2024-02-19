package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends TestBase{

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");   //убирает банеры со страницы которые мешают нажатию кнопок

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("AlexEgorov@example.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("en").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-3").parent().click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("test 123 testtset");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();




        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave( 
                text("Alex Egorov"),
                text("AlexEgorov@example.com"),
                text("Male"),
                text("1234567890"),
                text("10 November,1999"),
                text("English"),
                text("Sports, Music"),
                text("test.jpg"),
                text("test 123 testtset"),
                text("NCR Noida")
        );
    }
}


