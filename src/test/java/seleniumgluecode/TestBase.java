package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.ComicsPage;
import pom.HomePage;

public class TestBase {
    protected WebDriver driver=Hooks.getDriver();
    protected HomePage homePage= PageFactory.initElements(driver, HomePage.class);
    /*protected HomePage homePage=new HomePage(driver);*/
    /*protected ComicsPage comicsPage =new ComicsPage(driver);*/
    protected ComicsPage comicsPage=PageFactory.initElements(driver,ComicsPage.class);
}
