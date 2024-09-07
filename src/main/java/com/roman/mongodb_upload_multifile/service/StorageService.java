package com.roman.mongodb_upload_multifile.service;

import com.roman.mongodb_upload_multifile.dto.requestDTO.FileToUpload;
import com.roman.mongodb_upload_multifile.dto.responseDTO.UploadResponse;

public interface StorageService {
    byte[] retrieveFile(String id);
    UploadResponse upload(FileToUpload fileToUpload);

}
