import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class WaitForElement {
    /**
     * Open "http://the-internet.herokuapp.com/dynamic_controls"
     *
     * click on "Enable" button
     * wait for <input> of type="text" to be enabled within 5 seconds
     * if <input> of type="text" is enabled print success
     * verify that <p> with id="message"  is visible and has text "It's enabled!"
     *
     * click on "Disable" button
     * wait for <input> of type="text" to be disabled within 5 seconds
     * if <input> of type="text" is disabled print success
     * verify that <p> with id="message"  is visible and has text "It's disabled!"
     *
     **/
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,5);

        WebElement enable = driver.findElement(By.xpath("//*[@onclick='swapInput()']"));
        enable.click();

        driver.findElement(By.xpath("//*[@id='input-example']"));

        try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#input-example input[type='text'][disabled]")));
            System.out.println( "Success!" );
        } catch(TimeoutException e) {
            System.out.println( "Failure, textInput was not enabled in 5 seconds!" );
        }
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\suler\\IdeaProjects\\Xpath and Css Selector Practice/src/waitForElement.jpg");
        FileUtils.copyFile(file,destFile);
    }
}
