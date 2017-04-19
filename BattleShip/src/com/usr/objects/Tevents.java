/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usr.objects;

import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author sirbobby
 */
public class Tevents {
    public Tevents() {
        System.out.println("Tevents iniciado");
    }
    public static void main(String[] args) {
        System.out.println("com.usr.objects.Tevents.main()");
    }
    public void events(JPanel panel) {

    }
    public int checkShipRange(Point point, Tfleet[] tfleet) {
        //local VarBox
        int inRange = 20;
        //local VarBox
        for (int i = 0; i < 8; i++) {
            if (tfleet[i].getOrientation()) {
                if (point.x >= tfleet[i].getImgHorizontalX() && point.x <= (tfleet[i].getImgHorizontalX() + tfleet[i].getImgHorizontalX1())) {
                    if (point.y >= tfleet[i].getImgHorizontalY() && point.y <= (tfleet[i].getImgHorizontalY() + tfleet[i].getImgHorizontalY1())) {
                        inRange = i;
                    }
                }
            }
            else {
                if (point.x > tfleet[i].getImgVerticalX() && point.x < (tfleet[i].getImgVerticalX() + tfleet[i].getImgVerticalX1())) {
                    if (point.y > tfleet[i].getImgVerticalY() && point.y < (tfleet[i].getImgVerticalY() + tfleet[i].getImgVerticalY1())) {
                        inRange = i;
                    }
                }
            }
        }
        return inRange;
    }
    
    public Tfleet setFleet(Tfleet tfleet, Tpenny[][] tpenny,JPanel jpanel) {
        //local VarBox
        int[][] penny = new int[1][2];
        penny = checkPennyRange(jpanel, tpenny);
        //local VarBox
        if (penny[0][1] >= 0){
            if (tfleet.getOrientation()) {
                tfleet.setImgHorizontalX(tpenny[penny[0][0]][penny[0][1]].getImgHorizontalX());
                tfleet.setImgHorizontalY(tpenny[penny[0][0]][penny[0][1]].getImgHorizontalY());
            }
            else {
                tfleet.setImgVerticalX(tpenny[penny[0][0]][penny[0][1]].getImgHorizontalX());
                tfleet.setImgVerticalY(tpenny[penny[0][0]][penny[0][1]].getImgHorizontalY());
            }
        }
        return tfleet;
    }
    
    public int[][] checkPennyRange(JPanel jpanel, Tpenny[][] tboard) {
        //local VarBox
        Point point = jpanel.getMousePosition();
        int[][] penny = new int[1][2];
        penny[0][0] = -1;
        penny[0][1] = -1;
        //local VarBox
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (point.x > tboard[i][j].getImgHorizontalX() && point.x < (tboard[i][j].getImgHorizontalX()+tboard[i][j].getImgHorizontalX1())) {
                    if (point.y > tboard[i][j].getImgHorizontalY() && point.y < (tboard[i][j].getImgHorizontalY() + tboard[i][j].getImgHorizontalY1())) {
                        penny[0][0] = i;
                        penny[0][1] = j;
                    }
                }
            }
        }
        return penny;
    }
    
    public boolean checkBoardRange(JPanel jpanel) {
        Point point = jpanel.getMousePosition();
        if ((point.x > 311 && point.x < 829)&&(point.y > 11 && point.y < 528)) return true;
        else return false;
    }
    public Tfleet[] axys(Tfleet[] battleShip) {
    	return battleShip;
    }
    public void ShowBoard(Tpenny[][] tboard, JPanel jpanel) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tboard[i][j].paint(jpanel.getGraphics());
            }
        } 
    }
    
    public void showShip(Tfleet[] tbattleShip, JPanel jpanel) {
        for (int i = 0; i < 8; i++) {
            tbattleShip[i].paint(jpanel.getGraphics());
        }
    }
}
