package page.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDay(String day, String mount, String year){
        $(".react-datepicker__month-select").selectOption(mount);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
    }
}
