package DesignPatterns.Plan;

import java.util.Map;
import java.util.HashMap;

class ConfigManager {
    private static ConfigManager instance;
    private Map<String, Object> settings = new HashMap<>(); 

    private ConfigManager() {}

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public void set(String key, Object value) {
        settings.put(key, value);
    }

    public Object get(String key) {
        return settings.get(key);
    }

}
public class Singleton {
    public static void main(String[] args) {
        ConfigManager manager = ConfigManager.getInstance();
        manager.set("name", "Dann");

        ConfigManager other = ConfigManager.getInstance();
        System.out.println(other.get("name"));
    }
}
