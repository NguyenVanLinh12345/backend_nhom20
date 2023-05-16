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

import student.data.EmailDangKiRepository;
import student.EmailDangKi;

@RestController
@RequestMapping(path = "/emaildangki", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmailDangKiController {
	private EmailDangKiRepository myEmailDangKiRepo;

	public EmailDangKiController(EmailDangKiRepository myStudentRepo) {
		this.myEmailDangKiRepo = myStudentRepo;
	}

	@GetMapping
	public Iterable<EmailDangKi> getAllStudent() {
		return myEmailDangKiRepo.findAll();
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public EmailDangKi postStudent(@RequestBody EmailDangKi mystudent) {
		return myEmailDangKiRepo.save(mystudent);
	}
}