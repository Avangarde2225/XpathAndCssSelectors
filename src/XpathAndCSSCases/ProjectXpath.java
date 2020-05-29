package XpathAndCSSCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectXpath {
    /**
     *  "http://the-internet.herokuapp.com/login"
     *
     * using XPath:
     *      grab username from first <em> tag and store inside a String
     *      grab password from second <em> tag and store inside a String
     *      fill in username and password inputs with above username and password
     *      find <button> with type="submit" and click it
     *      find and verify text "Welcome to the Secure Area. When you are done click logout below."
     *      find "Log out" button and click it
     *      find and verify text "You logged out of the secure area!"
     * */


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");

        driver.manage().window().maximize();

        String usernameFromEmTag= driver.findElement(By.xpath("//h4[@class='subheader']//em[1]")).getText();
        String passwordFromEmTag= driver.findElement(By.xpath("//h4[@class='subheader']//em[2]")).getText();

        driver.findElement(By.xpath("//*[@name='username']")).sendKeys(usernameFromEmTag);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwordFromEmTag);

        driver.findElement(By.xpath("//button[@class='radius']")).click();


        //verification of Welcome to the Secure Area text

        String verfiedText= driver.findElement(By.xpath("//h4[@class='subheader']")).getText();

        String textAfterSubmission = "Welcome to the Secure Area. When you are done click logout below.";

        if(verfiedText.equals(textAfterSubmission)){
            System.out.println("Login message: Success");
        } else{
            System.out.println("Failure");
        }


    //Last Part - Logout

        driver.findElement(By.xpath("//a[@class='button secondary radius']")).click();

        WebElement logOutText = driver.findElement(By.xpath("//div[@class = 'flash success']"));

        String verifyNeeded="You logged out of the secure area!";


        WebElement x = driver.findElement( By.xpath("//*[@id=\"flash\"]/a"));

        String signedOut = logOutText.getText().replace(x.getText(), "").trim();

        if(signedOut.equals(verifyNeeded)){
            System.out.println("Log out message: Success");
        } else{
            System.out.println("Failure");
        }

        driver.quit();

}
}
