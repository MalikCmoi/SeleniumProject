Feature: Test Ztrain Deconnexion
  AS a user I want to test the deconnexion

  Scenario: Je me deconnecte de mon compte
    Given etre sur la page Ztrain, et être connécter a un compte
    When User clique sur le bonton mail sur le header
    And User clque sur le bonton Se déconnectée
    Then User est déconnécté
