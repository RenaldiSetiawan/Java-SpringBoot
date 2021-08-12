package com.backend.tourtraveljava.controller;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.backend.tourtraveljava.model.ToursImages;
import com.backend.tourtraveljava.services.ToursImagesService;
import com.backend.tourtraveljava.storage.StorageService;
import com.backend.tourtraveljava.storage.UploadFileResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/toursimages")
public class ToursImagesController {
    
    @Autowired
    private ToursImagesService toursImagesService;

    @Autowired
    private StorageService storageService;

    //FIND ALL 
    @GetMapping
    public ResponseEntity<?> findAllTours() {
        List<ToursImages> toursimages = toursImagesService.findAllToursImages();
        return ResponseEntity.ok().body(toursimages);
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = storageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/product/downloadFile/")
                .path(fileName).toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    } 

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = storageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
        
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
    }

    @PostMapping("/addMultipart")
    public ResponseEntity<?> addToursMultipart(ToursImages toursImages, @RequestParam("file") MultipartFile file) {

        try {
            String fileName = storageService.storeFile(file);
            ToursImages toursimages = toursImages;
            if (fileName.contains(".")) {
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/tours/downloadFile/").path(fileName).toUriString();
                toursimages.setToim_filename(fileDownloadUri);
            }
            return ResponseEntity.ok().body(toursImagesService.addToursImages(toursimages));

        } catch (Exception e) {
            
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteToursImagesById(@PathVariable("id") Long id) {
        try {
            toursImagesService.deleteToursImagesById(id);
            return ResponseEntity.ok().body("Tours Images has been Delete");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ToursImages Id not found!!");
        }
    }
   
}