package base;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver;
    protected static Logger log;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/Rejon/IdeaProjects/Unosquare/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("deny-permission-prompts");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        log =  Logger.getLogger(this.getClass());
        BasicConfigurator.configure();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
