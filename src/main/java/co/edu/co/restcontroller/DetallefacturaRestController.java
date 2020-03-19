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

import co.edu.co.domain.DetalleFactura;
import co.edu.co.services.IDetalleFacturaService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@RestController
@RequestMapping("/apiDetalle")
@CrossOrigin("http://localhost:4200")
public class DetallefacturaRestController {
	
	@Autowired
	private IDetalleFacturaService detalleService;
	
	@GetMapping("/listar")
	public List<DetalleFactura> listAll(){
		return detalleService.listAll();		
	}
	@GetMapping("/detalle/{id}")
	public DetalleFactura findById(@PathVariable long id) {
		return detalleService.findById(id);
	}
	@PostMapping("/insertar")
	@ResponseStatus(HttpStatus.CREATED)
	public void insert(@RequestBody DetalleFactura detalle) {
		detalleService.save(detalle);
	}
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable Long id) {
	detalleService.deleteById(id);	
	}

}
