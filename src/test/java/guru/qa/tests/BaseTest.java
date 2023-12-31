package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {


    @BeforeAll
    static void beforeAll() {
        System.setProperty("selenide.browser", "Chrome");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1800";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
    }

}
