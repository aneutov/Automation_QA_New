package Automation_QA_New.webdriver.driverexts;

import Automation_QA_New.paramcontainers.DriversProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by aneutov on 1/27/2017.
 */

public class ChromeDriverExt extends ChromeDriver implements WebDriverExt
{

    public ChromeDriverExt() throws IOException, InterruptedException {
        this(DriversProperties.getInstance().defaultChromeDriverExecutable,getDefaultChromeOptions(), DriversProperties.getInstance().implicitTimeout);

    }

    public ChromeDriverExt(String path, ChromeOptions options, Long commandTimeout) throws IOException
    {
        super(new ChromeDriverService.Builder().
                usingDriverExecutable(new File(path)).
                usingAnyFreePort().
                build(),options);
        super.manage().timeouts().implicitlyWait(commandTimeout, TimeUnit.SECONDS);
    }

    private static ChromeOptions getDefaultChromeOptions()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return options;
    }
}
