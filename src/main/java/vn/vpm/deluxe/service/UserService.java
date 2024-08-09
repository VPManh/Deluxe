package vn.vpm.deluxe.service;

import org.springframework.stereotype.Service;
import vn.vpm.deluxe.domain.Role;
import vn.vpm.deluxe.domain.User;
import vn.vpm.deluxe.repository.RoleRepository;
import vn.vpm.deluxe.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Role createByNameGetRole(String name) {
        return this.roleRepository.findByName(name);
    }

    public User handleSave(User user) {
        return this.userRepository.save(user);
    }
}
