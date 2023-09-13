package parameters;

import org.testng.annotations.DataProvider;

import static constants.TestConstants.*;

public class TestData {

    @DataProvider
    public static Object[][] yandexMailCredentials() {
        return new Object[][] {
            {YANDEX_MAIL_USERNAME_1, YANDEX_MAIL_PASSWORD_1},
            {YANDEX_MAIL_USERNAME_2, YANDEX_MAIL_PASSWORD_2}
        };
    }
}
