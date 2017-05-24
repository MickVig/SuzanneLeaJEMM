<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.text.SimpleDateFormat"%>
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
        <a href="compterendu" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-clipboard" aria-hidden="true"></i> Comptes Rendus</a>
        <a href="agenda" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-calendar" aria-hidden="true"></i> Agenda</a>
        <a href="deconnexion" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-times" aria-hidden="true"></i> Déconnexion</a>
      </div>

      <div class="w3-main" style="margin-left:200px">
          <div class="w3-container w3-teal">
            <button class="w3-button w3-teal w3-xlarge w3-hide-large" onclick="w3_open()">&#9776;</button>
            <h1>Comptes rendus</h1>
          </div>
          <div class="w3-container">
            <button id="btnaddcr" class="w3-button w3-large w3-amber">Nouveau Compte Rendu <i class="fa fa-plus" aria-hidden="true"></i></button>
          </div> 
          <div class="w3-container">
            <ul class="w3-ul">
            	<c:forEach items="${comptesRendus}" var="compterendu">
              <li>
			<!--<c:set var="count" value="0"/>
			<c:set var="count" value="${count + 1}"/> -->
                <h3>CR N°${count}</h3>
                <% SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd"); %>
                <p> Date : ${compterendu.get(0)}</p>
                <p> Auteur : ${compterendu.get(2)}</p>
                <p> Contenu : ${compterendu.get(1)}</p>
                <!--  <p>Contenu : Duis ut orci non tortor faucibus egestas. Nullam aliquet massa in dictum hendrerit. Fusce dignissim ex vulputate hendrerit tincidunt. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed a lacus efficitur, eleifend mauris vitae, consequat risus. Integer feugiat massa ac ultrices suscipit. Cras rutrum nisl nec ligula vestibulum gravida.</p>
              -->
              </li>
              </c:forEach>
              <!-- <li>
                <h3>CR N°3</h3>
                <p>Auteur : Marc</p>
                <p>Contenu : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam non varius nisi. Maecenas euismod libero nec augue euismod imperdiet. Maecenas a dui ac augue sollicitudin lobortis eget eget est. Sed gravida urna leo, ut vehicula nibh molestie nec. Suspendisse nunc ante, gravida non lacus non, tristique porttitor mi. Vestibulum dictum posuere cursus. Ut molestie mi sed euismod sollicitudin. Mauris fermentum commodo metus.</p>
              </li>
              <li>
                <h3>CR N°2</h3>
                <p>Auteur : Nicolas</p>
                <p>Contenu : Proin quis metus ipsum. Curabitur sed pretium nulla. Aenean porta tortor in massa imperdiet, vitae efficitur nunc tincidunt. Aenean quis sodales lacus, aliquet venenatis lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Suspendisse ac iaculis velit, a iaculis felis. Aenean non dictum lorem. Praesent a nibh tristique, porttitor sapien consectetur, euismod tortor. Vestibulum tristique lectus vitae ex laoreet vestibulum sit amet sollicitudin dolor.</p>
              </li>
              <li>
                <h3>CR N°1</h3>
                <p>Auteur : Marc</p>
                <p>Contenu : Duis ut orci non tortor faucibus egestas. Nullam aliquet massa in dictum hendrerit. Fusce dignissim ex vulputate hendrerit tincidunt. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed a lacus efficitur, eleifend mauris vitae, consequat risus. Integer feugiat massa ac ultrices suscipit. Cras rutrum nisl nec ligula vestibulum gravida.</p>
              </li>
                -->
            </ul>
          </div>
      </div>


  </body>

  <script>
    
  </script>




</html>
