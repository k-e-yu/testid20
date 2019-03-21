import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class PasswordErrorTest {
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://dev4.id20.ru");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void passErrorTest() {

        WebElement loginElement = driver.findElement(By.id("loginform-username"));
        loginElement.sendKeys("kislovaeyu@gmail.com");
        WebElement passwordElement = driver.findElement(By.id("loginform-password"));
        passwordElement.sendKeys("VRCAjb7vVySQv2J");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/div[4]/div/button"));
        loginButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement chekErrorMessage = driver.findElement(By.cssSelector("#login-form > div.col-xs-12.col-sm-6.col-md-6 > div.alert.alert-danger > div > p"));
        String errorMsg = chekErrorMessage.getText();
        Assert.assertEquals("Исправьте следующие ошибки:", errorMsg);
    }
}
