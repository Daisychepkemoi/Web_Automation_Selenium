package stepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dataAccess.CsvData;
import stepDefinition.Customer;

public class BankAccount {
	private static WebDriver driver = AccessHomePage.driver;
    private static WebDriverWait wait= AccessHomePage.wait;
    private static String firstName = Customer.firstName;
    private static String lastName = Customer.lastName;
    
    @Given("I am at the home_page page")
    public void homepageAccess() throws InterruptedException{
    	AccessHomePage.loadbaseUrl();
    }
    @Then("I can view Bank Manager_Login_Button")
    public void validateViewOfBankManagerLogin() throws InterruptedException{
    	AccessHomePage.validateViewOfLandingPage();
    }
    @When("I click on Bank_Manager_Login_Button")
    public static void clickBankManagerLogin() throws InterruptedException{
    	 wait=new WebDriverWait(driver, 3);
    	WebElement BankManagerLoginButton = driver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]"));
    	BankManagerLoginButton.click();
    	
    }
    @Then("I should be able to view Open_Account_Button")
    public static void validateViewOfOpenAccountBtn() throws InterruptedException{
    	String openAccount= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-class='btnClass2']"))).getAttribute("ng-click");
    	Assert.assertEquals(openAccount,"openAccount()");
    }
    @When("I click on Open Account Button")
    public static void clickOpenAccountButton() throws InterruptedException{
    	WebElement openAccountbtn = driver.findElement(By.xpath("//*[@ng-class='btnClass2']"));
    	openAccountbtn.click();
    }
    @Then("I should view input options to enter customer Bank account details")
    public static void validateViewOfOpenAccountInputs() throws InterruptedException{
    	String selectAccountInputAttribute = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userSelect"))).getAttribute("name");
    	Assert.assertEquals(selectAccountInputAttribute,"userSelect");
    }
    
    @When("I select {string}, {string} and click on Process")
    public static void createCustomer(String Customer, String Currency) throws InterruptedException, IOException {
    	 
    	WebElement customerName = driver.findElement(By.id("userSelect"));
    	customerName.click();
    	JavascriptExecutor je = (JavascriptExecutor) driver;
    	WebElement ActualCustomerName = driver.findElement(By.xpath("//option[text()='"+firstName+" "+ lastName+"']"));
    	WebElement currency = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='Dollar']")));
    	WebElement submitAccountDetailsbtn = driver.findElement(By.xpath("//*[text()='Process']"));
    	je.executeScript("arguments[0].scrollIntoView(true);",currency);
    	currency.click();
    	if(Customer ==null && Currency == null) {
    		submitAccountDetailsbtn.click();
    	}
    	else if (Customer ==null && Currency != null){
    		je.executeScript("arguments[0].scrollIntoView(true);",currency);
        	currency.click(); 
    	}
    	else if(Customer != null && Currency == null) {
    		je.executeScript("arguments[0].scrollIntoView(true);",ActualCustomerName);
    		ActualCustomerName.click();
    		submitAccountDetailsbtn.click();
    	}
    	else {
    		je.executeScript("arguments[0].scrollIntoView(true);",ActualCustomerName);
    		ActualCustomerName.click();
    		je.executeScript("arguments[0].scrollIntoView(true);",currency);
        	currency.click(); 
        	submitAccountDetailsbtn.click();
        	
    	}
    	
    }
    @Then("I should get a success {string} on the operation")
    public static void ValidateCustomerIsCreated(String Message) throws InterruptedException{
    	    Alert alert = driver.switchTo().alert();
		    System.out.println("hello");
		    String popuupText = alert.getText();
		    alert.accept();
		    Assert.assertTrue(popuupText.contains("Account created successfully with account Number"));
    	 
    }
    
    
    
    
    

}
