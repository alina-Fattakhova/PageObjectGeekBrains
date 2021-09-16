import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GbLoginTest {

    private static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space/user/login");
    }

    @Test
    public void loginFormTest() {
        LoginGbPage user1 = new LoginGbPage(driver);
        user1.register("Applanatest1", "Student2020!");
        Assert.assertFalse("Логин не был введён", driver.findElement(By.xpath("//input[@name='_username']")).getAttribute("value").isEmpty());
        Assert.assertEquals("Ошибка при вводе логина", "Applanatest1", driver.findElement(By.xpath("//input[@name='_username']")).getAttribute("value"));
        Assert.assertFalse("Пароль не был введён", driver.findElement(By.xpath("//input[@id='_password']")).getAttribute("value").isEmpty());
        Assert.assertEquals("Ошибка при вводе пароля", "Student2020!", driver.findElement(By.xpath("//input[@id='_password']")).getAttribute("value"));
    }
}
