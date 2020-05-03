boolean isPassed
String grade

isPassed = false

//if i am passed in exam my dad will buy me a bike

if (isPassed == true){ //evaluates a boolean expression
	log.info 'Congratulations!!!'
}else{
	log.error 'Better luck next time!!!'
}

//How can handle multiple scenerios/conditions?
// A - Car, B - Bike C  - Nothing
grade = 'C'

if(grade =='A'){
	log.info ' You got Car!!'
}else if(grade=='B'){
	log.warn 'You got a Bike!!!'
}else{
	log.error 'You got Nothing!!!'
}





