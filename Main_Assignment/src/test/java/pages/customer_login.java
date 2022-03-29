package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.List;
public class customer_login {
    int amount;
    excel_data xls1;
    WebDriver dr;
    public customer_login(WebDriver driver)
    {
        dr=driver;
    }
    public void click_customer_login() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@ng-click='home()']")).click();
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@ng-click='customer()']")).click();
        Thread.sleep(3000);
    }
    public void select_customer() throws InterruptedException {
        Select se = new Select(dr.findElement(By.xpath("//*[@id='userSelect']")));
        List<WebElement> l = se.getOptions();
        int n = l.size() - 1;
        se.selectByIndex(n);
        Thread.sleep(3000);
        dr.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
        Thread.sleep(3000);
    }
    public void get_amount(int row){
        try {
            xls1 = new excel_data("maindata.xlsx");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        amount=xls1.getData1(1,row,0);
    }
    public void depoist() throws InterruptedException, IOException {
        dr.findElement(By.xpath("//*[@ng-click='deposit()']")).click();
        Thread.sleep(2000);
        WebElement e3 = dr.findElement(By.xpath("//*[@ng-model='amount']"));
        e3.sendKeys(Integer.toString(amount));
        Thread.sleep(3000);
        if(amount<=0)
        {
            WebDriverWait wt = new WebDriverWait(dr, 5);
            wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-default']")));
            setup.log.error("amount should be greater than 0");
            screenshots sc =new screenshots(dr);
            sc.takescreenshot("negativescreenshot");
        }
        else {
            int initialbalance,finalbalance;
            WebElement e2=dr.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]"));
            String s1=e2.getText();
            initialbalance=Integer.parseInt(s1);
            // System.out.println(s1);
            dr.findElement(By.xpath("//button[@class='btn btn-default']")).click();
            WebElement e4=dr.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]"));
            String s2=e4.getText();
            finalbalance=Integer.parseInt(s2);
            if(finalbalance==amount)
            {
                System.out.println("Balance updated successfulluy");
            }
            else
            {
                setup.log.error("Balance not updated successfully");
            }
            Thread.sleep(3000);
            WebElement e1=dr.findElement(By.xpath("//*[@ng-show='message']"));
            screenshots sc =new screenshots(dr);
            sc.takescreenshot("deposit");
        }
    }
}

