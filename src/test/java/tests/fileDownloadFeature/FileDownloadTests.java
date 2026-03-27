package tests.fileDownloadFeature;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FileDownloadPage;
import pages.HomePage;
import reports.ExtentTestManager;
import utils.FileDownloadUtil;

public class FileDownloadTests extends BaseTest {

    private FileDownloadPage fileDownloadPage;
    private HomePage homePage;

    @BeforeMethod
    public void init() {
        fileDownloadPage = new FileDownloadPage();
        homePage = new HomePage();
    }

    // ===============================
    // 🔹 Navigation
    // ===============================
    private void navigateToDownloadPage() {
        homePage.clickFileDownload();
        ExtentTestManager.getTest().info("Navigated to File Download page");
    }

    // ===============================
    // 🔹 Test Cases
    // ===============================

    @Test(description = "Verify file download by name")
    public void verifyFileDownloadByName() {

        navigateToDownloadPage();

        String fileName = "image.PNG";

        fileDownloadPage.clickFileByName(fileName);

        boolean isDownloaded = FileDownloadUtil.waitForFileToDownload(fileName);

        Assert.assertTrue(isDownloaded);

        ExtentTestManager.getTest().info("File downloaded successfully: " + fileName);
    }

    @Test(description = "Verify file download by index")
    public void verifyFileDownloadByIndex() {

        navigateToDownloadPage();

        String fileName = fileDownloadPage.getAllFileNames().get(0);

        fileDownloadPage.clickFileByIndex(0);

        boolean isDownloaded = FileDownloadUtil.waitForFileToDownload(fileName);

        Assert.assertTrue(isDownloaded);

        ExtentTestManager.getTest().info("File downloaded successfully: " + fileName);
    }
}