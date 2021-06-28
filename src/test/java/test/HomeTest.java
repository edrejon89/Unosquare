package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.VSProfessionalPage;
import pageobjects.WindowsPage;

public class HomeTest extends BaseTest {
    private HomePage hp;
    private WindowsPage winPage;
    private VSProfessionalPage vsPage;
    private CartPage cp;
    private final String WINDOWSURL = "https://www.microsoft.com/en-us/windows/";
    private double resultPrice;

    @Test(priority = 0)
    public void microsoftTest(){
        hp = new HomePage(driver);
        driver.get("https://www.microsoft.com/en-us/");
        Assert.assertTrue(hp.getOfficeNav(driver).isDisplayed(), "Office option is not visible on nav");
        Assert.assertTrue(hp.getWindowsNav().isDisplayed(), "Windows option in not visible on nav");
        Assert.assertTrue(hp.getSurfaceNav().isDisplayed(), "Surface option in not visible on nav");
        Assert.assertTrue(hp.getXboxNav().isDisplayed(), "Xbox option in not visible on nav");
        Assert.assertTrue(hp.getDealsNav().isDisplayed(), "Deals option in not visible on nav");
        Assert.assertTrue(hp.getSupportNav().isDisplayed(), "Support option in not visible on nav");
        log.info("All elements in nav are visible");

    }

    @Test(priority = 1)
    public void microsoftTest2()  {
        winPage = new WindowsPage(driver);
        hp.clickOnHomeElement(hp.getWindowsNav());
        Assert.assertEquals(driver.getCurrentUrl(), WINDOWSURL);
        winPage.clickWindowsPageElements(winPage.getWin10NavElement(), driver);
        winPage.printWindowsPageElementsText(winPage.getWin10Elements(),driver);

        winPage.clickWindowsPageElements(winPage.getSearchBtn(), driver);
        winPage.searchProduct(winPage.getSearchBtn(), driver, " Visual Studio");
        winPage.clickWindowsPageElements(winPage.getSearchBtn(),driver);
        winPage.closeRegionModal();
        winPage.printSearchResults(winPage.getSearchResults(), 3);
        log.info("Prices were printed");
    }

    @Test(priority = 2)
    public void microsoftTest3()  {
        resultPrice = Double.parseDouble(winPage.getSearchResults().get(0).getText().replace("$","").replace(",",""));
        winPage.clickWindowsPageElements(winPage.getSearchResults().get(0),driver);
        System.out.println("Price: " + resultPrice);
        winPage.closeRegionModal();
        vsPage = new VSProfessionalPage(driver);
        double productPagePrice = vsPage.getPrice(driver);
        System.out.println("resutlPrice " + resultPrice + "\nPrice on product page: " + productPagePrice);
        Assert.assertEquals(productPagePrice, resultPrice, "Products prices do not match");
    }

    @Test(priority = 3)
    public void microsoftTest4()  {
        cp = new CartPage(driver);
        vsPage.addToCart();
        Assert.assertTrue(cp.arePricesVisible(driver));
        Assert.assertEquals(cp.getPrice(),cp.getSummaryPrice());
        Assert.assertEquals(cp.getSummaryPrice(),cp.getTotal());
    }

    @Test(priority = 4)
    public void microsoftTest5()  {
        cp.selectPiecestAmount(20);
//        Assert.assertEquals();
//        Thread.sleep(5000);
    }

}
