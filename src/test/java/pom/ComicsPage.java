package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ComicsPage extends BasePage {
    @FindBy(id = "comp-lc61aui31")
    /*private By pageTitleLocator=By.id("comp-lc61aui31");*/
    private WebElement titleLocator;
    private String titlePage= "THE LITTLE TESTER COMICS SERIES";


    public ComicsPage(WebDriver driver){
        super(driver);
    }
    public boolean isTitleComicsDisplayed() throws Exception{
        return this.isDisplayed(titleLocator) && this.getText(titleLocator).equals(titlePage);

    }
}
