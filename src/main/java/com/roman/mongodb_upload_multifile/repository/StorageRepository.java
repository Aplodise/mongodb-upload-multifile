package com.roman.mongodb_upload_multifile.repository;

import com.roman.mongodb_upload_multifile.entity.Storage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StorageRepository extends MongoRepository<Storage, String> {

}
