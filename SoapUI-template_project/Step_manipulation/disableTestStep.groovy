

/* disable 1 test step by name */
def oTestCase = testRunner.testCase;
oTestCase.getTestStepByName("stepName").setDisabled(true)



/* this script disables all the test steps
* whose name contains the string specified in the
* variable 'stepNamePatternToDisable'
**/

//You may change the pattern required
def stepNamePatternToDisable = 'Country'

//Get the project object
def project = context.testCase.testSuite.project

//Loop thru the suite lise
project.testSuiteList.each { suite ->  
	//Loop thru the case list
	suite.testCaseList.each { caze ->
		//Loop thru the step list of the specific case
		caze.testStepList.each { step ->
			//if step name contains the given pattern, then disable, enable otherwise.
			if (step.name.contains(stepNamePatternToDisable)) {
				step.disabled = true
			} else {
				step.disabled = false
			}
		}
	}
}