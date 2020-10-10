package testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.StringTokenizer;

/**
 * @program: testSelenium->CookiesTest
 * @description: 测试cookies
 * @author: qiuyu
 * @create: 2020-07-02 10:02
 * 浏览器启动命令行Chrome --remote-debugging-port=9222
 **/
public class CookiesTest {
    //获取cookie的所有内容

    public static WebDriver webDriver;
@BeforeAll
    public static void sem() {
          /*
        打开已有浏览器
         */
        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        webDriver = new ChromeDriver(options);
        //拿到浏览器cookie
        System.out.print(webDriver.manage().getCookies());

    try {
        FileWriter fileWriter=new FileWriter("cookie.txt");
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        for(Cookie cookie:webDriver.manage().getCookies()){

            //将cookie的信息一次保存到文件中

            //读一个字节写一个字节大量 消耗io操作

            bufferedWriter.write(cookie.getName()+';'+cookie.getValue()+';'+cookie.getDomain()+';'+cookie.getPath()+';'+cookie.getExpiry()+';'+cookie.isSecure()+';');
            //增加新的一行
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    //文件加缓冲
    //加快处理速度，节省io
    //先存成一个文件然后再次写入
    }
    @Test
    public void dragTest() throws InterruptedException {
        //*[@id="_hmt_click"]/div[1]/div[4]/div[2]/a[1]/div/span[1]
        webDriver.findElement(By.xpath("//*[@id=\"_hmt_click\"]/div[1]/div[4]/div[2]/a[1]/div/span[1]")).click();
    }
}
