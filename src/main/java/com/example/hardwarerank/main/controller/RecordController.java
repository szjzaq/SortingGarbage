package com.example.hardwarerank.main.controller;



import com.example.hardwarerank.main.entity.RecordData;
import com.example.hardwarerank.main.service.RecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("/record")
public class RecordController {


    @Resource
    private RecordService recordService;

    @GetMapping("/getWeight")
    public Map<String,Integer> getAllRecords(){
        return recordService.getRecordList();
    }

    @ResponseBody
    @RequestMapping("/addRecord/{weight}")
    public String insertRecord(@PathVariable String weight){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        RecordData recordData = new RecordData();
        recordData.setWeight(Integer.parseInt(weight));
        recordData.setDate(date);

        return recordService.addRecord(recordData);
    }
}
