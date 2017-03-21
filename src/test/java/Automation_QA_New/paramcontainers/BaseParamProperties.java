package Automation_QA_New.paramcontainers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by aneutov on 2/8/2017.
 */
public class BaseParamProperties
{

    private Properties prop = new Properties();
    private InputStream input = null;

    protected BaseParamProperties()
    {
        try
        {
            input = new FileInputStream("target\\test-classes\\config.properties");
            prop.load(input);
        }
        catch (IOException ex) { }
    }

    protected String getParamFromConfig(String paramname)
    { return prop.getProperty(paramname); }
}
