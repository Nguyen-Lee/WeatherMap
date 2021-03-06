package utils;

import config.CommonParams;
import io.github.cdimascio.dotenv.Dotenv;

public class ConfigUtils {
    private static Dotenv dotenv = Dotenv.load();

    public static String getBaseUrl() {
        return dotenv.get(CommonParams.BASE_URL.name());
    }

    public static String getExpectedBrowser() {
        return dotenv.get(CommonParams.EXPECTED_BROWSER.name());
    }

    public static long getDefaultTimeoutSecond()
    {
        return Long.parseLong(dotenv.get(CommonParams.DEFAULT_TIMEOUT_SECONDS.name()));
    }

    public static long getLongTimeoutSecond()
    {
        return Long.parseLong(dotenv.get(CommonParams.LONG_TIMEOUT_SECONDS.name()));
    }

    public static long getShortTimeoutSecond()
    {
        return Long.parseLong(dotenv.get(CommonParams.SHORT_TIMEOUT_SECONDS.name()));
    }
}
