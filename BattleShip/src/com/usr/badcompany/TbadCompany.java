/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usr.badcompany;

import com.usr.objects.TbattleShip;
import com.usr.objects.Tbox;
import java.awt.Color;
import java.awt.Point;
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
        initBattleShip();
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
        setSize(1040, 611);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Batalla Naval");
        
        jpanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickedStatus();
            }
        });
        jpanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                if (activeMouse) mouseMotion(evt);
            }
        });
        jpanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showBoard();
            }
        });
        jpanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                if (activeMouse) mouseMotion(evt);
            }
        });
        addWindowListener(new WindowAdapter() {
            public void mouse(WindowAdapter e){
                
            }
        });
        add(jpanel1);
        add(jpanel2);
    }
    private boolean checkMouseRange() {
        boolean range = false;
        for (int i = 0; i < 8; i++) {
            Point point = jpanel1.getMousePosition();
            //System.out.println(point.x+"--"+point.y);
            if (point.x > battleShip[i].getImgHorizontalX() && point.x < battleShip[i].getImgHorizontalX1()){
                //range = true;
                System.out.println(battleShip[i].getImgHorizontalX()+"--"+battleShip[i].getImgHorizontalX1());
                System.out.println("Estoy en rango");
            }
        }
        return range;
    }
    private void mouseClickedStatus() {
        if (checkMouseRange()) {
            if (mouseStatus == 0) {
                activeMouse = true;
                mouseStatus++;
            }
            else {
                activeMouse = false;
                mouseStatus = 0;
            }
        }  
    }
    private void mouseMotion(MouseEvent evt) {
        //System.out.println(evt.getX()+"--"+evt.getY());
    }
    private void variableStart() {
        jpanel1 = new JPanel();
        jpanel2 = new JPanel();
        board1 = new Tbox[10][10];
        
        mouseStatus = 0;
        activeMouse = false;
    }
    private void variableProperties() {
        jpanel1.setBackground(new Color(230, 126, 34));
        jpanel1.setLayout(new AbsoluteLayout());
        jpanel1.setBounds(0, 0, 300, 600);
        jpanel2.setBackground(new Color(46, 204, 113));
        jpanel2.setLayout(new AbsoluteLayout());
        jpanel2.setBounds(301, 0, 1040, 611);
        
    }
    private void initBoard() {
        int addX;
        int addY = 10;
        for (int i = 0; i < 10;i++) {
            addX = 310;
            for (int j = 0; j < 10; j++) {
                board1[i][j] = new Tbox("/com/usr/resorcs/water1.png", addX, addY, false);   
                addX = addX += 58;
            }
            addY = addY += 55;
        }   
    }
    private void initBattleShip() {
        int addX = 28;
        int addY = 8;
        battleShip[0] = new TbattleShip("/com/usr/resorcs/5horizontal.jpg","/com/usr/resorcs/2vertical.jpg", addX, addX, 0, 0,new boolean[] {true,true,true,true,true},true, false);
        battleShip[1] = new TbattleShip("/com/usr/resorcs/4horizontal.jpg", "/com/usr/resorcs/4vertical.jpg", addX, (addY*2) + 52, 0, 0, new boolean[] {true,true,true,true},true, false);
        battleShip[2] = new TbattleShip("/com/usr/resorcs/4horizontal.jpg", "/com/usr/resorcs/4vertical.jpg", addX, (addY*4) + 96, 0, 0, new boolean[] {true,true,true,true},true, false);
        battleShip[3] = new TbattleShip("/com/usr/resorcs/3horizontal.jpg", "/com/usr/resorcs/3vertical.jpg", addX, (addY*6) + 96+48, 0, 0, new boolean[] {true,true,true},true, false);
        battleShip[4] = new TbattleShip("/com/usr/resorcs/3horizontal.jpg", "/com/usr/resorcs/3vertical.jpg", addX, (addY*8) + 96+96, 0, 0, new boolean[] {true,true,true},true, false);
        battleShip[5] = new TbattleShip("/com/usr/resorcs/2horizontal.jpg", "/com/usr/resorcs/2vertical.jpg", addX, (addY*10) +48+ 96+96, 0, 0, new boolean[] {true,true},true, false);
        battleShip[6] = new TbattleShip("/com/usr/resorcs/2horizontal.jpg", "/com/usr/resorcs/2vertical.jpg", addX, (addY*12) +96+ 96+96, 0, 0, new boolean[] {true,true},true, false);
        battleShip[7] = new TbattleShip("/com/usr/resorcs/2horizontal.jpg", "/com/usr/resorcs/2vertical.jpg", addX, (addY*14) +48+96+ 96+96, 0, 0, new boolean[] {true,true},true, false);
        
    }
    private void showBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board1[i][j].paint(jpanel2.getGraphics());
            }
        }
        battleShip[0].paint(jpanel1.getGraphics());
    }
    //VarBox
    private JPanel jpanel1;
    private JPanel jpanel2;
    private Tbox board1[][];
    private final TbattleShip[] battleShip = new TbattleShip[8];
    private int mouseStatus;
    private boolean activeMouse;
    //VarBox
}
