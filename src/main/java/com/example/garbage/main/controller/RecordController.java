package com.example.garbage.main.controller;



import com.example.garbage.main.entity.RecordData;
import com.example.garbage.main.service.RecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author: zjs
 * @data: 2022-03-10 21:00:33
 * @Description: RecordController api
 */

@RestController
@RequestMapping("/record")
@CrossOrigin
public class RecordController {


    @Resource
    private RecordService recordService;

    /**
     * Send daily weekly monthly data to frontend
     * @return Map<String,Integer>
     */
    @GetMapping("/getWeight")
    public Map<String,Integer> getAllRecords(){
        System.out.println(11111111);
        return recordService.getRecordList();
    }

    /**
     * receive an int param insert send to service
     * @param weight
     * @return
     */
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
