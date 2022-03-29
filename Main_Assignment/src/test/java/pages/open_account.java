package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
public class open_account{
    WebDriver dr;
    public open_account(WebDriver driver)
    {
        dr=driver;
    }
    public void select_customer() throws InterruptedException {
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@ng-click='openAccount()']")).click();
        Thread.sleep(3000);
        Select se = new Select(dr.findElement(By.xpath("//*[@id='userSelect']")));
        List<WebElement> l = se.getOptions();
        int n= l.size()-1;
        se.selectByIndex(n);
        Thread.sleep(3000);
    }
    public void select_currency() throws InterruptedException, IOException {
        WebElement e2 = dr.findElement(By.xpath("//*[@id='currency']"));
        Select select = new Select(e2);
        select.selectByIndex(3);
        Thread.sleep(3000);
        WebElement e3 = dr.findElement(By.xpath("//*[@type='submit']"));
        e3.click();
        Thread.sleep(3000);
    }
    public void alert() throws InterruptedException, IOException {
        Thread.sleep(3000);
        dr.switchTo().alert().accept();
        screenshots sc =new screenshots(dr);
        sc.takescreenshot("accountcreated");
    }
}

