package com.example.garbage.main.service;

import com.example.garbage.main.entity.RecordData;

import java.util.Map;

public interface RecordService {
    Map<String, Integer> getRecordList();

    String addRecord(RecordData recordData);
}
