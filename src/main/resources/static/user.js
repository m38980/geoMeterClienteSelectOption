/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){
		
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(user, status){
			$('#IdEdit').val(user.id);
			$('#usernameEdit').val(user.username);
			$('#passwordEdit').val(user.password);
			$('#emailEdit').val(user.email);
			$('#enabledEdit').val(user.enabled);
			
		});	
		
		$('#editModal').modal();
		
	});
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
		
	});
	
});