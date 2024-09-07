package com.roman.mongodb_upload_multifile.controller;


import com.roman.mongodb_upload_multifile.dto.requestDTO.FileToUpload;
import com.roman.mongodb_upload_multifile.dto.responseDTO.UploadResponse;
import com.roman.mongodb_upload_multifile.service.StorageService;
import com.roman.mongodb_upload_multifile.service.StorageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StorageController {
    private final StorageService storageService;



    @GetMapping("/storage/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id){
        var file = storageService.retrieveFile(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        return new ResponseEntity<>(file, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/storage")
    public UploadResponse uploadFile(@RequestBody FileToUpload fileToUpload){
        return storageService.upload(fileToUpload);
    }

}
