package Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreation {
    /**
     * Part 1:
     *  Open "https://courses.ultimateqa.com/users/sign_up"
     *  create random and valid first name, last name, email and password, store for later validating
     *  fill in account submission form with data above
     *  Click on checkbox with id="user[terms]" to agree with terms and conditions
     *  click on "Sign up" button
     *  go to https://courses.ultimateqa.com/account
     *  validate that first name, last name and email you provided earlier is correct
     *
     * Part 2 (Optional)
     *  sign out of the website
     *  go to "https://courses.ultimateqa.com/users/sign_in"
     *  fill in sign in form with your stored email and password
     *  click on "Sign in" button
     *  validate that message "Signed in successfully." is displayed
     **/

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://courses.ultimateqa.com/users/sign_up");
        driver.manage().window().maximize();

        //part 1

        WebElement fname = driver.findElement(By.xpath("//input[@id='user[first_name]']"));
        fname.sendKeys("Abuzer");

        WebElement lname = driver.findElement(By.xpath("//input[@id='user[last_name]']"));
        lname.sendKeys("Banderas");

        WebElement email = driver.findElement(By.xpath("//input[@id='user[email]']"));
        email.sendKeys("Abuzittin936@aol.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='user[password]']"));
        password.sendKeys("yeyehsnwkkw");

        WebElement terms = driver.findElement(By.xpath("//input[@id='user[terms]']"));
        terms.click();

        WebElement submit = driver.findElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        submit.click();

        WebDriverWait wait = new WebDriverWait( driver, 500 );
        wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "a.dropdown__toggle-button" ) ) );

        driver.get( "https://courses.ultimateqa.com/account" );
        String actualFirstName = driver.findElement( By.id( "user[first_name]" ) ).getAttribute( "value" );
        String actualLastName = driver.findElement( By.id( "user[last_name]" ) ).getAttribute( "value" );
        String actualEmail = driver.findElement( By.id( "user[email]" ) ).getAttribute( "value" );

        System.out.println( fname.equals( actualFirstName ) ? "Success!" : "Failure!" );
        System.out.println( lname.equals( actualLastName ) ? "Success!" : "Failure!" );
        System.out.println( email.equals( actualEmail ) ? "Success!" : "Failure!" );

        WebElement dropdown = driver.findElement( By.cssSelector( "a.dropdown__toggle-button" ) );
        dropdown.click();

        WebElement signOutLink = wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//a[contains(text(), 'Sign Out')]" ) ) );
        signOutLink.click();

        WebElement signInLink = wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//a[contains(text(), 'Sign In')]" ) ) );
        signInLink.click();

        driver.findElement( By.id( "user[email]" ) ).sendKeys( email+"" );
        driver.findElement( By.id( "user[password]" ) ).sendKeys( password+"" );
        driver.findElement( By.cssSelector( "input[value='Sign in']" ) ).click();

        WebElement message = wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "p.message-text" ) ) );
        System.out.println( message.getText().equals( "Signed in successfully." ) ? "Signed in successfully." : "Failure!" );

    }



    }



