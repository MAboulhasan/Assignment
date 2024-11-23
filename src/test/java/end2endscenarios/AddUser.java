package end2endscenarios;

import base.BaseTests;
import Pages.AdminViewUsersPage;
import Pages.AdminSaveUsersPage;
import Pages.DashboardPage;
import reader.ReadDataFromJson;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class AddUser extends BaseTests {
    ReadDataFromJson readDataFromJson;

    @Test
    public void testAddUser() throws FileNotFoundException, InterruptedException {
        readDataFromJson = new ReadDataFromJson();

        homePage.insertUsername(readDataFromJson.readJsonFile().Login.ValidCredentials.Username);
        homePage.insertPassword(readDataFromJson.readJsonFile().Login.ValidCredentials.Password);
        DashboardPage dashboardPage = homePage.clickOnLoginButton();


        AdminViewUsersPage admin = dashboardPage.clickOnAdminButton();

        String recordsbeforeadd = admin.recordnumber();
        System.out.println("Total Number Of Records :" + recordsbeforeadd);

        AdminSaveUsersPage adminUserSave = admin.clickOnAddButton();


        adminUserSave.enterUsername(readDataFromJson.readJsonFile().Admin.SaveUser.usernamesave);
        adminUserSave.enterPassword(readDataFromJson.readJsonFile().Admin.SaveUser.passwordsave);
        adminUserSave.enterconfirmPassword(readDataFromJson.readJsonFile().Admin.SaveUser.confirmpasswordsave);
        adminUserSave.selectUserRole();
        adminUserSave.selectUserStatus();
        adminUserSave.employeeName();
        adminUserSave.saveUserData();


        String recordsafteradd = admin.recordnumber();
        System.out.println("Total Number Of Records After Add Username :" + recordsafteradd);

        admin.searchUsername(readDataFromJson.readJsonFile().Admin.SaveUser.usernamesave);
        admin.clickSearch();

        admin.clickDelete();
        admin.confirmDelete();

        dashboardPage.clickOnAdminButton();
        String recordsafterdelete = admin.recordnumber();
        System.out.println("Total Number Of Records After Delete Username :" + recordsafterdelete);

        Assert.assertEquals(recordsbeforeadd,recordsafterdelete);













    }
}
