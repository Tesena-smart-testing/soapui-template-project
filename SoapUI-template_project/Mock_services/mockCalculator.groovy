//it returns variable sum as a result of addition of intA and intB from request

// create XmlHolder for request content
def holder = new com.eviware.soapui.support.XmlHolder( mockRequest.requestContent )
// get arguments and sum
def intA = Integer.parseInt( holder["//tem:intA"] )
def intB = Integer.parseInt( holder["//tem:intB"] )
requestContext.sum =  intA + intB