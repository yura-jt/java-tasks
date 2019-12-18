package com.practice.task3_1.model;

import com.practice.task3_1.model.entity.Toy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayRoom<T extends Toy> {
    private List<T> toys = new ArrayList<>();

    public List<T> getToys() {
        return toys;
    }

    public void setToys(List<T> toys) {
        this.toys = toys;
    }

    public List<T> sortByParam(Parameter parameter) {
        Comparator<T> comparator = getComparator(parameter);
        List<T> sortedList = new ArrayList<>(toys);
        sortedList.sort(comparator);
        return sortedList;
    }

    public double calcTotalPrice() {
        BigDecimal sum = toys.stream()
                .map(Toy::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.doubleValue();
    }

    public <E> List<T> getToysByParam(E from, E to) {
        List<T> result = new ArrayList<>();
        if (from instanceof Color) {
            result = getListByColor(from, to);
        } else if (from instanceof BigDecimal) {
            result = getListByPrice(from, to);
        } else if (from instanceof String) {
            result = getListByNames(from, to);
        }
        return result;
    }

    private <E> List<T> getListByPrice(E from, E to) {
        List<T> result = new ArrayList<>();
        BigDecimal fromPrice = (BigDecimal) from;
        BigDecimal toPrice = (BigDecimal) to;
        for (T toy : toys) {
            if (toy.getPrice().compareTo(fromPrice) >= 0 &&
                    toy.getPrice().compareTo(toPrice) <= 0) {
                result.add(toy);
            }
        }
        return result;
    }

    private <E> List<T> getListByColor(E from, E to) {
        List<T> result = new ArrayList<>();
        String fromColor = ((Color) from).name();
        String toColor = ((Color) to).name();
        for (T toy : toys) {
            if (toy.getColor().name().compareTo(fromColor) >= 0 &&
                    toy.getColor().name().compareTo(toColor) <= 0) {
                result.add(toy);
            }
        }
        return result;
    }

    private <E> List<T> getListByNames(E from, E to) {
        List<T> result = new ArrayList<>();
        String fromName = (String) from;
        String toName = (String) to;
        for (T toy : toys) {
            if (toy.getName().compareTo(fromName) >= 0 &&
                    toy.getName().compareTo(toName) <= 0) {
                result.add(toy);
            }
        }
        return result;
    }

    private Comparator<T> getComparator(Parameter parameter) {
        Comparator<T> result;
        if (parameter == Parameter.COLOR) {
            result = Comparator.comparing((T o) -> o.getColor().name());
        } else if (parameter == Parameter.PRICE) {
            result = Comparator.comparing(Toy::getPrice);
        } else {
            result = Comparator.comparing(Toy::getName);
        }
        return result;
    }
}
