package miniassigntest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class generic {
    public WebDriver driver;
    @BeforeMethod
    public void LaunchBrowser(){
        String key = "webdriver.chrome.driver";
        String value = "C:\\Users\\manjpr\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty(key,value);
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void CloseBrowser(){

        driver.quit();
    }
}