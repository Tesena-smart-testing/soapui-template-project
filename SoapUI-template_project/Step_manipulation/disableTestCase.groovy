
// disable 1 test case by name
def oTestSuite = testRunner.testCase.testSuite;
oTestSuite.getTestCaseByName("TestCase 2").setDisabled(true)



/* this groovy script disables all the test cases
* whose name contains the string specified in the
* variable 'testNamePatternToDisable'
**/
def testNamePatternToDisable = 'TestCase'
def project = context.testCase.testSuite.project

//Loop thru the suite lise
project.testSuiteList.each { suite ->  
	//Loop thru the case list
	suite.testCaseList.each { caze ->
		//Loop thru the step list of the specific case
		
			//if step name contains the given pattern, then disable, enable otherwise.
			if (caze.name.contains(testNamePatternToDisable)) {
				caze.disabled = true
			} else {
				caze.disabled = false
			}
		
	}
}




