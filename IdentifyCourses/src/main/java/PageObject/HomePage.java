package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//(css="input[placeholder='What do you want to learn?']")
	@FindBy(css="input[placeholder='What do you want to learn?']")
	WebElement searchBox;
	
	@FindBy(css=".search-button div")
	WebElement searchIcon;
	
	@FindBy(css="div[data-testid*='Begin'] input")
	WebElement beginner;
	
	@FindBy(css="button[aria-label*='Language options']")
	WebElement languageOptions;
	
	@FindBy(css="div[data-testid*='English']")
	WebElement English;
	
	@FindBy(xpath="//span[text()='Apply']")
	WebElement applyBtn;
	
	@FindBy(css="div[data-e2e='ProductCard']")
	List<WebElement> courses;

	By coursename=By.cssSelector("h2");
	By rating=By.cssSelector("div:nth-child(2)>div:nth-child(2)>div>p");
	By duration=By.cssSelector("div:nth-child(2)>p");
	
	public void searchCourse(String courseName)
	{
		searchBox.sendKeys(courseName);
		searchIcon.click();
	}
	
	public void selectLevelAndLanguage() throws InterruptedException
	{
		Thread.sleep(5000);
		beginner.click();
		Thread.sleep(3000);
		languageOptions.click();
		Thread.sleep(3000);
		English.click();
		applyBtn.click();
		
	}
	
	
	public void extractCourseDetails(int n)
	{
		// List<WebElement> courses =driver.findElements(By.cssSelector("div[data-e2e='ProductCard']"));
		  
		    for(int i=0;i<n;i++)
		    {
		    	String CourseName = courses.get(i).findElement(coursename).getText();
		    	System.out.println("CourseName - "+CourseName);
		    	String Rating=courses.get(i).findElement(rating).getText();
		    	System.out.println("Rating - "+Rating);
		    	String[] hours=courses.get(i).findElement(duration).getText().split(" . ");
		    	System.out.println("Learning hours - "+ hours[2]);
		    }
	}
	
	

}
