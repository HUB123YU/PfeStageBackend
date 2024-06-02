package ma.zs.stocky.service.facade.admin.minio;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface MinioService {
    void createBucket(String bucketName);

    void uploadFile(MultipartFile file, String bucketName, String objectName);

    InputStream downloadFile(String bucketName, String objectName);
}
