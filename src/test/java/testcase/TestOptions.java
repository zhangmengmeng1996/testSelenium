package testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/**
 * @program: testSelenium->TestOptions
 * @description: 仅一次打开浏览器窗口无需多次
 * @author: qiuyu
 * @create: 2020-06-29 14:20
 **/
public class TestOptions {
    public static WebDriver webDriver;

    //public static WebDriverWait wait;
    @BeforeAll
    public  static void initdata(){
        /*
        打开已有浏览器
         */
        ChromeOptions options=new ChromeOptions();

        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        webDriver=new ChromeDriver(options);
        //拿到浏览器cookie
        System.out.print(webDriver.manage().getCookies());

    }
    /*
    
     */
    @Test
    public void dragTest() throws InterruptedException {
        //*[@id="_hmt_click"]/div[1]/div[4]/div[2]/a[1]/div/span[1]
       webDriver.findElement(By.xpath("//*[@id=\"_hmt_click\"]/div[1]/div[4]/div[2]/a[1]/div/span[1]")).click();
    }
}
