package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(css = "a[id='shellmenu_1']")
    private WebElement officeNav;
    @FindBy(css = "a[id='shellmenu_2']")
    private WebElement windowsNav;
    @FindBy(css = "a[id='shellmenu_3']")
    private WebElement surfaceNav;
    @FindBy(css = "a[id='shellmenu_4']")
    private  WebElement xboxNav;
    @FindBy(css = "a[id='shellmenu_5']")
    private  WebElement dealsNav;
    @FindBy(css = "a[id='shellmenu_1']")
    private WebElement supportNav;


    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public WebElement getOfficeNav() { return officeNav; }
    public WebElement getOfficeNav(WebDriver driver) {
        return new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id='shellmenu_1")));
    }

    public WebElement getWindowsNav() {
        return windowsNav;
    }

    public WebElement getSurfaceNav() {
        return surfaceNav;
    }

    public WebElement getXboxNav() {
        return xboxNav;
    }

    public WebElement getDealsNav() {
        return dealsNav;
    }

    public WebElement getSupportNav() {
        return supportNav;
    }

    public void clickOnHomeElement(WebElement el){
        el.click();
    }

}
