package student.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import student.DanhGia;
public interface DanhGiaRepository extends CrudRepository<DanhGia, Long> {
   List<DanhGia> findBySanPhamId(long sanPhamId);
}