import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SolvingMathCaptcha {
    /**
     * open "https://ultimateqa.com/filling-out-forms/"
     * fill in et_pb_contact_form_1 with some random data
     * solve math problem in et_pb_contact_captcha_question
     * and fill the answer in et_pb_contact_captcha_1
     * click on submit button of this form
     * check that text "Success" is displayed
     **/
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/complicated-page/");

        driver.manage().window().maximize();
    }
}

