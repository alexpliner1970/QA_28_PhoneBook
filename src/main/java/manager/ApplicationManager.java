package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;
    HelperContact helperContact;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init(){
        wd=new ChromeDriver();
        logger.info("All tests rus in Chrom");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://telranedu.web.app/home");
        logger.info("The link --->"+ wd.getCurrentUrl());
        helperUser=new HelperUser(wd);

        helperContact = new HelperContact(wd);
        WebDriverListener webDriverListener=new WDListener();



    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperContact getHelperContact() {
        return helperContact;
    }

    public void stop() {

        wd.quit();
    }

}
