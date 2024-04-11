package com.penguin.chalcak.util;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ImageUtil {
    public static String multiPartFileBase64Encoder(MultipartFile file) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(file.getBytes());
        byte[] bytesArray = outputStream.toByteArray();
        outputStream.close();
        return Base64.getEncoder().encodeToString(bytesArray);
    }
}
