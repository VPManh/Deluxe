package vn.vpm.deluxe.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.vpm.deluxe.domain.Room;
import vn.vpm.deluxe.service.RoomService;

import java.util.Optional;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/room/{id}")
    public String getRoomDetails(Model model, @PathVariable long id) {

        Optional<Room> optional = this.roomService.getRoomById(id);
        if (optional.isPresent()) {
            Room room = optional.get();
            model.addAttribute("room", room);
            System.out.println("idpeoe: "+room.getId());
        }

        return "client/room/roomdetail";
    }
}
