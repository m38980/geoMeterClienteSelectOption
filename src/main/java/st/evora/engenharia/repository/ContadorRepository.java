package st.evora.engenharia.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import st.evora.engenharia.model.Contador;

public interface ContadorRepository extends JpaRepository<Contador, Long> {
	
	
	@Query("SELECT c FROM Contador c WHERE CONCAT"
			+ "(c.conta_numero, "
			+ "c.numero_contador, "
			+ "c.leitura_anterior, "
			+ "c.nova_leitura,"
			+ "c.ramal,"
			+ "c.descricao) LIKE %?1%")

	public List<Contador> search(String keyword);

}
