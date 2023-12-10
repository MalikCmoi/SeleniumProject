Feature: Test Ztrain Connection
  AS a user I want to test the connection

  Scenario: mauvais mdp et bon login
    Given Ouvrir un page web et se rendre sur le site Ztrain
    When user click sur button de connection
    And User entre un bon login
    And User entre un mauvais mots de passe
    And Appuis sur le boutton se connecté
    Then User n'est pas connectée

  Scenario: bon mdp et mauvais login
    Given Ouvrir un page web et se rendre sur le site Ztrain
    When user click sur button de connection
    And User entre un mauvais login
    And User entre un bon mots de passe
    And Appuis sur le boutton se connecté
    Then User n'est pas connectée

  Scenario: Bon mdp et bon login
    Given Ouvrir un page web et se rendre sur le site Ztrain
    When user click sur button de connection
    And User entre un bon login
    And User entre un bon mots de passe
    And Appuis sur le boutton se connecté
    Then User est connectée

