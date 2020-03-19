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

import co.edu.co.domain.Empleado;
import co.edu.co.services.IEmpleadoService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@RestController
@RequestMapping("/apiempleado")
@CrossOrigin("http://localhost:4200")
public class EmpleadoRestController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("/listar")
	public List<Empleado> listAll(){
		return empleadoService.listAll();		
	}
	@GetMapping("/empleado/{id}")
	public Empleado findById(@PathVariable String id) {
		return empleadoService.findById(id);
	}
	@PostMapping("/insertar")
	@ResponseStatus(HttpStatus.CREATED)
	public void insert(@RequestBody Empleado persona) {
		empleadoService.save(persona);
	}
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable String id) {
		empleadoService.deleteById(id);	
	}

}
