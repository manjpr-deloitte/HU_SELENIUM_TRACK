package pages;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
public class screenshots {
    WebDriver dr;
    public screenshots(WebDriver driver)
    {
        dr=driver;
    }
    void takescreenshot(String name) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) dr);
        File SourceFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("C:\\Users\\manjpr\\IdeaProjects\\Main_Assignment\\successscreenshots\\"+name+".jpg");
        FileUtils.copyFile(SourceFile, DestFile);

    }
}
