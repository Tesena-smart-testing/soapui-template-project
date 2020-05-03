//Definuje Groovy Utils a holder pro validaci xml responsu
def groovyUtils = new com.eviware.soapui.support.GroovyUtils(context)
def holder = groovyUtils.getXmlHolder(messageExchange.responseContent)

//Define the NameSpace
holder.namespaces["xmlns"] = "http://tempuri.org/"

//Vezme hodnotu od urciteho nodu
def AddResult = holder.getNodeValue("//xmlns:AddResult")


log.info holder
//vypis hodnoty do konzole
log.info "Result is " + AddResult

//Porovnani stringu a vysledek assertion
assert AddResult=="54329"

if(AddResult=="54329")
{ log.info "Pass" }
else
{ log.info "fail"
assert false}