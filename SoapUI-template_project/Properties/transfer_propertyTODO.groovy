/* Purpose of this script is to call request, get specified value from response 
  and set the property, then call another request that use this property. */

// enter name of test step
testStep_name = "CountryName";


def myTestCase = context.testCase;
def groovyUtils = new com.eviware.soapui.support.GroovyUtils(context);

// run test step
testRunner.runTestStepByName(testStep_name);

def responseHolder= groovyUtils.getXmlHolder (testStep_name+"#Response")
responseHolder.namespaces["soapenv"] = "http://www.w3.org/2003/05/soap-envelope";
responseHolder.namespaces["ns1"] = "http://www.oorsprong.org/websamples.countryinfo";
result = responseHolder.getNodeValues( "//soapenv:Body//ns1:CountryNameResult" );

log.info(result.toString());