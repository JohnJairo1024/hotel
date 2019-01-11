package com.example.service;

import com.example.entity.Hotel;
import com.example.entity.Localization;
import com.example.entity.Room;
import com.example.repo.LocalizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocalizationService {

    @Autowired
    private LocalizationRepo localizationRepo;

    /**
     * Method to create new localization when new room is created.
     *
     * @param localization - binded entity from thymeleaf form.
     * @return saved location.
     */
    public Localization newLocalization(Localization localization) {
        Localization tmp = localization;
        localizationRepo.save(tmp);
        return tmp;
    }

    /**
     * Method to get all cities where rooms are located.
     *
     * @return List of cities.
     */
    public List<String> findAllCities() {
        return localizationRepo.findAllCities();
    }

    /**
     * Save given hotel to given localization.
     *
     * @param localization - localization of the hotel.
     * @param hotel        - hotel of given localization.
     */
    public void hotelLocalization(Localization localization, Hotel hotel) {
        localization.setHotel(hotel);
        localizationRepo.save(localization);
    }

    /**
     * Save given room to given localization.
     *
     * @param localization - localization of the room.
     * @param room         - room of given localization.
     */
    public void roomLocalization(Localization localization, Room room) {
        localization.setRoom(room);
        localizationRepo.save(localization);
    }
}
