package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preconditions(){
        if(app.getHelperUser().isLogget())
            app.getHelperUser().logout();
    }

    @Test
    public void registrationSuccess(){
        Random random= new Random();
        int i= random.nextInt(1000)+1000;

        User user=new User()
                .setEmail("ser" + i + "@gmail.com")
                .setPassword("Wer34#64");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogget());

    }
    //=================Negative===========

    @Test
    public void registrationWrongEmail() {
        User user=new User()
                .setEmail("gmail.com")
                .setPassword("Wer34#64");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertTrue(app.getHelperUser().error400());
    }
    @Test
    public void registrationEmptyEmail() {
        User user=new User()
                .setEmail("")
                .setPassword("Wer34#64");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertTrue(app.getHelperUser().error400());
    }
    @Test
    public void registrationWrongPassword() {
        User user=new User()
                .setEmail("sdf@wt.com")
                .setPassword("Wer");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertTrue(app.getHelperUser().error400());
    }

    @Test
    public void registrationEmptyPassword() {
        User user=new User()
                .setEmail("sdf@wt.com")
                .setPassword("");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertTrue(app.getHelperUser().error400());
    }
    @Test
    public void registrationRegisteredUser() {
        User user=new User()
                .setEmail("sdf@wweb")
                .setPassword("Wer34#64");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
        Assert.assertTrue(app.getHelperUser().error409());
    }
}
