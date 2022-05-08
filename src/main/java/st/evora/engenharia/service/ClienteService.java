package st.evora.engenharia.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
    private ClienteRepository clienteRepository ;

	/* BEGIN listarTODOS Student método (listAll) */ 
	public List<Cliente> listAll(String keyword) {
		if (keyword != null) {
			return clienteRepository.search(keyword);
		}
		return (List<Cliente>) clienteRepository.findAll();
	}
	/* END listarTODOS Student */ 
	
	/* BEGIN paginação */
	
	public Page<Cliente> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection){
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return clienteRepository.findAll(pageable);
	}
	
	/* END paginação */ 
	
	/* BEGIN selecionar Por ID */ 
	
	public Optional<Cliente> getOne(Integer Id) {
		return clienteRepository.findById(Id);
	}
	/* BEGIN selecionar Por ID */ 
	
	/* BEGIN adiconar Cliente */ 
	public void addNew(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	/* END adiconar Cliente */ 
	
	/* BEGIN ACTUALIZAR Cliente */ 
	public void update(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	/* END ACTUALIZAR Cliente */ 
	
	/* BEGIN DELETE Cliente */ 
	public void delete(Integer Id) {
		clienteRepository.deleteById(Id);
	}
	/* END DELETE Cliente */ 
	
	/* BEGIN gerarPDF Cliente */ 
	public List<Cliente> listPdfCliente() {
        return (List<Cliente>) clienteRepository.findAll();
    }
	/* END gerarPDF Cliente */ 
}