package controllers;

import models.Product;
import views.SalesView;

import static utils.Rounder.round;


public class ProductController {

    Product model;
    SalesView view;


    public ProductController(Product model, SalesView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {

        view.getInputs();
        String name = model.getName();

        double income = model.calculateIncome();
        String incomeResult = round(income);

        double tax = model.calculateTax(income);
        String taxResult = round(tax);

        double netIncome = model.calculateIncome(tax);
        String netIncomeResult = round(netIncome);

        String output = "Наименование товара: " + name + "\n"
                + "Общий доход (грн.): " + incomeResult + "\n"
                + "Сумма налога (грн.): " + taxResult + "\n"
                + "Чистый доход (грн.): " + netIncomeResult;
        view.getOutput(output);
    }
}
