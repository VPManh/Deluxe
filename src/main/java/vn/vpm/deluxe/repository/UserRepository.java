package vn.vpm.deluxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.vpm.deluxe.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User deleteById(long id);
    User findByEmail(String email);
}
