/* This script show how to create dialog windows for alert message,  
 prompt user for input and set this value to property
 e.g. username and password */


 
def dialog = com.eviware.soapui.support.UISupport;



String username = dialog.prompt("Enter username","Username","")
testRunner.testCase.setPropertyValue( "username", username )
log.info(username)

String pass = dialog.prompt("Enter password","Password","")
testRunner.testCase.setPropertyValue( "password", pass ) 

// alert info message
dialog.showInfoMessage("Press return when ready...")


/* prompt user for yes/yesToAll/no 
 *  return values yes - 0
 *  			   yes to all - 1
 *  			   no - 2 
 */
res=dialog.yesYesToAllOrNo("tak co?", "title") 
log.info(res)
