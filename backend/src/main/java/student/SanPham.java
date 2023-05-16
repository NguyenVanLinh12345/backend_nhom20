package student;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class SanPham implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String tenSanPham;

	private double gia;

	private String anhDaiDien;

	private String moTa;

	private long danhMucId;

	private Date ngayDangBan;

	private long soLuong;

	@NotNull
	private boolean activate;

	@PrePersist
	void placedAt() {
		this.ngayDangBan = new Date(System.currentTimeMillis());
		this.activate = true;
	}
}
