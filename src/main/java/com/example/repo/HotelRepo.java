package com.example.repo;

import com.example.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepo extends JpaRepository<Hotel, Long> {


    /**
     * Gives list of hotels that belong to user.
     *
     * @param id - id of user who is owner of the hotels.
     * @return
     */
    List<Hotel> findAllByHOwnerId(long id);
}
