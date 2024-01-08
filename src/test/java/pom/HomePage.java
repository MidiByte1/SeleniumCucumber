package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
    @FindBy(id="comp-iiyocj9v5")
    private WebElement titleComicsLocator;
    private String titleHomePage="Testing | imalittletester";
    /*private By titleComicsLocator = By.id("comp-iiyocj9v5");*/


    public HomePage(WebDriver driver){
        super(driver);
    }

    public boolean homePageisDisplayed() throws Exception{
        return this.getTitle().equals(titleHomePage);
    }
    public void clickOnTitleComics() throws Exception{
        this.click(titleComicsLocator);
    }
}
