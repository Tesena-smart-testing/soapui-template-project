import com.eviware.soapui.support.GroovyUtils
//Read bank service data from File
//create instance of GroovyUtils class.
def groovyUtils = new GroovyUtils(context)
def requestXmlHolder,responseXmlHolder
//loop through file and read the content
File blzFile = new File("C:\\soapUI\\data.txt")
String blz,bez,ort,plz,bic
def lineData
blzFile.eachLine{
	line->
	lineData = line.split(',')
	blz = lineData[0] //blz code
	bez = lineData[1] 
	bic = lineData[2] 
	ort = lineData[3] 
	plz = lineData[4]
	log.info "blz=$blz, bez=$bez, bic=$bic, ort=$ort, plz=$plz "
}
