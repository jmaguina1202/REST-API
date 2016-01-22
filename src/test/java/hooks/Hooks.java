package hooks;

import cucumber.api.java.After;
import utils.RequestManager;

import java.io.IOException;

public class Hooks {

    @After({"@project", "user"})
    public void closeConnection() throws IOException {
        RequestManager.closeHttpConnection();
    }
}
