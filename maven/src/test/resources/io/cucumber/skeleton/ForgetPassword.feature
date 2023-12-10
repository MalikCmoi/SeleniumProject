@ForgetPassWord
Feature: Test Ztrain Forget PassWord
  AS a user I want change my forget password
  Scenario: J'essai de changer avec un mail invalide
    Given etre sur la page Ztrain et ne pas être connécté forget password
    When User clique sur le bouton de connection sur le header
    And User Click sur le lien Mot de passe oublié
    And User mets un mail invalide dans la page mots de passe oublié
    And User mets un mots de passe valide dans la page mots de passe oublié
    And User click sur le boutton Réinitialiser
    Then le mots de pass n'est pas modifié message d'erreur: "Le format de l'email est invalid"

  Scenario: J'essai de changer avec un mail non enregister
    Given etre sur la page Ztrain et ne pas être connécté forget password
    When User clique sur le bouton de connection sur le header
    And User Click sur le lien Mot de passe oublié
    And User mets un mail non enregister dans la page mots de passe oublié
    And User mets un mots de passe valide dans la page mots de passe oublié
    And User click sur le boutton Réinitialiser
    Then le mots de pass n'est pas modifié message d'erreur: "Cet utilisateur n'existe pas"

  Scenario: J'essai de changer avec un mail enregister mais un mauvais mdp
    Given etre sur la page Ztrain et ne pas être connécté forget password
    When User clique sur le bouton de connection sur le header
    And User Click sur le lien Mot de passe oublié
    And User mets un mail enregister dans la page mots de passe oublié
    And User mets un mots de passe non valide dans la page mots de passe oublié
    And User click sur le boutton Réinitialiser
    Then le mots de pass n'est pas modifié message d'erreur: "* Le mot de passe doit avoir au moins 8 caractères"

  Scenario: J'essai de changer avec un mail enregister et un bon mdp
    Given etre sur la page Ztrain et ne pas être connécté forget password
    When User clique sur le bouton de connection sur le header
    And User Click sur le lien Mot de passe oublié
    And User mets un mail enregister dans la page mots de passe oublié
    And User mets un mots de passe valide dans la page mots de passe oublié
    And User click sur le boutton Réinitialiser
    Then le mots de passe est modifié et on peux se connéctée