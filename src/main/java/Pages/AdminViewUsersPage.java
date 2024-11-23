package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminViewUsersPage {
    WebDriver driver;

    public AdminViewUsersPage(WebDriver driver) {

        this.driver = driver;
    }

    private By record = By.xpath("//span[@class='oxd-text oxd-text--span']");
    private By addbutton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private By usernamebox = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    private By searchbutton = By.xpath("//button[@type='submit']");
    private By deleteicon = By.xpath("//i[@class ='oxd-icon bi-trash']");
    private By confirmdelete = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");


    public String recordnumber()  {
        String text = driver.findElement(record).getText();
        return text;
    }
    public void searchUsername(String usernameS){

        driver.findElement(usernamebox).sendKeys(usernameS);
    }
    public void clickSearch(){

        driver.findElement(searchbutton).click();
    }
    public void clickDelete(){

        driver.findElement(deleteicon).click();
    }
    public void confirmDelete(){

        driver.findElement(confirmdelete).click();
    }

    public AdminSaveUsersPage clickOnAddButton() {
        driver.findElement(addbutton).click();
        return new AdminSaveUsersPage(driver);
    }

    /*public String errormessage1(){
        String text = driver.findElement(errormessageinvalidemail).getText();
        return text;
    }
    public String errormessage2(){
        String text = driver.findElement(errormessagesameemail).getText();
        return text;
    }
    public void clickRegister(){

        driver.findElement(RegisterButton).click();
    }
    public void clickGender(){

        driver.findElement(Genderfield).click();
    }
    public void insertFirstname(String FirstName){
        driver.findElement(Firstnamefield).sendKeys(FirstName);
    }
    public void insertLastname(String Lastname){

        driver.findElement(records).sendKeys(Lastname);
    }

    public void insertPassword(String password){
        driver.findElement(passwordfield).sendKeys(password);
    }

    public void insertConfirmPassword(String confirmPassword){
        driver.findElement(confirmPasswordfield).sendKeys(confirmPassword);
    }
    public void insertEmail(String Email){

        driver.findElement(Emailfield).sendKeys(Email);
    }

    public void insertCompany(String Company){

        driver.findElement(Companyfield).sendKeys(Company);
    }
*/

}
