package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import reports.ExtentTestManager;
import utils.WaitUtil;

public class FileDownloadPage extends BasePage {

    // ===============================
    // 🔹 Locators
    // ===============================
    private By allDownloadLinks = By.xpath("//div[@class='example']/a");

    // ===============================
    // 🔹 Private Helpers
    // ===============================
    private List<WebElement> getAllDownloadLinks() {
        return WaitUtil.presenceOfAllElement(allDownloadLinks);
    }

    // ===============================
    // 🔹 Actions
    // ===============================

    public int getTotalDownloadableFiles() {
        int count = getAllDownloadLinks().size();
        ExtentTestManager.getTest().info("Total downloadable files: " + count);
        return count;
    }

    public void clickFileByName(String fileName) {
        for (WebElement file : getAllDownloadLinks()) {
            if (file.getText().equalsIgnoreCase(fileName)) {
                file.click();
                ExtentTestManager.getTest().info("Clicked file: " + fileName);
                break;
            }
        }
    }

    public void clickFileByIndex(int index) {
        List<WebElement> files = getAllDownloadLinks();

        if (index >= 0 && index < files.size()) {
            String fileName = files.get(index).getText();
            files.get(index).click();
            ExtentTestManager.getTest().info("Clicked file: " + fileName);
        }
    }

    public List<String> getAllFileNames() {
        List<WebElement> files = getAllDownloadLinks();
        return files.stream().map(WebElement::getText).toList();
    }
}