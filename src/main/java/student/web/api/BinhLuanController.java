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

import student.data.BinhLuanRepository;
import student.BinhLuan;

@RestController
@RequestMapping(path = "/binhluan", produces = "application/json")
@CrossOrigin(origins = "*")
public class BinhLuanController {
	private BinhLuanRepository myStudentRepo;

	public BinhLuanController(BinhLuanRepository myStudentRepo) {
		this.myStudentRepo = myStudentRepo;
	}

	@GetMapping
	public Iterable<BinhLuan> getAllStudent() {
		return myStudentRepo.findAll();
	}
	
	@GetMapping("tintuc/{id}")
	public Iterable<BinhLuan> getTinTucBinhLuan(@PathVariable long id) {
		return myStudentRepo.findByTinTucId(id);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public BinhLuan postStudent(@RequestBody BinhLuan mystudent) {
		return myStudentRepo.save(mystudent);
	}
}
//	@PutMapping("/{id}") 
//	public Map<String, String> putStudent(@PathVariable long id, @RequestBody Student myStudent) { 
////		Student myStudent = myStudentRepo.findById(id).get();
//		myStudentRepo.save(myStudent); 
//		return Collections.singletonMap("message", "Edit " + id + " succsess");
//	} 
//	@DeleteMapping("/{id}")
//	public Map<String, String> deleteStudent(@PathVariable long id) {
//		Student myStudent = myStudentRepo.findById(id).get();
//		myStudentRepo.delete(myStudent); 
//		return Collections.singletonMap("message", "Delete " + id + " succsess");
//	}