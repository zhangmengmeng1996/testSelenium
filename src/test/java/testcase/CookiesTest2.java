package testcase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @program: testSelenium->CookiesTest
 * @description: 测试cookies用已有cookies登录
 * @author: qiuyu
 * @create: 2020-07-02 10:02
 * 浏览器启动命令行Chrome --remote-debugging-port=9222
 **/
public class CookiesTest2 {
    //获取cookie的所有内容

    public static WebDriver webDriver;
    /*
    获取登录信息
     */
    @Test
    public  void sem(){
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        webDriver=new ChromeDriver();
        webDriver.get("https://work.weixin.qq.com/wework_admin/frame");
        try {
            FileReader fileReader = new FileReader("cookie.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                String domain = tokenizer.nextToken();
                String path = tokenizer.nextToken();
                Date expiry = null;
                String dt = tokenizer.nextToken();
                //date类型转换为
                if (!dt.equals("null")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    //把 string 转换成 date
                    expiry = sdf.parse(dt);
                }
                //把 string 转换成 boolean
                boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                webDriver.manage().addCookie(cookie);

            }
            webDriver.get("https://work.weixin.qq.com/wework_admin/frame");
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public void saveCookie(WebDriver driver) {
        //每次只取一条cookie进行处理
        try {
            FileWriter fileWriter = new FileWriter("cookie.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cookie cookie : driver.manage().getCookies()) {
                bufferedWriter.write(cookie.getName() + ';' +
                        cookie.getValue() + ";" +
                        cookie.getDomain() + ";" +
                        cookie.getPath() + ";" +
                        cookie.getExpiry() + ";" +
                        cookie.isSecure());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
