package starter.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@DefaultUrl("https://www.netflix.com/us-es/login")
public class NetflixLoginPage extends PageObject {

    String tittle = "Netflix";
    public NetflixLoginPage() {}

    @FindBy(id = "id_userLoginId") private WebElement emailInput;
    @FindBy(id = "id_password") private WebElement passInput;
    @FindBy(css = "button[type='submit']") private WebElement logInBtn;
    @FindBy(className = "ui-message-contents") private WebElement errorMsgDiv;

    public void verifyLogInPage()
    {
        Assert.assertEquals(tittle,  getDriver().getTitle());
    }

    public void enterUserCredentials(String email, String password)
    {
        waitForCondition().withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
        waitForCondition().withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(passInput));
        passInput.sendKeys(password);
    }

    public void clickLogInButton()
    {
        waitForCondition().withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(logInBtn));
        logInBtn.click();
    }

    public void verifyErrorMessage()
    {
        waitForCondition().withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(errorMsgDiv));
        System.out.println(errorMsgDiv.getText());
    }

}
