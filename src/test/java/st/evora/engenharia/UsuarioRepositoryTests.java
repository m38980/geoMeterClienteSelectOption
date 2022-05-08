package st.evora.engenharia;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import st.evora.engenharia.model.User;
import st.evora.engenharia.repository.UserRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUsuario() {
		User user =   new User();
		
		user.setEmail("cross@hotmail.com");
		user.setUsername("cross");
		user.setPassword("cross");
		user.setEnabled(true);
		
		User savedUser =  userRepository.save(user);
		
		User  existeUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(existeUser.getEmail()).isEqualTo(user.getEmail());
	}
}
