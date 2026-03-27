package utils;

import java.io.File;

import constants.FrameworkConstants;

public class FileDownloadUtil {

    public static boolean waitForFileToDownload(String fileName) {

        File file = new File(FrameworkConstants.DOWNLOAD_DIR + "/" + fileName);

        int waitTime = 10; // seconds
        int count = 0;

        while (count < waitTime) {
            if (file.exists()) {
                return true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }

        return false;
    }
}