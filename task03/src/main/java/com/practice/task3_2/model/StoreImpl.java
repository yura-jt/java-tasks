package com.practice.task3_2.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StoreImpl implements Store {
    private List<Department> departments = new ArrayList<>();
    private List<Product> stock = new ArrayList<>();

    private String name;

    private class Department {
        private String name;
        private String productType;
        private String serviceType;
        private String location;

        @Override
        public String toString() {
            return "Department '" + name + '\'' +
                    ", products type = '" + productType + '\'' +
                    ", service type = '" + serviceType + '\'' +
                    ", location = '" + location + "\'\n";
        }
    }

    @Override
    public boolean addDepartment(String name, String product, String service, String location) {
        Department department = new Department();
        department.name = name;
        department.productType = product;
        department.serviceType = service;
        department.location = location;
        return departments.add(department);
    }

    @Override
    public boolean deleteDepartment(String name) {
        return departments.removeIf(department -> department.name.equalsIgnoreCase(name));
    }

    @Override
    public void redeployDepartments() {
        departments.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }

    @Override
    public void deliverGoods(List<Product> products) {
        stock.addAll(products);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String departmentsToStrings = "";

        for (Department department : departments) {
            departmentsToStrings += department.toString();
        }

        return name + " Mall:\n" +
                departmentsToStrings +
                "Total departments: " + departments.size() +
                "\nTotal amount of products in a warehouse: " + stock.size();
    }

    public List<Department> getDepartments() {
        return departments;
    }
}
