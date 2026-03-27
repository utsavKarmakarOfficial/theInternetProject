package tests.fileUploadFeature;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FileUploadPage;
import pages.HomePage;
import reports.ExtentTestManager;

public class FileUploadTests extends BaseTest {

    private FileUploadPage fileUploadPage;
    private HomePage homePage;

    @BeforeMethod
    public void init() {
        fileUploadPage = new FileUploadPage();
        homePage = new HomePage();
    }

    // ===============================
    // 🔹 Navigation (Reusable)
    // ===============================
    private void navigateToFileUploadPage() {
        homePage.clickFileUpload();
        ExtentTestManager.getTest().info("Navigated to File Upload page");
    }

    // ===============================
    // 🔹 Test Cases
    // ===============================

    @Test(description = "Verify single file upload")
    public void verifySingleFileUpload() {

        navigateToFileUploadPage();

        String filePath = System.getProperty("user.dir") + "/src/test/resources/test.pdf";

        fileUploadPage.uploadFileAndSubmit(filePath);

        Assert.assertTrue(fileUploadPage.isFileUploaded("test.pdf"));

        ExtentTestManager.getTest().info("File upload verified successfully");
    }

    @Test(description = "Verify uploaded file name")
    public void verifyUploadedFileName() {

        navigateToFileUploadPage();

        String filePath = System.getProperty("user.dir") + "/src/test/resources/sample.txt";

        fileUploadPage.uploadFileAndSubmit(filePath);

        String uploadedFileName = fileUploadPage.getUploadedFileName();

        Assert.assertEquals(uploadedFileName, "sample.txt");

        ExtentTestManager.getTest().info("Uploaded file name matched successfully");
    }

    @Test(description = "Verify file upload using JS (hidden input case)",enabled=false)
    public void verifyFileUploadUsingJS() {

        navigateToFileUploadPage();

        String filePath = System.getProperty("user.dir") + "/src/test/resources/test.pdf";

        fileUploadPage.uploadFileUsingJS(filePath);
        fileUploadPage.clickUploadButton();

        Assert.assertTrue(fileUploadPage.isFileUploaded("test.pdf"));

        ExtentTestManager.getTest().info("File upload using JS verified successfully");
    }
}