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
        logger.info("Before method finished logout");
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
        app.getHelperUser().pause(2000);
        logger.info("Test data --> email:"+ "'"+user.getEmail()+"'"+" & password: 'Wer34#64'");
        app.getHelperUser().submitRegistration();



        Assert.assertTrue(app.getHelperUser().isLogget());

        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
        logger.info("Assert check is text 'No Contacts here!'");

    }
    //=================Negative===========

    @Test
    public void registrationWrongEmail() {
        User user=new User()
                .setEmail("gmail.com")
                .setPassword("Wer34#64");
        logger.info("Test data --> email: 'gmail.com' & password: 'Wer34#64'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertTrue(app.getHelperUser().error400());
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test
    public void registrationWrongPassword() {
        User user=new User()
                .setEmail("sdf@wt.com")
                .setPassword("Wer");
        logger.info("Test data --> email: 'sdf@wt.com' & password: 'Wer'");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertTrue(app.getHelperUser().error400());
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    
    @Test
    public void registrationRegisteredUser() {
        User user=new User()
                .setEmail("sdf@wweb")
                .setPassword("Wer34#64");
        logger.info("Test data --> email: 'sdf@wweb' & password: 'Wer34#64'");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
        Assert.assertTrue(app.getHelperUser().error409());
        logger.info("Assert check is alert present with error text 'User already exist'");
    }
}
