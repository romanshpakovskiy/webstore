package by.wb.webstore.dao.connectionpool;

import java.util.ResourceBundle;

public class DBResourceManager {
    private static final DBResourceManager instance = new DBResourceManager();
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("src.main.java.by.wb.webstore.dao.connectionpool.db");

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
}
