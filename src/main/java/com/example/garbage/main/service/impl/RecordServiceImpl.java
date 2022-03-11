package com.example.garbage.main.service.impl;

import com.example.garbage.main.dao.RecordDataDao;
import com.example.garbage.main.entity.RecordData;
import com.example.garbage.main.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDataDao recordDataDao;


    @Override
    public Map<String, Integer> getRecordList() {
        Map<String, Integer> result = new HashMap<>();
        result.put("daily", 0);
        result.put("weekly", 0);
        result.put("monthly", 0);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate listDays = LocalDate.now();
        String today = listDays.toString();
        List<LocalDate> week = Arrays.stream(DayOfWeek.values()).map(listDays::with).collect(Collectors.toList());
        List<String> weekString = new ArrayList<>();
        for (LocalDate l :
                week) {
            weekString.add(l.toString());
        }

        List<String> month = new ArrayList<>();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+10"));
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
        cal.set(Calendar.MONTH, Calendar.MONTH);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 1; j <= count; j++) {
            month.add(simpleDateFormat.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }


        List<RecordData> recordDataList = recordDataDao.selectedAllRecords();

        for (RecordData recordData :
                recordDataList) {
            String recordDay = simpleDateFormat.format(recordData.getDate());
            if (month.contains(recordDay)) {
                result.put("monthly", result.get("monthly") + recordData.getWeight());
                if (weekString.contains(recordDay)) {
                    result.put("weekly", result.get("weekly") + recordData.getWeight());
                    if (recordDay.equals(today)) {
                        result.put("daily", result.get("daily") + recordData.getWeight());
                    }
                }
            }
        }

        return result;
    }

    @Override
    public String addRecord(RecordData recordData) {
        try {
            recordDataDao.addRecord(recordData);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
