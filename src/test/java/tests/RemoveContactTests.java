package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void preCondition() {

        int i = new Random().nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Misha")
                .lastName("Shaz")
                .phone("7345" + i + "7658")
                .email("ser" + i + "@gmail.com")
                .address("Akko")
                .build();
        if (!app.getHelperUser().isLogget()) {
            app.getHelperUser().login(new User().setEmail("sdf@wweb").setPassword("Wer34#64"));
        }
        app.getHelperContact().openContacts();
        app.getHelperContact().provideContacts(contact);
    }
    @Test
    public void removeFirstContact(){
        Assert.assertEquals(app.getHelperContact().removeContact(),1);

    }
    @Test
    public void removeAllContacts(){
        Assert.assertEquals(app.getHelperContact().removeAllContacts(),0);


    }
}
