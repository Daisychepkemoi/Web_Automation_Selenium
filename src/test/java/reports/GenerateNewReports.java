package reports;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

public class GenerateNewReports {
 
    public static ReportBuilder generateNewReport()  {
        File reportOutputDirectory = new File("target/");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("src/target/json-reports.json");
        String buildNumber = "1";
        String projectName = "CucumberProject";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Branch", "Master");
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
        // configuration.getDirectorySuffix()
        return new ReportBuilder(jsonFiles, configuration);
        }
}