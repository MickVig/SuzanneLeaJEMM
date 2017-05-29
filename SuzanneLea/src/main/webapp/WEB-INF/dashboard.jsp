<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div class="w3-container w3-teal w3-row">
			<button class="w3-button w3-teal w3-xlarge w3-hide-large w3-quarter"
				onclick="w3_open()">
				<i class="fa fa-bars" aria-hidden="true"></i> Menu
			</button>
			<h1 class="w3-repos">Tableau de bord</h1>
		</div>

		<div id="menu">
			<ul class="w3-row w3-ul">
				<li id="btndashboard"
					class="w3-col m2 w3-teal w3-text-white w3-hover-amber">
					<h4>
						<i class="fa fa-tachometer" aria-hidden="true"></i> <br>
						Tableau de bord
					</h4>
				</li>
				<li id="btncarnet"
					class="w3-col m2 w3-pink w3-text-white w3-hover-amber">
					<h4>
						<i class="fa fa-users" aria-hidden="true"></i> <br> Carnet
						Proches
					</h4>
				</li>
				<li id="btncarnetpart"
					class="w3-col m2 w3-teal w3-text-white w3-hover-amber">
					<h4>
						<i class="fa fa-address-book" aria-hidden="true"></i> <br>
						Carnet Partenaires
					</h4>
				</li>
				<li id="btncr"
					class="w3-col m2 w3-pink w3-text-white w3-hover-amber">
					<h4>
						<i class="fa fa-clipboard" aria-hidden="true"></i> <br>
						Comptes Rendus
					</h4>
				</li>
				<li id="btnagenda"
					class="w3-col m2 w3-teal w3-text-white w3-hover-amber">
					<h4>
						<i class="fa fa-calendar" aria-hidden="true"></i> <br> Agenda
					</h4>
				</li>
				<li id="btnlogout"
					class="w3-col m2 w3-pink w3-text-white w3-hover-amber">
					<h4>
						<i class="fa fa-times" aria-hidden="true"></i> <br>
						Déconnexion
					</h4>
				</li>
			</ul>
		</div>

		<div class="w3-container">
			<h2>Bienvenue dans votre espace personnel ${personne.prenom}
				${personne.nom} !</h2>
		</div>

		<section id="infodash">
			<h2>Informations</h2>
			<div>
				<ul class="w3-ul ">
					<li>Aidant référent</li>
					<li>NOM et PRENOM : ${procheReferent.nom}
						${procheReferent.prenom}</li>
					<li>Adresse : ${procheReferent.adresse}</li>
					<li>Telephone : ${procheReferent.tel}</li>
					<li>Email : ${procheReferent.email }</li>
				</ul>
				<ul class="w3-ul ">
					<li>Medecin référent</li>
					<li>NOM et PRENOM : ${medecinReferent.nom}
						${medecinReferent.prenom}</li>
					<li>Adresse : ${medecinReferent.adresse}</li>
					<li>Telephone : ${medecinReferent.tel}</li>
					<li>Email : ${medecinReferent.email }</li>
				</ul>
			</div>
			<div>
				<ul class="w3-ul ">
					<li>Dernier compte rendu</li>
					<c:if test="${dernierCR.size()==4}">
						<li>Auteur : ${dernierCR.get(3).getNom()}
							${dernierCR.get(3).getPrenom()}</li>
					</c:if>
					<c:if test="${dernierCR.size()==3}">
						<li>Auteur : ${dernierCR.get(2).getNom()} ${dernierCR.get(2).getPrenom()}</li>
					</c:if>
					<li>Date : ${dernierCR.get(1)}</li>
					<li>Contenu : ${dernierCR.get(0).getCommentaire()}</li>
				</ul>
				<ul class="w3-ul ">
					<li>Prochain évènement</li>
					<li>Titre : ${prochainEvenement.get(0).titre}</li>
					<li>Date : ${prochainEvenement.get(1)}</li>
					<li>Contenu : ${prochainEvenement.get(0).contenu}</li>
				</ul>
			</div>
		</section>
	</div>
</body>
</html>
