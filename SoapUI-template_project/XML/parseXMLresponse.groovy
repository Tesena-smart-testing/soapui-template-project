/* Below script get data from xml response
 *  
Suppose the response looks like this:
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope">
   <soap:Body>
      <m:CountryNameResponse xmlns:m="http://www.oorsprong.org/websamples.countryinfo">
         <m:CountryNameResult>Portugal</m:CountryNameResult>
      </m:CountryNameResponse>
   </soap:Body>
</soap:Envelope>
*/

// enter name of test step
testStep_name = "CountryName";


def groovyUtils = new com.eviware.soapui.support.GroovyUtils(context);

// run test step
testRunner.runTestStepByName(testStep_name);

def responseHolder= groovyUtils.getXmlHolder (testStep_name+"#Response")
responseHolder.namespaces["soapenv"] = "http://www.w3.org/2003/05/soap-envelope";
responseHolder.namespaces["ns1"] = "http://www.oorsprong.org/websamples.countryinfo";
result = responseHolder.getNodeValue( "//soapenv:Body//ns1:CountryNameResult" ); // xpath

log.info(result);
