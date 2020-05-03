
/* This script calls SOAP method and then decide to which step to go according to result */

testStep_name = "CountryName";
def groovyUtils = new com.eviware.soapui.support.GroovyUtils(context);
testRunner.runTestStepByName(testStep_name);

// change this according to xml structure
def responseHolder= groovyUtils.getXmlHolder (testStep_name+"#Response")
responseHolder.namespaces["soapenv"] = "http://www.w3.org/2003/05/soap-envelope";
responseHolder.namespaces["ns1"] = "http://www.oorsprong.org/websamples.countryinfo";
result = responseHolder.getNodeValue( "//soapenv:Body//ns1:CountryNameResult" ); // xpath

expectedResult = "Greece"

if (result != expectedResult)
{
log.info(" " + result + " != " + expectedResult)
log.info(" Fail")
testRunner.gotoStepByName("TC FAIL")
return
}
else
{
log.info(" " + result + " == " + expectedResult)
log.info(" Pass")
testRunner.gotoStepByName("TC PASS")
return
