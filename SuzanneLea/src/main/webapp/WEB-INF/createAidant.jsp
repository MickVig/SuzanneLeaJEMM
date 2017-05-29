<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Suzanne &amp; Léa</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/w3.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./js/jquery-3.2.1.min.js"></script>
    <script src="./js/script.js"></script>
  </head>
  <body>

      <header class="w3-container w3-pink">
        <h1 class="w3-center">Suzanne &amp; Léa</h1>
      </header>
      
      <div class="w3-main">
          <div class="w3-container w3-teal">
              <h2>Ajout d'un nouveau aidant proche</h2>
          </div>
          <section>
              <div class="w3-container">
                <button id="btncarnet" class="w3-button w3-large w3-amber">Retour au Carnet Proches <i class="fa fa-users" aria-hidden="true"></i></button>
              </div>
              <div class="w3-container w3-white">
             	 ${messageinscription}
                <form id="formaidant"  method="post" action="">

                  <label for="nom" class="w3-text-teal">Nom</label>
                  <input class="w3-input w3-border" id="nom" name="nom" type="text" >
                  <br>
                  <label for="prenom" class="w3-text-teal">Prénom</label>
                  <input class="w3-input w3-border" id="prenom" name="prenom" type="text" >
                  <br>
                  <label for="adresse" class="w3-text-teal">Adresse</label>
                  <input class="w3-input w3-border" id="adresse" name="adresse" type="text">
                  <br>
                  <label for="tel" class="w3-text-teal">Téléhone</label>
                  <input class="w3-input w3-border" id="tel" name="tel" type="text">
                  <br>
                  <label for="mail" class="w3-text-teal">Mail</label>
                  <input class="w3-input w3-border" id="mail" name="mail" type="email">
                  <br>
                  <label for="mdp" class="w3-text-teal">Mot de passe</label>
                  <input class="w3-input w3-border" id="mdp" name="mdp" type="text">

                  <button class="w3-btn w3-amber">Enregistrer</button>
                </form>
            </div>
          </section>
          
      </div>


  </body>
</html>
