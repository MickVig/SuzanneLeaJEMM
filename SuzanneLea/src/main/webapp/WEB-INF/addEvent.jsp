<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Suzanne &amp; L�a</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/w3.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
  </head>
  <body class="w3-dark-grey">

      <header class="w3-container">
        <h1 class="w3-center">Suzanne &amp; L�a</h1>
      </header>
      
      <main class="w3-main">
          <div class="w3-container ">
              <h2>Ajout d'un �v�nement</h2>
          </div>
          <div class="w3-container w3-white w3-col s10">
            <form id="addEvent" class="w3-container " method="post" action="">

              <label for="titre" class="w3-text-teal"><b>Titre</b></label>
              <input class="w3-input w3-border w3-light-grey" id="titre" name="titre" type="text" >
			
			<label for="date" class="w3-text-teal"><b>Date</b></label>
             <input class="w3-input w3-border w3-light-grey" id="date" name="date" type="date" >

			<label for="time" class="w3-text-teal"><b>Heure</b></label>
             <input class="w3-input w3-border w3-light-grey" id="time" name="time" type="time" >

              <label for="contenu" class="w3-text-teal"><b>Contenu</b></label>
              <textarea id="contenu" name="contenu" class="w3-input w3-border" placeholder="Vous pouvez faire votre compte rendu"></textarea>

              <label for="accompagnant" class="w3-text-teal"><b>Accompagnant</b></label>
              <select class="w3-select" name="accompagnant" id="accompagnant">
                <option value="" disabled selected>Choisir un accompagnant</option>
                <c:forEach items="${proches}" var="aidant">
                	<option value="${aidant.get(0)}"> ${aidant.get(2)} ${aidant.get(3)} </option>
                </c:forEach>
              </select>

              <button class="w3-btn w3-blue-grey">Enregistrer</button>
            </form>
          </div>
      </main>


  </body>
</html>