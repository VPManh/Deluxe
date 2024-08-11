package vn.vpm.deluxe.service;

import org.springframework.stereotype.Service;
import vn.vpm.deluxe.domain.Room;
import vn.vpm.deluxe.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void handleSaveRoom(Room room) {
        roomRepository.save(room);
    }

    public void handleDeleteRoom(long id) {
        this.roomRepository.deleteById(id);
    }

    public List<Room> getFindA6New() {
        return this.roomRepository.findTop6ByOrderByIdAsc();
    }

    public List<Room> getFindAllRoom() {
        return this.roomRepository.findAll();
    }

    public Optional<Room> getRoomById(long id) {
        return this.roomRepository.findById(id);
    }
}
