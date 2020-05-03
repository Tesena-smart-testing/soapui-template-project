/*This script is used as dispatch for MockResponse. The Script dispatch method allows for more dynamic handling of the responses. */



def groovyUtils=  new com.eviware.soapui.support.GroovyUtils(context)
def requestXml = groovyUtils.getXmlHolder(mockRequest.requestContent)

def blz_code = requestXml.getNodeValue('//ns1:bic')

log.info "received blz code $blz_code"
def valid_codes = ['20010020','55010111','55010424','55010800']

if (valid_codes.contains(blz_code)){ 
	return "$blz_code Response"
}else{
	return "Not Found Response"
}