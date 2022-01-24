package runners;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import reports.GenerateNewReports;
@RunWith(Cucumber.class)
@CucumberOptions( 
				plugin ={
						"html:html_reports.html" ,
						"json:src/target/json-reports.json" ,
						"junit:src/target/cucumber-reports.xml",
						},
				 features = "src/test/resources/features",
				 glue={"stepDefinition"}
				
						 )
public class TestRunners {
		@AfterClass
		public static void after()  throws Exception{
			GenerateNewReports.generateNewReport().generateReports();
		}
}