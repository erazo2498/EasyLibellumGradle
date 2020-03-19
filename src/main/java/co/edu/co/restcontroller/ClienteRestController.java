package co.edu.co.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.co.domain.Cliente;
import co.edu.co.services.IClienteService;
import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
@RequestMapping("/apiCliente")
@CrossOrigin("http://localhost:4200")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteServicio;

	@GetMapping("/listar")
	public List<Cliente> listAll(){
		return clienteServicio.listAll();		
	}
	@GetMapping("/buscar/{id}")
	public Cliente findById(@PathVariable String id) {
		return clienteServicio.findById(id);
	}
	@PostMapping("/insertar")
	@ResponseStatus(HttpStatus.CREATED)
	public void insert(@RequestBody Cliente cliente) {
		clienteServicio.save(cliente);
	}
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable String id) {
		clienteServicio.deleteById(id);	
	}
}

