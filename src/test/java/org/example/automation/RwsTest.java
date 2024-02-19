package org.example.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class RwsTest {

    private WebDriver driver = WebDriverManager.firefoxdriver().create();
    @Test
    public void findPhilosophyTest() {
        WikiPage page = new WikiPage(driver);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        page.openMainMenu();
        page.openRandomArticle();
        int redirects = 0;
        while (!page.getTitle().toLowerCase().contains("philosophy")) {
            String oldTitle = page.getTitle();
            page.clickFirstLink();
            String newTitle = page.getTitle();
            if (oldTitle.equals(newTitle)) {
                System.err.println("Endless loop, please try again");
                return;
            }
            redirects = redirects + 1;
            System.out.println("Redirect number " + redirects + " to page: " + page.getTitle());
        }

        System.out.println("A page about philosophy was found after " + redirects + " redirects");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}



