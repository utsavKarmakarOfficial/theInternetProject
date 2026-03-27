package constants;

public class FrameworkConstants {
    
	private FrameworkConstants() {}
	
	public static final String CONFIG_PATH = System.getProperty("user.dir")+"/src/main/resources/config-";
	public static final String REPORT_PATH = System.getProperty("user.dir")+"/reports/ExtentReport.html";
	public static final String DOWNLOAD_DIR = System.getProperty("user.dir") + "/downloads";
}
