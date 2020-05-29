package XpathAndCSSCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpXpath {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/suler/IdeaProjects/Xpath%20and%20Css%20Selector%20Practice/src/htmlproject/SignUpForm.html");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("avangarde2225");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234567");
        driver.findElement(By.xpath("//input[@id='passwordrepeat']")).sendKeys("1234567");
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("350 5th ave, New York,NY, 10005");
        driver.findElement(By.xpath("//input[@id='male']")).click();
        driver.findElement(By.xpath("//*[@name='Plan']//child::option[1]")).click();
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        driver.quit();

    }
}
