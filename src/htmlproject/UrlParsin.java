package htmlproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UrlParsin {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        String path = "file:///C:/Users/suler/IdeaProjects/Xpath%20and%20Css%20Selector%20Practice/src/htmlproject/SignUpForm.html";
        driver.get( path );

        driver.findElement( By.name( "username" ) ).sendKeys( "name" );
        driver.findElement( By.name( "password" ) ).sendKeys( "password" );
        driver.findElement( By.name( "password_repeat" ) ).sendKeys( "password" );
        driver.findElement( By.name( "address" ) ).sendKeys( "7514 Riverview Rd.\n" + "Sheboygan, WI 53081" );
        driver.findElement( By.cssSelector( "input[type='radio'][value='male']" ) ).click();
        Select plan = new Select( driver.findElement( By.name( "plan" ) ) );
        plan.selectByIndex( plan.getOptions().size() - 1 ); //selects last option
        driver.findElement( By.name( "agreement" ) ).click();
        driver.findElement( By.id( "submit" ) ).click();
        String currentUrl = driver.getCurrentUrl();

        Map<String, String> queryMap = getQueryMap( currentUrl );
        for(String key : queryMap.keySet()) {
            System.out.println( key + " = " + queryMap.get( key ) );
        }
//        driver.quit();
    }
    //SignUpForm.html?username=name&password=password&password_repeat=password&address=7514+Riverview+Rd.%0D%0ASheboygan%2C+WI+53081&sex=male&plan=enterprise&agreement=on&x=100&y=24
    public static Map<String, String> getQueryMap(String query) {
        String onlyParams = query.substring( query.indexOf( "?" ) + 1 );
        String[] params = onlyParams.split( "&" );
        Map<String, String> map = new HashMap<String, String>();
        for(String param : params) {
            String key = param.split( "=" )[0];
            String value = param.split( "=" )[1];
            map.put( key, value );
        }
        return map;
    }
}
