package ma.zs.stocky.service.impl.admin.minio;

import io.minio.*;
import ma.zs.stocky.service.facade.admin.minio.MinioService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class MinioServiceImpl implements MinioService {

    private final MinioClient minioClient;


    public MinioServiceImpl(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public void createBucket(String bucketName) {
        try {
            // Check if the bucket already exists
            if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
                // Create the bucket
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            } else {
                // Bucket already exists, do nothing
            }
        } catch (Exception e) {
            throw new RuntimeException("Error creating Minio bucket: " + e.getMessage(), e);
        }
    }


@Override
    public void uploadFile(MultipartFile file, String bucketName, String objectName) {
        try (InputStream inputStream = file.getInputStream()) {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .stream(inputStream, file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Error uploading file to Minio: " + e.getMessage());
        }
    }

    @Override
    public InputStream downloadFile(String bucketName, String objectName) {
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Error downloading file from Minio: " + e.getMessage());
        }
    }


}