package com.spring.blogappapis.impl;

import com.spring.blogappapis.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile multipartFile) throws IOException {
        String name = multipartFile.getOriginalFilename();
        String randomId = UUID.randomUUID().toString();
        String fileName = name.concat(name.substring(name.lastIndexOf(".")));

        String filePath = path + File.separator + fileName;

        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }

        Files.copy(multipartFile.getInputStream(), Path.of(filePath));
        return fileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
       String fullPath = path+File.separator+fileName;
        InputStream inputStream = new FileInputStream(fullPath);
        return inputStream;
    }
}
