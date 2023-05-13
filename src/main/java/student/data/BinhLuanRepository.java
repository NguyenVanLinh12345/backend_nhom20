package student.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import student.BinhLuan;
public interface BinhLuanRepository extends CrudRepository<BinhLuan, Long> {
    List<BinhLuan> findByTinTucId(long tinTucId);
}
