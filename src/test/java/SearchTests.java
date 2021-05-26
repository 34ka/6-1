import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    /**
     *
     * @BeforeAll
     *
     *     @BeforeEach
     *               @Test
     *     @AfterEach
     *
     *     @BeforeEach
     *               @Test
     *     @AfterEach
     *
     * @AfterAll
     */

    static Logger logger = LoggerFactory.getLogger(SearchTests.class);

    @BeforeAll
    static void config() {
        logger.info("@BeforeAll method");
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

    @BeforeEach
    void openGooglePage() {
        logger.info("@BeforeEach method");
        open("https://www.google.com/");
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @Test
    void selenideSearchTest() {
        //System.out.println("This is the selenide test!");// тоже самое, что и logger на строчке ниже
        logger.info("This is the selenide test!");
        $(byName("q")).setValue("selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }

    @Test
    void allureSearchTest() {
        logger.info("This is the allure test!");
        $(byName("q")).setValue("Allure testops").pressEnter();
        $("#search").shouldHave(text("qameta.io"));
    }
}

