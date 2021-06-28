package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WindowsPage {

    String firstResultPrice;


    @FindBy(css = "button[id='c-shellmenu_54']")
    WebElement win10NavElement;
    @FindBy(xpath = "//button[@id='c-shellmenu_54']/following-sibling::ul/descendant::a")
    private List<WebElement> win10Elements;
    @FindBy(id = "search")
    private WebElement searchBtn;
    @FindBy(id = "R1MarketRedirect-1")
    WebElement regionModal;
    @FindBy(xpath = "//*[@id='R1MarketRedirect-1']/descendant::button[1]")
    WebElement regionModalCloseBtn;
    @FindBy(xpath = "//span[@itemprop=\"price\"]")
    private List<WebElement> searchResults;

    public WindowsPage(WebDriver driver){
            PageFactory.initElements(driver, this);
    }

    public WebElement getWin10NavElement() {
        return win10NavElement;
    }
    public List<WebElement> getWin10Elements() {
        return win10Elements;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }

    public WebElement getRegionModal() {
        return regionModal;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public WebElement getRegionModalCloseBtn() {
        return regionModalCloseBtn;
    }

    public void clickWindowsPageElements(WebElement el, WebDriver driver){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(el));
       el.click();
    }



    public void printWindowsPageElementsText(List<WebElement> win10Elements, WebDriver driver) {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(win10Elements.get(0)));
        for(WebElement el : win10Elements){
            System.out.println(el.getText());

        }
    }

    public void searchProduct(WebElement el, WebDriver driver, String text){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(el));
        el.sendKeys(text);
    }

    public void closeRegionModal(){
        if (regionModal.isDisplayed()){
            regionModalCloseBtn.click();
        }
    }

    public void printSearchResults(List<WebElement> els, int resultsAmount ){
        for( int i = 0; i <= resultsAmount - 1; i++){
            System.out.println("Product " + (i+1) + " price: " + els.get(i).getText());
        }
    }

    public String storeValue(List<WebElement> els){
        return els.get(0).getText();
    }

}
