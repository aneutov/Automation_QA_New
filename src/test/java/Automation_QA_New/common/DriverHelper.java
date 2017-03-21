package Automation_QA_New.common;

import Automation_QA_New.paramcontainers.DriversProperties;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.Runtime.*;
import static java.lang.Thread.sleep;


/**
 * Created by aneutov on 1/28/2017.
 */
public class DriverHelper extends BaseCommonHelper
{

    public static void PrepareCleanChromeDriver() throws InterruptedException, IOException {
        log.info(String.format("Closing Chrome driver instance"));
        ForceCloseApp("chromedriver.exe");
        sleep(2000);

        log.info(String.format("Deleting default Chrome folder"));
        if (Files.exists(Paths.get(DriversProperties.getInstance().defaultChromeDataFolder)))
        { DriverHelper.ForceDelete(DriversProperties.getInstance().defaultChromeDataFolder);   }
        FileUtils.forceMkdir(new File(DriversProperties.getInstance().defaultChromeDataFolder));
        CopyFileString(DriversProperties.getInstance().chromeDriverLocation, DriversProperties.getInstance().defaultChromeDriverExecutable);
    }

    public static void PrepareChromeDriver() throws InterruptedException, IOException {
        log.info(String.format("Closing Chrome driver instance"));
        ForceCloseApp("chromedriver.exe");
        sleep(2000);

        FileUtils.forceMkdir(new File(DriversProperties.getInstance().defaultChromeDataFolder));
        CopyFileString(DriversProperties.getInstance().chromeDriverLocation, DriversProperties.getInstance().defaultChromeDriverExecutable);
    }

    public static void PrepareCleanFirefoxDriver() throws IOException, InterruptedException
    {
        log.info(String.format("Closing Firefox driver instance"));
        ForceCloseApp("geckodriverx32.exe");
        ForceCloseApp("geckodriverx64.exe");
        sleep(2000);

        if (Files.exists(Paths.get(DriversProperties.getInstance().defaultFirefoxDataFolder)))
        { DriverHelper.ForceDelete(DriversProperties.getInstance().defaultFirefoxDataFolder);   }
        FileUtils.forceMkdir(new File(DriversProperties.getInstance().defaultFirefoxDataFolder));
        CopyFileString(DriversProperties.getInstance().firefoxDriverLocation, DriversProperties.getInstance().defaultFirefoxDriverExecutable);
        System.setProperty("webdriver.gecko.driver", DriversProperties.getInstance().defaultFirefoxDriverExecutable);
    }



    public static void ForceDelete(String path) throws IOException
    { FileUtils.deleteDirectory(new File(path)); }

    public static void CopyFileString(String source,String dest) throws IOException
    {  FileUtils.copyFile(new File(source), new File(dest)); }

    public static void ForceCloseApp(String appexename) throws IOException
    {
        new Thread(() -> {
            try
            {
                getRuntime().exec("TASKKILL /F /IM "+appexename);
            } catch (IOException e) {  }
        }).start();
    }
}


