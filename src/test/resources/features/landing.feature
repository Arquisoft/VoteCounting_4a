Feature: landing page 
  Scenario: client makes call to GET /index.xhtml
    When the client calls /index.xhtml
    Then the client receives status code of 200
    And the client receives the string "Sistema de Conteo"

 