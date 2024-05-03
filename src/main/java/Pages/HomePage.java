package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
     WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }
    private   By Registerationbutton = By.className("ico-register");
    public  RegisterationPage clickonRegisterationbutton(){
        driver.findElement(Registerationbutton).click();
        return new RegisterationPage(driver);
    }
}
