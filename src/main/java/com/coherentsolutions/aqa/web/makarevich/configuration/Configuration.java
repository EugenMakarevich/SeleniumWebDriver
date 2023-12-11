package com.coherentsolutions.aqa.web.makarevich.configuration;

import com.coherentsolutions.aqa.web.makarevich.utils.ConfigUtils;

public class Configuration {
    public static final String DRIVER_STRATEGY = ConfigUtils.getProperty("driver.strategy");
    public static final String BROWSER = ConfigUtils.getProperty("driver.browser");
    public static final String HUB_URL = ConfigUtils.getProperty("driver.grid.hub.url");
}
