<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <body class="w3-dark-grey">

      <header class="w3-container">
        <h1 class="w3-center">Suzanne &amp; Léa</h1>
      </header>
      <button id="btnaccueil" class="w3-btn w3-green w3-xlarge"><i class="fa fa-user" aria-hidden="true"></i> Accueil</button>
      <main class="w3-main">
          <div class="w3-container">
              <h2>Inscription</h2>
          </div>
          <div class="w3-col s1">
          </div>
          <div class="w3-container w3-white w3-col s10">
          
          <form id="formaidee" class="w3-container w3-col s10" method="post" action="">
            	${messageInscriptionAidee}
              <h3>La personne à aider</h3>
              <label for="nom" class="w3-text-teal"}><b>Nom</b></label>
              <input class="w3-input w3-border w3-light-grey" id="nom" name="nom" type="text" value="${nom1}">

              <label for="prenom" class="w3-text-teal"><b>Prénom</b></label>
              <input class="w3-input w3-border w3-light-grey" id="prenom" name="prenom" type="text" value="${prenom1}">

              <label for="adresse" class="w3-text-teal"><b>Adresse</b></label>
              <input class="w3-input w3-border w3-light-grey" id="adresse" name="adresse" type="text" value="${adresse1}">

              <label for="tel" class="w3-text-teal"><b>Téléphone</b></label>
              <input class="w3-input w3-border w3-light-grey" id="tel" name="tel" type="text" value="${telephone1}">

              <label for="mail" class="w3-text-teal"><b>Mail</b></label>
              <input class="w3-input w3-border w3-light-grey" id="mail" name="mail" type="mail" value="${mail1}">

              <label for="mdp" class="w3-text-teal"><b>Mot de passe</b></label>
              <input class="w3-input w3-border w3-light-grey" id="mdp" name="mdp" type="password">
            
              <br>
              <hr>
			  ${messageInscriptionRef}
              <h3>La personne référente</h3>
              <label for="nomref" class="w3-text-teal"><b>Nom</b></label>
              <input class="w3-input w3-border w3-light-grey" id="nomref" name="nomref" type="text" value="${nomref1}" >

              <label for="prenomref" class="w3-text-teal"><b>Prénom</b></label>
              <input class="w3-input w3-border w3-light-grey" id="prenomref" name="prenomref" type="text"  value="${prenomref1}">

              <label for="adresseref" class="w3-text-teal"><b>Adresse</b></label>
              <input class="w3-input w3-border w3-light-grey" id="adresseref" name="adresseref" type="text" value="${adresseref1}">

              <label for="telref" class="w3-text-teal"><b>Téléphone</b></label>
              <input class="w3-input w3-border w3-light-grey" id="telref" name="telref" type="text" value="${telephoneref1}">

              <label for="mailref" class="w3-text-teal"><b>Mail</b></label>
              <input class="w3-input w3-border w3-light-grey" id="mailref" name="mailref" type="mail" value="${mailref1}">

              <label for="mdpref" class="w3-text-teal"><b>Mot de passe</b></label>
              <input class="w3-input w3-border w3-light-grey" id="mdpref" name="mdpref" type="password">
          
              <br>
              <hr>
				
              <h3>Medecin traitant</h3>
              <select class="w3-select" name="medecin">
	                <option value="" disabled selected>Choisir un médecin</option>
	                <c:forEach items="${medecins}" var="medecin">
	                	<option value="${medecin.get(0)}">${medecin.get(2)} ${medecin.get(3)}</option>
	            	</c:forEach>
              </select>

              <br><br>
              

              <button class="w3-btn w3-blue-grey">S'inscrire</button>
              <br><br>
          </form>
          </div>
          <div class="w3-col s1">
          </div>
      </main>
  </body>
</html>
