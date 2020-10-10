package testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * @program: testSelenium->InterteacticeTest
 * @description: 交互测试
 * @author: zhangmm
 * @create: 2020-06-18 11:34
 **/
public class InterteacticeTest {
    public static WebDriver webDriver;
    public static Actions action;
    //public static WebDriverWait wait;
    @BeforeAll
    public  static void initdata(){
        webDriver=new ChromeDriver();
        action=new Actions(webDriver);
        //隐式等待
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //显示等待
       // wait=new WebDriverWait(webDriver,5);

    }
    /*
    动作的填写方法
     */
    @Test
    public void clickTest() throws InterruptedException {
        webDriver.get("http://sahitest.com/demo/clicks.htm");

        action.click(webDriver.findElement(By.xpath("/html/body/form/input[3]")));
        action.perform();
        Thread.sleep(3000);
    }
    @Test
    public void dragTest() throws InterruptedException {
        webDriver.get("http://sahitest.com/demo/dragDropMooTools.htm");
        action.dragAndDrop(webDriver.findElement(By.id("dragger")),webDriver.findElement(By.xpath("/html/body/div[2]"))).click().perform();
        Thread.sleep(3000);
    }
    //谷歌不生效
    @Test
    public void labaleTest() throws InterruptedException {
        webDriver.get("http://sahitest.com/demo/label.htm");
        webDriver.findElement(By.xpath("//input[@type='textbox'][1]")).sendKeys("as");
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        action.keyDown(webDriver.findElement(By.xpath("//input[@type='textbox'][2]")),Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);


    }
    @Test
    public  void scrollTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com/");
        webDriver.findElement(By.id("kw")).sendKeys("霍格沃兹测试学院");
        //手势操作
        TouchActions actions=new TouchActions(webDriver);
        actions.click(webDriver.findElement(By.id("su")));
        JavascriptExecutor js=(JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//a[@class='n']")).click();
        Thread.sleep(4000);
    }
    @AfterAll
    public static void data(){
        webDriver.quit();
    }

}
