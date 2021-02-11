Feature: first test in API

Scenario: Checking resposnse 
 Given I hit the uri "http://jsonplaceholder.typicode.com" with string "users"
 When I get non empty response
 Then I verify status code is 200
 
 
 
 