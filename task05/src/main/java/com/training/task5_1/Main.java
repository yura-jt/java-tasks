package com.training.task5_1;

import com.training.task5_1.controller.Controller;
import com.training.task5_1.model.CuratorJournal;
import com.training.task5_1.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        CuratorJournal journal = new CuratorJournal();
        Controller controller = new Controller(view, journal);

        controller.run();
    }
}