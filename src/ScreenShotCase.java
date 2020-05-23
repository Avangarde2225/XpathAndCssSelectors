import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenShotCase {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "http://the-internet.herokuapp.com/iframe" );

       // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)

        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.switchTo().frame("mce_0_ifr");

        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id = 'tinymce']")));

        System.out.println(webElement.getTagName());


        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        File DestFile = new File("./testFrame.jpeg");

        FileUtils.copyFile(file, DestFile);


        driver.quit();
    }


}
