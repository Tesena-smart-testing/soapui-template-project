//it logs and appends traces into a file stored within "Location" (project property)

testRunner.runTestStepByName( "Add" )
 
def groovyUtils = new com.eviware.soapui.support.GroovyUtils(context)
 
def xml = groovyUtils.getXmlHolder("Add#Response")
 
xml.namespaces["ns1"] = "http://tempuri.org/"
 
def value = xml.getNodeValue("//ns1:AddResult")
 
log.info (value)
 
//get testSuite name
def filename = testRunner.testCase.name
 
//get directory from Project Properties
def directory = testRunner.testCase.testSuite.project.getPropertyValue( "Location" )
 
//define the file location and name
def outputFile = new File(directory, "${filename}.txt")
 
//start writing stuff to it
outputFile.append( context.expand('${Add#Request}') )
outputFile.append( context.expand('${Add#Response}') )