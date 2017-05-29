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

      <div class="w3-main">
          <div class="w3-container w3-teal">
            <button class="w3-button w3-teal w3-xlarge w3-hide-large" onclick="w3_open()">&#9776;</button>
            <h1>Agenda</h1>
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
                  Déconnexion
                </h4>
              </li>
            </ul>
          </div>
          <section>
            <div class="w3-container">
              <button id="btnaddevent"class="w3-button w3-large w3-amber">Ajouter un événement <i class="fa fa-plus" aria-hidden="true"></i></button>
            </div> 

            <h2>Liste des évènements</h2>

            <div class="w3-container">
              <ul class="liste w3-ul">
                <li>
                  <c:forEach items="${allRDV}" var="rdv">
                    <ul class="w3-ul">
                      <li>Titre : ${rdv.get(0).titre} </li>
                      <li>Date : ${rdv.get(0).date} </li>
                      <c:if test = "${rdv.size()>1}">
                            <li>Aidant : ${rdv.get(1).getNom()} ${rdv.get(1).getPrenom()}</li>
                          </c:if>
                      <li>Contenu : ${rdv.get(0).contenu}</li>
                    </ul>
                  </c:forEach>
                </li> 
                <li>
                  <c:forEach items="${allRDV}" var="rdv">
                    <ul class="w3-ul">
                      <li>Titre : ${rdv.get(0).titre} </li>
                      <li>Date : ${rdv.get(0).date} </li>
                      <c:if test = "${rdv.size()>1}">
                            <li>Aidant : ${rdv.get(1).getNom()} ${rdv.get(1).getPrenom()}</li>
                          </c:if>
                      <li>Contenu : ${rdv.get(0).contenu}</li>
                    </ul>
                  </c:forEach>
                </li>
              </ul>
            </div>
          </section>
      </div>


  </body>
</html>
