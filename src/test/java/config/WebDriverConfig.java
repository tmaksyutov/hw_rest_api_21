package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties"
})
public interface WebDriverConfig extends Config{

    @Key("baseUrl")
    @DefaultValue("https://allure.autotests.cloud")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("remoteWebDriver")
    String getRemoteWebDriver();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();



}
