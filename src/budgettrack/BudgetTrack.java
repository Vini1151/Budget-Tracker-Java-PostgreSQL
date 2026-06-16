/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package budgettrack;

import gui.DashboardFrame;
public class BudgetTrack {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new DashboardFrame().setVisible(true);
        });
    }
}