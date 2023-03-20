package StepDefinitions;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IdentifyCourse {
	public WebDriver driver;
	String url;
	public HomePage homePage;
	
	
	public IdentifyCourse(Base base)
	{
		this.driver=base.getDriver();
		this.url =base.prop.getProperty("url");
	}
	
	
	@Given("launch the coursera application")
	public void lauch_the_coursera_application() throws IOException {
       System.out.println("into url");
	   driver.get(url);
	}
	
	@When("search for {string} courses")
	public void search_for_web_development_courses(String courseName) {
		homePage=new HomePage(driver);
		homePage.searchCourse(courseName);
		
	}

	@When("select the Beginners level & English Language")
	public void select_the_beginners_level_english_language() throws InterruptedException {
		
		homePage.selectLevelAndLanguage();
	}
	
	@When("extract course names, total learning hours & rating for first {int} courses")
	public void extract_course_names_total_learning_hours_rating_for_first_courses(int n) {
		
	   homePage.extractCourseDetails(n);
	    
	}
	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	}
}
