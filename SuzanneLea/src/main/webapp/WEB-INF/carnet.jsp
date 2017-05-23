<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <body>

      <header class="w3-container w3-dark-grey">
        <h1 class="w3-center"><a href="#" class="w3-hover-text-teal">Suzanne &amp; L�a</a></h1>
      </header>
      
      <div class="w3-sidebar w3-bar-block w3-collapse w3-card-2 w3-dark-grey w3-animate-left" style="width:200px;" id="mySidebar">
        <button class="w3-bar-item w3-button w3-large w3-hide-large" onclick="w3_close()">Close &times;</button>
        <a href="dashboard.html" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-tachometer" aria-hidden="true"></i> Tableau de bord</a>
        <a href="carnet.html" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-address-book" aria-hidden="true"></i> Carnet d'adresses</a>
        <a href="compterendu.html" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-clipboard" aria-hidden="true"></i> Comptes Rendus</a>
        <a href="agenda.html" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-calendar" aria-hidden="true"></i> Agenda</a>
        <a href="#" class="w3-bar-item w3-button w3-text-white"><i class="fa fa-times" aria-hidden="true"></i> D�connexion</a>
      </div>

      

      <div class="w3-main" style="margin-left:200px">
          <div class="w3-container w3-teal">
            <button class="w3-button w3-teal w3-xlarge w3-hide-large" onclick="w3_open()">&#9776;</button>
            <h1>Carnet d'adresse</h1>
          </div>

          <div class="w3-container">
            <button id="btnaddcontact" class="w3-button w3-large w3-amber">Nouveau Contact <i class="fa fa-plus" aria-hidden="true"></i></button>
          </div> 

          <div class="w3-container">
            <ul>
              <li class="w3-padding-16">
                <span onclick="this.parentElement.style.display='none'" class="w3-button w3-white w3-xlarge w3-right">&times;</span>
                <img src="images/avatar.jpg" class="w3-left w3-circle w3-margin-right" style="width:50px">
                <span class="w3-large">Mike</span><br>
                <span>M�decin</span>
              </li>
              <li class="w3-padding-16">
                <span onclick="this.parentElement.style.display='none'" class="w3-button w3-white w3-xlarge w3-right">&times;</span>
                <img src="images/avatar.jpg" class="w3-left w3-circle w3-margin-right" style="width:50px">
                <span class="w3-large">Lise</span><br>
                <span>Proche</span>
              </li>
              <li class="w3-padding-16">
                <span onclick="this.parentElement.style.display='none'" class="w3-button w3-white w3-xlarge w3-right">&times;</span>
                <img src="images/avatar.jpg" class="w3-left w3-circle w3-margin-right" style="width:50px">
                <span class="w3-large">Arnaud</span><br>
                <span>Plombier</span>
              </li>
            </ul>
          </div> 
      </div>


  </body>

  <script>
    
  </script>




</html>