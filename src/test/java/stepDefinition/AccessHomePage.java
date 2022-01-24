package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import dataAccess.ConfigData;


public class AccessHomePage {

	public static WebDriver driver= new ChromeDriver();
    public static String baseUrl;
    public static WebDriverWait wait;
    public static String firstlinkText;
    
    @Before
    public static void setUpClass() {
    	  wait=new WebDriverWait(driver, 5);
    	  baseUrl =ConfigData.getInstance().getBaseUrl();
      
    }
  
    @Given("I have the correct url")
    public static void loadbaseUrl() throws InterruptedException  {
		driver.get(baseUrl);
		wait=new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
	}
	
    @Then("I should be able to view Customer login button")
	public static void validateViewOfLandingPage() throws InterruptedException{
    	wait=new WebDriverWait(driver, 5);
    	String homePageText= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Bank Manager Login')]"))).getText();
    	Assert.assertEquals(homePageText,"Bank Manager Login" );
    }
    

	}

