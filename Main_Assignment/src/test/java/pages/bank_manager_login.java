package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class bank_manager_login{
    WebDriver dr;
    public bank_manager_login(WebDriver driver)
    {
        dr=driver;
    }
    public void click_bank_manager_login() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@ng-click='manager()']")).click();
    }
    public void click_add_customer() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@ng-class='btnClass1']")).click();
    }
}
