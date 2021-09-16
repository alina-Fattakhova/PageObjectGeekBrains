import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GbSpacePage {
    WebDriver driver;

    public GbSpacePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
