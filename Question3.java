package Task21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
        driver.switchTo().frame("frame-top");
        int topFramesCount = driver.findElements(By.tagName("frame")).size();
        if (topFramesCount == 3) {
            System.out.println("There are three frames in the top frame.");
        }

        driver.switchTo().frame("frame-left");
        WebElement leftFrameBody = driver.findElement(By.tagName("body"));
        if (leftFrameBody.getText().contains("LEFT")) {
            System.out.println("The left frame contains text: LEFT");
        } else {
            System.out.println("The left frame does not contain text: LEFT");
        }

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement MiddleFrameBody = driver.findElement(By.tagName("body"));
        if (MiddleFrameBody.getText().contains("MIDDLE")) {
            System.out.println("The middle frame contains text: MIDDLE");
        } else {
            System.out.println("The middle frame does not contain text: MIDDLE");
        }

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        WebElement RightFrameBody = driver.findElement(By.tagName("body"));
        if (RightFrameBody.getText().contains("RIGHT")) {
            System.out.println("The right frame contains text: RIGHT");
        } else {
            System.out.println("The right frame does not contain text: RIGHT");
        }
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        WebElement BottomFrameBody = driver.findElement(By.tagName("body"));
        if (BottomFrameBody.getText().contains("BOTTOM")) {
            System.out.println("The bottom frame contains text: BOTTOM");
        } else {
            System.out.println("The bottom frame does not contain text: BOTTOM");
        }

        driver.switchTo().defaultContent();

        String pageTitle = driver.getTitle();
        if (pageTitle.equals("Frames")) {
            System.out.println("The page title is: Frames");
        } else {
            System.out.println("The page title is not Frames, it is: " + pageTitle);
        }

    }
}
