String expectedName,acutalName

expectedName = 'Jhon'
actualName = 'Jhon'

int a,b,c
a=10
b=10

c = a+b

log.info 'before assertion'
assert expectedName == actualName,"names are not matching expected name is $expectedName but actual name was $actualName"
assert 20== c
log.info 'after assertion'
def fruits =['Apple','Banana','Grapes','Mango']

assert true == fruits.contains('Apple'), "Can't find Apple in the list"
