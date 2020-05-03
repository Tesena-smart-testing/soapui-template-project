// The below Groovy Script can be used to update the request header values. 

def stepName = ""
import com.eviware.soapui.support.types.StringToStringMap 
def headers = testRunner.testCase.testSteps[stepName].getHttpRequest().getRequestHeaders()
def list = []
list.add("newvalue")
headers["name1"] = list;
testRunner.testCase.testSteps[stepName].getHttpRequest().setRequestHeaders(headers)