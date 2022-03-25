package Assignment_4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
    public class setup {
        public static WebDriver dr;
        @BeforeMethod
        public static void main(String args[]) throws InterruptedException, IOException {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\manjpr\\Downloads\\chromedriver_win32\\chromedriver.exe");
            dr = new ChromeDriver();
            dr.get("https://www.saucedemo.com/");
            dr.manage().window().maximize();
            Assignment4_final at = new Assignment4_final();
            at.excelData();
        }
        @AfterMethod
        public void CloseBrowser(){
            dr.quit();
        }
    }
