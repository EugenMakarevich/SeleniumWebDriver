package com.coherentsolutions.aqa.web.makarevich.constants;

import com.coherentsolutions.aqa.web.makarevich.utils.ConfigUtils;

public class TestConstants {
    public static final String YANDEX_MAIL_USERNAME_1 = ConfigUtils.getProperty("yandexmail.username_1");
    public static final String YANDEX_MAIL_PASSWORD_1 = ConfigUtils.getProperty("yandexmail.password_1");
    public static final String YANDEX_MAIL_USERNAME_2 = ConfigUtils.getProperty("yandexmail.username_2");
    public static final String YANDEX_MAIL_PASSWORD_2 = ConfigUtils.getProperty("yandexmail.password_2");
    public static final String YANDEX_MAIL_INBOX_TITLE = "Inbox — Yandex Mail";
    public static final String ALERT_TEXT = "I am an alert box!";
    public static final String OK_BUTTON_RESULT_TEXT = "You pressed OK!";
    public static final String CANCEL_BUTTON_RESULT_TEXT = "You pressed Cancel!";
    public static final String FIRST_NAME_TEXT = "First Name";
    public static final String LAST_NAME_TEXT = "Last Name";
    public static final String DEFAULT_PROGRESS_BAR_VALUE = "0%";
    public static final int DOWNLOAD_PERCENT = 50;
    public static final String SCREENSHOT_FOLDER_PATH = "artifacts/screenshots/";
    public static final String SCREENSHOT_PNG_NAME = "screenshot.png";
    public static final String MAGENTO_EMAIL = "eugendallas@gmail.com";
    public static final String MAGENTO_PASSWORD = "Password123";
}
