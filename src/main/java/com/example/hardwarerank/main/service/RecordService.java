package com.example.hardwarerank.main.service;

import com.example.hardwarerank.main.entity.RecordData;

import java.util.List;
import java.util.Map;

public interface RecordService {
    Map<String, Integer> getRecordList();

    String addRecord(RecordData recordData);
}
