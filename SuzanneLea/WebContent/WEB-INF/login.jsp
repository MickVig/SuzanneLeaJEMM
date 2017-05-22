<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Suzanne &amp; Léa</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/w3.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./js/jquery-3.2.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/script.js"></script>
  </head>
  <body class="w3-dark-grey w3-container">

      <header class="w3-container">
        <h1 class="w3-center">Suzanne &amp; Léa</h1>
      </header>
      <button id="btnaccueil" class="w3-btn w3-green w3-xlarge"><i class="fa fa-user" aria-hidden="true"></i> Accueil</button>
      <main class="w3-main w3-quarter">
          <div class="w3-container ">
              <h2>Connexion</h2>
          </div>
          <div class="w3-container w3-white w3-col s10">
            <form id="formlogin" class="w3-container" method="post" action="login">
              <label for="mail" class="w3-text-teal"><b>Mail</b></label>
              <input class="w3-input w3-border w3-light-grey" id="mail" name="mail" type="mail" >

              <label for="mdp" class="w3-text-teal"><b>Mot de passe</b></label>
              <input class="w3-input w3-border w3-light-grey" id="mdp" name="mdp" type="text">

              <button class="w3-btn w3-blue-grey">Se Connecter</button>
            </form>
          </div>
      </main>


  </body>
</html>
