package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.bank_manager_login;
import pages.*;
import java.io.IOException;
@Listeners(tests.TestNGListner.class)
public class loginTest {
    @Test
    private static void TEST_1() throws InterruptedException, IOException {
        WebDriver dr;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\manjpr\\Downloads\\chromedriver_win32\\chromedriver.exe");
        dr = new ChromeDriver();
        dr.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        dr.manage().window().maximize();
        bank_manager_login BM_login=new bank_manager_login(dr);
        add_customer customer=new add_customer(dr);
        open_account account=new open_account(dr);
        customer_login login=new customer_login(dr);
        withdraw_amount withdrawAmount=new withdraw_amount(dr);
        transaction Transaction = new transaction(dr);
        BM_login.click_bank_manager_login();
        BM_login.click_add_customer();
        setup.log.info("Status");
        customer.get_details();
        customer.add_details();
        customer.alert();
        account.select_customer();
        account.select_currency();
        account.alert();
        login.click_customer_login();
        login.select_customer();
        login.get_amount(0);
        login.depoist();
        withdrawAmount.get_amount(0);
        withdrawAmount.withdraw();
        Transaction.transaction();
        dr.quit();
    }
    @Test
    private static void TEST_2() throws InterruptedException, IOException {
        WebDriver dr1;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\manjpr\\Downloads\\chromedriver_win32\\chromedriver.exe");
        dr1 = new ChromeDriver();
        dr1.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        dr1.manage().window().maximize();
        bank_manager_login BM_login=new bank_manager_login(dr1);
        add_customer customer=new add_customer(dr1);
        open_account account=new open_account(dr1);
        customer_login login=new customer_login(dr1);
        withdraw_amount withdrawAmount=new withdraw_amount(dr1);
        transaction Transaction = new transaction(dr1);
        BM_login.click_bank_manager_login();
        BM_login.click_add_customer();
        setup.log.info("Status");
        customer.get_details();
        customer.add_details();
        customer.alert();
        account.select_customer();
        account.select_currency();
        account.alert();
        login.click_customer_login();
        login.select_customer();
        login.get_amount(1);
        login.depoist();
        dr1.quit();
    }
    @Test
    private static void TEST_3() throws InterruptedException, IOException {
        WebDriver dr2;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\manjpr\\Downloads\\chromedriver_win32\\chromedriver.exe");
        dr2= new ChromeDriver();
        dr2.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        dr2.manage().window().maximize();
        bank_manager_login BM_login=new bank_manager_login(dr2);
        add_customer customer=new add_customer(dr2);
        open_account account=new open_account(dr2);
        customer_login login=new customer_login(dr2);
        withdraw_amount withdrawAmount=new withdraw_amount(dr2);
        transaction Transaction = new transaction(dr2);
        BM_login.click_bank_manager_login();
        BM_login.click_add_customer();
        setup.log.info("Status");
        customer.get_details();
        customer.add_details();
        customer.alert();
        account.select_customer();
        account.select_currency();
        account.alert();
        login.click_customer_login();
        login.select_customer();
        login.get_amount(0);
        login.depoist();
        withdrawAmount.get_amount(1);
        withdrawAmount.withdraw();
        Transaction.transaction();
        dr2.quit();
    }

}