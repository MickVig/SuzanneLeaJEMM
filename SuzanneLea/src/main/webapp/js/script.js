function w3_open() {
	document.getElementById("mySidebar").style.display = "block";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
}


/******** Init programme **********/
function initbtn(){
	console.log( "ready!" );

	/*** BOUTON PAGE INDEX ***/
	$("#btnlogin").on('click',function(){
		console.log("login");
		$(location).attr('href',"login");
	})

	$("#btncreate").on('click',function(){
		console.log("create");
		$(location).attr('href',"inscription");
	})

	/*** BOUTON PAGE LOGIN & INSCRIPTION ***/
	$("#btnaccueil").on('click',function(){
		console.log("index");
		$(location).attr('href',"index");
	})


	/*** BOUTON MENU ***/
	$("#btndashboard").on('click',function(){
		console.log("formulaire ajout aidant");
		$(location).attr('href',"dashboard");
	})

	$("#btncarnet").on('click',function(){
		console.log("formulaire ajout aidant");
		$(location).attr('href',"carnet");
	})

	$("#btncarnetpart").on('click',function(){
		console.log("formulaire ajout aidant");
		$(location).attr('href',"carnetPart");
	})

	$("#btncr").on('click',function(){
		console.log("formulaire ajout aidant");
		$(location).attr('href',"compterendu");
	})

	$("#btnagenda").on('click',function(){
		console.log("formulaire ajout aidant");
		$(location).attr('href',"agenda");
	})

	$("#btnlogout").on('click',function(){
		console.log("formulaire ajout aidant");
		$(location).attr('href',"deconnexion");
	})
	


	/*** BOUTON PAGE CARNET PROCHES ***/
	$("#btnaddcontact").on('click',function(){
		console.log("formulaire ajout aidant");
		$(location).attr('href',"createAidant");
	})
	/*** BOUTON PAGE AGENDA ***/
	$("#btnaddevent").on('click',function(){
		console.log("formulaire ajout evenement");
		$(location).attr('href',"addEven");
	})
	/*** BOUTON PAGE COMPTES RENDUS ***/
	$("#btnaddcr").on('click',function(){
		console.log("formulaire ajout CR");
		$(location).attr('href',"addCR");
	})
	
	
}


/******** Programme ************/
$(document).ready(function() {
    initbtn();

    
});