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
        initVariable();
        variableProperties();
        userInterface();
        initBoard();
        initShip();
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
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Batalla Naval");
        
        jpanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                mouseDo(evt);
            }
        });
        jpanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mouseDoMove(evt);
            }
        });
        
        add(jpanel2);
    }
    
    private void initVariable() {
        jpanel2 = new JPanel();
        board1 = new Tbox[10][10];
        mouseStatus = 0;
        activeMouse = false;
    }
    
    private void variableProperties() {
        jpanel2.setBackground(new Color(46, 204, 113));
        jpanel2.setLayout(new AbsoluteLayout());
        jpanel2.setBounds(0, 0, 1040, 611);
    }
    
    private void mouseDo(MouseEvent evt) {
        if (checkShipRange() < 8) {
            activeMouse = true;
            mouseStatus++;
        }
        else {
            activeMouse = false;
        }
        if (evt.getButton()==3) {
            System.out.println("asdfasdfasdfasdf");
        }
        showElements();
    }
    
    private void mouseDoMove(MouseEvent evt) {
        //local VarBox
        int battleShipePosition;
        Point point = jpanel2.getMousePosition();
        //local VarBox
        if (activeMouse) {
                    System.out.println("Voy a arrastrar");
                    if (mouseStatus < 2) {
                        battleShipePosition = checkShipRange();
                        if ( battleShip[battleShipePosition].getOrientation()) {
                            battleShip[battleShipePosition].setImgHorizontalX(point.x);
                            battleShip[battleShipePosition].setImgHorizontalY(point.y);
                            showElements();
                            
                        }
                        else {
                            battleShip[battleShipePosition].setImgVerticalX(point.x);
                            battleShip[battleShipePosition].setImgVerticalY(point.y);
                        }
                    }
                    else {
                        mouseStatus = 0;
                    }
                }
    }
    
    private boolean checkBoardRange() {
        //local VarBox
        Point point = jpanel2.getMousePosition();
        boolean inRange = false;
        //local VarBox
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (point.x > board1[i][j].getImgHorizontalX() && point.x < board1[i][j].getImgHorizontalX1()) {
                    if (point.y > board1[i][j].getImgHorizontalY() && point.y < board1[i][j].getImgHorizontalY1()) {
                        inRange = true;
                    }
                }
            }
        }
        return inRange;
    }
    
    private int checkShipRange() {
        //local VarBox
        int inRange = 20;
        Point point = jpanel2.getMousePosition();
        //local VarBox
        for (int i = 0; i < 8; i++) {
            if (point.x > battleShip[i].getImgHorizontalX() && point.x < battleShip[i].getImgHorizontalX1()) {
                if (point.y > battleShip[i].getImgHorizontalY() && point.y < battleShip[i].getImgHorizontalY1()) {
                   inRange = i;
                }
            }
        }
        return inRange;
    }
    
    private void showElements() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board1[i][j].paint(jpanel2.getGraphics());
            }
        }
        for (int i = 0; i < 8; i++) {
            battleShip[i].paint(jpanel2.getGraphics());
        }
    }
    
    private void initShip() {
        //local VarBox
        int addX = 8;
        int addY = 8;
        int addMargin = 2;
        //local VarBox
        battleShip[0] = new TbattleShip("/com/usr/resorcs/5horizontal.jpg","/com/usr/resorcs/2vertical.jpg", 
                                        addX, (8 + addMargin), 0, 0,new boolean[] {true,true,true,true,true},true, false);
        battleShip[1] = new TbattleShip("/com/usr/resorcs/4horizontal.jpg", "/com/usr/resorcs/4vertical.jpg", addX, (60 + addMargin), 0, 0, 
                                        new boolean[] {true,true,true,true},true, false);
        battleShip[2] = new TbattleShip("/com/usr/resorcs/4horizontal.jpg", "/com/usr/resorcs/4vertical.jpg", addX, (112 + addMargin), 0, 0, 
                                        new boolean[] {true,true,true,true},true, false);
        battleShip[3] = new TbattleShip("/com/usr/resorcs/3horizontal.jpg", "/com/usr/resorcs/3vertical.jpg", addX, (164 + addMargin), 0, 0, 
                                        new boolean[] {true,true,true},true, false);
        battleShip[4] = new TbattleShip("/com/usr/resorcs/3horizontal.jpg", "/com/usr/resorcs/3vertical.jpg", addX, (216 + addMargin) , 0, 0, 
                                        new boolean[] {true,true,true},true, false);
        battleShip[5] = new TbattleShip("/com/usr/resorcs/2horizontal.jpg", "/com/usr/resorcs/2vertical.jpg", addX, (268 + addMargin), 0, 0, 
                                        new boolean[] {true,true},true, false);
        battleShip[6] = new TbattleShip("/com/usr/resorcs/2horizontal.jpg", "/com/usr/resorcs/2vertical.jpg", addX, (320 + addMargin), 0, 0, 
                                    new boolean[] {true,true},true, false);
        battleShip[7] = new TbattleShip("/com/usr/resorcs/2horizontal.jpg", "/com/usr/resorcs/2vertical.jpg", addX, (372 + addMargin), 0, 0, 
                                    new boolean[] {true,true},true, false);   
    }
    
    private void initBoard() {
        //local VarBox
        int addX;
        int addY =10;
        //local VarBox
        for (int i = 0; i < 10; i++) {
            addX = 310;
            
            for (int j = 0; j < 10; j++) {
                board1[i][j] = new Tbox("/com/usr/resorcs/water1.png", addX, addY, false,new boolean[] {true});
                addX += 52;
            }
            addY += 52;
        }
    } 
    //VarBox
    private JPanel jpanel2;
    //private JPanel jpanel2;
    private Tbox board1[][];
    private final TbattleShip[] battleShip = new TbattleShip[8];
    private int mouseStatus;
    private boolean activeMouse;
    //VarBox
}
