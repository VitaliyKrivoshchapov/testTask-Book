Feature:  check test

  Scenario:
    Given url 'http://localhost:8080/api/books'
    When method Get
    Then status 200

