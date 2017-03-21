package Automation_QA_New.testcases;
import Automation_QA_New.paramcontainers.DriversProperties;
import Automation_QA_New.paramcontainers.GeneralProperties;
import Automation_QA_New.webdriver.Browsers;
import Automation_QA_New.webdriver.Driver;
import Automation_QA_New.webdriver.driverexts.WebDriverExt;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.model.Statement;

import java.io.IOException;
import java.util.Collection;

import static Automation_QA_New.common.DriverHelper.PrepareChromeDriver;
import static Automation_QA_New.common.DriverHelper.PrepareCleanChromeDriver;
import static Automation_QA_New.common.DriverHelper.PrepareCleanFirefoxDriver;

/**
 * Created by aneutov on 1/25/2017.
 */

@RunWith(Parameterized.class)
public class BasicTestClass
{
    protected static WebDriverExt driver;
    protected Browsers  browser;
    protected Logger log = GeneralProperties.getInstance().log;


    protected class ExceptionLoggingRule implements TestRule {

        public Statement apply(Statement base, Description description) {
            return statement(base);
        }

        private Statement statement(final Statement base) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        base.evaluate();
                    } catch (Exception e) {
                        //log.error(e.getMessage().toString());
                        log.error(ExceptionUtils.getStackTrace(e));
                        throw e;
                    }
                }
            };
        }
    }

    @Rule public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();



    @Parameterized.Parameters(name ="{0}")
    public static Collection data()
    { return DriversProperties.getInstance().browsers; }


    public BasicTestClass(Browsers browser)
    { this.browser = browser;}


    @BeforeClass
    public static void OneTimeSetUp() throws Exception
    {
        if (DriversProperties.getInstance().cleanChromedir) PrepareCleanChromeDriver();
        else PrepareChromeDriver();
        PrepareCleanFirefoxDriver();

    }

    @Before
    public void SetUp() throws Exception {
        Driver.Initialize(browser);
        driver = Driver.getInstance();
    }


    @After
    public void TearDown() throws IOException, InterruptedException {
       //driver.quit();
    }

    @AfterClass
    public static void OneTimeTearDown()
    {
    }

}
