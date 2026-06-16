/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author vini pandhare
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Budget;
import util.DBconnection;

public class BudgetDAO {
    public void addBudget(Budget budget) {
        String sql =
                "INSERT INTO budgets(category,budget_amount) VALUES (?,?)";
        try{
            Connection con =
                    DBconnection.getConnection();
            PreparedStatement pst =
                    con.prepareStatement(sql);
            pst.setString(1,
                    budget.getCategory());
            pst.setDouble(2,
                    budget.getBudgetAmount());
            pst.executeUpdate();
            System.out.println(
                    budget.getCategory()
                    + " Budget Added");
        }catch (SQLException e) {
            System.out.println(e);

        }
    }
}