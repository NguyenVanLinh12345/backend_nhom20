package student.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import student.SanPham;
public interface SanPhamRepository extends CrudRepository<SanPham, Long> {
	List<SanPham> findByTenSanPham(String tenSanPham);
	List<SanPham> findByTenSanPhamContaining(String tenSanPham);
}
