package st.evora.engenharia;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import st.evora.engenharia.controller.UserController;
import st.evora.engenharia.model.Role;
import st.evora.engenharia.model.User;
import st.evora.engenharia.repository.RoleRepository;
import st.evora.engenharia.repository.UserRepository;
import st.evora.engenharia.service.UserService;
@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserService userService;
	@MockBean
	private RoleRepository roleRepository;
	@MockBean
	private UserRepository userRepository;
	@Test
	public void testExportPdf() throws Exception {
		List<User>listUsers = new ArrayList<>();
		Set<Role> roles = new HashSet<>();
		roles.add(new Role("Admin"));
		listUsers.add(new User((long) 4, "admin@gmail.com", "admin", "$2a$10$K9vzsL69JkyGc.XIEp2EP.vrBGZliPyR3socAyryHuJwLS31rbmR2", 
										  true, roles));
		listUsers.add(new User((long) 5, "filipe@gmail.com", "filipe", "$2a$10$wfNyMcS.iw0sMnxrFo4gyuQq1.y5D/IvDk/Fo6iOrXtne7HIb9tea",
									      true, roles));
		listUsers.add(new User((long) 6, "alzira@hotmail.com","alzira", "$2a$10$pyOJ47vUzPsunvcbmt5BiuTUmG3b3PtPJF7ZGw6.Lx11P/efD3Dxa",
										  true, roles));
		listUsers.add(new User((long) 7, "lisy@hotmail.com","lisy", "$2a$10$AFMKc9Rp1ykGwryH5Fk2Mu1dwjbesUE3Gr2nddxI9hf.09IQbgq36",
										  true, roles));
		listUsers.add(new User((long) 8, "lavinea@hotmail.com","lavinea", "$2a$10$eZb1LxUVmSaSojY0.OfJn..Y/QCAYaU482YiWkSS3sYE00zCOBb56",
									      true, roles));
		Mockito.when(userService.listPdfUser()).thenReturn(listUsers);
		String url = "/users/users/export/pdf";	
		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		byte[] bytes =  mvcResult.getResponse().getContentAsByteArray();
		Path path = Paths.get("users.pdf");
		Files.write(path, bytes);
	}
}
