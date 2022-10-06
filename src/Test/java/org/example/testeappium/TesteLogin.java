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



// CLASSE DESIGNADA PARA EFETUAR TESTES DA TELA DE LOGIN


public class TesteLogin {

    private static ScreenLogin ScreenLogin;
    private static AppiumDriver<RemoteWebElement> driver;

    //capabilities informações sobre a versão que será usado no device etc, econimiza código, capabilities auxiliam também na liberação de permissões
    // do celular, para que caso apareça na tela, automaticamente é permitido acesso.

    @BeforeClass
    public static void caps() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities( ); //usando capabilities setando verificar urls mal formadas antes de rodar os testes
        capabilities.setCapability("app", new File("apps/app-debug.apk"));
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android"); //para adquirir  esse nome, abrir cmd appium e executar "adb devices"
        capabilities.setCapability("unicodeKeyboard", true);  //corrige alguns bugs do nosso teclado
        driver = new AndroidDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        ScreenLogin = new ScreenLogin(driver);
    }

    @Test
    public void Login() {
        ScreenLogin.logar();
    }

}
