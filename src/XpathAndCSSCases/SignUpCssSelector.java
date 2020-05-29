package XpathAndCSSCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpCssSelector {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/suler/IdeaProjects/Xpath%20and%20Css%20Selector%20Practice/src/htmlproject/SignUpForm.html");



        driver.findElement(By.cssSelector("#username")).sendKeys("avangarde2225");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234567");
        driver.findElement(By.cssSelector("#passwordrepeat")).sendKeys("1234567");
        driver.findElement(By.cssSelector("#address")).sendKeys("350 5th ave, New York,NY, 10005");
        driver.findElement(By.cssSelector("#male")).click();
        driver.findElement(By.cssSelector("#option2")).click();
        driver.findElement(By.cssSelector("#submit")).click();

        driver.quit();

    }
}
