package com.vytrack.pages;


import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase{

    @FindBy(id = "prependedInput") //we put annotation FindBy on top of instance var and specify locator type
    private WebElement username; //this is reference for username WebElement
    //or  public WebElement username2 = Driver.getDriver().findElement(By.id("perpendedInput"));

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessageText() {
        return warningMessage.getText();
    }

    /**
     * Method to login, version 1
     * Login as a specific user
     *
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue) { //this method is overloaded
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

    /**
     * Method to login, version 2
     * Login as a default user
     * Credentials will be retrieved from the configuration.properties file
     */
    public void login() {
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

    /**
     * this method stands for login based on user type
     * For example: if param is equals to driver, user will login as a driver
     * If role param is incorrect, method will throw exception
     * @param role - driver, sales manager or store manager
     */
    public void login(String role){
        String userName = "";
        if (role.equalsIgnoreCase("driver")) {
            userName = "user15";
        }else if(role.equalsIgnoreCase("sales manager")){
            userName = "salesmanager110";
        }else if(role.equalsIgnoreCase("store manager")){
            userName = "storemanager85";
        }else{
            throw new RuntimeException(("Invalid role!"));
        }
        System.out.println("Login as: " + role);
        login(userName, "UserUSer123");
    }
}
