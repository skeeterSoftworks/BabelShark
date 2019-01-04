$(document).ready(getWisdom);


function getWisdom() {

	 $.ajax({
	        url: "/wisdom"
	    }).then(function(data) {
	       $('.wisdom').html(data);
	    });
	};