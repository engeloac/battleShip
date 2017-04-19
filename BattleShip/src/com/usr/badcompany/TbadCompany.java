/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usr.badcompany;

import com.usr.objects.Tfleet;
import com.usr.objects.Tevents;
import com.usr.objects.Tpenny;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 *
 * @author sirbobby
 */
public class TbadCompany extends JFrame{
    //_iconstructor
    public TbadCompany() {
        initVariable();
        variableProperties();
        initBoard();
        initShip();
        tevent.showShip(tfleet, jpanel1);
        tevent.ShowBoard(Tboard, jpanel1);
    }
    //_imain
    public static void main(String[] args) {
        TbadCompany frame = new TbadCompany();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Batalla Naval");
        frame.setResizable(false);
    }
    //End _main
    //_ifunhod
    private void variableProperties() {
        setDefaultCloseOperation(3);
        setSize(1340, 611);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Batalla Naval");
        jpanel1.setBackground(new Color(46, 204, 113));
        jpanel1.setLayout(new AbsoluteLayout());
        jpanel1.setBounds(0, 0, 1340, 611);
        jpanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                //local VarBox
                Point point = jpanel1.getMousePosition();
                boolean addMouseCount = false;
                //local VarBox
                repaint();
                if (evt.getButton() == 1) mouseCount++;
                if (mouseCount == 1) {
                    if (tevent.checkBoardRange(jpanel1)) mouseCount = 0;
                    if (tevent.checkShipRange(point, tfleet) < 8) selectedShip = tevent.checkShipRange(point, tfleet);
                    if (evt.getButton() == 3) {
                        if (selectedShip < 8) {
                            tfleet[selectedShip].setOrientation(!tfleet[selectedShip].getOrientation());
                            if (tfleet[selectedShip].getOrientation()) {
                                tfleet[selectedShip].setImgHorizontalX(jpanel1.getMousePosition().x);
                                tfleet[selectedShip].setImgHorizontalY(jpanel1.getMousePosition().y);
                            }
                            else {
                                tfleet[selectedShip].setImgVerticalX(jpanel1.getMousePosition().x);
                                tfleet[selectedShip].setImgVerticalY(jpanel1.getMousePosition().y);
                            }
                        }
                        repaint();
                        tevent.showShip(tfleet, jpanel1);
                    }
                    if (tfleet[selectedShip].getOrientation()) {
                        if (point.x > tfleet[selectedShip].getImgHorizontalX()  && point.x <(tfleet[selectedShip].getImgHorizontalX() + tfleet[selectedShip].getImgHorizontalX1())) {
                            if (point.y > tfleet[selectedShip].getImgHorizontalY()  && point.y <(tfleet[selectedShip].getImgHorizontalY() + tfleet[selectedShip].getImgHorizontalY1())) {
                                clicked = true;
                            }
                        }
                    }
                    else {
                        if (point.x > tfleet[selectedShip].getImgVerticalX()  && point.x <(tfleet[selectedShip].getImgVerticalX() + tfleet[selectedShip].getImgVerticalX1())) {
                            if (point.y > tfleet[selectedShip].getImgVerticalY()  && point.y <(tfleet[selectedShip].getImgVerticalY() + tfleet[selectedShip].getImgVerticalY1())) {
                                clicked = true;
                            }
                        }
                    }
                }
                else {
                    if (mouseCount == 2) {
                        if (tevent.checkBoardRange(jpanel1)) {
                            if (clicked) {
                                tfleet[selectedShip] = tevent.setFleet(tfleet[selectedShip], Tboard, jpanel1);
                                tevent.ShowBoard(Tboard, jpanel1);
                                tevent.showShip(tfleet, jpanel1);
                                addMouseCount = false;
                            }
                        }
                        else {
                            mouseCount = 1;
                            addMouseCount = true;
                        }
                    }
                    if (!addMouseCount) {
                        mouseCount = 0;
                        clicked = false;
                    }
                }
            }
        });
        jpanel1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent evt) {
                if (clicked) {
                    if (tfleet[selectedShip].getOrientation()) {
                        tfleet[selectedShip].setImgHorizontalX(jpanel1.getMousePosition().x);
                        tfleet[selectedShip].setImgHorizontalY(jpanel1.getMousePosition().y);
                    }
                    else {
                        tfleet[selectedShip].setImgVerticalX(jpanel1.getMousePosition().x);
                        tfleet[selectedShip].setImgVerticalY(jpanel1.getMousePosition().y);
                    }
                }
                tevent.ShowBoard(Tboard, jpanel1);
                tevent.showShip(tfleet, jpanel1);      
            }
        });
        add(jpanel1);
    }
    //End _funhod
    //_iinit
    private void initShip() {
        //local VarBox
        int addX = 8;
        int addMargin = 2;
        //local VarBox
        tfleet[0] = new Tfleet("/com/usr/resorcs/5horizontal.jpg","/com/usr/resorcs/5vertical.jpg", 
                                        addX, (8 + addMargin), 0, 0,new boolean[] {true,true,true,true,true},true, false);
        tfleet[1] = new Tfleet("/com/usr/resorcs/4horizontal.jpg", "/com/usr/resorcs/4vertical.jpg", addX, (60 + addMargin), 20, 20, 
                                        new boolean[] {true,true,true,true},true, false);
        tfleet[2] = new Tfleet("/com/usr/resorcs/4horizontal.jpg", "/com/usr/resorcs/4vertical.jpg", addX, (112 + addMargin), 20, 20, 
                                        new boolean[] {true,true,true,true},true, false);
        tfleet[3] = new Tfleet("/com/usr/resorcs/3horizontal.jpg", "/com/usr/resorcs/3vertical.jpg", addX, (164 + addMargin), 20, 20, 
                                        new boolean[] {true,true,true},true, false);
        tfleet[4] = new Tfleet("/com/usr/resorcs/3horizontal.jpg", "/com/usr/resorcs/3vertical.jpg", addX, (216 + addMargin) , 20, 20, 
                                        new boolean[] {true,true,true},true, false);
        tfleet[5] = new Tfleet("/com/usr/resorcs/2horizontal.jpg", "/com/usr/resorcs/2vertical.jpg", addX, (268 + addMargin), 20, 20, 
                                        new boolean[] {true,true},true, false);
        tfleet[6] = new Tfleet("/com/usr/resorcs/2horizontal.jpg", "/com/usr/resorcs/2vertical.jpg", addX, (320 + addMargin), 20, 20, 
                                    new boolean[] {true,true},true, false);
        tfleet[7] = new Tfleet("/com/usr/resorcs/2horizontal.jpg", "/com/usr/resorcs/2vertical.jpg", addX, (372 + addMargin), 20, 20, 
                                    new boolean[] {true,true},true, false);   
    }
    
    private void initBoard() {
        //local VarBox
        int addX;
        int addY =10;
        //local VarBox
        for (int i = 0; i < 10; i++) {
            addX = 270;
            for (int j = 0; j < 10; j++) {
                Tboard[i][j] = new Tpenny("/com/usr/resorcs/water1.png", addX, addY, false,new boolean[] {true},false);
                addX += 52;
            }
            addY += 52;
        }
    }
        
    private void initVariable() {
        jpanel1 = new JPanel();
        Tboard = new Tpenny[10][10];
        tevent = new Tevents();
        mouseCount = 0;
        clicked = false;
        selectedShip = 20;
    }
    //End _init
    //_iVarBox
    private JPanel jpanel1;
    private Tpenny Tboard[][];
    private final Tfleet[] tfleet = new Tfleet[8];
    Tevents tevent;
    private int mouseCount;
    private boolean clicked;
    private int selectedShip;
    //End _VarBox
}