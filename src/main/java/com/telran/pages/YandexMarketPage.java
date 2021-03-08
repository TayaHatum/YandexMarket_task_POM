package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class YandexMarketPage extends PageBase {

    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }
    Logger logger = LoggerFactory.getLogger(YandexMarketPage.class);
@FindBy (how = How.XPATH, using = "//span[.='Компьютеры']")
    WebElement computersSection;
@FindBy (how = How.XPATH, using = "//a[contains(@href,'/catalog--planshety/54545/list?hid=6427100')]")
WebElement tabletsSection;
@FindBy (id="glpricefrom")
WebElement minPrice;
@FindBy (id="glpriceto")
WebElement maxPrice;
@FindBy (how = How.XPATH, using = "//article[2]//h3/a/span")
WebElement actualElement;
@FindBy(id="header-search")
WebElement searchFild;
@FindBy(how = How.XPATH, using = "//button[.='Найти']")
WebElement searchButton;
@FindBy (how = How.XPATH,using = "//article[1]//img")
WebElement expectedElement;



    public YandexMarketPage selectedComputer() {
        List<String> tabs= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        computersSection.click();
        logger.info("Computer section selected!");
        return this;
    }

    public YandexMarketPage selectTablets() {
        tabletsSection.click();
        logger.info("Tablets section selected!");
        return this;
    }

    public YandexMarketPage setPriceRange( double min, double max) {
        type(minPrice, String.valueOf(min));
        type(maxPrice, String.valueOf(max));
        logger.info("Price boundaries were set!" + ": " + min + "->" +max);
        return this;
    }
    public YandexMarketPage selectProducer(String text) {
        driver.findElement(By.xpath(String.format("//span[.='%s']",text))).click();
        logger.info("Selected manufacture -->" +text);
        pause(2000);
        return this;
    }

    public boolean varifySearchResult(){

        String text = actualElement.getText();
        System.out.println(text);
        type(searchFild,text);
        searchButton.click();
        System.out.println("*******");
        pause(2000);

        String text2 =expectedElement.getAttribute("alt");
        System.out.println(text2);
        logger.info("Was checked tablet -->" +text);
        logger.info("Test Passed");
        return text.equals(text2);
    }
}
