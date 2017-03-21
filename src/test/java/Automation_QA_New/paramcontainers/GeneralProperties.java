package Automation_QA_New.paramcontainers;

import org.apache.log4j.Logger;

/**
 * Created by aneutov on 2/2/2017.
 */
public class GeneralProperties extends BaseParamProperties
{
    private static GeneralProperties ourInstance;

    public static GeneralProperties getInstance()
    {
        if (ourInstance == null) ourInstance = new GeneralProperties();
        return ourInstance;
    }

    public Logger log = Logger.getLogger("WebUITests");


    private GeneralProperties()
    {
        super();
    }
}
