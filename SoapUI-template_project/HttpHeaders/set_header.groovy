// The below Groovy Script can be used to set the request header values. 


def stepName = ""
 import com.eviware.soapui.support.types.StringToStringMap 
 def headers = new StringToStringMap()
 headers.put("name","value");
 headers.put("name1","value1")
 headers.put("name2","value2")
 testRunner.testCase.testSteps[stepName].getHttpRequest().setRequestHeaders(headers)