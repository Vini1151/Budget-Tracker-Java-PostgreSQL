/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
/**
 *
 * @author vini pandhare
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBconnection;

public class DashboardService {

    public String getDashboardText() {
        StringBuilder dashboard =
                new StringBuilder();
        try {
            Connection con =
                    DBconnection.getConnection();
            Statement st =
                    con.createStatement();
            ResultSet budgetResult =
                    st.executeQuery(
                    "SELECT SUM(budget_amount) total FROM budgets");
            double totalBudget = 0;
            if (budgetResult.next()) {
                totalBudget =
                        budgetResult.getDouble("total");
            }
            ResultSet expenseResult =
                    st.executeQuery(
                    "SELECT SUM(amount) total FROM expenses");
            double totalExpense = 0;
            if (expenseResult.next()) {
                totalExpense =
                        expenseResult.getDouble("total");
            }
            double remaining =
                    totalBudget - totalExpense;
            double usage = 0;
            if (totalBudget > 0) {
                usage =
                        (totalExpense * 100)
                        / totalBudget;
            }
            dashboard.append(
                    "========== DASHBOARD ==========\n\n");
            dashboard.append(
                    "Total Budget: ₹")
                    .append(totalBudget)
                    .append("\n");
            dashboard.append(
                    "Total Expense: ₹")
                    .append(totalExpense)
                    .append("\n");
            dashboard.append(
                    "Remaining: ₹")
                    .append(remaining)
                    .append("\n");
            dashboard.append(
                    "Usage: ")
                    .append(String.format("%.2f", usage))
                    .append("%\n");
            if(totalExpense>totalBudget){
                dashboard.append(
                        "\n⚠ Budget Exceeded");
            }
        } catch(SQLException e){
            dashboard.append(e.getMessage());
        }
        return dashboard.toString();
    }
}