import org.openqa.selenium.By;
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
        driver.get("https://ultimateqa.com/filling-out-forms/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='et_pb_contact_name_1']")).sendKeys("Tom");
        driver.findElement(By.xpath("//textarea[@name='et_pb_contact_message_1']")).sendKeys("bla bla bla text");



    }
}

