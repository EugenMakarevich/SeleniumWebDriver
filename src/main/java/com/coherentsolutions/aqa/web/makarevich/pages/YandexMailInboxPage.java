package com.coherentsolutions.aqa.web.makarevich.pages;

import com.coherentsolutions.aqa.web.makarevich.pages.components.Header;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class YandexMailInboxPage extends PageBase {
    private Header header;
    public YandexMailInboxPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }
}
