//how to define a map?
def countries = ['IND':'India',
			  'USA':'United States Of America',
			  'SIN':'Singapore',
			  'AUS':'Australia',
			  'RUS':'Russia'
			 ]
//find a country in the map?
String countryIamLookingFor = 'SIN'

boolean foundCountry = countries.containsKey(countryIamLookingFor)

log.info "Found country $countryIamLookingFor  : $foundCountry"
//how can i get the country name for the given country code?

String countryName = countries.get(countryIamLookingFor)

if(foundCountry==true){
	log.info "Country name is $countryName"	
}else{
	log.error "Sorry can't find the country"	
}

//ADDING AN ENTRY TO MAP?
countries.put('GB','Great Britian')
log.info countries