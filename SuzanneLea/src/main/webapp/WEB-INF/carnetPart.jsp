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
  </head>
  <body>

      <header class="w3-container w3-pink">
        <h1 class="w3-center">Suzanne &amp; Léa</h1>
      </header>
      
      <div class="w3-main" >
          <div class="w3-container w3-teal">
            <button class="w3-button w3-teal w3-xlarge w3-hide-large" onclick="w3_open()">&#9776;</button>
            <h1>Carnet d'adresse</h1>
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
                  D?onnexion
                </h4>
              </li>
            </ul>
          </div>

          <section>
            <div class="w3-container">
              <button id="btnaddcontact" class="w3-button w3-large w3-amber">Nouveau Contact <i class="fa fa-plus" aria-hidden="true"></i></button>
            </div> 

            <h3>Liste des aidants partenaires</h3> 

            <div class="w3-container">
              <ul class="liste w3-ul">
                <li>
                    <h4>Médecins</h4>
                    <c:forEach items="${medecins}" var="medecin">
                      <ul class="w3-ul liste2">
                        <li>${medecin.get(2)} ${medecin.get(3)}</li>
                        <li>Adresse : ${medecin.get(4)}</li>
                        <li>Téléhone : ${medecin.get(5)}</li>
                        <li>Email : ${medecin.get(6)}</li>
                      </ul>
                    </c:forEach>
                </li>
                <li>
                    <h4>Infirmiers</h4>
                    <c:forEach items="${infirmiers}" var="infirmier">
                      <ul class="w3-ul liste2">
                        <li>${infirmier.get(2)} ${infirmier.get(3)}</li>
                        <li>Adresse : ${infirmier.get(4)}</li>
                        <li>Téléhone : ${infirmier.get(5)}</li>
                        <li>Email : ${infirmier.get(6)}</li>
                      </ul>
                    </c:forEach>
                </li>
                <li>
                    <h4>Taxis</h4>
                    <c:forEach items="${taxis}" var="taxi">
                      <ul class="w3-ul liste2">
                       <li>${taxi.get(2)} ${taxi.get(3)}</li>
                       <li>Adresse : ${taxi.get(4)}</li>
                        <li>Téléhone : ${taxi.get(5)}</li>
                       <li>Email : ${taxi.get(6)}</li>
                      </ul>
                    </c:forEach>
                </li>
                <li>
                    <h4>Plombiers</h4>
                    <c:forEach items="${plombiers}" var="plombier">
                      <ul class="w3-ul liste2">
                        <li>${plombier.get(2)} ${plombier.get(3)}</li>
                        <li>Adresse : ${plombier.get(4)}</li>
                        <li>Téléhone : ${plombier.get(5)}</li>
                        <li>Email : ${plombier.get(6)}</li>
                      </ul>
                    </c:forEach>
                </li>
                <li>
                    <h4>Electriciens</h4>
                    <c:forEach items="${electriciens}" var="electricien">
                      <ul class="w3-ul liste2">
                        <li>${electricien.get(2)} ${electricien.get(3)}</li>
                        <li>Adresse : ${electricien.get(4)}</li>
                        <li>Téléhone : ${electricien.get(5)}</li>
                        <li>Email : ${electricien.get(6)}</li>
                      </ul>
                    </c:forEach>
                </li>
                <li>
                    <h4>Serruriers</h4>
                    <c:forEach items="${serruriers}" var="serrurier">
                      <ul class="w3-ul liste2">
                        <li>${serrurier.get(2)} ${serrurier.get(3)}</li>
                        <li>Adresse : ${serrurier.get(4)}</li>
                        <li>Téléhone : ${serrurier.get(5)}</li>
                        <li>Email : ${serrurier.get(6)}</li>
                      </ul>
                    </c:forEach>
                </li>
              </ul>
            </div> 
          </section>
      </div>
  </body>
</html>
