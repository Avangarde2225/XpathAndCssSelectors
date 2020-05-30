package Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class SeleniumEasyFormUrlParsing {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        String path = "https://www.seleniumeasy.com/test/input-form-demo.html";
        driver.get( path );
        driver.manage().window().maximize();

        driver.findElement( By.xpath( "//input[@name='first_name']" ) ).sendKeys( "John" );
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Matson");
        driver.findElement( By.xpath( "//input[@name='email']" ) ).sendKeys( "John.Matson@fareportal.com" );
        driver.findElement( By.xpath( "//input[@name='phone']" ) ).sendKeys( "212-345-6789" );
        driver.findElement( By.xpath( "//input[@name='address']" ) ).sendKeys( "7514 Riverview Rd." );
        driver.findElement( By.xpath( "//input[@name='city']" ) ).sendKeys( "Sheboygan" );

        Select state = new Select( driver.findElement( By.xpath( "//select[@name='state']" ) ) );
        state.selectByIndex( state.getOptions().size() - 2 ); //selects Wisconsin
        driver.findElement( By.xpath( "//input[@name='zip']" ) ).sendKeys( "53408" );
        driver.findElement( By.xpath( "//input[@name='website']" ) ).sendKeys( "www.voyagerhq.com" );

        driver.findElement( By.xpath( "//input[@type='radio'][@value='yes']" ) ).click();
        driver.findElement( By.xpath( "//textarea[@class='form-control']" ) ).sendKeys( "Bla Bla Bla Bla" );

        driver.findElement( By.xpath( "//button[@type='submit']" ) ).click();

        String currentUrl = driver.getCurrentUrl();
       // System.out.println(currentUrl);

        Map<String, String> queryMap = getQueryMap( currentUrl );
        for(String key : queryMap.keySet()) {
            System.out.println( key + " = " + queryMap.get( key ) );
        }
//        driver.quit();
    }
    //SignUpForm.html?username=name&password=password&password_repeat=password&address=7514+Riverview+Rd.%0D%0ASheboygan%2C+WI+53081&sex=male&plan=enterprise&agreement=on&x=100&y=24
    public static Map<String, String> getQueryMap(String query) {

        String onlyParams = query.substring( query.indexOf( "test/" ) + 1 );

        String[] params = onlyParams.split( "-" );

        Map<String, String> map = new HashMap<>();
        for(String param : params) {
            String key = param.split( "=" )[0];
            String value = param.split( "=" )[1];
            map.put( key, value );
        }
        return map;
  }
}
