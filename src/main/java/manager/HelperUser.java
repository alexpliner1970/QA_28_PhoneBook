package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {

        super(wd);
    }


    public void openLoginRegistrationForm(){
//        WebElement loginTab=wd.findElement(By.cssSelector("a[href='/login'")) ;
//        loginTab.click();
        click(By.cssSelector("a[href='/login'"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        //WebElement emailInput =wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys();
        type(By.name("email"),email);


       // WebElement passwordInput=wd.findElement(By.xpath("//input[last()]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys();
        type(By.xpath("//input[last()]"),password);
    }

    public void fillLoginRegistrationForm(User user){
        type(By.name("email"), user.getEmail());
        type(By.xpath("//input[last()]"),user.getPassword());

    }
    public void submitLogin(){
        click(By.xpath("//button[text()='Login']"));

    }

    public boolean isLogget() {
        return isElementPresent(By.xpath("//button[text()= 'Sign Out']"));
    }


    public void logout() {
        click(By.xpath("//button[text()= 'Sign Out']"));
    }


    public void submitRegistration() {
        click(By.xpath("//button[text()='Registration']"));
    }
}
