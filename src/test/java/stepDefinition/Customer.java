package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Customer {
	private static WebDriver driver = AccessHomePage.driver;
    public static WebDriverWait wait= AccessHomePage.wait;
    public static String firstName;
    public static String lastName;

    @Given("I am at the home page")
    public void homepageAccess() throws InterruptedException{
    	AccessHomePage.loadbaseUrl();
    }
    @Then("I can see Bank Manager Login_Button")
    public void validateViewOfBankManagerLogin() throws InterruptedException{
    	AccessHomePage.validateViewOfLandingPage();
    }
    @When("I click on Bank Manager Login")
    public static void clickBankManagerLogin() throws InterruptedException{
    	 wait=new WebDriverWait(driver, 3);
    	WebElement BankManagerLoginButton = driver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]"));
    	BankManagerLoginButton.click();
    	
    }
    @Then("I should be able to view Add Customer_Button")
    public static void validateViewOfAddCustomerButton() throws InterruptedException{
    	String addCustomerBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-class='btnClass1']"))).getAttribute("ng-click");
    	Assert.assertEquals(addCustomerBtn,"addCust()");
    }
    @When("I click on Add Customer Button")
    public static void clickAddCustomerButton() throws InterruptedException{
    	WebElement AddCustomerBtn = driver.findElement(By.xpath("//*[@ng-class='btnClass1']"));
    	AddCustomerBtn.click();
    }
    @Then("I should view input options to enter customer details")
    public static void validateViewOfCustomerDetailsInputs() throws InterruptedException{
    	String FirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-model='fName']"))).getAttribute("placeholder");
    	Assert.assertEquals(FirstName,"First Name");
    }
   
    
    @When("I Input {string}, {string},{string} and click on Add Customer")
    public static void createCustomer(String fname, String lname, String pcode) throws InterruptedException,NoAlertPresentException {

    	 
    	WebElement firstNameInput = driver.findElement(By.xpath("//*[@ng-model='fName']"));
    	firstNameInput.sendKeys(fname);
    	WebElement lastNameInput = driver.findElement(By.xpath("//*[@ng-model='lName']"));
    	lastNameInput.sendKeys(lname);
    	WebElement postCodeInput = driver.findElement(By.xpath("//*[@ng-model='postCd']"));
    	postCodeInput.sendKeys(pcode);
    	WebElement submitCustomerDetailsBtn = driver.findElement(By.xpath("//*[text() = 'Add Customer']"));
    	firstName = fname;
    	lastName = lname;
    	submitCustomerDetailsBtn.click();
    	
    }
    @Then("I should get a success {string} on the operation")
    public static void ValidateCustomerIsCreated(String successMsg) throws InterruptedException{
    	
    	String firstNameRequiredAttribute = driver.findElement(By.xpath("//*[@ng-model='fName']")).getAttribute("validationMessage");
    	String lastNameRequiredAttribute= driver.findElement(By.xpath("//*[@ng-model='lName']")).getAttribute("validationMessage");
    	String postCodeRequiredAttribute = driver.findElement(By.xpath("//*[@ng-model='postCd']")).getAttribute("validationMessage");
    	System.out.println("Fist name   " +firstName );
    	System.out.println("Last name   " +lastName );
    	System.out.println("PostCode    " +postCodeRequiredAttribute );

    	if(firstNameRequiredAttribute.length() >0) {
    		Assert.assertTrue(firstNameRequiredAttribute.contains(successMsg));
    	}
    	else if(firstNameRequiredAttribute.length() <=0 && lastNameRequiredAttribute.length() >0){
    		Assert.assertTrue(lastNameRequiredAttribute.contains(successMsg));
    	}
    	else if(firstNameRequiredAttribute.length() <=0 && lastNameRequiredAttribute.length()<=0 && postCodeRequiredAttribute.length()>0) {
    		Assert.assertTrue(postCodeRequiredAttribute.contains(successMsg));
    	}
    	else {
//    		
    		try{
    			wait.until(ExpectedConditions.alertIsPresent());
    			Alert alert = driver.switchTo().alert();
    			String alertText = alert.getText();
    			 System.out.println("ALERT TESTTTTTTT"+alertText);  
    			alert.accept();
    			Assert.assertTrue(alertText.contains(successMsg));
    			} catch (Exception e) {
    			       try {
    			if(e.toString().contains("org.openqa.selenium.UnhandledAlertException"))
    			 {   
    			    Alert alert = driver.switchTo().alert();
    			    alert.accept();
    			 }
    			} catch (NoAlertPresentException e1) {
    			    e.printStackTrace();
    			}
    			              }
    	}
    }
//    @After
//    public void quit() {
//    	driver.quit();
//    }
   
}

    
    
    
    
    


