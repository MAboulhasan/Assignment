package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterationPage {
    WebDriver driver;
    public RegisterationPage(WebDriver driver) {

        this.driver = driver;
    }
    private By Firstnamefield = By.id("FirstName");
    private By Lastnamefield = By.id("LastName");
    private By Emailfield = By.id("Email");
    private By passwordfield = By.id("Password");
    private By confirmPasswordfield = By.id("ConfirmPassword");
    private By Companyfield = By.id("Company");
    private   By Genderfield =  By.id("gender-male");
    private   By RegisterButton =  By.id("register-button");
    private By validation = By.className("result");
    private By errormessageinvalidemail = By.xpath("//*[@id=\"Email-error\"]");
    private By errormessagesameemail = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/ul/li");




    public String ValidationMessage(){
        String text = driver.findElement(validation).getText();
        return text;
    }
    public String errormessage1(){
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

        driver.findElement(Lastnamefield).sendKeys(Lastname);
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


}
