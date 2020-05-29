package Projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpFormValidation {
    /**
     * open SignUpForm.html
     * store values that you will use inside some Strings
     * fill in your data inside the all input elements using Strings above
     * submit the form
     * get URL
     * parse values that was submitted
     * validate parsed values with stored values above
     */
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get( "file:///C:/Users/suler/IdeaProjects/Xpath%20and%20Css%20Selector%20Practice/src/htmlproject/SignUpForm.html" );

        driver.manage().window().maximize();





    }
}
