function w3_open() {
	document.getElementById("mySidebar").style.display = "block";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
}


/******** Init programme **********/
function init(){
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
	
}





/******** Programme ************/
$(document).ready(function() {
    init();

    
});