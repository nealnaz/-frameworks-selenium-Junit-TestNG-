package junitesting;

import net.sourceforge.htmlunit.corejs.javascript.ast.WhileLoop;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class testfacebook {

    WebDriver driver;

    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zubair\\Desktop\\NewAutomation\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void open() {


        driver.get("https://www.zoopla.co.uk/");
        Assert.assertEquals("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents" ,driver.getTitle());

        if (driver.getTitle().contains("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents"))
            System.out.println("Title is validated");
        else
            System.out.println("Title is different");



        driver.findElement(By.xpath("//*[@id=\"search-tabs-for-sale\"]/span"));
        new Select(driver.findElement(By.id("forsale_price_min"))).selectByVisibleText("£10,000");
        new Select(driver.findElement(By.id("forsale_price_max"))).selectByVisibleText("£10,000");
        new Select(driver.findElement(By.id("property_type"))).selectByVisibleText("Houses");

        WebElement mySelectedElement = driver.findElement(By.id("beds_min"));
        Select dropdown= new Select(mySelectedElement);
        dropdown.selectByIndex(2);



        driver.findElement(By.id("search-submit")).submit();


        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.linkText("For sale"))).perform();
        driver.findElement(By.linkText("UK estate agents")).click();




    }
     @Test
     public  void syntaxzz(){
         driver.navigate().back();


}
    @Test

    public void close(){



        driver.manage().window().maximize();

        driver.quit();


    }
}

