package com.example.fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    // Endpoint to retrieve all files
    @GetMapping("/files")
    public List<FileUpload> getAllFiles() {
        return fileUploadService.getAllFiles();
    }

    // Endpoint to upload a file
    @PostMapping("/upload")
    public FileUpload uploadFile(@RequestParam("file") MultipartFile file,
                                 @RequestParam("description") String description) throws IOException {
        return fileUploadService.uploadFile(file, description);
    }

    // Endpoint to delete a file by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable Long id) throws IOException {
        fileUploadService.deleteFile(id);
        return ResponseEntity.ok("File deleted successfully!");
    }
}
