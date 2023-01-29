package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import static helpers.CustomApiListener.withCustomTemplates;

public class BaseTest {
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    public static void beforeAll(){
        RestAssured.filters(withCustomTemplates());


//        String[] browserSettings = System.getProperty("browser", "chrome 100").split("\\s+");
//        Configuration.browserVersion = System.getProperty("version");
//        Configuration.browserSize = System.getProperty("size", "1920x1080");
//        Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
