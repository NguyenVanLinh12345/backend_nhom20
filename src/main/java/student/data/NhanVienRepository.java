package student.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import student.NhanVien;
public interface NhanVienRepository extends CrudRepository<NhanVien, Long> {
   List<NhanVien> findByEmail(String email);
}
