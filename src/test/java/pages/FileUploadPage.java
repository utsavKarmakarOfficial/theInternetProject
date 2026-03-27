package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BasePage;
import driver.DriverFactory;
import reports.ExtentTestManager;
import utils.WaitUtil;

public class FileUploadPage extends BasePage {

    // ===============================
    // 🔹 Locators
    // ===============================
    private By fileInput = By.id("file-upload");
    private By uploadBtn = By.id("file-submit");
    private By uploadedFileText = By.id("uploaded-files");

    // ===============================
    // 🔹 Private Element Getters
    // ===============================
    private WebElement getFileInput() {
        return WaitUtil.presenecOfElement(fileInput);
    }

    private WebElement getUploadButton() {
        return WaitUtil.elementToBeClickable(uploadBtn);
    }

    private WebElement getUploadedFileTextElement() {
        return WaitUtil.presenecOfElement(uploadedFileText);
    }

    // ===============================
    // 🔹 Actions
    // ===============================
    public void uploadFile(String filePath) {
        getFileInput().sendKeys(filePath);
        ExtentTestManager.getTest().info("File selected: " + filePath);
    }

    public void clickUploadButton() {
        getUploadButton().click();
        ExtentTestManager.getTest().info("Clicked upload button");
    }

    public void uploadFileAndSubmit(String filePath) {
        uploadFile(filePath);
        clickUploadButton();
    }

    // ===============================
    // 🔹 Validations
    // ===============================
    public String getUploadedFileName() {
        String fileName = getUploadedFileTextElement().getText();
        ExtentTestManager.getTest().info("Uploaded file name: " + fileName);
        return fileName;
    }

    public boolean isFileUploaded(String expectedFileName) {
        return getUploadedFileName().contains(expectedFileName);
    }

    // ===============================
    // 🔹 Special Case: Hidden Input
    // ===============================
    public void uploadFileUsingJS(String filePath) {
        WebElement input = getFileInput();

        ((JavascriptExecutor) DriverFactory.getDriver())
                .executeScript("arguments[0].style.display='block';", input);

        input.sendKeys(filePath);

        ExtentTestManager.getTest().info("File uploaded using JS: " + filePath);
    }
}