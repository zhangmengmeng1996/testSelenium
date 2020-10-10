package testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * @program: testSelenium->windowTest
 * @description:多窗口处理
 * @author: qiuyu
 * @create: 2020-06-21 18:39
 **/
public class windowTest {
    public static WebDriver webDriver;

    //public static WebDriverWait wait;
    @BeforeAll
    public  static void initdata(){
        webDriver=new ChromeDriver();
        //隐式等待
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //显示等待
        // wait=new WebDriverWait(webDriver,5);

    }
    /*
    百度注册后回到页面进行登录所以需要多窗口 处理
     */
    @Test
    public void windowSwitchTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com/");
        //窗口放到最大
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//*[@id=\"u1\"]/a[2]")).click();
        //拿到当前句柄
        String m=webDriver.getWindowHandle();
        webDriver.findElement(By.xpath("//a[@class='pass-reglink pass-link']")).click();
        //拿到所有句柄并进行判断
        for(String win:webDriver.getWindowHandles()){
            if(!win.equals(m)){
                webDriver.switchTo().window(win);
                webDriver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("ass");
                webDriver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("13147644038");
                //注册完成切换回想要登录的页面
                webDriver.switchTo().window(m);

                webDriver.findElement(By.xpath("//p[@class='tang-pass-footerBarULogin pass-link']")).click();

                    Thread.sleep(3000);

            }
        }
    }
}
