package com.practice.task3_2;

import com.practice.task3_2.controller.Controller;
import com.practice.task3_2.model.StoreImpl;
import com.practice.task3_2.view.View;

public class Main {
    public static void main(String[] args) {
        StoreImpl storeImpl = new StoreImpl();
        View view = new View();
        Controller controller = new Controller(storeImpl, view);

        controller.processData();
    }
}