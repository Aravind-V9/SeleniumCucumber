
Feature: IdentifyCourses

  Scenario: Search for web development courses for Beginners level & English Language and extract the course names, total learning hours & rating for first 2 courses.
    Given launch the coursera application
    When search for "web development" courses
    And select the Beginners level & English Language
    And extract course names, total learning hours & rating for first 2 courses
    Then I validate the outcomes
    
    
    
    