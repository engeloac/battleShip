/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usr.badcompany;

import com.usr.objects.TbattleShip;
import com.usr.objects.Tbox;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 *
 * @author sirbobby
 */
public class TbadCompany extends JFrame{
   
    public TbadCompany() {
        variableStart();
        variableProperties();
        userInterface();
        initBoard();
        //showBoard();
    }
    public static void main(String[] args) {
        TbadCompany frame = new TbadCompany();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Batalla Naval");
    }
    private void userInterface() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1040, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Batalla Naval");
        
        jpanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click en el panel 1");
                
            }
        });
        jpanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click en el panel 2");
                showBoard();
            }
        });
        addWindowListener(new WindowAdapter() {
            public void mouse(WindowAdapter e){
                
            }
        });
        add(jpanel1);
        add(jpanel2);
    }
    private void mouse() {
        
    }
    private void variableStart() {
        jpanel1 = new JPanel();
        jpanel2 = new JPanel();
        board1 = new Tbox[10][10];
    }
    private void variableProperties() {
        jpanel1.setBackground(new Color(230, 126, 34));
        jpanel1.setLayout(new AbsoluteLayout());
        jpanel1.setBounds(0, 0, 300, 600);
        jpanel2.setBackground(new Color(46, 204, 113));
        jpanel2.setLayout(new AbsoluteLayout());
        jpanel2.setBounds(301, 0, 1040, 600);
        
    }
    private void initBoard() {
        int addX;
        int addY = 10;
        for (int i = 0; i < 10;i++) {
            addX = 310;
            for (int j = 0; j < 10; j++) {
                board1[i][j] = new Tbox("/com/usr/resorcs/square.jpeg", addX, addY, addX + 36, addY + 36, false);
                System.out.println(board1[i][j].getImgHorizontal()+"");    
                addX = addX += 58;
            }
            addY = addY += 55;
        }
        
    }
    private void iniBattleShip() {
        //battleShip[0] = new TbattleShip("", "", 0, 0, 0, 0, boolean nombres={false} , false);
    }
    private void showBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board1[i][j].paint(jpanel2.getGraphics());
            }
        }
    }
    //VarBox
    private JPanel jpanel1;
    private JPanel jpanel2;
    private Tbox board1[][];
    private TbattleShip battleShip[];
    //VarBox
}
