package com.example.fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileUploadService {

    @Autowired
    private FileUploadRepository fileUploadRepository;

    private final String uploadDir = "uploads/";

    // Method to upload a file and save its details to the database
    public FileUpload uploadFile(MultipartFile file, String description) throws IOException {
        // Ensure the upload directory exists
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Create the file path
        Path filePath = Paths.get(uploadDir + file.getOriginalFilename());

        // Write file to the disk
        Files.write(filePath, file.getBytes());

        // Save file info to the database
        FileUpload fileUpload = new FileUpload(file.getOriginalFilename(), description);
        return fileUploadRepository.save(fileUpload);
    }

    // Method to delete a file and remove its entry from the database
    public void deleteFile(Long id) throws IOException {
        FileUpload fileUpload = fileUploadRepository.findById(id).orElseThrow(() -> new IOException("File not found"));
        File file = new File(uploadDir + fileUpload.getFilename());
        if (file.exists()) {
            file.delete();
        }
        fileUploadRepository.delete(fileUpload);
    }

    // New method to retrieve all uploaded files from the database
    public List<FileUpload> getAllFiles() {
        return fileUploadRepository.findAll();
    }
}
