import groovy.json.JsonSlurper
import groovy.json.JsonOutput
def myTestCase = context.testCase
def groovyUtils = new com.eviware.soapui.support.GroovyUtils(context)

//load input json file
inputjsonfile="/test.json"
def projectPath = groovyUtils.projectPath
def jsonFilePath = projectPath + inputjsonfile
log.info("jsonFilePath: " + jsonFilePath)
def fileContents = new File(jsonFilePath).text
log.info(fileContents)

// load json data to jsonObj
def jsonObj = new JsonSlurper().parseText(fileContents)
log.info(jsonObj.set1.name)

