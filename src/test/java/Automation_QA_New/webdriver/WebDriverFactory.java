package Automation_QA_New.webdriver;

import Automation_QA_New.webdriver.driverexts.ChromeDriverExt;
import Automation_QA_New.webdriver.driverexts.FirefoxDriverExt;
import Automation_QA_New.webdriver.driverexts.WebDriverExt;



/**
 * Created by aneutov on 1/26/2017.
 */
public class WebDriverFactory
{
    public static WebDriverExt Create(Browsers browser) throws Exception {
        if (browser.equals(Browsers.chrome)) return new ChromeDriverExt();
        if (browser.equals(Browsers.firefox)) return new FirefoxDriverExt();
        throw new Exception("Such browser is currently unsupported");
    }
}
