package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddContactForm() {
        click(By.cssSelector("a[href='/add'"));
    }

    public void fillAddContactForm(Contact contact) {
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




    public String existContact() {
        openContactInf(By.xpath("//h2[normalize-space()='Igor']"));
        pause(2000);
        return wd.findElement(By.cssSelector(".contact-item-detailed_card__50dTS")).getText();
    }



    public boolean isButtonContactsBlack(){
        return isElementPresent(By.cssSelector("a.active[href='/contacts']"));
    }

    public boolean isButtonAddBlack(){
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }
}
