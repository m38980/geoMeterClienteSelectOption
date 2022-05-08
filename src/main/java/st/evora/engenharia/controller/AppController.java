package st.evora.engenharia.controller;

import java.util.Map;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import st.evora.engenharia.model.User;
import st.evora.engenharia.repository.UserRepository;
import st.evora.engenharia.service.ClienteService;
import st.evora.engenharia.service.ContadorService;
import st.evora.engenharia.service.UserService;

@SuppressWarnings("unused")
@Controller
@RequestMapping
public class AppController {

	@SuppressWarnings("unused")
	@Autowired
	private ClienteService clienteService;
	@SuppressWarnings("unused")
	private ContadorService contadorService;
	private UserService userService;

	private final ErrorAttributes errorAttributes = null;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;

	}

	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user) {

		@SuppressWarnings("unused")
		User loginUser = userService.login(user.getUsername(), user.getPassword());

		System.out.print(user);
		if (Objects.nonNull(user)) {

			return "redirect:/clientes";

		} else {
			return "redirect:/login";

		}

	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/login";
	}

	@RequestMapping("/")
	public String paginaPrincipal() {
		return "home";

	}
	
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		String errorPage = "error"; // default

		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				// handle HTTP 404 Not Found error
				errorPage = "error/404";

			} else if (statusCode == HttpStatus.FORBIDDEN.value()) {
				// handle HTTP 403 Forbidden error
				errorPage = "error/403";

			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				// handle HTTP 500 Internal Server error
				errorPage = "error/500";

			}
		}

		return errorPage;
	}

	public String getErrorPath() {
		return "/error";
	}

}
