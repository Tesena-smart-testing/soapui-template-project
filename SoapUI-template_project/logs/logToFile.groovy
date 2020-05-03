import groovy.util.logging.Slf4j
 
// This script shows how to redirect log from console to log file stored in SoapUI home directory /bin

@Slf4j
class LogClass {
    def execute() {
        log.info 'this is log from groovy script.'
    }
}
 
def logToFile = new LogClass()
logToFile.execute()