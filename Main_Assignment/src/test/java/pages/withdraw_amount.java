package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
public class withdraw_amount {
    WebDriver dr;
    public withdraw_amount(WebDriver driver)
    {
        dr=driver;
    }
    int amount;
    excel_data xls1;
    public void get_amount(int row){
        try {
            xls1 = new excel_data("maindata.xlsx");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        amount=xls1.getData1(2,row,0);
    }
    public void withdraw() throws InterruptedException, IOException {
        dr.findElement(By.xpath("//*[@ng-click='withdrawl()']")).click();
        Thread.sleep(2000);
        WebElement e3 = dr.findElement(By.xpath("//*[@ng-model='amount']"));
        e3.sendKeys(Integer.toString(amount));
        Thread.sleep(3000);
        WebElement e2=dr.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]"));
        String s1=e2.getText();
        int initialbalance;
        initialbalance=Integer.parseInt(s1);
        if(amount<=0)
        {
            WebDriverWait wt = new WebDriverWait(dr, 5);
            wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-default']")));
            setup.log.error("amount should be greater than 0");
            screenshots sc =new screenshots(dr);
            sc.takescreenshot("negativescreenshot2");
        }
        else if(amount>initialbalance){
            setup.log.error("Amount should not be greater than balance");
        }
        else {
            int balance,finalbalance;
            WebElement e4=dr.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]"));
            String s2=e4.getText();
            balance=Integer.parseInt(s2);
            dr.findElement(By.xpath("//button[@class='btn btn-default']")).click();
            WebElement e5=dr.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]"));
            String s3=e5.getText();
            finalbalance=Integer.parseInt(s3);
            if(finalbalance==(balance-amount))
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
            sc.takescreenshot("withdraw");
        }
    }
}
