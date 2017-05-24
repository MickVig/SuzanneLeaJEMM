<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  </head>
  <body>

      <header class="w3-container w3-dark-grey">
        <h1 class="w3-center"><a href="#" class="w3-hover-text-teal">Suzanne &amp; Léa</a></h1>
      </header>
      
      <div class="w3-sidebar w3-bar-block w3-collapse w3-card-2 w3-dark-grey w3-animate-left" style="width:200px;" id="mySidebar">
        <button class="w3-bar-item w3-button w3-large w3-hide-large" onclick="w3_close()">Close &times;</button>
        <a href="dashboard" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-tachometer" aria-hidden="true"></i> Tableau de bord</a>
        <a href="carnet" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-address-book" aria-hidden="true"></i> Carnet d'adresses</a>
        <a href="carnetpartenaires" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-address-book" aria-hidden="true"></i> Carnet Part</a>
        <a href="compterendu" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-clipboard" aria-hidden="true"></i> Comptes Rendus</a>
        <a href="agenda" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-calendar" aria-hidden="true"></i> Agenda</a>
        <a href="deconnexion" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-times" aria-hidden="true"></i> Déconnexion</a>
      </div>

      <div class="w3-main" style="margin-left:200px">
          <div class="w3-container w3-teal">
            <button class="w3-button w3-teal w3-xlarge w3-hide-large" onclick="w3_open()">&#9776;</button>
            <h1>Agenda</h1>
          </div>
          <div class="w3-container">
            <button id="btnaddevent"class="w3-button w3-large w3-amber">Ajouter un événement <i class="fa fa-plus" aria-hidden="true"></i></button>
          </div> 
          <div class="w3-container">
            <ul class="w3-ul">
           
              
              <li>
				<h3>Liste de tous les évènements</h3> 
				
					<c:forEach items="${allRDV}" var="rdv">
						<ul>
							<li>Titre : ${rdv.get(0).titre} </li>
							<li>Date : ${rdv.get(0).date} </li>
							<c:if test = "${rdv.size()>1}">
         						<li>Aidant : ${rdv.get(1).getNom()} ${rdv.get(1).getPrenom()}</li>
      						</c:if>
							<li>Contenu : ${rdv.get(0).contenu}</li>
						</ul>
						<br/>
					</c:forEach>
				</li>
              
              
              
              
              
              
              
              
            </ul>
          </div>
      </div>


  </body>

  <script>
    
  </script>




</html>
