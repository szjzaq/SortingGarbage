package com.example.garbage.main.dao;

import com.example.garbage.main.entity.RecordData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordDataDao {
    List<RecordData> selectedAllRecords();

    void addRecord(RecordData record);
}
