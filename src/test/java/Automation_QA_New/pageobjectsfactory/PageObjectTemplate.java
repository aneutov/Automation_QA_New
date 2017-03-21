package Automation_QA_New.pageobjectsfactory;

import Automation_QA_New.paramcontainers.GeneralProperties;
import Automation_QA_New.webdriver.driverexts.WebDriverExt;
import org.apache.log4j.Logger;

/**
 * Created by aneutov on 2/3/2017.
 */
public class PageObjectTemplate
{
    protected WebDriverExt driver;
    protected static Logger log = GeneralProperties.getInstance().log;
}
