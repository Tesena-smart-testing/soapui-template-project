def groovyUtils = new com.eviware.soapui.support.GroovyUtils(context)
def myTestCase = context.testCase

// Using the method projectPath you can get the project path which you are working
// it is neccessary to set property stepName and csvFileName

def projectPath = groovyUtils.projectPath
def csvFilePath = projectPath + myTestCase.getPropertyValue("csvFileName")
def csvOutputFilePath = csvFilePath //now output = input + found value in next column
log.info "Input parameters"
log.info myTestCase.getPropertyValue("csvFileName")
log.info myTestCase.getPropertyValue("stepName")
log.info csvFilePath
log.info csvOutputFilePath
context.fileReader = new BufferedReader(new FileReader(csvFilePath))

rowsData = context.fileReader.readLines()
int rowsize = rowsData.size()
log.info rowsize

firstRowData = rowsData[0]
log.info firstRowData
String[] columnName = firstRowData.split(";")
int columncount = columnName.size()
log.info columncount

//prepare output file
f = new File(csvOutputFilePath)
f.delete()
f.append(firstRowData+";"+myTestCase.getPropertyValue("newColumnHeader")+"\r\n")
  
for(int i =1; i < rowsize;  i++)
{
    rowdata = rowsData[i]
    //osetreni pro pripadne prazdne radky
    if (rowdata?.trim()) {
        String[] data = rowdata.split(";")
	    for(int j =0; j < columncount;  j++)
		{
			 log.info columnName[j] + " = " + "\"" + data[j].replace("\"", "") + "\"."
    		      myTestCase.setPropertyValue(columnName[j], data[j].replace("\"", ""))
		}
	
		log.info " Testrun" + " - " + myTestCase.getPropertyValue("stepName")
		def tst =  testRunner.runTestStepByName(myTestCase.getPropertyValue("stepName"))
		log.info(tst.status)
		def responseXML =  testRunner.testCase.getTestStepByName(myTestCase.getPropertyValue("stepName")).getHttpRequest().getResponseContentAsXml()
		log.info("-- Response value  is: "+responseXML)
		def holder = groovyUtils.getXmlHolder( myTestCase.getPropertyValue("stepName") + "#Response" )
		//Define the namespace
		holder.namespaces["soapenv"] = "http://schemas.xmlsoap.org/soap/envelope/"
	   	//Takes value from certain node
	  	def nodeName = holder.getNodeValue(myTestCase.getPropertyValue("xPath"))
	  	log.info nodeName
	  
	  	f.append(rowdata+";"+nodeName+"\r\n")
    } 
    
}