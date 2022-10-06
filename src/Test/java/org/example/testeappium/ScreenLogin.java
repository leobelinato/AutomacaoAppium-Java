package org.example.testeappium;

//DENTRO DE CLASSES, DEIXAMOS OS COMANDOS DENTRO DO ANDROID, COMO CLIQUES, ESCONDER O TECLADO ETC...


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;



public class ScreenLogin {

    public ScreenLogin(AppiumDriver<RemoteWebElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "login_username")  //Quando Forr Android, vai ser via id que irei buscar
    @iOSFindBy(accessibility = "1234567")     // Quando for Ios, irá buscar pelo accessibility
    public RemoteWebElement campoemail;      // Jogando o elemento dentro da variável
    @AndroidFindBy(id = "login_password")  //Quando Forr Android, vai ser via id que irei buscar
    @iOSFindBy(accessibility = "1234567")     // Quando for Ios, irá buscar pelo accessibility
    public RemoteWebElement camposenha;    // Jogando o elemento dentro da variável
    @AndroidFindBy(id = "login_button")  //Quando Forr Android, vai ser via id que irei buscar
    @iOSFindBy(accessibility = "1234567")     // Quando for Ios, irá buscar pelo accessibility
    public RemoteWebElement botaologar;    // Jogando o elemento dentro da variável

    @AndroidFindBy(id = "btn_sign_up_login")  //Quando Forr Android, vai ser via id que irei buscar
    @iOSFindBy(accessibility = "1234567")     // Quando for Ios, irá buscar pelo accessibility
    public RemoteWebElement botaocadastrar;    // Jogando o elemento dentro da variável

    public void logar() {                    //MÉTODO CLASSE LOGAR

        campoemail.sendKeys("qazando@gmail.com");
        camposenha.sendKeys("1234");
        botaologar.click();

    }

}
