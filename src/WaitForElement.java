import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

    }
}
