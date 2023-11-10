package cn.featherfly.hammer.sqldb;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class TimeReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        Set<ITestResult> pass = new HashSet<>();
        Set<ITestResult> fail = new HashSet<>();
        Set<ITestResult> skip = new HashSet<>();

        for (ISuite suite : suites) {
            for (Entry<String, ISuiteResult> entry : suite.getResults().entrySet()) {
                ISuiteResult suiteResult = entry.getValue();
                ITestContext testContext = suiteResult.getTestContext();
                pass.addAll(testContext.getPassedTests().getAllResults());
                fail.addAll(testContext.getFailedTests().getAllResults());
                skip.addAll(testContext.getSkippedTests().getAllResults());

                //                Set<ITestResult> passedTests = testContext.getPassedTests().getAllResults();
                //                Set<ITestResult> failedTests = testContext.getFailedTests().getAllResults();
                //                Set<ITestResult> skippedTests = testContext.getSkippedTests().getAllResults();
                //
                //                printTestResults("Passed Tests", passedTests);
                //                printTestResults("Failed Tests", failedTests);
                //                printTestResults("Skipped Tests", skippedTests);
            }
        }

        printTestResults("Passed Tests", pass);
        printTestResults("Failed Tests", fail, System.err);
        printTestResults("Skipped Tests", skip);
    }

    private void printTestResults(String testType, Set<ITestResult> testResults) {
        printTestResults(testType, testResults, System.out);
    }

    private void printTestResults(String testType, Set<ITestResult> testResults, PrintStream print) {
        for (ITestResult result : testResults.stream()
            .sorted((r1, r2) -> Long
                .valueOf(r1.getEndMillis() - r1.getStartMillis() - (r2.getEndMillis() - r2.getStartMillis()))
                .intValue())
            .collect(Collectors.toList())) {
            print.println(testType + ": " + result.getName() + " - Time taken: "
                + (result.getEndMillis() - result.getStartMillis()) + " ms");
        }
        if (!testResults.isEmpty()) {
            print.println("");
        }
    }
}