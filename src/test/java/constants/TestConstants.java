package constants;

import utils.ConfigUtils;

public class TestConstants {
    public static final String RESOURCE_PATH = "src/main/resources/";
    public static final String YANDEX_MAIL_URL = ConfigUtils.getProperty("yandexmail.url");
    public static final String YANDEX_MAIL_USERNAME_1 = ConfigUtils.getProperty("yandexmail.username_1");
    public static final String YANDEX_MAIL_PASSWORD_1 = ConfigUtils.getProperty("yandexmail.password_1");
    public static final String YANDEX_MAIL_USERNAME_2 = ConfigUtils.getProperty("yandexmail.username_2");
    public static final String YANDEX_MAIL_PASSWORD_2 = ConfigUtils.getProperty("yandexmail.password_2");
    public static final String CONFIG_PROPERTIES = "src/test/resources/config.properties";
    public static final String YANDEX_MAIL_INBOX_TITLE = "Inbox — Yandex Mail";
    public static final String MULTISELECT_TEST_URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    public static final String ALERTS_TEST_URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    public static final String LOADING_DATA_DYNAMICALLY_URL = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";
    public static final String PROGRESS_BAR_URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    public static final String TABLE_TEST_URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
    public static final String ALERT_TEXT = "I am an alert box!";
    public static final String OK_BUTTON_RESULT_TEXT = "You pressed OK!";
    public static final String CANCEL_BUTTON_RESULT_TEXT = "You pressed Cancel!";
    public static final String FIRST_NAME_TEXT = "First Name";
    public static final String LAST_NAME_TEXT = "Last Name";
    public static final int DOWNLOAD_PERCENT = 50;
    public static final double TAX = 0.2;
}
