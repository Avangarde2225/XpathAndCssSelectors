package Projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectThree {
    /**
     * go to "https://ultimateqa.com/automation/fake-pricing-page/"
     * maximize page
     * validate that "Free Trial" is $0
     * validate that "Basic" is $80
     * validate that "Enterprise" is $900
     **/
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/automation/fake-pricing-page/");

        driver.manage().window().maximize();
    }
}
