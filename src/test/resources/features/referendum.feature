Feature: referendum page 
  Scenario: client makes call to GET /referendum.xhtml
    When the client call /referendum.xhtml
    Then the client receives status cod of 200
    And the client receives the stringResult "Resultados del Referendum"

 