package vn.vpm.deluxe.controller.admin;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.vpm.deluxe.config.SecurityConfig;
import vn.vpm.deluxe.domain.User;
import vn.vpm.deluxe.repository.UserRepository;
import vn.vpm.deluxe.service.UploadService;
import vn.vpm.deluxe.service.UserService;

import java.util.List;
import java.util.Optional;

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

//    Show

    @GetMapping("/admin/user")
    public String showUserPage(Model model) {
        List<User> user = this.userService.getAllUser();
        model.addAttribute("users",user);
        return "admin/user/show";
    }

    @GetMapping("/admin/user/{id}")
    public String showDetailUser (Model model, @PathVariable long id){

        Optional<User> user = this.userService.getUserById(id);
        model.addAttribute("id",id);
        model.addAttribute("userId",user.get());

        return "admin/user/detail";
    }

//   Start View Create User

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
        return "redirect:/admin/user";
    }

//  End View Create User

//   Start View Update User

    @GetMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        System.out.println("id"+id);
        Optional<User> currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser.get());
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User user,
                                 BindingResult updateBindingResult,
                                 @RequestParam("hoidanitFile") MultipartFile file) {

        if (updateBindingResult.hasErrors()) {
            return "admin/user/update";
        }

        String avatar = this.uploadService.handleSaveUploadFile(file,"avatar");

        Optional<User> optional = this.userService.getUserById(user.getId());
        if (optional.isPresent()) {
            User currentUser = optional.get();

            currentUser.setAddress(user.getAddress());
            currentUser.setFullName(user.getFullName());
            currentUser.setPhone(user.getPhone());
            currentUser.setAvatar(avatar);
//            luồng update role bị sai nên nó đang update bên bảng roles
            currentUser.getRole().setName(user.getRole().getName());

            this.userService.handleSave(currentUser);
        }
        return "redirect:/admin/user";
    }
//  End View Update User

//  Start View Delete User
    @GetMapping("/admin/user/delete/{id}")
    public String deleteUser(Model model, @PathVariable long id) {
        Optional<User> optional = this.userService.getUserById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            model.addAttribute("newUser", user);
        }
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User user) {
        User currentUser =  this.userService.getDeleteUserById(user.getId());
//        System.out.println("id"+currentUser.getId());
//        this.userService.handleSave(currentUser);
        return "redirect:/admin/user";
    }

}
