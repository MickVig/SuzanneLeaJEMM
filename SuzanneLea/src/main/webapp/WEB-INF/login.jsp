<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      <div class="w3-container w3-teal">
              <h2>Connexion</h2>
      </div>
      <div class="w3-main">
          <section>
	          <button id="btnaccueil" class="w3-btn w3-amber w3-xlarge"><i class="fa fa-user" aria-hidden="true"></i> Accueil</button>
				<button id="btncreate" class="w3-btn w3-amber w3-xlarge"><i class="fa fa-pencil" aria-hidden="true"></i> Inscription</button>
	          <div class="w3-container">
	            <form id="formlogin" method="post" action="">
	              <label for="mail" class="w3-text-teal">Mail</label>
	              <input class="w3-input w3-border w3-light-grey" id="mail" name="mail" type="email" value="ginette.menut@gmail.com" >
	              <br>
	              <label for="mdp" class="w3-text-teal">Mot de passe</label>
	              <input class="w3-input w3-border w3-light-grey" id="mdp" name="mdp" type="password" value="aide1">
	            
	              <button class="w3-btn w3-amber">Se Connecter</button>
	            </form>
	          </div>
	          ${messageLogin}
	         </section>
      </div>


  </body>
</html>
