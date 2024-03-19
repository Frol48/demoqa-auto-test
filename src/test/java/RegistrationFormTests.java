import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void fillFormTest() {

        step("Открываем страницу с формой регистрации", () -> {
            open("/automation-practice-form");
        });

        step("Удаляем со страницы мешающие элементы", () -> {
            executeJavaScript("$('#RightSide_Advertisement').remove()");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");   //убирает банеры со страницы которые мешают нажатию кнопок
        });


        step("Вводим значения в форму регистрации", () -> {
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
        });

        step("Проверяем значения в форме", () -> {
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
        });
    }
}


