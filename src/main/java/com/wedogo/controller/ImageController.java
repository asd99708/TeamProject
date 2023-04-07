package com.wedogo.controller;

import com.wedogo.hotel.entity.ImageEntity;
import com.wedogo.hotel.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Base64;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("image") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            ImageEntity image = imageService.saveImage(file);
            redirectAttributes.addAttribute("id", image.getId());
            return "redirect:/image";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/image")
    public String getImage(@RequestParam("id") Long id, Model model) {
        ImageEntity image = imageService.getImage(id);
        String encodedImageData = Base64.getEncoder().encodeToString(image.getImageData());
        model.addAttribute("imageData", encodedImageData);
        model.addAttribute("image", image);
        return "image";
    }
}