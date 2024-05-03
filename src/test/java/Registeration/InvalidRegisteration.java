package Registeration;

import Base.BaseTests;
import Pages.HomePage;
import Pages.RegisterationPage;
import Reader.ReadDataFromJson;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.AssertJUnit.assertTrue;

public class InvalidRegisteration extends BaseTests {

    ReadDataFromJson readDataFromJson;

    @Test(priority = 1)
    public void testregisterwithsameemail() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();

        RegisterationPage registerationPage = homePage.clickonRegisterationbutton();
        registerationPage.clickGender();
        registerationPage.insertFirstname(readDataFromJson.readJsonFile().Registeration.ValidCredentials.Firstname);
        registerationPage.insertLastname(readDataFromJson.readJsonFile().Registeration.ValidCredentials.Lastname);
        registerationPage.insertEmail(readDataFromJson.readJsonFile().Registeration.ValidCredentials.Email);
        registerationPage.insertPassword(readDataFromJson.readJsonFile().Registeration.ValidCredentials.Password);
        registerationPage.insertConfirmPassword(readDataFromJson.readJsonFile().Registeration.ValidCredentials.ConfirmPassword);
        registerationPage.insertCompany(readDataFromJson.readJsonFile().Registeration.ValidCredentials.Company);
        registerationPage.clickRegister();


        String actualResult = registerationPage.errormessage2();
        String expectedResult = "The specified email already exists";
        assertTrue(actualResult.contains(expectedResult));


    }
    @Test(priority = 2)
    public void testinvalidemailregister() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();

        RegisterationPage registerationPage = homePage.clickonRegisterationbutton();
        registerationPage.clickGender();
        registerationPage.insertFirstname(readDataFromJson.readJsonFile().Registeration.InvalidCredentials.Invalidemail.Firstname);
        registerationPage.insertLastname(readDataFromJson.readJsonFile().Registeration.InvalidCredentials.Invalidemail.Lastname);
        registerationPage.insertEmail(readDataFromJson.readJsonFile().Registeration.InvalidCredentials.Invalidemail.Email);
        registerationPage.insertPassword(readDataFromJson.readJsonFile().Registeration.InvalidCredentials.Invalidemail.Password);
        registerationPage.insertConfirmPassword(readDataFromJson.readJsonFile().Registeration.InvalidCredentials.Invalidemail.ConfirmPassword);
        registerationPage.insertCompany(readDataFromJson.readJsonFile().Registeration.InvalidCredentials.Invalidemail.Company);
        registerationPage.clickRegister();


        String actualResult = registerationPage.errormessage1();
        String expectedResult = "Please enter a valid email address.";
        assertTrue(actualResult.contains(expectedResult));

    }
}
