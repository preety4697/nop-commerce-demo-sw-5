package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DesktopsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//select[@id='products-orderby']")
    WebElement sortByPosition;

    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']/a")
    WebElement productArrangement;

    @CacheLookup
    @FindBy(xpath = "//div[@class='details']//button[@type='button']")
    WebElement addToCart;

    public void selectSortByPosition(String value) {
        selectByValueFromDropDown(sortByPosition, value);
    }

    public List<WebElement> returnListOfProductNamesElementsLocator() {
        List<WebElement> listOfElement = driver.findElements(By.xpath("//h2[@class='product-title']/a"));
        return listOfElement;
    }

    public void addToCartClick() {
        clickOnElement(addToCart);
    }
}
