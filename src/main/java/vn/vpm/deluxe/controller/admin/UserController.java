package vn.vpm.deluxe.controller.admin;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import vn.vpm.deluxe.config.SecurityConfig;
import vn.vpm.deluxe.domain.User;
import vn.vpm.deluxe.repository.UserRepository;
import vn.vpm.deluxe.service.UploadService;
import vn.vpm.deluxe.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UploadService uploadService;


    public UserController(UserService userService, PasswordEncoder passwordEncoder,
                          UploadService uploadService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String createUser(@ModelAttribute("newUser") User user,
                             BindingResult newUserBindingResult,
                             @RequestParam("hoidanitFile") MultipartFile file) {

        if (newUserBindingResult.hasErrors()) {
            return "admin/user/create";
        }
        String avatar = this.uploadService.handleSaveUploadFile(file,"avatar");
        user.setAvatar(avatar);

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRole(this.userService.createByNameGetRole(user.getRole().getName()));
        this.userService.handleSave(user);
        return "redirect:/";
    }

//    @PostMapping("/admin/user/create")
//    public String updateUser(@ModelAttribute("newUser") User user,
//                             BindingResult newUserBindingResult,
//                             @RequestParam("hoidanitFile") MultipartFile file) {
//
//        if (newUserBindingResult.hasErrors()) {
//            return "admin/user/create";
//        }
//
//        User currentUser = new User();
//
//        if (currentUser != null) {
//            String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
//
////            String hasPassword = passwordEncoder.encode(user.getPassword());
//
//            currentUser.setEmail(user.getEmail());
//            currentUser.setPassword(passwordEncoder.encode(user.getPassword()));
//            currentUser.setAddress(user.getAddress());
//            currentUser.setPhone(user.getPhone());
//            currentUser.setFullName(user.getFullName());
//            currentUser.setAvatar(avatar);
//            currentUser.getRole().setName(user.getRole().getName());
//
////            this.userService.handleSave(currentUser);
//        }
//        return "redirect:/";
//    }
}
