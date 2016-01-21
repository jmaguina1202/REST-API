package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    static private PropertiesReader instance;

    private Properties properties = new Properties();

    private static final String PROPERTIES_FILE_PATH = "resources.properties";
    private static final String PROJECT_URL = "rest.projects.url";
    private static final String USER_URL = "rest.user.url";
    private static final String ITEM_URL = "rest.item.url";
    private static final String AUTHORIZATION_STRING = "rest.projects.authorization";

    private PropertiesReader() {
        InputStream input = null;
        try {
            input = new FileInputStream(PROPERTIES_FILE_PATH);
            properties.load(input);
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

    public static PropertiesReader instance(){
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    public String getEndPoint(String type) {
        String endPoint="";
        switch (type)
        {
            case "project": endPoint = properties.getProperty(PROJECT_URL);
                break;
            case "user": endPoint = properties.getProperty(USER_URL);
                break;
            case "item": endPoint = properties.getProperty(ITEM_URL);
                break;
        }
        return endPoint;
    }

    public String getAuthorizationString() {
        return properties.getProperty(AUTHORIZATION_STRING);
    }
}
