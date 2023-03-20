package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class hooks{
	
	WebDriver driver;
	
	public hooks(Base base)
	{
		this.driver=base.getDriver();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			System.out.println("yes yes");
			File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

}
