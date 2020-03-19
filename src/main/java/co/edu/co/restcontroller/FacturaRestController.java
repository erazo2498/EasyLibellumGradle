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

import co.edu.co.domain.Factura;
import co.edu.co.services.IFacturaService;

@RestController
@RequestMapping("/apiFactura")
@CrossOrigin("http://localhost:4200")
public class FacturaRestController {

	@Autowired
	private IFacturaService facturaService;
	
	@GetMapping("/listar")
	public List<Factura> listAll(){
		return facturaService.listAll();		
	}

	@GetMapping("/factura/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura findById(@PathVariable long id) {
		return facturaService.findById(id);
	}

	@PostMapping("/insertar")
	public void insert(@RequestBody Factura factura) {
		facturaService.save(factura);
	}

	@DeleteMapping("eliminar/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable long id) {
		facturaService.deleteById(id);
	}

	public FacturaRestController() { super(); }
}
