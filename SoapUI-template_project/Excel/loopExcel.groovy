/* This scripts reads data from excel in for loop, sets the property to the readed value,
call the response and verify value from response match the result in excel */

import jxl.*
import jxl.write.*
import com.eviware.soapui.support.GroovyUtils;
def groovyUtils = new com.eviware.soapui.support.GroovyUtils( context ) 

/* CHANGE THIS, set name of test step and property */
propertyName =  "countryCode"
stepName = "CountryName"


String readExcel(int i, int j)
  {
    // set path to xls file
    excelPath= "pathToExcelFile"
    Workbook workbook1 = Workbook.getWorkbook(new File( excelPath))
    Sheet sheet1 = workbook1.getSheet(0)
    
    a1 = sheet1.getCell(i,j)
     
    workbook1.close()
    return a1.contents;
 }



  for(int i=0; i<4; i++)
    {	
    		propValue= readExcel(0,i);  // input values for request 
    		expectedResult = readExcel(1,i);   // expected results to check

        // set property to readed value
    	  testRunner.testCase.setPropertyValue( propertyName, propValue ); 


    	  def testStep = testRunner.testCase.testSteps[stepName];
      	testStep.run(testRunner,context);  // run test step

        // get required value from response
      	def responseHolder= groovyUtils.getXmlHolder (stepName+"#Response")
    		responseHolder.namespaces["soapenv"] = "http://www.w3.org/2003/05/soap-envelope";
    		responseHolder.namespaces["ns1"] = "http://www.oorsprong.org/websamples.countryinfo";
    		result = responseHolder.getNodeValue( "//soapenv:Body//ns1:CountryNameResult" );


    		log.info("result: "+result+" expectedResult: "+expectedResult);
    		assert result==expectedResult; 	      
    }

   




    
 