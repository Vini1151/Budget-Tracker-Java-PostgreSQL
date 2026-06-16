/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vini pandhare
 */
public class Budget {

    private String category;
    private double budgetAmount;

    public Budget() {
    }

    public Budget(String category,
            double budgetAmount) {

        this.category = category;
        this.budgetAmount = budgetAmount;
    }

    public String getCategory() {
        return category;
    }

    public double getBudgetAmount() {
        return budgetAmount;
    }
}
