package workshops;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class SeleniumTestMethodsWithJUnit {

    WebDriver webDriver;

    @BeforeEach
    public void start(){
        webDriver=new ChromeDriver();
        webDriver.navigate().to(GlobalConstants.BASE_URL);
    }

    @AfterEach
    public void finish(){
        webDriver.quit();
    }

    @Test
    public void testLoginPageTitle(){
        String expectedTitle="Swag Labs";
        String actualTitle=webDriver.getTitle();
        assertEquals(expectedTitle,actualTitle);
    }

   @Test
    public void testLoginWithValidCredentials(){

       WebElement usernameInput=webDriver.findElement(By.id(GlobalConstants.USERNAME));
       usernameInput.sendKeys("standard_user");

       WebElement passwordInput=webDriver.findElement(By.id(GlobalConstants.PASSWORD));
       passwordInput.sendKeys("secret_sauce");

       WebElement loginButton=webDriver.findElement(By.id(GlobalConstants.LOGIN_BTN));
       loginButton.click();

       String expectedURL="https://www.saucedemo.com/v1/inventory.html";
       String actualURL=webDriver.getCurrentUrl();
       assertEquals(expectedURL,actualURL);
    }

    @Test
    public void testErrorMessageDisplayedWithInvalidCredentials(){
        WebElement usernameInput=webDriver.findElement(By.id(GlobalConstants.USERNAME));
        usernameInput.sendKeys("acelya_deneme");

        WebElement passwordInput=webDriver.findElement(By.id(GlobalConstants.PASSWORD));
        passwordInput.sendKeys("acelya");

        WebElement loginButton=webDriver.findElement(By.id(GlobalConstants.LOGIN_BTN));
        loginButton.click();

        WebElement errorText=webDriver.findElement(By.tagName("h3"));
        String expectedError="Epic sadface: Username and password do not match any user in this service";
        String actualError=errorText.getText();
        assertEquals(expectedError,actualError);
    }

    @Test
    public void testCountInputFields(){
        List<WebElement>inputs=webDriver.findElements(By.cssSelector("input"));
        int expectedInput=3;
        int actualInput=inputs.size();
        assertEquals(expectedInput,actualInput);
    }
    @Test
    public void testUsernameInputUnabled(){
        WebElement usernameInput=webDriver.findElement(By.id(GlobalConstants.USERNAME));
        assertTrue(usernameInput.isEnabled());
    }

    @Test
    public void logoDisplayedTest(){
        WebElement loginLogo=webDriver.findElement(By.className(GlobalConstants.LOGIN_LOGO));
        assertTrue(loginLogo.isDisplayed());
    }

    @Test
    public void testInputValues(){
        List<WebElement> inputs=webDriver.findElements(By.cssSelector("input"));
        for (WebElement input:inputs){
            assertNotNull(input.getAttribute("value"));
        }
    }

    @Test
    public void testPasswordInputValue(){
        WebElement passwordInput=webDriver.findElement(By.id(GlobalConstants.PASSWORD));
        passwordInput.sendKeys("acelya");
        String expectedResult="acelyza";
        String actualResult=passwordInput.getAttribute("value");
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testErrorMessageDisplayedWithEmptyPassword(){
        WebElement usernameInput=webDriver.findElement(By.id(GlobalConstants.USERNAME));
        usernameInput.sendKeys("acelya_deneme");

        WebElement loginButton=webDriver.findElement(By.id(GlobalConstants.LOGIN_BTN));
        loginButton.click();

        WebElement errorText=webDriver.findElement(By.tagName("h3"));
        String expectedError="Epic sadface: Passwordfdsv is required";
        String actualError=errorText.getText();
        assertEquals(expectedError,actualError);

    }

}

