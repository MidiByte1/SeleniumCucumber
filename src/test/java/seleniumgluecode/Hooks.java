package seleniumgluecode;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import runner.browser_manager.DriverType;

import java.util.concurrent.TimeUnit;


public class Hooks {
    private static WebDriver driver;
    private static int numberOfCase=0;
    private DriverManager driverManager;

    @Before("@browser")
    public void setUp(){
        numberOfCase++;
        System.out.println("Se esta ejecutando el escenario nro:"+numberOfCase);
        driverManager= DriverManagerFactory.getManager(DriverType.CHROME);
        driver= driverManager.getDriver();
        driver.get("https://imalittletester.com/");
        // tiempos de espera implicita
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //explicit
        //WebDriverWait wait=new WebDriverWait(driver,10);
        //WebElement newBadge=wait.until(ExpectedConditions.elementToBeClickable(By.id("")))

        driver.manage().window().maximize();
    }
    @After("@browser")
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        System.out.println("El escenario nro:"+numberOfCase+" se ejecuto correctamente");
        driverManager.quitDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
