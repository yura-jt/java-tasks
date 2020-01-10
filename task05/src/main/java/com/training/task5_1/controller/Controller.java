package com.training.task5_1.controller;

import com.training.task5_1.controller.util.Message;
import com.training.task5_1.controller.util.MessageConverter;
import com.training.task5_1.model.CuratorJournal;
import com.training.task5_1.model.Record;
import com.training.task5_1.view.InputData;
import com.training.task5_1.view.View;

import java.util.List;

public class Controller {
    private View view;
    private CuratorJournal journal;
    private RecordInputController recordInputController;

    public Controller(View view, CuratorJournal journal) {
        this.view = view;
        this.journal = journal;
        recordInputController = new RecordInputController(view);
    }

    public void run() {
        String command = "";
        while (!command.equals("exit")) {
            view.printMessage(Message.MAIN_MENU);
            command = InputData.getString().toLowerCase();
            if (command.equals("add")) {
                addRecords();
            } else if (command.equals("print")) {
                printRecords();
            } else if (!command.equals("exit")) {
                view.printMessage(Message.WRONG_INPUT);
            }
        }
    }

    private void addRecords() {
        List<Record> list = recordInputController.getRecordsFromConsole();
        List<Record> journalRecords = journal.getAllRecords();
        journalRecords.addAll(list);
    }

    private void printRecords() {
        view.printMessage(Message.PRINT);
        List<Record> list = journal.getAllRecords();
        String message = MessageConverter.convertList(list);
        if (list.size() > 0) {
            view.printMessage(message);
        } else {
            view.printMessage(Message.JOURNAL_EMPTY);
        }
    }
}