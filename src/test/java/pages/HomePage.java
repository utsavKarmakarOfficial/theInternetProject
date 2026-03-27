package pages;

import org.openqa.selenium.By;

import base.BasePage;
import reports.ExtentTestManager;

public class HomePage extends BasePage{
	
    private By addRemoveBtn = By.linkText("Add/Remove Elements");
    private By checkboxBtn = By.xpath("//a[@href='/checkboxes']");
    private By shadowDomBtn = By.xpath("//a[@href='/shadowdom']");
    private By fileUploadBtn = By.xpath("//a[@href='/upload']");
    private By fileDownloadBtn = By.xpath("//a[@href='/download']");

    
    public void clickaddRemoveBtn() {
    	
    	click(addRemoveBtn);
    	ExtentTestManager.getTest().info("Clicked the add/remove button in home page");
    }
    
    
    public void clickCheckboxBtn() {
    	
    	click(checkboxBtn);
    	ExtentTestManager.getTest().info("Clicked the checkbox button in home page");
    }
    
    public void clickShadowDomBtn() {
    	
    	click(shadowDomBtn);
    	ExtentTestManager.getTest().info("Clicked the Shadow Dom btn");
    }
    
    public void clickFileUpload() {
    	
    	click(fileUploadBtn);
    	ExtentTestManager.getTest().info("Clicked the File upload btn");
    }


	public void clickFileDownload() {
		
		click(fileDownloadBtn);
    	ExtentTestManager.getTest().info("Clicked the File download btn");
	}
}
