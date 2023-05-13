package student.web.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import student.data.NhanVienRepository;
import student.NhanVien;

class LoginDTO {
    private String username;
    private String password;
    
    public String getName() {
    	return username;
    }
    public String getPass() {
    	return password;
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class NhanVienDto{
	private Long id;

	private String tenNhanVien;

	private Date ngaySinh;

	private String chucVu;

	private String email;

	private String soCCCD;

	private String queQuan;
}
@RestController
@RequestMapping(path = "/nhanvien", produces = "application/json")
@CrossOrigin(origins = "*")
public class NhanVienController {
	private NhanVienRepository myDataRepo;

	public NhanVienController(NhanVienRepository myDataRepo) {
		this.myDataRepo = myDataRepo;
	}

	@GetMapping
	public Iterable<NhanVienDto> getAllStudent() {
		List<NhanVienDto> list = new ArrayList<NhanVienDto>();
		List<NhanVien> list1 = (List<NhanVien>)myDataRepo.findAll();
		
		for(NhanVien x: list1) {
			NhanVienDto x1 = new NhanVienDto();
			x1.setId(x.getId());
			x1.setNgaySinh(x.getNgaySinh());
			x1.setTenNhanVien(x.getTenNhanVien());
			x1.setChucVu(x.getChucVu());
			x1.setEmail(x.getEmail());
			x1.setSoCCCD(x.getSoCCCD());
			x1.setQueQuan(x.getQueQuan());
			System.out.println(x1.getEmail());
			list.add(x1);
		}
		return list;
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public NhanVien postStudent(@RequestBody NhanVien mystudent) {
		return myDataRepo.save(mystudent);
	}
	
	@PostMapping("/login")
	public Map<String, String> nhanvienlogin(@RequestBody LoginDTO nhanvien) {
	
		
		return Collections.singletonMap("message", "Edit succsess");
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