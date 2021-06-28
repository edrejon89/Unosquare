package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VSProfessionalPage {

    @FindBy(xpath = "//div[contains(@id,'ProductPrice_productPrice_PriceContainer')]/descendant::span")
    WebElement price;
    @FindBy(id = "buttonPanel_AddToCartButton")
    WebElement addCartBtn;

    public VSProfessionalPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public double getPrice(WebDriver driver){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(price));
        double price = Double.parseDouble(this.price.getText().replace("$","").replace(",",""));
        System.out.println("Casted Price " + price);
        return price;
    }

    public void addToCart(){
        addCartBtn.click();
    }


}
