//it executes particular test step based on a condition

status = testRunner.runTestStepByName("Add").status
 
def ns1 = "http://tempuri.org/"
 
AddResult = context.expand( '${Add#Response#//ns1:AddResult}' ).toInteger()
 
if (AddResult < 16) {
    testRunner.runTestStepByName("Subtract")
    }
else {
}