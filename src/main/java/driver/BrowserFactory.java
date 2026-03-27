package driver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import constants.FrameworkConstants;
import enums.BrowserType;
import exceptions.InvalidBrowserException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver createBrowser(BrowserType browser) {

		switch (browser) {

		case CHROME:
		    WebDriverManager.chromedriver().setup();

		    String downloadPath = new File(FrameworkConstants.DOWNLOAD_DIR).getAbsolutePath();

		    // Fix for Windows path issues
		    downloadPath = downloadPath.replace("/", "\\");

		    File dir = new File(downloadPath);
		    if (!dir.exists()) {
		        dir.mkdirs();
		    }

		    Map<String, Object> prefs = new HashMap<>();
		    prefs.put("download.default_directory", downloadPath);
		    prefs.put("download.prompt_for_download", false);
		    prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
		    prefs.put("plugins.always_open_pdf_externally", true);
		    prefs.put("safebrowsing.enabled", true);

		    ChromeOptions options = new ChromeOptions();
		    options.setExperimentalOption("prefs", prefs);

		    return new ChromeDriver(options);

		case SAFARI:
			WebDriverManager.safaridriver().setup();
			return new SafariDriver();
			
		case EDGE:
			return new EdgeDriver();
		
		case FIREFOX:
			return new FirefoxDriver();

		default:
			throw new InvalidBrowserException(String.valueOf(browser));
		}

	}

}
