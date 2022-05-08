package st.evora.engenharia.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.lowagie.text.DocumentException;

import st.evora.engenharia.ClientePDFExporter;
import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.repository.ClienteRepository;
import st.evora.engenharia.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteservice;

	@Autowired
	ClienteRepository clienteRepository;

	@RequestMapping("/getAll")
	@GetMapping()
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Cliente> listClientes = clienteservice.listAll(keyword);
		model.addAttribute("listClientes", listClientes);
		model.addAttribute("keyword", keyword);

		return findPaginated(1, "nome", "asc", model);

	}

	/* BEGIN PAGINATION GENERATED */

	@GetMapping("/getAll/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 4;

		Page<Cliente> page = clienteservice.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Cliente> listClientes = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listClientes", listClientes);
		return "clientes";
	}
	/* END PAGINATION GENERATED */

	/* BEGIN endPoints pegarClientePorID */
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Cliente> getOne(Model model, Integer Id) {
		// model.addAttribute("Cliente", cliente);
		return clienteservice.getOne(Id);
	}

	/* BEGIN endPoints pegarClientePorID */

	/* BEGIN endPoints adicionarNovoCliente */
	@PostMapping("/addNew")
	public String addNew(Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		clienteservice.addNew(cliente);

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/clientes/getAll";
		}
		attributes.addFlashAttribute("mensagem", "Cliente Adicionado com sucesso!");
		return "redirect:/clientes/getAll";
	}

	/* END endPoints adicionarNovoCliente */

	/* BEGIN endPoints updateCliente */

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Cliente cliente) {
		clienteservice.update(cliente);
		return "redirect:/clientes/getAll";
	}

	/* BEGIN endPoints updateCliente */

	/* BEGIN endPoints deleteCliente */

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer Id) {
		clienteservice.delete(Id);
		return "redirect:/clientes/getAll";
	}

	/* BEGIN endPoints deleteCliente */

	/* BEGIN PDF GENERATED */

	@GetMapping("/clientes/export/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=clientes_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Cliente> listClientes = clienteservice.listPdfCliente();

		ClientePDFExporter exporter = new ClientePDFExporter(listClientes);
		exporter.export(response);

	}

	/* END PDF GENERATED */
}
