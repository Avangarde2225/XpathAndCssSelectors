package Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpFormById {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get( "file:///C:/Users/suler/IdeaProjects/Xpath%20and%20Css%20Selector%20Practice/src/htmlproject/SignUpForm.html" );

        driver.findElement( By.name( "username" ) ).sendKeys( "name" );
        driver.findElement( By.name( "password" ) ).sendKeys( "password" );
        driver.findElement( By.name( "password_repeat" ) ).sendKeys( "password" );
        driver.findElement( By.name( "address" ) ).sendKeys( "7514 Riverview Rd.\n" + "Sheboygan, WI 53081" );
        driver.findElement( By.cssSelector( "input[type='radio'][value='male']" ) ).click();
        Select plan = new Select( driver.findElement( By.name( "plan" ) ) );
        plan.selectByIndex( plan.getOptions().size() - 1 ); //selects last option
        driver.findElement( By.name( "agreement" ) ).click();
//        driver.quit();
    }
}
