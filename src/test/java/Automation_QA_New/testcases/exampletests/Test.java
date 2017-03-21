package Automation_QA_New.testcases.exampletests;

import Automation_QA_New.paramcontainers.DriversProperties;
import Automation_QA_New.paramcontainers.GeneralProperties;
import Automation_QA_New.testcases.BasicTestClass;
import Automation_QA_New.webdriver.Browsers;
import org.junit.Ignore;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by aneutov on 2/7/2017.
 */
public class Test extends BasicTestClass {

    @Parameterized.Parameters(name ="{0}")
    public static Collection data()
    { return DriversProperties.getInstance().browsers; }

    public Test(Browsers browser)
    { super(browser); }

    @org.junit.Test
    //@Ignore
    public void TestDummy() throws Exception
    {
        driver.get("http://yahoo.com");

    }
}
