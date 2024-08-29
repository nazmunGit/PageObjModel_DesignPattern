package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilereader {
    //C:\Users\shimu\IdeaProjects\PageObjectModel_DesignPattern\src\test\resources
    public static String getPropertyValue(String key) throws IOException {
        FileInputStream fis = new FileInputStream(
                "C:\\Users\\shimu\\IdeaProjects\\PageObjectModel_DesignPattern\\src\\test\\resources\\configuration.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(key);
    }
}
