package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import base.BasePage;
import reports.ExtentTestManager;
import utils.WaitUtil;

public final class ShadowDomPage extends BasePage {

    // 🔹 Shadow Host
    private By shadowHost1 = By.xpath("//my-paragraph[1]");

    // 🔹 Elements inside shadow root
    private By paragraph = By.cssSelector("p");

    // ===============================
    // 🔹 Private reusable method
    // ===============================
    private SearchContext getShadowRoot() {
        WebElement host = WaitUtil.presenecOfElement(shadowHost1);
        return host.getShadowRoot();
    }

    private WebElement getParagraphElement() {
        return getShadowRoot().findElement(paragraph);
    }

    // ===============================
    // 🔹 Public Actions / Getters
    // ===============================

    public boolean isParagraphDisplayed() {
        boolean isDisplayed = getParagraphElement().isDisplayed();
        ExtentTestManager.getTest().info("Paragraph displayed: " + isDisplayed);
        return isDisplayed;
    }

    public String getParagraphText() {
        String text = getParagraphElement().getText();
        ExtentTestManager.getTest().info("Paragraph text: " + text);
        return text;
    }

    public String getParagraphBackgroundColor() {
        String bgColor = getParagraphElement().getCssValue("background-color");
        ExtentTestManager.getTest().info("Paragraph background color: " + bgColor);
        return bgColor;
    }

    public String getParagraphTextColor() {
        String color = getParagraphElement().getCssValue("color");
        ExtentTestManager.getTest().info("Paragraph text color: " + color);
        return color;
    }
}