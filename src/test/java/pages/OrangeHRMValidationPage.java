package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeHRMValidationPage {
        public OrangeHRMValidationPage(){
            WebDriver driver= Driver.getDriver();
            PageFactory.initElements(driver,this);
        }
        @FindBy(id="btnEdit")
        public WebElement editButton;

        @FindBy(id="initialRows_0_projectName")
        public WebElement projectName;

        @FindBy(id="initialRows_0_projectActivityName")
        public WebElement projectActivityName;

        @FindBy(id="initialRows_0_0")
        public WebElement monday;

        @FindBy(id = "initialRows_0_1")
        public WebElement tuesday;

        @FindBy(id="btnAddRow")
        public WebElement AddRowButton;

        @FindBy(id="initialRows_0_toDelete")
        public WebElement firstCheckBox;

        @FindBy(id="submitRemoveRows")
        public WebElement removeButton;

        @FindBy(xpath ="//div[@class='message success']")
        public WebElement actualSuccessMessage;

        @FindBy(xpath="//div[@class='message warning']")
        public WebElement actualErrorMessage;

        @FindBy(xpath = "//div[@class='message warning']")
        public WebElement actualMessage;
    }

