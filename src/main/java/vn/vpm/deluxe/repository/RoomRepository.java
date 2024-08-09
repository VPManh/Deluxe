package vn.vpm.deluxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.vpm.deluxe.domain.Room;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findTop6ByOrderByIdAsc();
}
