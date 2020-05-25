package Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectCss {
    /**
     * Open "https://ultimateqa.com/complicated-page/"
     * find "Skills Improved:" using css selectors and validate text
     * find "How to deal with a large page that has many elements and divisions?" using css selector and validate it
     * find "Properly structuring your page objects" using css selector and validate it
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/complicated-page/");

        driver.manage().window().maximize();

        driver.findElement(By.cssSelector(".et_pb_text_inner > h2:nth-child(1)"));

        driver.findElement(By.cssSelector("div.et_pb_text_inner ul li:first-child"));

        driver.findElement(By.cssSelector("div.et_pb_text_inner ul li:nth-child(2)"));





    }
}
