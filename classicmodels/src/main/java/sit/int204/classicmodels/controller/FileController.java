package sit.int204.classicmodels.controller;


import org.springframework.beans.factory.annotation.Autowired;
//ระวัง ต้องใช้  core.io.Resource ไม่ใช่ jakarta
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
//import sit.int204.classicmodels.execeptions.ErrorResponse;
import sit.int204.classicmodels.execeptions.ResourceNotFoundException;
import sit.int204.classicmodels.services.FileService;

import java.io.FileNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/api/files")
public class FileController {
//    เข้า Body ไปลองเทส แล้วยิง ตาม end point
    private final FileService fileService;
    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }



    @GetMapping("/{filename:.+}")
    @ResponseBody
// เวลาเรียกชื่อไฟล์ เรียกพร้อมนามสกุล และ เป็น inSensitiveCase
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
      /*  String x = null ;
        x.toLowerCase();*/
        Resource file = fileService.loadFileAsResource(filename);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
    }



    @PostMapping("")
    //    parameter ที่ส่งใน body post man ต้องเป็น ชื่อเดียวกับใน code ที่เรารับมา
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        fileService.store(file);
        return "You successfully uploaded " + file.getOriginalFilename() + "!";
    }





}

