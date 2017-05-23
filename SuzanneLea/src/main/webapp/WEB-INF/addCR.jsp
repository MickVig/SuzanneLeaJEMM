<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <body class="w3-dark-grey">

      <header class="w3-container">
        <h1 class="w3-center">Suzanne &amp; Léa</h1>
      </header>
      
      <main class="w3-main">
          <div class="w3-container ">
              <h2>Ajout d'un compte rendu</h2>
          </div>
          <div class="w3-container w3-white w3-col s10">
            <form id="formaidant" class="w3-container " method="post" action="">

              <label for="contenu" class="w3-text-teal"><b>Contenu</b></label>
              <textarea id="contenu" name="contenu" class="w3-input w3-border" placeholder="Vous pouvez faire votre compte rendu"></textarea>

              <button class="w3-btn w3-blue-grey">Enregistrer</button>
            </form>
          </div>
      </main>


  </body>
</html>
