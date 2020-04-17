$(document).ready(function() {
	
	// DO GET
	$.ajax({
		type : "GET",
		url : "/ServiceBrico",
		success: function(result){
			$.each(result, function(i, ServicesBrico){
				
				var ServicesBricoRow = '<tr>' +
									'<td>' + ServicesBrico.nomService + '</td>' +
									'<td>' + ServicesBrico.description + '</td>' +
									'<td>' + ServicesBrico.prix + '</td>' +
									'<td>' + ServicesBrico.date_publication + '</td>' +
									'<td>' + ServicesBrico.date_publication_Heure + '</td>' +
								  '</tr>';
				
				$('#serviceTable tbody').append(ServicesBricoRow);
				
	        });
			
			$( "#serviceTable tbody tr:odd" ).addClass("info");
			$( "#serviceTable tbody tr:even" ).addClass("success");
		},
		error : function(e) {
			alert("ERROR: ", e);
			console.log("ERROR: ", e);
		}
	});
	
	// do Filter on View
	$("#inputFilter").on("keyup", function() {
	    var inputValue = $(this).val().toLowerCase();
	    $("#serviceTable tr").filter(function() {
	    	$(this).toggle($(this).text().toLowerCase().indexOf(inputValue) > -1)
	    });
	});
})