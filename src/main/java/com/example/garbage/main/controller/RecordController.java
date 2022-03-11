package com.example.garbage.main.controller;



import com.example.garbage.main.entity.RecordData;
import com.example.garbage.main.service.RecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

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
        Date date = new Date();

        RecordData recordData = new RecordData();
        recordData.setWeight(Integer.parseInt(weight));
        recordData.setDate(date);

        return recordService.addRecord(recordData);
    }
}
