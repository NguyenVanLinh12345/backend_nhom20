package student.web.api;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.Collections;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import student.data.TinTucRepository;
import student.BinhLuan;
import student.NhanVien;
import student.TinTuc;

class MyTinTuc {
	private String tenTinTuc;
	private String noiDung;
	private String anhDaiDien;
}

@RestController
@RequestMapping(path = "/tintuc", produces = "application/json")
@CrossOrigin(origins = "*")
public class TintucController {
	private TinTucRepository tinTucRepository;

	public TintucController(TinTucRepository myTintucRepo) {
		this.tinTucRepository = myTintucRepo;
	}

	@GetMapping
	public Iterable<TinTuc> getAllTinTucWithBinhLuan() {
    List<TinTuc> tinTucList = (List)tinTucRepository.findAll();
    return tinTucList;
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public TinTuc postStudent(@RequestBody TinTuc mystudent) {
		return tinTucRepository.save(mystudent);
	}

}
