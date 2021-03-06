package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private static final By BOT_LOGO = By.xpath("//*[@class='bot_column']");

    public ProductsPage login(String username, String password) {
        waitForElementLocated(USERNAME_INPUT, 10);
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return  new ProductsPage(driver);
    }
    public void waitForPageOpenedExample() {
        waitForElementLocated(BOT_LOGO, 10);
    }
    public void typeTextInFrames() {
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("asdsd");
        driver.switchTo().defaultContent();
    }
    public String getPasswordErrorMessage() {
        return driver.findElement(By.xpath("//*//*[@id='login_button_container']//h3")).getText();
    }
    public String getLoginErrorMessageText() {
        return driver.findElement(By.xpath("//*[@ data-test='error']")).getText();
    }

    public LoginPage openPage(){
        openPage(BASE_URL);
        waitForPageLoaded();
        return this;
    }
}
