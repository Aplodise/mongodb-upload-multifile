package com.roman.mongodb_upload_multifile.dto.requestDTO;

public record FileToUpload(String fileName, byte[] content) {
}
