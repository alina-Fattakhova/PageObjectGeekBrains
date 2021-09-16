import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GbLoginTest {

    private static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        driver.manage().window().maximize();
    }

    @Test
    public void loginFormTest() {
//        LoginGbPage user1 = new LoginGbPage(driver);
//        user1.register("Applanatest1", "Student2020!");
        driver.findElement(By.xpath ("//input[@id='prependedInput']")).click();
        driver.findElement(By.xpath ("//input[@id='prependedInput']")).sendKeys("Applanatest1");
        Assert.assertFalse("Логин не был введён", driver.findElement(By.xpath("//input[@id='prependedInput']")).getAttribute("value").isEmpty());
        Assert.assertEquals("Ошибка при вводе логина", "Applanatest1", driver.findElement(By.xpath("//input[@id='prependedInput']")).getAttribute("value"));
        driver.findElement(By.xpath ("//input[@id='prependedInput2']")).click();
        driver.findElement(By.xpath ("//input[@id='prependedInput2']")).sendKeys("Student2020!");
        Assert.assertFalse("Пароль не был введён", driver.findElement(By.xpath("//input[@id='prependedInput2']")).getAttribute("value").isEmpty());
        Assert.assertEquals("Ошибка при вводе пароля", "Student2020!", driver.findElement(By.xpath("//input[@id='prependedInput2']")).getAttribute("value"));
        driver.findElement(By.xpath ("//button[@id='_submit']")).click();
    }
    @After
    public void tearDown() {

        driver.quit();
    }
}
