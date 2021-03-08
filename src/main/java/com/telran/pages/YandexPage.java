package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class YandexPage extends PageBase{
    public YandexPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (how = How.XPATH, using = "//div[@class='services-new__item-title'][.='Маркет']")
    WebElement toMarket;

    public YandexMarketPage novigateToMarket(){
        toMarket.click();
        return new YandexMarketPage(driver);
    }
}
