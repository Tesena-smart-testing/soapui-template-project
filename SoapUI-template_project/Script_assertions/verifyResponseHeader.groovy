// can be used in script assertion to verify valid http request
def status= "HTTP/1.1 200 OK"
def headers =  messageExchange.getResponseHeaders()
log.info headers["#status#"]
assert [status] == headers["#status#"]

// verify content type of response
def content_type = "application/json"
def headers =  messageExchange.getResponseHeaders()
log.info headers["Content-Type"]
assert [content_type] == headers["Content-Type"]