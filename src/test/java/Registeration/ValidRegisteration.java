package Registeration;

import Base.BaseTests;
import Pages.RegisterationPage;
import Reader.ReadDataFromJson;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.AssertJUnit.assertTrue;

public class ValidRegisteration extends BaseTests {

    ReadDataFromJson readDataFromJson;

    @Test
    public void testsuccesfullregister() throws FileNotFoundException {
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


        String actualResult = registerationPage.ValidationMessage();
        String expectedResult = "Your registration completed";
        assertTrue(actualResult.contains(expectedResult));


    }


}



