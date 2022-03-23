import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Mini_Assignment2A {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\manjpr\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        String parentWindow = driver.getWindowHandle();
        driver.get("http://www.phptravels.com");
        String s = driver.getTitle();
        compare(s);
        Thread.sleep(3000);
        //login page
        By login = By.xpath("/html/body/header/div/nav/a[4]");
        driver.findElement(login).click();
        for(String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(5000);
        String s2 = driver.getTitle();
        compares(s);
        driver.switchTo().window(parentWindow);
        //url
        driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        //pricing page
        By hotels = By.xpath("//a[text()='Pricing']");
        driver.findElement(hotels).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        //refresh
        driver.navigate().refresh();
        driver.quit();
    }

    public static void compare(String s) {
        if (s.contains("PHPTRAVELS"))
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }

    public static void compares(String s) {
        if (s.contains("login"))
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }
}
