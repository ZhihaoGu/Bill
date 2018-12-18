package service;

import dao.ConfigDAO;
import entity.Config;

public class ConfigService {
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";
    static ConfigDAO dao = new ConfigDAO();

    static {
        init();
    }

    public static void init() {
        init(budget, default_budget);
        init(mysqlPath, "");    //初始化路径以及预算
    }

    private static void init(String key, String value) {

        Config config = dao.getByKey(key);  //数据库取数据
        if (config == null) {               //若取回对象为空则用默认值初始化
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            dao.add(c);                     //并将值写回数据库
        }
    }

    public String get(String key) {
        Config config = dao.getByKey(key);
        return config.getValue();
    }

    public void update(String key, String value) {
        Config config = dao.getByKey(key);
        config.setValue(value);
        dao.update(config);
    }

    public int getIntBudget() {
        return Integer.parseInt(get(budget));
    }
}
