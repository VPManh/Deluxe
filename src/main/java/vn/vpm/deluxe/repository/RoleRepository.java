package vn.vpm.deluxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vpm.deluxe.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
