import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {
    // repeat Task 3 for all the buttons. Success, warning, danger and info buttons.
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
        driver.manage().window().maximize();


    }

}
