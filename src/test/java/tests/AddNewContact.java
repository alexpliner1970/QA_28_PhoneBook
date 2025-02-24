package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContact extends TestBase {

    @BeforeClass
    public void preCondition() {
        if (!app.getHelperUser().isLogget()) {
            app.getHelperUser().login(new User().setEmail("sdf@wweb").setPassword("Wer34#64"));
        }
    }
    @Test
    public void addNewContactSuccess_1(){
        int i=  new Random().nextInt(1000)+1000;

        Contact contact=Contact.builder()
                .name("Igor")
                .lastName("Break")
                .phone("7345"+i+"7658")
                .email("ser" + i + "@gmail.com")
                .address("Holon")
                .description("Friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));



    }

    @Test
    public void addNewContactSuccess_2() {
        int i = new Random().nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Misha")
                .lastName("Shaz")
                .phone("7345" + i + "7658")
                .email("ser" + i + "@gmail.com")
                .address("Akko")

                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

        Assert.assertTrue(app.getHelperContact().isButtonContactsBlack());

    }

    //==================negative==========================

    @Test
    public void addWithEmtyName(){// Displayed  filed form and error message “Name cant be empty!”

        Contact contact = Contact.builder()
                .name("")
                .lastName("Shaz")
                .phone("7345787657658")
                .email("serft@gmail.com")
                .address("Akko")

                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isButtonAddBlack());
    }

    @Test
    public void addWithEmtyLastName(){//Displayed  filed form and error message “Last Name can be empty!”
        Contact contact = Contact.builder()
                .name("Tom")
                .lastName("")
                .phone("7345787657658")
                .email("serft@gmail.com")
                .address("Akko")

                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isButtonAddBlack());
    }

    @Test
    public void addWithEmtyAddress(){//Displayed  filed form and error message “Address can be empty!”
        Contact contact = Contact.builder()
                .name("Tom")
                .lastName("Shaz")
                .phone("7345787657658")
                .email("serft@gmail.com")
                .address("")

                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isButtonAddBlack());
    }

    @Test
    public void addWithWrongPhone(){// Displayed  filed form and error message “Phone can be in digital format in min 10, max 15 digits!
        Contact contact = Contact.builder()
                .name("Tom")
                .lastName("Shaz")
                .phone("734")
                .email("serft@gmail.com")
                .address("Akko")

                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

        Assert.assertTrue(app.getHelperContact().isButtonAddBlack());
    }
    @Test
    public void addWithWrongEmail(){//Displayed error message “Email can be in email well- format”.
        Contact contact = Contact.builder()
                .name("Tom")
                .lastName("Shaz")
                .phone("7345787657658")
                .email("serftgmail.com")
                .address("Akko")

                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid: "));

        Assert.assertTrue(app.getHelperContact().isButtonAddBlack());
    }


}
