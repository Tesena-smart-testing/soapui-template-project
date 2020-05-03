 /* this method exports test case properties into a file. */
 /* properties have to be stored in file
  like this prop1=value1
	  		prop2=value2
      		prop3=value3
   it can be .txt or .properties file
  */

def filePath="filepath"

def importPropertiesToTestCase(def context,String filePath) {
    def  props = new Properties()
    def propFile = new File(filePath)
    //load the properties files into properties object
    props.load(propFile.newDataInputStream())
    //loop thru the properties and set them at test case level
    props.each {
        context.testCase.setPropertyValue(it.key, it.value.toString())
    }
}

importPropertiesToTestCase(context, filePath)

