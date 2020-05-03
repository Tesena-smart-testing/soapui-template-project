//Working with Lists and Maps
String fruit,country

fruit ='Apple'
fruit ='Banana'

def fruits =['Apple','Banana','Grapes','Mango']

log.info "Fruit name  = $fruit"

log.info "Fruits = $fruits"

//Reading one by one entry in the list?

fruits.each{
	fruitName ->
	log.info "Name is $fruitName"
}

//i want to find out whether my fruit list contains a fruit?
String fruitIamLookingFor = 'Papaya'
boolean hasFruitInsideIt = fruits.contains(fruitIamLookingFor)

if(hasFruitInsideIt == true){
	log.info "Gotcha!! found  $fruitIamLookingFor  in the fruit list"
}else{
	log.error "Can't find fruit $fruitIamLookingFor in the fruit list"
}

//During run time , can I add a fruit to the existing list?
fruits.add('Papaya')
fruits << 'Pomegranate'

hasFruitInsideIt = fruits.contains(fruitIamLookingFor)

log.info '-------------After ----------------------'
if(hasFruitInsideIt == true){
	log.info "Gotcha!! found  $fruitIamLookingFor  in the fruit list"
}else{
	log.error "Can't find fruit $fruitIamLookingFor in the fruit list"
}

//Remove papaya from list
fruits.remove('Papaya')
hasFruitInsideIt = fruits.contains(fruitIamLookingFor)

log.info '-------------After removing again ----------------------'
if(hasFruitInsideIt == true){
	log.info "Gotcha!! found  $fruitIamLookingFor  in the fruit list"
}else{
	log.error "Can't find fruit $fruitIamLookingFor in the fruit list"
}





