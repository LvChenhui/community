package com.wl.lch.util;

import com.wl.lch.domain.Resp;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class FileUtil {

    public static String uploadFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String today = LocalDate.now().toString();

            String type = file.getContentType();
            String suffix = "." + type.split("/")[1];
            String userUploadPath = today + "/";
            String fileName = UUID.randomUUID().toString()+suffix;
            File file_dir = new File(Resp.UPLOAD_PATH + userUploadPath);
            if (!file_dir.exists()) 
                file_dir.mkdirs();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(Resp.UPLOAD_PATH + userUploadPath + fileName)));
            stream.write(file.getBytes());
            stream.close();

            return Resp.STATIC_URL+userUploadPath+fileName;
        }
        return null;
    }
}
