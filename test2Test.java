package junitesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import net.sourceforge.htmlunit.corejs.javascript.ast.WhileLoop;

import org.testng.annotations.AfterSuite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class test2Test {


    static WebDriver driver;

    @Test(priority = 1, description = "xyz")


    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zubair\\Desktop\\NewAutomation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.next.co.uk/");
        driver.manage().deleteAllCookies();




        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//*[@id=\"MainNavigation\"]/div/ul/li[2]/a/span"))).perform();

        driver.findElement(By.linkText("Coats & Jackets"));




        WebElement chekbox = driver.findElement(By.xpath("//*[@id=\"feat\"]/div/ul/li[1]/div/div/label"));
        chekbox.click();

        if (chekbox.isSelected())

            System.out.println("checked");
        else
            System.out.println("notchecked");


       WebElement chekbox2 = driver.findElement(By.xpath("//*[@id=\"feat\"]/div/ul/li[2]/div/div[1]/label"));

        for (int i=0;i<2;i++)
            chekbox2.click();
        System.out.println(chekbox2.isSelected());
}


}









