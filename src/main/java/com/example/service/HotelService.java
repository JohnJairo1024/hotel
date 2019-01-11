package com.example.service;

import com.example.entity.Hotel;
import com.example.entity.Image;
import com.example.entity.Localization;
import com.example.entity.User;
import com.example.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    public HotelService(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    public List<Hotel> findAllByHOwnerId(long id) {
        return hotelRepo.findAllByHOwnerId(id);
    }

    public Hotel findById(long id) {
        return hotelRepo.findOne(id);
    }

    public void addHotel(Hotel hotel, Image image, Localization hotelLocalization, User user) {
        hotel.sethOwner(user);
        hotel.setImages(image);
        hotel.setAddress(hotelLocalization);
        hotelRepo.save(hotel);
    }
}
