package vn.vpm.deluxe.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.vpm.deluxe.domain.Room;
import vn.vpm.deluxe.domain.RoomImage;
import vn.vpm.deluxe.service.RoomService;
import vn.vpm.deluxe.service.UploadService;

import java.util.List;
import java.util.Optional;

@Controller
public class RoomAdminController {

    private final RoomService roomService;
    private final UploadService uploadService;

    public RoomAdminController(RoomService roomService, UploadService uploadService) {
        this.roomService = roomService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/room")
    public String getRoom(Model model) {
        List<Room> room = this.roomService.getFindAllRoom();
        model.addAttribute("rooms", room);
        return "admin/room/show";
    }

    @GetMapping("/admin/room/{id}")
    public String getRoomDetail(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        Optional<Room> room = this.roomService.getRoomById(id);
        model.addAttribute("room", room.get());
        return "admin/room/detail";
    }

    //   Start Create Room
    @GetMapping("/admin/room/create")
    public String getCreateRoom(Model model) {
        model.addAttribute("newRoom", new Room());
        return "admin/room/create";
    }

    @PostMapping("/admin/room/create")
    public String postCreateRoom(@ModelAttribute("newRoom") Room room,
                                 Model model,
                                 BindingResult bindingResult,
                                 @RequestParam("hoidanitFiles") MultipartFile[] files) {

        if (bindingResult.hasErrors()) {
            return "admin/room/create";
        }

        // Nếu bạn vẫn muốn lưu 1 ảnh chính như trước đây:
        if (files.length > 0) {
            String mainImage = uploadService.handleSaveUploadFile(files[0], "rooms");
            room.setImage(mainImage);

        }

        // Lưu các file còn lại vào imagesDetail
        List<String> fileNames = uploadService.handleSaveUploadFiles(files, "rooms/" + room.getId());

        List<RoomImage> imagesDetail = fileNames.stream()
                .map(fileName -> new RoomImage(null, room, "/resources/admin/images/rooms/" + room.getId() + "/" + fileName))
                .toList();

        room.setImagesDetail(imagesDetail);

        // Lưu thông tin phòng vào cơ sở dữ liệu
        roomService.handleSaveRoom(room);

        return "redirect:/admin/room";
    }

//   End Create Room

    //   Start Update Room
    @GetMapping("/admin/room/update/{id}")
    public String getUpdateRoom(Model model, @PathVariable long id) {
        Optional<Room> room = this.roomService.getRoomById(id);
        model.addAttribute("newRoom", room.get());
        String soPhong = room.get().getRoomNumber();
        model.addAttribute("soPhong", soPhong);
        model.addAttribute("id", id);
        return "admin/room/update";
    }

    @PostMapping("/admin/room/update")
    public String postUpdateRoom(@ModelAttribute("newRoom") Room room,Model model,
                                 BindingResult bindingResult,
                                 @RequestParam("hoidanitFile") MultipartFile file) {

        if (bindingResult.hasErrors()) {
            return "admin/room/update";
        }
        Optional<Room> roomOptional = this.roomService.getRoomById(room.getId());
        if (roomOptional.isPresent()) {
            Room roomToUpdate = roomOptional.get();

            String imageRoom = this.uploadService.handleSaveUploadFile(file, "rooms");
            roomToUpdate.setImage(imageRoom);

            this.roomService.handleSaveRoom(roomToUpdate);

        }

        return "redirect:/admin/room";
    }
//   End Update Room

//    Start View Delete Room
    @GetMapping("/admin/room/delete/{id}")
    public String getDeleteRoom(Model model, @PathVariable long id) {
        Optional<Room> room = this.roomService.getRoomById(id);
        model.addAttribute("id", id);
        model.addAttribute("newRoom", room.get());
        return "admin/room/delete";
    }

    @PostMapping("/admin/room/delete")
    public String postDeleteRoom(@ModelAttribute("newRoom") Room room) {
        this.roomService.handleDeleteRoom(room.getId());
//        this.roomService.handleSaveRoom(room);
        return "redirect:/admin/room";
    }
//    End View Delete Room
}
