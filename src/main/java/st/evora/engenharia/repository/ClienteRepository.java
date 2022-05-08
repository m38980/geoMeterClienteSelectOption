package st.evora.engenharia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import st.evora.engenharia.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query("SELECT c FROM Cliente c WHERE CONCAT" + "(c.nome, " + "c.email, " + "c.telefone, " + "c.endereco, "
			+ "c.nip," + "c.descricao) LIKE %?1%")

	public List<Cliente> search(String keyword);
	
	public Cliente findByNome(String nome);
}