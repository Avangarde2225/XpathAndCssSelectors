import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {
    // repeat Task 3 for all the buttons. Success, warning, danger and info buttons.
    // https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html
    // click on the "Normal success message" button then validate
    // that message is equal "I'm a normal success message. To close use the appropriate button."
    // then click on X button on the message
    // validate the the message is invisible or not present
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
        driver.manage().window().maximize();


    }

}
