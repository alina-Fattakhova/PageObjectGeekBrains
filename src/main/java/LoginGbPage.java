
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginGbPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement username;
    @FindBy(xpath = "//input[@name='_password']")
    private WebElement password;
    @FindBy(xpath = "//button[@id='_submit']")
    private WebElement enterButton;

    public LoginGbPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginGbPage setUsername(String username) {
        this.username.sendKeys(username);
        return this;
    }

    public LoginGbPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public GbSpacePage clickEnterButton() {
        this.enterButton.click();
        return new GbSpacePage(driver);
    }

    public GbSpacePage register(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
        this.clickEnterButton();
        return new GbSpacePage(driver);
    }

}
