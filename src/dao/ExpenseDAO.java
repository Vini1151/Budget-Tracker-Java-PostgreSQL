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
import model.Expense;
import util.DBconnection;

public class ExpenseDAO {
    public void addExpense(Expense expense) {
        String sql =
                "INSERT INTO expenses(category,amount,expense_date,description)"
                + " VALUES(?,?,?,?)";
        try {
            Connection con =
                    DBconnection.getConnection();
            PreparedStatement pst =
                    con.prepareStatement(sql);
            pst.setString(1,
                    expense.getCategory());
            pst.setDouble(2,
                    expense.getAmount());
            pst.setDate(3,
                    java.sql.Date.valueOf(
                            expense.getExpenseDate()));
            pst.setString(4,
                    expense.getDescription());
            pst.executeUpdate();
            System.out.println(
                    "Expense Added Successfully");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}