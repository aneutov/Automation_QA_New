package Automation_QA_New.webdriver;

import Automation_QA_New.webdriver.driverexts.WebDriverExt;

/**
 * Created by aneutov on 1/26/2017.
 */
public class Driver
{
    private static WebDriverExt instance;

    public static WebDriverExt getInstance()
    { return instance; }

    public static void  setInstance(WebDriverExt setinstance)
    { instance = setinstance; }

    public static void Initialize(Browsers browser) throws Exception
    {
        if (instance!=null) {instance.quit();}
        WebDriverFactory factory = new WebDriverFactory();
        instance = factory.Create(browser);
    }
}
