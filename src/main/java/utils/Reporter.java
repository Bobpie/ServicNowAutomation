package utils;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public abstract class Reporter {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test, node;
	
	public String testCaseName, testDescription, nodes, authors,category;
	public String excelFileName;
	
	// Report starting point
	@BeforeSuite
	public void startReport() {
		// To create Output HTML file
		reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true); 
		// To create report to mark the logs
		extent = new ExtentReports();
		// To establish connection between Report & HTML file
		extent.attachReporter(reporter);
	}
	
    // For creating a main test in the reporter
	@BeforeClass
	public void report() throws IOException {
		test = extent.createTest(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);  
	}
    
    public abstract long takeSnap();
    
    public void reportStep(String dec, String status,boolean bSnap ) {
    	MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+snapNumber+".jpg").build();
			} catch (IOException e) {
				
			}
		}
    	if(status.equalsIgnoreCase("pass")) {
    		node.pass(dec, img);
    	} else if(status.equalsIgnoreCase("fail")) {
    		node.fail(dec, img); 
    	}
    }
    
    public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

    
    @AfterSuite
    public void stopReport() {
    	extent.flush();
    }
}














