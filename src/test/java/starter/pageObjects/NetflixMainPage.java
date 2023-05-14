package starter.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@DefaultUrl("https://www.netflix.com/")
public class NetflixMainPage extends PageObject {

    String tittle = "Netflix";
    public NetflixMainPage() {}

    @FindBy(css = "a[role='button']") private WebElement logInBtn;

    public void MaximizeWindow()
    {
        getDriver().manage().window().maximize();
    }

    public void verifyCurrentURL()
    {
        Assert.assertEquals(tittle,  getDriver().getTitle().substring(0,7));
        System.out.println(getDriver().getTitle());
    }

    public void clickLogInButton()
    {
        waitForCondition().withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(logInBtn));
        logInBtn.click();
    }

}
