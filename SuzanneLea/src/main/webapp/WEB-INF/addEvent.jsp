<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Suzanne &amp; Léa</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/script.js"></script>

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
</head>
<body class="w3-dark-grey">

	<header class="w3-container">
		<h1 class="w3-center">Suzanne &amp; Léa</h1>
	</header>

	<main class="w3-main">
	<div class="w3-container ">
		<h2>Ajout d'un évènement</h2>
	</div>
	<div class="w3-container w3-white w3-col s10">
		<form id="addEvent" class="w3-container " method="post" action="">

			<label for="titre" class="w3-text-teal"><b>Titre</b></label> 
			<input class="w3-input w3-border w3-light-grey" id="titre" name="titre" type="text"> 
				
			<label for="datepicker" class="w3-text-teal"><b>Date</b></label>
			<input class="w3-input w3-border w3-light-grey" id="datepicker" name="datepicker" type="text"> 
			
			<div class="w3-row">
				<label for="heure" class="w3-text-teal"><b>Heure</b></label><br>
				<input class="w3-input w3-border w3-light-grey w3-quarter" id="heure" name="heure" type="text">
				<input class="w3-input w3-border w3-light-grey w3-quarter" id="minute" name="minute" type="text"> 
			</div>
			
			<label for="contenu" class="w3-text-teal"><b>Contenu</b></label>
			<textarea id="contenu" name="contenu" class="w3-input w3-border" placeholder="Vous pouvez faire votre compte rendu"></textarea>

			<label for="accompagnant" class="w3-text-teal"><b>Accompagnant</b></label>
			<select class="w3-select" name="accompagnant" id="accompagnant">
				<option value="" disabled selected>Choisir un accompagnant</option>
				
				<c:forEach items="${proches}" var="aidant">
					<option value="${aidant.get(0)}">${aidant.get(2)}
						${aidant.get(3)}</option>
				</c:forEach>
				
			</select>

			<button class="w3-btn w3-blue-grey">Enregistrer</button>
		</form>
	</div>
	</main>


</body>
</html>