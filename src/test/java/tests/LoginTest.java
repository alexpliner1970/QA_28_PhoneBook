package tests;

import manager.HelperUser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        if(app.getHelperUser().isLogget())
            app.getHelperUser().logout();
        logger.info("Before method finished logout");
    }

    @Test
    public void loginSuccess(){
        logger.info("Start test with name 'loginSuccess'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sdf@wweb","Wer34#64");
        logger.info("Test data --> email: 'sdf@wweb' & password: 'Wer34#64'");
        app.getHelperUser().submitLogin();


        Assert.assertTrue(app.getHelperUser().isLogget());
        logger.info("Assert check is element button 'Sign out' present");

    }

    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sdf@wweb","Wer34#64");
        app.getHelperUser().submitLogin();



        Assert.assertTrue(app.getHelperUser().isLogget());


    }
    @Test
    public void loginWrongEmail(){
        logger.info("Test data --> email: 'sdfwweb' & password: 'Wer34#64'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sdfwweb","Wer34#64");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test data --> email: 'sdf@wweb' & password: 'Wer34#61'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sdf@wweb","Wer34#61");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }
    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data --> email: 'sdаf@wweb' & password: 'Wer34#62'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sdft@wweb","Wer34#62");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

}
