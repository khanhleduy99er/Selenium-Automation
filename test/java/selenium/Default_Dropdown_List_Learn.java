package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Default_Dropdown_List_Learn {
    WebDriver driver;
    @BeforeClass
    public void setUpBrowser() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        // maximize browser window
        driver.manage().window().maximize();
        driver.get("https://translate.google.com/");
    }
    @Test
    public void test() {
        driver.findElement(By.xpath("//span[text()=\"Images\"]")).click();
    }

    @AfterClass
    public void tearDownBrowser() {
        driver.quit();
    }
}
