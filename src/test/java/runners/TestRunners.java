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
						// "rerun:report_output/rerun.txt",
						},
				 features = "src/test/resources/features",
				 glue={"stepDefinition"}
				//  ,tags="@Todos"
				// ,tags = ("@Users")
				 
						 )
public class TestRunners {
		@AfterClass
		public static void after()  throws Exception{
			GenerateNewReports.generateNewReport().generateReports();
		}
}