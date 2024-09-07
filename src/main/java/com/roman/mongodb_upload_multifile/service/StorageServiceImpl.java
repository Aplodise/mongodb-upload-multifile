package com.roman.mongodb_upload_multifile.service;

import com.roman.mongodb_upload_multifile.dto.requestDTO.FileToUpload;
import com.roman.mongodb_upload_multifile.dto.responseDTO.UploadResponse;
import com.roman.mongodb_upload_multifile.entity.Storage;
import com.roman.mongodb_upload_multifile.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;


@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService{
    private final StorageRepository storageRepository;


    @Override
    public byte[] retrieveFile(String id) {
        var file = storageRepository.findById(id).orElseThrow();

        return file.data().getData();
    }

    @Override
    public UploadResponse upload(FileToUpload fileToUpload) {
        var resp =storageRepository.insert(new Storage(fileToUpload.fileName(), new Binary(fileToUpload.content())));
        return new UploadResponse(resp.id(), resp.data());
    }
}
