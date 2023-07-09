package Base_element;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Text_Box {
    public WebDriver driver;
    public JavascriptExecutor javascriptExecutor;
    public String pageTextBoxUrl = "https://demoqa.com/text-box";
    public long timeWait = 3000;

    // element in website
    String fullNameInput = "khanh le ";
    String emailAddressInput = "khanhleduy99er@gmail.com";
    String currentAddressInput = "555b/A2 nhi hoa, thanh pho bien hoa";
    String permanentAddressInput = "none";

    // locator for input text box
    By nameTextBox = By.xpath("//input[@id=\"userName\" and @type=\"text\"]");
    By emailTextBox = By.xpath("//input[@id=\"userEmail\" and @type=\"email\"]");
    By currentAddressTextBox = By.xpath("//textarea[@id=\"currentAddress\" and @class=\"form-control\"]");
    By permanentAddressTextBox = By.xpath("//textarea[@id=\"permanentAddress\" and @class=\"form-control\"]");
    By submitButton = By.xpath("//button[@id=\"submit\" and @type=\"button\"]");

    public void generateDriverBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // input text box function
    public void TextBoxWebElement(By locator, String inputTextBoxElement){
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(inputTextBoxElement);
    }

    // click function
    public void SubmitButtonElement(By locator){
        WebElement element = driver.findElement(locator);
        element.submit();
    }

    @BeforeClass
    public void BeforeClass(){
        generateDriverBrowser();

        javascriptExecutor = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get(pageTextBoxUrl);
    }
    @Test
    public void TC_01_InputIntoTextBox(){
        TextBoxWebElement(nameTextBox, fullNameInput);
        TextBoxWebElement(emailTextBox, emailAddressInput);
        TextBoxWebElement(currentAddressTextBox, currentAddressInput);
        TextBoxWebElement(permanentAddressTextBox, permanentAddressInput);

        SubmitButtonElement(submitButton);
    }


    @AfterClass
    public void AfterClass(){
        driver.quit();
    }

}
