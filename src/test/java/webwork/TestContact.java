package webwork;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.web.webwork.page.ContactPage;
import com.web.webwork.page.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @program: testSelenium->TestContact
 * @description: 联系人测试用例
 * @author: qiuyu
 * @create: 2020-08-12 14:17
 **/
public class TestContact {
    static MainPage main;
    static ContactPage contact;
    @BeforeAll
    static void beforeAll(){
        main=new MainPage();
        contact=main.toContact();
    }
    @Test
    void testAddMember(){
       String getUserName=contact.addMember("6","6","15600534769").search("6").getUserName();
       assertEquals(getUserName,"6");
    }
   @Test
   void testSearch(){

        contact.search("3").delete();
   }
   @Test
   void importFromFile(){
        contact.importFromFile("C:\\Users\\Administrator\\.ssh\\workspace\\testSelenium\\src\\main\\resources\\通讯录批量导入.xlsx");
   }
    @AfterAll
    static void afterAll(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main.quit();
    }
}
