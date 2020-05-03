// This script get all headers of specified request and log it to console

def stepName = ""
 def header = testRunner.testCase.testSteps[stepName].httpRequest.getRequestHeaders()
 header.each
 {
  key,val ->
  log.info "Key = "+key+" ; value="+val
 }