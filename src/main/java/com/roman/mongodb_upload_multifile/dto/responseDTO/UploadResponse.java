package com.roman.mongodb_upload_multifile.dto.responseDTO;

import org.bson.types.Binary;

public record UploadResponse(String code, Binary data) {
}
