package miniassigntest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.Test;
import java.io.IOException;
public class minitest extends generic{
    ExcelData xls1;
    {
        try {
            xls1 = new ExcelData("sample.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    String UN = xls1.getData(0,1,0);
    String Pass = xls1.getData(0,1,1);
    String FirstName = xls1.getData(1,0,0);
    String LastName = xls1.getData(1,1,0);
    String ZipCode = xls1.getData(1,2,0);
    By username = By.xpath("//*[@id='user-name']");
    By password = By.xpath("//*[@type='password']");
    By loginButton = By.xpath("//*[@type='submit']");
    By addToCart = By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']");
    By removeButton = By.xpath("//*[@id='remove-sauce-labs-fleece-jacket']");
    By cartFunc = By.xpath("//*[@id='shopping_cart_container']/a/span");
    By continueShopping = By.xpath("//*[@id='continue-shopping']");
    By addToCart2 = By.xpath("//*[@id='add-to-cart-sauce-labs-onesie']");
    By checkOutButton = By.xpath("//*[@id='checkout']");
    By FN = By.xpath("//*[@id='first-name']");//First Name
    By LN = By.xpath("//*[@id='last-name']");//Last Name
    By zip = By.xpath("//*[@id='postal-code']");//Zip code or Postal Code
    By continueButton = By.xpath("//*[@id='continue']");
    By finishButton = By.xpath("//*[@id='finish']");
    By thankYouMessage = By.xpath("//*[@id='checkout_complete_container']/h2");
    @Test(priority = 1)
    public void verifyLogin() throws InterruptedException {
        driver.findElement(username).sendKeys(UN);
        driver.findElement(password).sendKeys(Pass);
        driver.findElement(loginButton).click();
    }
    @Test(priority = 2)
    public void GetExpensiveProduct(){
        WebElement ele = driver.findElement(By.xpath("//*[@class='product_sort_container']"));
        Select dropDown = new Select(ele);
        dropDown.selectByIndex(4);
        WebElement e1 = driver.findElement(addToCart);
        if (e1.isEnabled()){
            e1.click();
        }else {
            throw new SkipException("Skipping this test as the condition was false");
        }
        WebElement e2 = driver.findElement(removeButton);
        if (e2.isEnabled()){
            e2.click();
        }
        if (e1.isDisplayed()){
            e1.click();
        }
        driver.findElement(cartFunc).click();
        driver.findElement(continueShopping).click();
    }
    @Test(priority = 3)
    public void GetLessPriceProduct(){
        WebElement ele = driver.findElement(By.xpath("//*[@class='product_sort_container']"));
        Select dropDown = new Select(ele);
        dropDown.selectByIndex(3);
        driver.findElement(addToCart2).click();
        driver.findElement(cartFunc).click();
        driver.findElement(checkOutButton).click();
    }
    @Test(priority = 4)
    public void FinalBilling(){
        driver.findElement(FN).sendKeys(FirstName);
        driver.findElement(LN).sendKeys(LastName);
        driver.findElement(zip).sendKeys(ZipCode);
        driver.findElement(continueButton).click();
        driver.findElement(finishButton).click();
        String str = driver.findElement(thankYouMessage).getText();
        if (str.equals("THANK YOU FOR YOUR ORDER")){
            System.out.println("Output is verified");
        }else {
            System.out.println("Output is not verified");
        }
    }
}