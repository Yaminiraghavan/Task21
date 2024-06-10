package Task21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Question2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        String mainWindowHandle = driver.getWindowHandle();

        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains("New Window"))
                return;
        }
        WebElement newWindowHeading= driver.findElement(By.tagName("h3"));
        if(newWindowHeading.getText().equals("New Window")){
            System.out.println("New window is present");
        }else {
            System.out.println("New window is not present");
        }
        driver.close();

        driver.switchTo().window(mainWindowHandle);

        driver.quit();


    }
}
