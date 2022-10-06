package org.example.testeappium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class DeviceFarmLogin {

    private static ScreenLogin ScreenLogin;
    private static AppiumDriver<RemoteWebElement> driver;


    @BeforeClass
    public static void caps() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities(); //usando capabilities setando verificar urls mal formadas antes de rodar os testes

        caps.setCapability("browserstack.user", "leonardobelinato_PID6iV");
        caps.setCapability("browserstack.key", "qvsATqkZipX4qnuyqqZR");

        // Set URL of the application under test
        caps.setCapability("app_url", "bs://37263613c7419543a5d91da370790852afea14bf");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy S9");
        caps.setCapability("os_version", "8.0");

        caps.setCapability("unicodeKeyboard", true);  //corrige alguns bugs do nosso teclado

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        caps.setCapability("bstack:options", browserstackOptions);

        browserstackOptions.put("projectName", "Home page must have a title");
        browserstackOptions.put("buildName", "alpha_0.1.7");
        browserstackOptions.put("buildTag", "reg");


        driver = new AndroidDriver<RemoteWebElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
        ScreenLogin = new ScreenLogin(driver);
    }

    @Test
    public void Login() {
        ScreenLogin.logar();

    }


}
