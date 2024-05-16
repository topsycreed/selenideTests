import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

class SimpleTests {
    @Test
    void test() {
        String url = "https://bonigarcia.dev/selenium-webdriver-java/";
        String input = "testText";

        open(url);
        $(By.xpath("//a[text() = 'Web form']")).click();
        var textInput = $(By.cssSelector("#my-text-id123"));
        textInput.setValue(input);

        Assertions.assertEquals(url(), url + "web-form.html");
        Assertions.assertEquals(textInput.getAttribute("value"), input);
    }
}
