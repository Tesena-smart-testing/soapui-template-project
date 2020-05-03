def json = '''
{
"quote": {
"id": "test_id",
"amount": 100,
"links":    [
    {
    "rel": "self",
    "href": "http://localhost:8080/quote/777"
    },
    {
    "rel": "customer",
    "href": "http://localhost:8080/customer/12345"
    }
]
 }
}'''
def parsedJson = new groovy.json.JsonSlurper().parseText(json)
log.info parsedJson.quote.id