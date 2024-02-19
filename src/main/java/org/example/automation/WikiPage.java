package org.example.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class WikiPage {
        private WebDriver webDriver;

        public WikiPage(WebDriver driver) {
            webDriver = driver;
        }

        public WikiPage clickFirstLink() {
            webDriver.findElement(By.xpath("//div[@id=\"mw-content-text\"]//p/a")).click();
            return this;
        }

        public WikiPage openMainMenu() {
            webDriver.findElement(By.id("vector-main-menu-dropdown")).click();
            return this;
        }

        public WikiPage openRandomArticle() {
            webDriver.findElement(By.id("n-randompage")).click();
            return this;
        }

        public String getTitle() {
            return webDriver.getTitle();
        }


    }
