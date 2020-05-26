package Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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

        List<WebElement>priceSums = driver.findElements(By.xpath("//*[@class='et_pb_sum']"));

        String [] prices = {"$0", "$80", "$900"};

        for (int i = 0; i < prices.length; i++) {
            if(priceSums.get(i).getText().equals(prices[i])){
                System.out.println("Total is " + priceSums.get(i).getText());
            } else{
                System.out.println("Failed total is " + priceSums.get(i).getText());
            }
        }
        driver.quit();
    }
}
