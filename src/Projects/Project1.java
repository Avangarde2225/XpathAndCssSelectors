package Projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project1 {
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






    }
}
