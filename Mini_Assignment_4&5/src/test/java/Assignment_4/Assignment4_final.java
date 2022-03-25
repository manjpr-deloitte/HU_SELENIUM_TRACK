package Assignment_4;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
public class Assignment4_final extends setup
{
    public void excelData() throws IOException, InterruptedException {

        String excelPath="sample.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row = null;
        XSSFCell cell = null;
        String usr = null;
        String pass = null;
        for(int i=1;i<=sheet.getLastRowNum();i++)
        {
            row = sheet.getRow(i);
            for (int j=0;j<row.getLastCellNum();j++)
            {
                cell=row.getCell(j);
                if(j==0){
                    usr=cell.getStringCellValue();
                }
                if(j==1){
                    pass = cell.getStringCellValue();
                }
            }
        }
        login(usr,pass);
    }
    @Test(priority = 1)
    public void login(String usr,String pass) throws InterruptedException, IOException {

        By username = By.xpath("//*[@id='user-name']");
        dr.findElement(username).sendKeys(usr);
        By password = By.xpath("//*[@type='password']");
        By loginButton = By.xpath("//*[@type='submit']");
        dr.findElement(password).sendKeys(pass);
        dr.findElement(loginButton).click();
        exp_prod();

    }
    @Test(priority = 2)
    public void exp_prod() throws InterruptedException, IOException {
        WebElement ele = dr.findElement(By.xpath("//*[@class='product_sort_container']"));
        ele.click();
        WebElement ele1 = dr.findElement(By.xpath("//*[@value='hilo']"));
        ele1.click();
        WebElement e1 = dr.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']"));
        e1.click();
        Thread.sleep(5000);
        WebElement e2 = dr.findElement(By.xpath("//*[@id='remove-sauce-labs-fleece-jacket']"));
        e2.click();
        Thread.sleep(5000);
        WebElement e3 = dr.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']"));
        e3.click();
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span")).click();
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@class='btn btn_secondary back btn_medium']")).click();
        least_prod();
    }
    @Test(priority = 3)
    public void least_prod() throws InterruptedException, IOException {
        WebElement ele = dr.findElement(By.xpath("//*[@class='product_sort_container']"));
        ele.click();
        WebElement ele1 = dr.findElement(By.xpath("//*[@value='lohi']"));
        ele1.click();
        WebElement e1 = dr.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']"));
        e1.click();
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span")).click();
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@class='btn btn_action btn_medium checkout_button']")).click();
        checkout();
    }
    @Test(priority = 4)
    public void checkout() throws IOException, InterruptedException {

        String excelPath="sample.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(1);
        XSSFRow row = null;
        XSSFCell cell = null;
        String firstname= null;
        String lastname = null;
        String  zip = null ;
        for(int i=1;i<=sheet.getLastRowNum();i++){
            row = sheet.getRow(i);
            for (int j=0;j<row.getLastCellNum();j++){
                cell=row.getCell(j);
                if(j==0){
                    firstname =cell.getStringCellValue();
                }
                if(j==1){
                    lastname = cell.getStringCellValue();
                }
                if(j==2){
                    zip= cell.getStringCellValue();
                }
            }
        }
        dr.findElement(By.xpath("//*[@id='first-name']")).sendKeys(firstname);
        dr.findElement(By.xpath("//*[@id='last-name']")).sendKeys(lastname);
        dr.findElement(By.xpath("//*[@id='postal-code']")).sendKeys(zip);
        Thread.sleep(4000);
        dr.findElement( By.xpath("//*[@id='continue']")).click();
        dr.findElement(By.xpath("//*[@id='finish']")).click();
        String str = dr.findElement(By.xpath("//*[@id='checkout_complete_container']/h2")).getText();
        if (str.equals("THANK YOU FOR YOUR ORDER")){
            System.out.println("Success message is verified");
        }else {
            System.out.println("Success message is not verified");
        }
        CloseBrowser();
    }
}


