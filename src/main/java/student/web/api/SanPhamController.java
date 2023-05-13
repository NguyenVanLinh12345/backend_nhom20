package student.web.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import antlr.StringUtils;
import student.SanPham;
import student.data.SanPhamRepository;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/sanpham", produces = "application/json")
@CrossOrigin(origins = "*")
public class SanPhamController {
	private SanPhamRepository myDataRepo;

	public SanPhamController(SanPhamRepository myDataRepo) {
		this.myDataRepo = myDataRepo;
	}

	@GetMapping
	public Iterable<SanPham> getAllStudent() {
		return myDataRepo.findAll();
	}
	
	@GetMapping("/search")
    public Iterable<SanPham> searchSanPham(@RequestParam("ten") String ten) {
        return myDataRepo.findByTenSanPhamContaining(ten);
    }

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public SanPham postStudent(@RequestBody SanPham mystudent) {
		return myDataRepo.save(mystudent);
	}
	
	@PutMapping("/{id}") 
	public Map<String, String> putStudent(@PathVariable long id, @RequestBody String tenMoi) { 
		SanPham sp = myDataRepo.findById(id).get();
		sp.setTenSanPham(tenMoi);
		myDataRepo.save(sp); 
		return Collections.singletonMap("message", "Edit " + id + " succsess");
	} 
}
//	@DeleteMapping("/{id}")
//	public Map<String, String> deleteStudent(@PathVariable long id) {
//		Student myStudent = myStudentRepo.findById(id).get();
//		myStudentRepo.delete(myStudent); 
//		return Collections.singletonMap("message", "Delete " + id + " succsess");
//	}