package testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @program: testSelenium->aice
 * @description: 测试
 * @author: qiuyu
 * @create: 2020-06-02 23:03
 **/
public class aice {
    public static WebDriver webDriver;
    public static WebDriverWait wait;
    @BeforeAll
    public  static void initdata(){
        webDriver=new ChromeDriver();
        //隐式等待
        //webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //显示等待
        wait=new WebDriverWait(webDriver,5);
    }
    @Test
    public void startSelenium(){

        webDriver.get("https://ceshiren.com/");
        webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        webDriver.findElement(By.id("login-account-name")).clear();
        webDriver.findElement(By.id("login-account-name")).sendKeys("963748383@qq.com");
        webDriver.findElement(By.id("login-account-password")).clear();
        webDriver.findElement(By.id("login-account-password")).sendKeys("19960917mm");
        webDriver.findElement(By.id("login-button")).click();
    }
    /*
    显示等待
     */
    @Test
    public void test2(){
        webDriver.get("https://ceshiren.com/");
       // webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        /*WebElement w=wait.until(new ExpectedCondition<WebElement>(){
            public WebElement apply(WebDriver driver1) {
                return driver1.findElement(By.xpath("//span[contains(text(),'登录')]"));
            }
        });
        w.click();
*/
        WebElement w2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'登录')]")));
        w2.click();
    }
    @AfterAll
    public static void data(){
        webDriver.quit();
    }

}
