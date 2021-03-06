<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Suzanne &amp; L�a</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/w3.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/script.js"></script>
  </head>
  <body>

      <header class="w3-container w3-pink">
        <h1 class="w3-center">Suzanne &amp; L�a</h1>
      </header>

      <div class="w3-main">
          <div class="w3-container w3-teal">
            <button class="w3-button w3-teal w3-xlarge w3-hide-large" onclick="w3_open()">&#9776;</button>
            <h2>Carnet d'adresse</h2>
          </div>
          <div id="menu">
            <ul class="w3-row w3-ul">
              <li id="btndashboard" class="w3-col m2 w3-teal w3-text-white w3-hover-amber">
                <h4>
                  <i class="fa fa-tachometer" aria-hidden="true"></i>
                  <br>
                  Tableau de bord
                </h4>
              </li>
              <li id="btncarnet" class="w3-col m2 w3-pink w3-text-white w3-hover-amber">
                <h4>
                  <i class="fa fa-users" aria-hidden="true"></i>
                  <br>
                  Carnet Proches
                </h4>
              </li>
              <li id="btncarnetpart" class="w3-col m2 w3-teal w3-text-white w3-hover-amber">
                <h4>
                  <i class="fa fa-address-book" aria-hidden="true"></i>
                  <br>
                  Carnet Partenaires
                </h4>
              </li>
              <li id="btncr" class="w3-col m2 w3-pink w3-text-white w3-hover-amber">
                <h4>
                  <i class="fa fa-clipboard" aria-hidden="true"></i>
                  <br>
                  Comptes Rendus
                </h4>
              </li>
              <li id="btnagenda" class="w3-col m2 w3-teal w3-text-white w3-hover-amber">
                <h4>
                  <i class="fa fa-calendar" aria-hidden="true"></i>
                  <br>
                  Agenda
                </h4>
              </li>
              <li id="btnlogout" class="w3-col m2 w3-pink w3-text-white w3-hover-amber">
                <h4>
                  <i class="fa fa-times" aria-hidden="true"></i>
                  <br>
                  D�connexion
                </h4>
              </li>
            </ul>
          </div>

          <section>
            <div class="w3-container">
              <button id="btnaddcontact" class="w3-button w3-large w3-amber">Nouvel aidant <i class="fa fa-pencil" aria-hidden="true"></i></button>
            </div>

            <h2>Liste des aidants proches</h2> 

            <div class="w3-container">
              <ul class="liste w3-ul">
              	<c:forEach items="${aidantsProches}" var="aidant">
   					<li>
   						<ul class="w3-ul">
   							<li>${aidant.nom} ${aidant.prenom}</li>
   							<li>Adresse : ${aidant.adresse}</li>
   							<li>Telephone : ${aidant.tel}</li>
   							<li>Email : ${aidant.email }</li>
   						</ul>
   					</li>
   				</c:forEach>
  			  </ul>
            </div> 
          </section>
      </div>


  </body>
</html>
