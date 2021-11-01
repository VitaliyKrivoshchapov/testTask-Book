 Feature: My test
   Scenario: Test simple try

     Given url 'http://localhost:8080/api/books'
     When method GET
     Then status  200
     And print response