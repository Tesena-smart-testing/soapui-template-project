// This script is used to modify response before assert validation
// if-else statement based on the request response
def request = testRunner.testCase.testSteps["GetCountryCode"].testRequest
if( request.response == null ) {
	log.info("Empty response")
	// do sth
	return
}
else {
	log.info("ok")
	log.info(request.response.responseContent) // print response
	// do sth
}


// Getting the response content.
def content = request.response.responseContent

// Modifying the content – replacing all 555 with 444.
content = content.replaceAll( "555", "444" )

// Write the new content to the response
request.response.responseContent = content