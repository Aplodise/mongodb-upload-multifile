package com.roman.mongodb_upload_multifile.entity;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "storage")
public record Storage(@Id String id, String fileName, Binary data) {

    public Storage(String fileName, Binary data) {
        this(null, fileName, data);
    }
}
