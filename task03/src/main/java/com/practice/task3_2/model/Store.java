package com.practice.task3_2.model;

import java.util.List;

public interface Store {
    boolean addDepartment(String name, String product, String service, String location);

    boolean deleteDepartment(String name);

    void redeployDepartments();

    void deliverGoods(List<Product> products);
}
