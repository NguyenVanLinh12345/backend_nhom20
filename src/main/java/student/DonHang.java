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
public class DonHang implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private long khachId;

	
	private long tinhTrangDonHang;

	
	private Date thoiGianMua;

	
	private boolean activate;

	
	private long sanPhamId;

	
	private long soLuong;

	@PrePersist
	void activateThis() {
		this.activate = true;
		this.thoiGianMua = new Date(System.currentTimeMillis());
		this.tinhTrangDonHang = 0;
	}
}
