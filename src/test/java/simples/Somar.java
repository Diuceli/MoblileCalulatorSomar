package simples;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertEquals;

public class Somar{

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
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

        URL remoteUrl = new URL("https://dmribeiro:9b67ee52-b8f8-43d2-85dc-f594a69ee9ad@ondemand.us-west-1.saucelabs.com:443/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void SomardoisNumeros() {
        String resultadoEsperado = "10";

        MobileElement btn8 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_8");
        btn8.click();
        MobileElement btnSomar = (MobileElement) driver.findElementByAccessibilityId("plus");
        btnSomar.click();
        MobileElement btn2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        btn2.click();
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();
        MobileElement lblResultadoAtual = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals( resultadoEsperado, lblResultadoAtual.getText());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
