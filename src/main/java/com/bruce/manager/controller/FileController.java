package com.bruce.manager.controller;

import com.bruce.manager.model.to.UploadFile;
import com.bruce.manager.result.ResultEntity;
import com.bruce.manager.result.ResultTool;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * Created by bruce on 19/6/6 -- 21:03
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping(value = "/fetch/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] image(@PathVariable String id) {
        byte[] data = null;
        UploadFile file = mongoTemplate.findById(id, UploadFile.class);
        if (file != null) {
            data = file.getContent().getData();
        }
        return data;
    }

    @PostMapping("/upload")
    public ResultEntity uploadFile(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultTool.fail(400, "请选择一张图片");
        }
        // 返回的 JSON 对象，这种类可自己封装
        String fileName = file.getOriginalFilename();
        try {
            UploadFile uploadFile = new UploadFile();
            uploadFile.setName(fileName);
            uploadFile.setCreatedTime(new Date());
            uploadFile.setContent(new Binary(file.getBytes()));
            uploadFile.setContentType(file.getContentType());
            uploadFile.setSize(file.getSize());

            UploadFile savedFile = mongoTemplate.save(uploadFile);
            String url = "http://localhost:8090/file/fetch/" + savedFile.getId();
            return ResultTool.ok(url, "图片上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return ResultTool.fail(500, "图片上传失败");
        }

    }
}
