package student;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class DanhGia implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	
	private long sanPhamId;
	
	
	private Date ngayBinhLuan;
	
	
	private String noiDung;
	
	
	private String tenNguoiBinhLuan;
	
	@PrePersist
	  void placedAt() {
	    this.ngayBinhLuan = new Date(System.currentTimeMillis());
	  }
}
