import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PassRestoreTest {
    WebDriver driver;

    @Before
    public void kakatStoya() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void closeWeb() {
        driver.close();
    }

    @Test
    public void passwordForget() {
        driver.get("http://dev4.id20.ru");
        WebElement forgetElement = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/div[4]/div/a/span"));
        forgetElement.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement writeLogin = driver.findElement(By.id("passwordrecoveryform-username"));
        writeLogin.sendKeys("kislovaeyu@gmail.com");
        WebElement revorcePassword = driver.findElement(By.xpath("//*[@id=\"recovery-form\"]/div/div/div[3]/button"));
        revorcePassword.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement confirmPassReset = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/section/div/div"));
        String text = confirmPassReset.getText();
        Assert.assertEquals("На указанный E-mail были отправлены инструкции по восставновлению пароля. Прожалуйста, проверьте почту.", text);
    }
}
