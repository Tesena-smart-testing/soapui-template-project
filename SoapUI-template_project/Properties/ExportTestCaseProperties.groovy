 /* this method exports test case properties into a file. */

def filePath="filepath"

def exportTestCaseProperties(def context, String filePath) {
    def  props = new Properties()
    //Get all the property names of test cases
    def names = context.testCase.getPropertyNames()
    //loop through names and set Properties object
    if (names) {
        names.each { name ->
            log.info "Set property ${name}"
            props.setProperty(name, context.testCase.getPropertyValue(name))
        }
        //Write properties object to a file
        def propFile = new File(filePath)
        props.store(propFile.newWriter(), null)
        log.info "Check the properties file: ${filePath}"
    } else {
        log.info "There does not seem to have any test case properties to write, check it."
    }
}


exportTestCaseProperties(context, filePath)