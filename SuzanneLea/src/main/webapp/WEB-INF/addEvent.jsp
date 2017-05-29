<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Suzanne &amp; Léa</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/script.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$( function() {
	  $( "#datepicker" ).datepicker();
	} );
</script>
</head>
<body>

	<header class="w3-container w3-pink">
		<h1 class="w3-center">Suzanne &amp; Léa</h1>
	</header>

	<div class="w3-main">
		<div class="w3-container w3-teal">
			<h2>Ajout d'un événement</h2>
		</div>
		<section>
			<div class="w3-container">
				<button id="btnagenda" class="w3-button w3-large w3-amber">
					Retour à l'agenda <i class="fa fa-clipboard" aria-hidden="true"></i>
				</button>
			</div>
			<div class="w3-container w3-white">
				<form id="addEven" method="post" action="">

					<label for="titre" class="w3-text-teal">Titre</label> <input
						class="w3-input w3-border" id="titre" name="titre" type="text">
					<br> <label for="datepicker" class="w3-text-teal">Date</label>
					<input class="w3-input w3-border" id="datepicker"
						name="datepicker" type="text"> <br>
					<div class="w3-row">
						<label for="heure" class="w3-text-teal">Heure</label><br>
						<input class="w3-input w3-border w3-quarter"
							id="heure" name="heure" type="text" placeholder="heure"> 
							 
							<input
							class="w3-input w3-border w3-quarter" id="minute"
							name="minute" type="text" placeholder="minute">
					</div>
					<br> <label for="contenu" class="w3-text-teal">Evènement</label>
					<textarea id="contenu" name="contenu" class="w3-input w3-border"
						placeholder="Description de l'évènement"></textarea>
					<br> 
					
					
					<label for="accompagnant" class="w3-text-teal">Accompagnant</label>
					<select class="w3-select" name="accompagnant" id="accompagnant">
						<option value="" disabled selected>Choisir un accompagnant</option>
						<c:forEach items="${proches}" var="aidant">
							<option value="${aidant.get(0)}">${aidant.get(2)} ${aidant.get(3)}</option>
						</c:forEach>
					</select>

					<button class="w3-btn w3-amber">Enregistrer</button>
				</form>
			</div>
		</section>
	</div>
</body>
</html>