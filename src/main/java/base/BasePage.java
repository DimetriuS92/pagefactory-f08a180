package base;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePage {
    private WebDriver driver;

    public BasePage() {
        driver = BaseTest.getDriver();

    }
    public void getURL(String urlString) {
        driver.get(urlString);
    }


    public void waitForVisibilityOfElement(WebElement element, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(visibilityOf(element));
        } catch (NoSuchElementException e) {

            throw e;
        }
    }

    public String getElementText(WebElement element) {
        waitForVisibilityOfElement(element, 100);
        return element.getText();
    }



    public void clickOnVisibleElement(WebElement element) {
        waitForVisibilityOfElement(element, 10);
        element.click();
    }

    public void sendKeys(WebElement element, String string) {
        waitForVisibilityOfElement(element, 10);
        element.sendKeys(string);
    }

    public void showPrices(ArrayList<Double> list) {
        for (Double e : list) {
            System.out.println(e + " $");
        }
    }

    public ArrayList<Double> getPricesList(List<WebElement> list) {
        ArrayList<Double> prices = new ArrayList();
        for (WebElement e : list) {
            String s = e.toString().replaceAll("[^0-9]", "");
            double i = Double.parseDouble(s);
            prices.add(i);
        }
        return (prices);
    }


    public void showPricesSum(List<Double> list, double limit) {
        double sum = 0;
        for (double i : list) {
            if (i > limit) {
                sum += i;
            } else
                sum += 0;

        }
        if (sum == 0) {
            System.out.println("No Such items");
        } else
            System.out.println("Price sum " + sum + " $");

    }


   /* public void waitForVisibilityOfElement(By locator, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(visibilityOf(driver.findElement(locator)));
        } catch (NoSuchElementException e) {

            throw e;
        }
    }

    public void clickOnVisibleElement(By locator) {
        waitForVisibilityOfElement(locator, 100);
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String string) {
        waitForVisibilityOfElement(locator, 100);
        driver.findElement(locator).sendKeys(string);
    }

    public Boolean isElementPresent(By locator) {
        try {
            waitForVisibilityOfElement(locator, 100);
            driver.findElement(locator).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;

        }*/
    }


