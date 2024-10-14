package sachin.FileUplDown.FileUplDown.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import sachin.FileUplDown.FileUplDown.PayLoad.FileResponse;
import sachin.FileUplDown.FileUplDown.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/file")
public class FileController 
{

    @Autowired
    FileService fileService;

    @Value("${project.image}")
    String path;

   
                            /*  Uploading Single File   */
    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload( @RequestParam("image") MultipartFile image)
    {
        String fileName =null;
        try {
            fileName = fileService.uploadImage(path, image);
        } 
        catch (IOException e)
         {
            e.printStackTrace();
            return new ResponseEntity<>(new FileResponse(null, "Image is not Uploaded due to server error !!"), HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return new ResponseEntity<>(new FileResponse(fileName, "Image is successfully Uploaded !!"), HttpStatus.OK);
    } 

                     /*  Uploading Multiple File   */

}
