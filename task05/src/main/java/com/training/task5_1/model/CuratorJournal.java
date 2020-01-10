package com.training.task5_1.model;

import java.util.ArrayList;
import java.util.List;

public class CuratorJournal {
    private List<Record> journal = new ArrayList<>();

    public List<Record> getAllRecords() {
        return journal;
    }
}
