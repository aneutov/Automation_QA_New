package Automation_QA_New.paramcontainers;

import Automation_QA_New.webdriver.Browsers;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by aneutov on 1/27/2017.
 */
public class DriversProperties  extends BaseParamProperties
{
    private static DriversProperties ourInstance;

    public static DriversProperties getInstance()
    {
        if (ourInstance == null) ourInstance = new DriversProperties();
        return ourInstance;
    }

    public final Collection browsers = new ArrayList();
    public long implicitTimeout;

    private String targetDir;

    public boolean cleanChromedir;
    public String chromeDriverLocation;
    public String defaultChromeDataFolder;
    public String defaultChromeDriverExecutable;

    public String firefoxDriverLocation;
    public String defaultFirefoxDataFolder;
    public String defaultFirefoxDriverExecutable;

    private DriversProperties() {
        implicitTimeout = Long.parseLong(getParamFromConfig("implicittimeout"));
        if (getParamFromConfig("runonchrome").equals("true")) browsers.add(Browsers.chrome);
        if (getParamFromConfig("runonfirefox").equals("true")) browsers.add(Browsers.firefox);

        targetDir = System.getProperty("basedir");
        if (targetDir == null) { targetDir = System.getProperty("user.dir"); }

        if (getParamFromConfig("cleanchromedir").equals("true")) cleanChromedir = true;
        else cleanChromedir = false;

        chromeDriverLocation = targetDir + "\\target\\test-classes\\ChromeDriver\\chromedriver.exe";
        defaultChromeDataFolder = System.getenv("APPDATA") + "\\..\\Local\\Google\\Chrome\\User Data\\Default";
        defaultChromeDriverExecutable = defaultChromeDataFolder.toString()+"\\chromedriver.exe";
        firefoxDriverLocation = targetDir + "\\target\\test-classes\\FirefoxDriver\\geckodriverx32.exe";
        defaultFirefoxDataFolder = System.getenv("APPDATA") + "\\..\\Roaming\\Mozilla\\Firefox\\Profiles\\Default";
        defaultFirefoxDriverExecutable = defaultFirefoxDataFolder.toString()+"\\geckodriverx32.exe";


    }

}
