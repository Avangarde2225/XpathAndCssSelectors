import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

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

        driver.findElement(By.cssSelector("#et_pb_contact_name_0")).sendKeys(randomLetterGenerator(10));
        driver.findElement(By.cssSelector("textarea#et_pb_contact_message_0")).sendKeys(randomLetterGenerator(50));


        driver.findElement(By.xpath("//input[@id='et_pb_contact_name_1']")).sendKeys("Tom");
        driver.findElement(By.xpath("//textarea[@name='et_pb_contact_message_1']")).sendKeys("bla bla bla text");

        String mathCaptcha = driver.findElement(By.xpath("//div[@class='et_contact_bottom_container']/div/p/span")).getText().trim();
        //System.out.println(mathCapthca);
        //String spaceRemoved = mathCaptcha.replaceAll("\\s+","");

        //get two numbers
        //String[] twoNumbers = spaceRemoved.split("\\+");
//        for (String num : twoNumbers) {
//            System.out.println(num);
//        }

//        String part1 = twoNumbers[0];
//        String part2 = twoNumbers[1];

        // int sumOfTwoNums = Integer.valueOf(part1) + Integer.valueOf(part2);

        driver.findElement(By.xpath("//*[@class='input et_pb_contact_captcha']")).sendKeys(solveMathCaptcha(mathCaptcha) + "");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //driver.quit();

        WebDriverWait wait = new WebDriverWait(driver,15);
        String testString = "Success";
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + testString + "')]")));
            System.out.println(testString);
        }catch(TimeoutException e){
            System.out.println("Failure, text did not wait 15 seconds");
        }


    }

    private static String solveMathCaptcha(String mathCaptcha) {
        String[] params = mathCaptcha.split("\\+");
        int sum = 0;
        for (String p : params) {
            sum += Integer.valueOf(p.trim());
        }
        return String.valueOf(sum);
    }

    public static String randomLetterGenerator(int length) {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }
}

