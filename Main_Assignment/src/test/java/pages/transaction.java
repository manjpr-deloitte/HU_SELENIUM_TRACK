package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
public class transaction{
    WebDriver dr;
    public transaction(WebDriver driver)
    {
        dr=driver;
    }
    public void transaction() throws InterruptedException, IOException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@ng-click='transactions()']")).click();
        Thread.sleep(2000);
        screenshots sc =new screenshots(dr);
        sc.takescreenshot("Transactions");
    }
}
