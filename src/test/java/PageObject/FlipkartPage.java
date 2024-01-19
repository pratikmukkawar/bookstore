package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.flipkart.com/
public class FlipkartPage {
    @FindBy(css = "html > body > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > div > div > div > a > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1)")
    public WebElement divApplePhoneProNatural;

    public FlipkartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}