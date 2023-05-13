package student.web.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.Collections;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import student.data.KhachRepository;
import student.data.NhanVienRepository;
import student.Khach;
import student.NhanVien;

@RestController
@RequestMapping(path = "/khach", produces = "application/json")
@CrossOrigin(origins = "*")
public class KhachController {
	private KhachRepository myDataRepo;

	public KhachController(KhachRepository myDataRepo) {
		this.myDataRepo = myDataRepo;
	}

	@GetMapping
	public Iterable<Khach> getAllStudent() {
		return myDataRepo.findAll();
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Khach postStudent(@RequestBody Khach mystudent) {
		return myDataRepo.save(mystudent);
	}
}
//	@PutMapping("/{id}") 
//	public Map<String, String> putStudent(@PathVariable long id, @RequestBody Student myStudent) { W
//		myStudentRepo.save(myStudent); 
//		return Collections.singletonMap("message", "Edit " + id + " succsess");
//	} 
//	@DeleteMapping("/{id}")
//	public Map<String, String> deleteStudent(@PathVariable long id) {
//		Student myStudent = myStudentRepo.findById(id).get();
//		myStudentRepo.delete(myStudent); 
//		return Collections.singletonMap("message", "Delete " + id + " succsess");
//	}