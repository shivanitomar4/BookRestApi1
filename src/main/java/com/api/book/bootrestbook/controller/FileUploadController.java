package com.api.book.bootrestbook.controller;

import com.api.book.bootrestbook.helper.FileHelperUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {
    
    @Autowired
    private FileHelperUpload fileHelperUpload;


    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file" ) MultipartFile file)
    {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        
        try {
            
       
        // validation
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
        }

        
        // if(!file.getContentType().equals("image/jpg")){
        //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("jpeg file only");
        // }

        // file upload code..
        boolean f= fileHelperUpload.uploadFile(file);
        if(f){
            // return ResponseEntity.ok("file uploaded sucessfully");
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
        }
    } catch (Exception e) {
        e.printStackTrace();

    }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SOMTHING WENT WRONG, TRY AGAIN");
        
    }
}
