package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.ZipFileBean.UploadZipFileInS3;
import com.example.jsgamesbackendmain.Model.DTO.S3.S3UrlResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ZipFileService {

    private final UploadZipFileInS3 uploadZipFileInS3;

    public List<S3UrlResponseDTO> uploadZipFile(MultipartFile file) throws IOException {
        return uploadZipFileInS3.exec(file);
    }

}
