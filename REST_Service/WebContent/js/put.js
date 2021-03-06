/**
 * js file for post.html
 * Please use modern web browser as this file will not attempt to be
 * compatible with older browsers. Use Chrome and open javascript console
 * or Firefox with developer console.
 * 
 * jquery is required
 */
$(document).ready(function() {
	
	var $put_example = $('#put_example')
		, $set_firstname = $('#set_firstname')
		, $set_lastname= $('#set_lastname');

	getInventory();
	
	
	$(document.body).on('click', ':button, .UPDATE_BTN', function(e) {
		//console.log(this);
		var $this = $(this)
			, data = $this.val()
			, $tr = $this.closest('tr')
			, firstname = $tr.find('.CL_firstname').text()
			, lastname = $tr.find('.CL_lastname').text(); 
		
		console.log(firstname);
		console.log(data);
		//$set_firstname.text();
		$set_lastname.text(lastname);
		
		$('#update_response').text("");
	});
	
	$put_example.submit(function(e) {
		e.preventDefault(); //cancel form submit
		
		var obj = $put_example.serializeObject()
			, firstname = $set_firstname.val()
			, lastname = $set_lastname.text();
			console.log(lastname);
		updateInventory(obj, firstname, lastname);
	});
});

function updateInventory(obj, firstname, lastname) {
	console.log(obj);
	ajaxObj = {  
			type: "PUT",
			url: "http://localhost:8080/REST_Service/api/V3/inventory/" + firstname + "/" + lastname,
			data: JSON.stringify(obj), 
			contentType:"application/json",
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR.responseText);
			},
			success: function(data) {
				console.log(data);
				$('#update_response').text( data[0].MSG );
			},
			complete: function(XMLHttpRequest) {
				//console.log( XMLHttpRequest.getAllResponseHeaders() );
				getInventory();
			}, 
			dataType: "json" //request JSON
		};
		
	return $.ajax(ajaxObj);
}

function getInventory() {
	
	var d = new Date()
		, n = d.getTime();
	
	ajaxObj = {  
			type: "GET",
			url: "http://localhost:8080/REST_Service/api/V1/inventory/", 
			data: "ts="+n, 
			contentType:"application/json",
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR.responseText);
			},
			success: function(data) { 
				//console.log(data);
				var html_string = "";
				
				$.each(data, function(index1, val1) {
					//console.log(val1);
					html_string = html_string + templateGetInventory(val1);
				});
				
				$('#get_inventory').html("<table border='1'>" + html_string + "</table>");
			},
			complete: function(XMLHttpRequest) {
				//console.log( XMLHttpRequest.getAllResponseHeaders() );
			}, 
			dataType: "json" //request JSON
		};
		
	return $.ajax(ajaxObj);
}

function templateGetInventory(param) {
	return '<tr>' +
				'<td class="CL_firstname">' + param.firstname + '</td>' +
				'<td class="CL_lastname">' + param.lastname + '</td>' +
				'<td class="CL_set_data"> <button class="UPDATE_BTN" value=" ' + param.lastname + ' " type="button">Update</button> </td>' +
			'</tr>';
}

