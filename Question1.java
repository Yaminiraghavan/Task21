package Task21;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Question1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='tox-icon']")).click();
        WebElement iframe=driver.findElement(By.xpath("//iframe[contains(@class,'iframe')]"));
        driver.switchTo().frame(iframe);

        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement text=driver.findElement(By.tagName("p"));
        //text.clear();
        //text.sendKeys("Hello People");
        js.executeScript("arguments[0].innerText= 'Hello people' ", text);
        //js.executeScript("arguments[0].setAttribute('value','Hello people')",text);
       // Thread.sleep(2000);
        //driver.close();
        driver.quit();


    }
}
