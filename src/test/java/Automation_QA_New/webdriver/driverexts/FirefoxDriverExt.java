package Automation_QA_New.webdriver.driverexts;

import Automation_QA_New.paramcontainers.DriversProperties;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by aneutov on 1/27/2017.
 */

public class FirefoxDriverExt extends FirefoxDriver implements WebDriverExt {
    public FirefoxDriverExt(FirefoxProfile profile, Long commandTimeout) throws IOException {
        super(profile);
        profile.setPreference("profile", "default");
        super.manage().timeouts().implicitlyWait(commandTimeout, TimeUnit.SECONDS);
    }

    public FirefoxDriverExt() throws IOException
    {
        this(new FirefoxProfile(), DriversProperties.getInstance().implicitTimeout);
    }
}
