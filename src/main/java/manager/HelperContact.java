package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input[placeholder='Name']"),contact.getName());
        type(By.cssSelector("input[placeholder='Last Name']"),contact.getLastName());
        type(By.cssSelector("input[placeholder='Phone']"),contact.getPhone());
        type(By.cssSelector("input[placeholder='email']"),contact.getEmail());
        type(By.cssSelector("input[placeholder='Address']"),contact.getAddress());
        type(By.cssSelector("input[placeholder='description']"),contact.getDescription());

    }

    public void saveContact() {
        click(By.xpath("//b"));
    }

    public boolean isButtonContactsBlack(){
        return isElementPresent(By.cssSelector("a.active[href='/contacts']"));
    }

    public boolean isButtonAddBlack(){
        return isElementPresent(By.cssSelector("a.active[href='/add']"));

    }
    public boolean isContactAddedByName(String name){
        for(WebElement elem:listContacts(By.cssSelector("h2"))){
            if (elem.getText().equals(name)){
                return true;
            }
        } return false;
    }

    public boolean isContactAddedByPhone(String phone){
        for(WebElement elem:listContacts(By.cssSelector("h3"))){
            if (elem.getText().equals(phone)){
                return true;
            }
        } return false;
    }

    public void provideContacts(Contact contact){
        while (listContacts(By.cssSelector("h2")).size()<3){
            openContactForm();
            fillContactForm(contact);
            saveContact();

        }
    }



    public int removeContact() {
        int e, r;
        r = listContacts(By.cssSelector("h2")).size();
        remove();
        pause(1500);
        e = listContacts(By.cssSelector("h2")).size();
        return r - e;
    }
    public int removeAllContacts(){
        do {
            remove();
            pause(750);
        }while (!listContacts(By.cssSelector("h3")).isEmpty());

        return listContacts(By.cssSelector("h3")).size();
    }


}
