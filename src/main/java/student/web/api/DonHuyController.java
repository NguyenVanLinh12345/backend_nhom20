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

import student.DonHuy;
import student.Khach;
import student.NhanVien;
import student.data.DonHuyRepository;

@RestController
@RequestMapping(path = "/donhuy", produces = "application/json")
@CrossOrigin(origins = "*")
public class DonHuyController {
	private DonHuyRepository myDataRepo;

	public DonHuyController(DonHuyRepository myDataRepo) {
		this.myDataRepo = myDataRepo;
	}

	@GetMapping
	public Iterable<DonHuy> getAllStudent() {
		return myDataRepo.findAll();
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public DonHuy postStudent(@RequestBody DonHuy mystudent) {
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