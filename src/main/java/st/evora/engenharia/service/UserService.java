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
import st.evora.engenharia.model.User;
import st.evora.engenharia.repository.UserRepository;

@Service
@Transactional
public class UserService {

	// public static final int USER_PER_PAGE = 3;

	@Autowired
	private UserRepository userRepository;

	public User login(String username, String password) {

		User user = userRepository.findByUsernameAndPassword(username, password);
		return user;
	}

	public List<User> listAll(String keyword) {

		if (keyword != null) {
			return userRepository.search(keyword);
		}
		return (List<User>) userRepository.findAll();
	}
	
	public void addNew(User user) {
		userRepository.save(user);
	}
	
	public Optional<User> getOne(Long Id) {
		return userRepository.findById(Id);
	}
	/*public void save(User user) {
		userRepository.save(user);
	}
	*/
	public void update(User user) {
		userRepository.save(user);
	}
	
	public User get(Long id) {
		return userRepository.findById(id).get();
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
/* BEGIN paginação */
	
	public Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection){
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return userRepository.findAll(pageable);
	}
	
	/* END paginação */ 
	
	public List<User> listPdfUser() {
        return (List<User>) userRepository.findAll();
    }
	
	public List<User> listAll() {
        return userRepository.findAll(Sort.by("email").ascending());
    }
}
