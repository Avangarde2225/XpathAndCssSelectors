import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {
    // repeat Task 3 for all the buttons. Success, warning, danger and info buttons.
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#normal-btn-warning")).click();

        WebElement message = driver.findElement(By.cssSelector(".alert-normal-warning"));

        WebElement button = driver.findElement(By.cssSelector(".alert-normal-warning > button"));

        String text = message.getText().replace(button.getText(), "").trim();

        String test = "I'm a normal warning message. To close use the appropriate button.";

        System.out.println( test.equals( text ) ? "Success!" : "Failure!" );

        button.click();
        System.out.println( !message.isDisplayed() ? "Success!" : "Failure" );
        driver.quit();

    }

}
