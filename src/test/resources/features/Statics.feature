Feature: Statics page

  Scenario: client makes call to GET /
  	When the client calls /
  	then the client receives status code of 200
  	And the client receives the string "Votos"

 