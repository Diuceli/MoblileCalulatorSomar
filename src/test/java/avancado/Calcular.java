package avancado;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class Calcular {

    private AndroidDriver driver;
    private DesiredCapabilities desiredCapabilities;
    private URL remoteUrl;

    @Before
    public void setUp() throws MalformedURLException {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("browserName", "");
        desiredCapabilities.setCapability("appiumVersion", "1.19.2");
        desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
        desiredCapabilities.setCapability("deviceOrientation", "portrait");
        desiredCapabilities.setCapability("app", "storage:filename=Calculator_v7.8 (271241277)_apkpure.com.apk");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("SAUCE_USERNAME", "dmribeiro");
        desiredCapabilities.setCapability("SAUCE_ACESS_KEY", "storage:filename=Calculator_v7.8 (271241277)_apkpure.com.apk");

        remoteUrl = new URL("https://dmribeiro:9b67ee52-b8f8-43d2-85dc-f594a69ee9ad@ondemand.us-west-1.saucelabs.com:443/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }


    @After
    public void tearDown() {
        driver.quit();

    }


    @Given("^abro a calculadora do Google no meu smartphone$")
    public void abroACalculadoraDoGoogleNoMeuSmartphone() {
        driver= new AndroidDriver(remoteUrl,desiredCapabilities);
    }

    @When("^seleciono \"([^\"]*)\" mais \"([^\"]*)\" e pressiono o botao Igual$")
    public void selecionoMaisEPressionoOBotaoIgual(String num1, String num2) {
        MobileElement btn8 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_8");
        btn8.click();
        MobileElement btnSomar = (MobileElement) driver.findElementByAccessibilityId("plus");
        btnSomar.click();
        MobileElement btn2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        btn2.click();
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();
    }

    @Then("^exibe o resultado como \"([^\"]*)\"$")
    public void exibeOResultadoComo(String resultadoEsperado) {
        MobileElement lblResultadoAtual = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals(resultadoEsperado, lblResultadoAtual.getText());
    }

}
