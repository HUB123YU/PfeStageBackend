package ma.zs.stocky.ws.facade.admin.minio;

import com.linecorp.armeria.common.HttpStatus;
import ma.zs.stocky.service.facade.admin.minio.MinioService;
import org.apache.poi.util.IOUtils;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/minio")

public class MinioController {

    private final MinioService minioService;

    public MinioController(MinioService minioService) {
        this.minioService = minioService;
    }

    @PostMapping("/upload/{bucketName}/{objectName}")
    public ResponseEntity<String> uploadFile(@PathVariable String bucketName,
                                             @PathVariable String objectName,
                                             @RequestParam("file") MultipartFile file) {
        minioService.uploadFile(file, bucketName, objectName);
        return ResponseEntity.ok("File uploaded successfully");
    }

    @GetMapping("/download/{bucketName}/{objectName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String bucketName,
                                               @PathVariable String objectName) {
        try (InputStream inputStream = minioService.downloadFile(bucketName, objectName)) {
            byte[] bytes = IOUtils.toByteArray(inputStream);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDisposition(ContentDisposition.attachment().filename(objectName).build());
            return new ResponseEntity<>(bytes, headers, HttpStatus.OK.code());
        } catch (IOException e) {
            throw new RuntimeException("Error downloading file from Minio: " + e.getMessage());

        }
    }


    @PostMapping("/buckets")
    public ResponseEntity<String> createBucket(@RequestBody String bucketName) {
        try {
            minioService.createBucket(bucketName);
            return ResponseEntity.ok("Bucket created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.code())
                    .body("Error creating bucket: " + e.getMessage());
        }
    }


}