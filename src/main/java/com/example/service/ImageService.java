package com.example.service;

import com.example.entity.Image;
import com.example.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    private static String UPLOADED_FOLDER = "C:\\cargueArchivo\\";

    @Autowired
    private ImageRepo imageRepo;

    public Image addNewImage(MultipartFile file) throws IOException {

        // Get the file and save it somewhere
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
        Files.write(path, bytes);

        Image image = new Image();

        image.setPath("../storage/" + file.getOriginalFilename().replaceAll(" ", ""));
        imageRepo.save(image);

        return image;
    }

    /**
     * Sets default user's avatar while register.
     *
     * @return
     */
    public Image defaultUserImage() {

        Image image = new Image();
        image.setPath("../storage/default.jpg");
        imageRepo.save(image);
        return image;
    }
}
