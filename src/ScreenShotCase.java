import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class ScreenShotCase {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "http://the-internet.herokuapp.com/nested_frames" );

        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.switchTo().frame("/frame_left");

        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name = 'frame-left']")));

        System.out.println(webElement.getTagName());

        //File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        File DestFile = new File("./testFrame.jpeg");

        FileUtils.copyFile(file, DestFile);


        driver.quit();
    }


}