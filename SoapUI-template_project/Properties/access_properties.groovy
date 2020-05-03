// In SoapUI project you can create property at any of these three levels - project, test suite, test case
// You can also define global property

// Get a test case property
def testCaseProperty = testRunner.testCase.getPropertyValue("MyProp")
// Get a test suite property
def testSuiteProperty = testRunner.testCase.testSuite.getPropertyValue( "MyProp" )
// Get a project property
def projectProperty = testRunner.testCase.testSuite.project.getPropertyValue( "MyProp" )
// Get a global property
def globalProperty = com.eviware.soapui.SoapUI.globalProperties.getPropertyValue( "MyProp" )

// Set a test case property
testRunner.testCase.setPropertyValue( "MyProp", someValue )
// Set a test suite property
testRunner.testCase.testSuite.setPropertyValue( "MyProp", someValue )
// Set a project property
testRunner.testCase.testSuite.project.setPropertyValue( "MyProp", someValue ) 
// Set a global property
com.eviware.soapui.SoapUI.globalProperties.setPropertyValue( "MyProp", someValue )


// If using in script assertion
// Get a test case property
def testCaseProperty = messageExchange.modelItem.testStep.testCase.getPropertyValue( "MyProp" )
// Get a test suite property
def testSuiteProperty = messageExchange.modelItem.testStep.testCase.testSuite.getPropertyValue( "MyProp" )
// Get a project property
def projectProperty = messageExchange.modelItem.testStep.testCase.testSuite.project.getPropertyValue( "MyProp" )
// Get a global property
def globalProperty = com.eviware.soapui.SoapUI.globalProperties.getPropertyValue( "MyProp" )