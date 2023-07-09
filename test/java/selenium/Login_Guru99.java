package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Guru99 {
    private WebDriver driver;
    private WebElement emailAddressElement;
    private WebElement passwordElement;
    private WebElement loginButtonElement;
    private WebElement statusLoginElement;

    public String emailInput = "khanhld@gmail.com";
    public String passwordInput = "123456";
    public int timeWait = 100 ;
    public int timeWaitReload = 18000;
    public String beforeUrl ;
    public void generateEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }
    @BeforeClass
    public void setUp() {
        generateEdgeDriver();

        // maximize browser window
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/login.html");

        // generate elements locator
        beforeUrl = driver.getCurrentUrl();
        emailAddressElement = driver.findElement(By.xpath("//input[@class='is_required validate account_input form-control' and @name='email']"));
        passwordElement = driver.findElement(By.xpath("//input[@class='is_required validate account_input form-control' and @name='passwd']"));
        loginButtonElement = driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']"));
    }
    @Test
    public void TCs_Login()
        {
        // input email address
        emailAddressElement.sendKeys(emailInput) ;
        // waiting then input email address
        try {
            Thread.sleep(timeWait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // input password
        passwordElement.sendKeys(passwordInput) ;
        // waiting then input email address

        // click login btn
        loginButtonElement.click();

            try {
                Thread.sleep(timeWait);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }

    @Test
    public void TCs_CheckSuccessful(){
        // waiting loading website then get url

        String getStatus = driver.findElement(By.xpath("//div[@class='error-copy']/h3")).getText();
        String expectStatus = "Successfully Logged in..." ;
        Assert.assertEquals(getStatus, expectStatus);
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}
