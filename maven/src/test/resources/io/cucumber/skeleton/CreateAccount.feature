@CreateAccount
Feature: Test Ztrain Creation Account
  AS a user I want Create new Account
  Scenario: J'essai de créer un compte avec un mots de passe de comfirmation différent
    Given etre sur la page Ztrain et ne pas être connécté
    When User clique sur le bouton de connection sur le header
    And User mets un bon mail
    And User mets un bon mots de passe de plus 8 caractère
    And User mots un mots de passe de confirmation différent
    And user click sur le boutton Inscription
    Then User est n'est pas inscrit mauvais mdp

  Scenario: J'essai de créer un compte avec un mauvai mots de passe
    Given etre sur la page Ztrain et ne pas être connécté
    When User clique sur le bouton de connection sur le header
    And User mets un bon mail
    And User mets un mots de passe de moins 8 caractère
    And User mets un mots de passe de confirmation identique au mdp
    And user click sur le boutton Inscription
    Then User est n'est pas inscrit mdp petit

  Scenario: J'essai de créer un compte avec un mauvai mail et un bon mdp
    Given etre sur la page Ztrain et ne pas être connécté
    When User clique sur le bouton de connection sur le header
    And User mets un mauvais mail
    And User mets un bon mots de passe
    And User mets un mots de passe de confirmation identique au mdp 1
    And user click sur le boutton Inscription
    Then User est n'est pas inscrit mail

    @CreateAccountGoodMdpEmail
  Scenario: Je créer un compte
    Given etre sur la page Ztrain et ne pas être connécté
    When User clique sur le bouton de connection sur le header
    And User mets un bon mail
    And User mets un bon mots de passe
    And User mets un mots de passe de confirmation identique au mdp 1
    And user click sur le boutton Inscription
    Then User est inscrit mail et connécté