package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    @FindBy(xpath = "(//span[@itemprop=\"price\"])[1]")
    WebElement unitPrice;
    @FindBy(xpath = "(//span[@itemprop=\"price\"])[2]")
    WebElement summaryPrice;
    @FindBy(xpath = "(//span[@itemprop=\"price\"])[3]")
    WebElement total;
    @FindBy (css = "select[aria-label=\"Visual Studio Professional Subscription  Quantity selection\"]")
    WebElement pieces;


    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        return unitPrice.getText();
    }

    public String getSummaryPrice() {
        return summaryPrice.getText();
    }

    public String getTotal() {
        return total.getText();
    }

    public void selectPiecestAmount(int piecesAmount){
        Select pieces = new Select(this.pieces);
        pieces.selectByValue(Integer.toString(piecesAmount));
    }

    public double priceMultipleItems(WebElement el){
        return Double.parseDouble(el.getText().replace(",", "").replace("$", ""));
    }

    public boolean arePricesVisible(WebDriver driver){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(unitPrice));
        return unitPrice.isDisplayed() && summaryPrice.isDisplayed() && total.isDisplayed();
    }


}
