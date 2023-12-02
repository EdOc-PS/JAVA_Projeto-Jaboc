/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_UI.JabocUI_Utilidades.JabocUI_Classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTable;

/**
 *
 * @author eeuar
 */
public class Table extends JTable {
    
    public Table() {
        setRowHeight(45);
        setShowGrid(false);
      
        setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        setForeground(new Color(79, 84, 101));
        getTableHeader().setOpaque(false);
        getTableHeader().setBackground(new Color(79, 84, 101));
        getTableHeader().setForeground(new Color(255,255,255));
        getTableHeader().setFont(new java.awt.Font("Gill Sans MT", 1, 14));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        
        g2.dispose();
        
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
