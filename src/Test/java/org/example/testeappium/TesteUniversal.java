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

public class TesteUniversal {

    private static ScreenLogin ScreenLogin;
    private static AppiumDriver<RemoteWebElement> driver;

    public static String local="";
    public static String plataforma="";



    //capabilities informações sobre a versão que será usado no device etc, econimiza código, capabilities auxiliam também na liberação de permissões
    // do celular, para que caso apareça na tela, automaticamente é permitido acesso.

    @BeforeClass
    public static void caps() throws MalformedURLException {

        local = System.getProperty("local").toLowerCase();
        plataforma = System.getProperty("plataforma").toLowerCase();


        DesiredCapabilities capabilities = new DesiredCapabilities( ); //usando capabilities setando verificar urls mal formadas antes de rodar os testes


        // utilizando o edit configurations teste universal, ao lado de build, de acordo com o que estiver selecionado, escrito, irá rodar os ifs abaixo
        // exemplo de código de execução do teste universal "Build and Run" -> " -ea -Dlocal=local -Dplataforma=android "

        if(local.equals("local") && plataforma.equals("android")) {

            capabilities.setCapability("app", new File("apps/app-debug.apk"));
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("platformName", "Android"); //para adquirir  esse nome, abrir cmd appium e executar "adb devices"
            capabilities.setCapability("unicodeKeyboard", true);  //corrige alguns bugs do nosso teclado
            driver = new AndroidDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
            ScreenLogin = new ScreenLogin(driver);
            }

            else if (local.equals("local") && plataforma.equals("iOS")) {
            capabilities.setCapability("app", new File("apps/LoginExemplo.app"));
            capabilities.setCapability("deviceName", "iPhone 11");
            capabilities.setCapability("platformName", "iOS"); //para adquirir  esse nome, abrir cmd appium e executar "adb devices"
            capabilities.setCapability("plataformversion", "15.0");
            capabilities.setCapability("automationNamme", "XCUITest");
            driver = new AndroidDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
            ScreenLogin = new ScreenLogin(driver);
        }
        else if (local.equals("devicefarm") && plataforma.equals("iOS")) {
            capabilities.setCapability("app", new File("apps/LoginExemplo.app"));
            capabilities.setCapability("deviceName", "iPhone 11");
            capabilities.setCapability("platformName", "iOS"); //para adquirir  esse nome, abrir cmd appium e executar "adb devices"
            capabilities.setCapability("plataformversion", "15.0");
            capabilities.setCapability("automationNamme", "XCUITest");
            driver = new AndroidDriver<RemoteWebElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
            ScreenLogin = new ScreenLogin(driver);
        }

        else if (local.equals("devicefarm") && plataforma.equals("Android")) {
            capabilities.setCapability("app", new File("apps/LoginExemplo.app"));
            capabilities.setCapability("deviceName", "iPhone 11");
            capabilities.setCapability("platformName", "iOS"); //para adquirir  esse nome, abrir cmd appium e executar "adb devices"
            capabilities.setCapability("plataformversion", "15.0");
            capabilities.setCapability("automationNamme", "XCUITest");
            driver = new AndroidDriver<RemoteWebElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
            ScreenLogin = new ScreenLogin(driver);
        }



    }

    @Test
    public void Login() {
        ScreenLogin.logar();
    }

}

