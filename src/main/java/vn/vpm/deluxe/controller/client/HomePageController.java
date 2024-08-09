package vn.vpm.deluxe.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.vpm.deluxe.service.RoomService;

@Controller
public class HomePageController {
    private final RoomService roomService;

    public HomePageController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("rooms",this.roomService.getFindA6New());
        return "client/room/show";
    }
}
