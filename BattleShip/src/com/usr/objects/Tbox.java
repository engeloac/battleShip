/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usr.objects;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author sirbobby
 */
public class Tbox{

    public Tbox(String directionHorizontal, int positionX, int positionY, int positionX1, int positionY1, boolean state) {
        this.directionHorizontal = directionHorizontal;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionX1 = positionX1;
        this.positionY1 = positionY1;
        this.state = state;
        this.imgHorizontal = new ImageIcon(new ImageIcon(getClass().getResource(directionHorizontal)).getImage());
    }

    public void paint(Graphics g) {
        g.drawImage(imgHorizontal.getImage(), positionX, positionY, 48, 48, null);
    }
    
    public String getDirection() {
        return directionHorizontal;
    }

    public void setDirection(String directionHorizontal) {
        this.directionHorizontal = directionHorizontal;
    }

    public ImageIcon getImgHorizontal() {
        return imgHorizontal;
    }

    public void setImgHorizontal(ImageIcon imgHorizontal) {
        this.imgHorizontal = imgHorizontal;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX1() {
        return positionX1;
    }

    public void setPositionX1(int positionX1) {
        this.positionX1 = positionX1;
    }

    public int getPositionY1() {
        return positionY1;
    }

    public void setPositionY1(int positionY1) {
        this.positionY1 = positionY1;
    }

    public boolean getState() {
        return state;
    }

    
    public void setState(boolean state) {
        this.state = state;
    }
    
    public String getDirectionHorizontal() {
        return directionHorizontal;
    }

    public void setDirectionHorizontal(String directionHorizontal) {
        this.directionHorizontal = directionHorizontal;
    }

    //VarBox
    private String directionHorizontal;
    private ImageIcon imgHorizontal;
    private int positionX;
    private int positionY;
    private int positionX1;
    private int positionY1;
    private boolean state;
    //VarBox
}