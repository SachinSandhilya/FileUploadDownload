package sachin.FileUplDown.FileUplDown.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService
 {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException 
    {

        // File-Name
        String name =file.getOriginalFilename();

        //Full-Path
       String filePath =path+ File.separator+name;

       //creating-Folder
        File file2=new File(path);
        if (!file2.exists()) 
        {
            file2.mkdir();
        }

        // Files-Copy
        Files.copy(file.getInputStream(),Paths.get(filePath));

        return filePath;
    }

}
