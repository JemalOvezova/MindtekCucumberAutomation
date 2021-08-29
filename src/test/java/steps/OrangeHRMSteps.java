package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.OrangeHRMHomePage;
import pages.OrangeHRMTimePage;
import pages.OrangeHRMValidationPage;
import utilities.ConfigReader;
import utilities.Driver;

public class OrangeHRMSteps {
        WebDriver driver = Driver.getDriver();
        OrangeHRMHomePage orangeHRMHomePage = new OrangeHRMHomePage();
        OrangeHRMTimePage orangeHRMTimePage = new OrangeHRMTimePage();
        OrangeHRMValidationPage orangeHRMValidationPage = new OrangeHRMValidationPage();

        @Given("user navigates to OrangeHR application")
        public void user_navigates_to_OrangeHR_application() {
            driver.get(ConfigReader.getProperty("OrangeAppURL"));
        }

        @When("user provides user name {string} and {string} and clicks on login")
        public void user_provides_user_name_and_and_clicks_on_login(String userName, String password){
            orangeHRMHomePage.userName.sendKeys(userName);
            orangeHRMHomePage.password.sendKeys(password);
            orangeHRMHomePage.loginbutton.click();
        }

        @And("user clicks on Time and chooses Timesheet")
        public void userClicksOnTimeAndChoosesTimesheet() {
            orangeHRMTimePage.timeModule.click();
            orangeHRMTimePage.timeSheetsModule.click();
            orangeHRMTimePage.mySheetsModule.click();
        }

        @And("user click on Edit button, provides data and clicks to add row button")
        public void userClickOnEditButtonProvidesDataAndClicksToAddRowButton() throws InterruptedException {
            Thread.sleep(3000);
            orangeHRMValidationPage.editButton.click();
            orangeHRMValidationPage.projectName.sendKeys("Global Corp and Co - Global Software phase - 1");
            orangeHRMValidationPage.projectActivityName.sendKeys("QA Testing");
            orangeHRMValidationPage.monday.sendKeys("5:00");
            orangeHRMValidationPage.tuesday.sendKeys("4:00");
            orangeHRMValidationPage.AddRowButton.click();
        }

        @And("user selects one sheet and removes it")
        public void userSelectsOneSheetAndRemovesIt() throws InterruptedException {
            orangeHRMValidationPage.firstCheckBox.click();
            orangeHRMValidationPage.removeButton.click();
        }

        @Then("user validates that selected row was deleted with success message {string}")
        public void user_validates_that_selected_row_was_deleted_with_success_message(String expectedSuccessMessage) {
            String actualSuccessMessage = orangeHRMValidationPage.actualSuccessMessage.getText();
            Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
        }

        @And("user clicks on Edit without choosing timesheet and clicks Remove Row")
        public void userClicksOnEditWithoutDataAndClicksRemoveRow() {
            orangeHRMValidationPage.editButton.click();
            orangeHRMValidationPage.removeButton.click();
        }

        @Then("user validates errorMessage {string}")
        public void userValidatesErrorMessage(String expectedErrorMessage) {
            String actualErrorMessage = orangeHRMValidationPage.actualErrorMessage.getText();
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        }

        @And("user clicks on Edit and selects first row without data")
        public void userClicksOnEditAndSelectsFirstRowWithoutData() {
            orangeHRMValidationPage.editButton.click();
            orangeHRMValidationPage.firstCheckBox.click();
            orangeHRMValidationPage.removeButton.click();
        }

        @Then("Validates warning message {string}")
        public void validatesWarningMessage(String expectedMessage) {
            String actualMessage = orangeHRMValidationPage.actualMessage.getText();
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    }

