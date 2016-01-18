package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    static private PropertiesReader _instance = null;
    //Variables for the properties
    public String url = null;
    public String authorization = null;

    Properties properties = new Properties();

    private static final String PROPERTIES_FILE_PATH = "resources.properties";

    String propertyUrl = "rest.projects.url";
    String authorizationString = "rest.projects.authorization";

    protected PropertiesReader() {
        InputStream input = null;
        try {
            input = new FileInputStream(PROPERTIES_FILE_PATH);
            properties.load(input);
            //List of preloaded properties
            url = properties.getProperty(propertyUrl);
            authorization = properties.getProperty(authorizationString);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static public PropertiesReader instance(){
        if (_instance == null) {
            _instance = new PropertiesReader();
        }
        return _instance;
    }
}
