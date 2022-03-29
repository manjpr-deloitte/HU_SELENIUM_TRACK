package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import static pages.setup.dr;
public class add_customer {
    String firstname="";
    String lastname="";
    int zip=0;
    excel_data xls1;
    WebDriver dr;
    public add_customer(WebDriver driver)
    {
        dr=driver;
    }
    public void get_details(){
        try {
            xls1 = new excel_data("maindata.xlsx");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        firstname=xls1.getData(0,0,0);
        lastname=xls1.getData(0,0,1);
        zip= xls1.getData1(0,0,2);
    }
    public void add_details() throws InterruptedException, IOException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(firstname);
        dr.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(lastname);
        dr.findElement(By.xpath("//*[@placeholder='Post Code']")).sendKeys(Integer.toString(zip));
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(2000);
    }
    public void alert() throws InterruptedException, IOException {

        Thread.sleep(3000);
        dr.switchTo().alert().accept();
        screenshots sc =new screenshots(dr);
        sc.takescreenshot("customeradded");
    }
}
