package Base_element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Check_Box extends Text_Box {
    public String pageCheckBoxUrl = "https://demoqa.com/checkbox";
    // element check box in website
    By checkBoxElement = By.xpath("//span[@class=\"rct-checkbox\"]");
    By toggleButtonElement = By.xpath("//span[@class=\"rct-text\"]//child::button");

    public void ClickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }
    @BeforeClass
    public void BeforeClass(){
        generateDriverBrowser();

        driver.manage().window().maximize();
        driver.get(pageCheckBoxUrl);
    }

    @Test
    public void TC_02_CheckBox (){
        WebElement checkCheckBox = driver.findElement(checkBoxElement);

        if(checkCheckBox.isEnabled()){
            ClickElement(toggleButtonElement);
            System.out.println("The toggle button has been clicked");
        }
    }


}
