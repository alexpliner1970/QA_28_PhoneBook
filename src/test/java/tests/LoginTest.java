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
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sdf@wweb","Wer34#64");
        app.getHelperUser().sumitLogin();

        //Assert.assertEquals();
        //Assert.assertNotEquals();
        Assert.assertTrue(app.getHelperUser().isLogget());
       // Assert.assertFalse();

    }

    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sdf@wweb","Wer34#64");
        app.getHelperUser().sumitLogin();



        Assert.assertTrue(app.getHelperUser().isLogget());


    }
}
