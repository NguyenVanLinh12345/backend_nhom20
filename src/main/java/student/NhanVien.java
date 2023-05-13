package student;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class NhanVien implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String tenNhanVien;

	private Date ngaySinh;

	private String chucVu;

	private String email;

	private String matkhau;

	private String soCCCD;

	private String queQuan;

	private boolean activate;
	
	@PrePersist
	  void createdAt() {
	    this.activate = true;
	  }
}
