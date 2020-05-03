/* This script shows how to write XML response from request to file  */

def groovyUtils = new com.eviware.soapui.support.GroovyUtils(context);

def projectPath = groovyUtils.projectPath
filePath=projectPath+"/response.txt"  // set name of the file to write
TestStep="stepName"  // change name of test step

def response =  testRunner.testCase.getTestStepByName(TestStep).getTestRequest().getResponseContentAsXml()

log.info(response)

def outputFile = new File(filePath)
outputFile.write(response)