function w3_open() {
	document.getElementById("mySidebar").style.display = "block";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
}


/******** Init programme **********/
function initbtn(){
	console.log( "ready!" );

	$("#btnlogin").on('click',function(){
		console.log("login");
		$(location).attr('href',"login");
	})

	$("#btncreate").on('click',function(){
		console.log("create");
		$(location).attr('href',"inscription");
	})

	$("#btnaccueil").on('click',function(){
		console.log("index");
		$(location).attr('href',"index");
	})
	
	$("#btnaddcontact").on('click',function(){
		console.log("formulaire ajout aidant");
		$(location).attr('href',"createAidant");
	})
	
	$("#btnaddevent").on('click',function(){
		console.log("formulaire ajout evenement");
		$(location).attr('href',"addEven");
	})
	
	$("#btnaddcr").on('click',function(){
		console.log("formulaire ajout CR");
		$(location).attr('href',"addCR");
	})
	
	
	
	
}





/******** Programme ************/
$(document).ready(function() {
    initbtn();

    
});