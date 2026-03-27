package tests.shadowDomFeature;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ShadowDomPage;
import reports.ExtentTestManager;

public class ShadowDomTests extends BaseTest {

    private ShadowDomPage shadowDomPage;
    private HomePage homePage;

    @BeforeMethod
    public void init() {
        shadowDomPage = new ShadowDomPage();
        homePage = new HomePage();
    }

    // ===============================
    // 🔹 Navigation Step (Reusable)
    // ===============================
    private void navigateToShadowDomPage() {
        homePage.clickShadowDomBtn();
        ExtentTestManager.getTest().info("Navigated to Shadow DOM page");
    }

    // ===============================
    // 🔹 Test Cases
    // ===============================

    @Test(description = "Verify paragraph is displayed inside Shadow DOM")
    public void verifyParagraphIsDisplayed() {

        navigateToShadowDomPage();

        Assert.assertTrue(shadowDomPage.isParagraphDisplayed());

        ExtentTestManager.getTest().info("Paragraph is displayed successfully");
    }

    @Test(description = "Verify paragraph background color inside Shadow DOM")
    public void verifyParagraphBackgroundColor() {

        navigateToShadowDomPage();

        String bgColor = shadowDomPage.getParagraphBackgroundColor();

        Assert.assertTrue(bgColor.contains("102"));

        ExtentTestManager.getTest().info("Background color matched successfully");
    }

    @Test(description = "Verify paragraph text color inside Shadow DOM")
    public void verifyParagraphTextColor() {

        navigateToShadowDomPage();

        String textColor = shadowDomPage.getParagraphTextColor();

        Assert.assertTrue(textColor.contains("255")); // white → rgb(255,255,255)

        ExtentTestManager.getTest().info("Text color matched successfully");
    }
}