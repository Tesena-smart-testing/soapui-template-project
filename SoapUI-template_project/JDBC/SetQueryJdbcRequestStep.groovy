/* This script sets the query to Jdbc request
*/

import groovy.text.SimpleTemplateEngine

//Edit the jdbc test step name if required
def nextStep = 'Get user'

//Edit query if required, but not ids variable below as that is used in binding
// id values are stored in property IDS
def query = 'select * from users where id in ( $ids )'
def binding = [ids: context.testCase.getPropertyValue('IDS')]
def step = context.testCase.testSteps[nextStep]
def template = new SimpleTemplateEngine().createTemplate(query).make(binding)

log.info "updated query : ${template.toString()}"

//Set the query to jdbc step
step.jdbcRequestTestStepConfig.query = template.toString()

// example 2
def username="John"
def query2 = "select * from users where username="+username
step.jdbcRequestTestStepConfig.query = query2