package utils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LocalStore {

    public static Map<String, JSONObject> localStore = new HashMap();

    public static String getId(String value) {
        String[] values = value.split("\\.");
        return LocalStore.localStore.get(values[0]).get(values[1]).toString();
    }
}
