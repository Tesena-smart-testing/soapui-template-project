/**
* this script will set the request's content in JSON */


def stepName="stepName"  // enter name of the step
def request = context.testCase.getTestStepByName(stepName).getTestRequest()
def jsonText = '''
{
  "id" : "sample id",
  "name" : "sample name",
  "tags" : [ "sample tags" ],
  "address" : {
    "street" : "sample street",
    "zipcode" : "sample zipcode",
    "city" : "sample city"
  }
}       
'''
request.setRequestContent(jsonText)