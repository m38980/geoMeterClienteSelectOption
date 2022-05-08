/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){
		
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(cliente, status){
			$('#idclienteEdit').val(cliente.idcliente);
			$('#nomeEdit').val(cliente.nome);
			$('#emailEdit').val(cliente.email);
			$('#telefoneEdit').val(cliente.telefone);
			$('#enderecoEdit').val(cliente.endereco);
			$('#nipEdit').val(cliente.nip);
			$('#energiaEdit').val(cliente.energia);
			$('#descricaoEdit').val(cliente.descricao);
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