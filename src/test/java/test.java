import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @program: testSelenium->test
 * @description: selenium测试
 * @author: qiuy
 * @create: 2020-06-01 00:09
 **/
public class test {
    /*
    selenium调试启动成功
     */
    @Test
    public void startSelenium(){
       WebDriver webdriver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","path");
        webdriver.get("https://ceshiren.com/");
        webdriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
    }
}
