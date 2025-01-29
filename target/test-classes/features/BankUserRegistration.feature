Feature: User Registration

  As a potential user of BugBank
  I want to register on the platform
  So that I can access and use its features

  Scenario: Login for a successful user registred
    Given I am on the BugBank registration page
    And I fill in the "email" field with "marcos.hioka@gmail.com"
    And I fill in the "name" field with "Marcos Test"
    And I fill in the "password" field with "Test#123"
    And I fill in the "confirmPassword" field with "Test#123"
    And I should see a message saying "foi criada com sucesso"
    And I should be redirected to the login page
    When I fill in the "emailLogin" field with "marcos.hioka@gmail.com"
    And I fill in the "passwordLogin" field with "Test#123"
    Then I should be redirected to the home page with message "bem vindo ao BugBank :)"
    And I can access the "EXTRATO" page with message "Saldo disponível"

