package constants;

import utils.ConfigUtils;

public class TestConstants {
    public static final String RESOURCE_PATH = "src/main/resources/";
    public static final String YANDEX_MAIL_URL = ConfigUtils.getProperty("yandexmail.url");
    public static final String YANDEX_MAIL_USERNAME = ConfigUtils.getProperty("yandexmail.username");
    public static final String YANDEX_MAIL_PASSWORD = ConfigUtils.getProperty("yandexmail.password");
    public static final String CONFIG_PROPERTIES = "src/test/resources/config.properties";
    public static final String YANDEX_MAIL_INBOX_TITLE = "Inbox — Yandex Mail";
    public static final double TAX = 0.2;
}
