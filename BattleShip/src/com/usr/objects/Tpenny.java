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
public class Tpenny{

    public Tpenny(String directionHorizontal, int positionX, int positionY, boolean state,boolean [] sizeBox,boolean underFleet) {
        this.directionHorizontal = directionHorizontal;
        this.imgHorizontal = new ImageIcon(new ImageIcon(getClass().getResource(directionHorizontal)).getImage());
        this.imgHorizontalX = positionX;
        this.imgHorizontalY = positionY;
        this.sizeBox = sizeBox;
        this.imgHorizontalX1 = (48*this.sizeBox.length);
        this.imgHorizontalY1 = 48;
        this.underFleet = underFleet;
    }
    
    public static void main(String[] args) {
        System.out.println("com.usr.objects.Tbox.main()");
    }
    public void paint(Graphics g) {
        g.drawImage(imgHorizontal.getImage(), this.imgHorizontalX, this.imgHorizontalY, 
                this.imgHorizontalX1, this.imgHorizontalY1, null);
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

    public int getImgHorizontalX() {
        return imgHorizontalX;
    }

    public void setImgHorizontalX(int imgHorizontalX) {
        this.imgHorizontalX = imgHorizontalX;
    }

    public int getImgHorizontalY() {
        return imgHorizontalY;
    }

    public void setImgHorizontalY(int imgHorizontalY) {
        this.imgHorizontalY = imgHorizontalY;
    }

    public int getImgHorizontalX1() {
        return imgHorizontalX1;
    }

    public void setImgHorizontalX1(int imgHorizontalX1) {
        this.imgHorizontalX1 = imgHorizontalX1;
    }

    public int getImgHorizontalY1() {
        return imgHorizontalY1;
    }

    public void setImgHorizontalY1(int imgHorizontalY1) {
        this.imgHorizontalY1 = imgHorizontalY1;
    }
    
    public String getDirectionHorizontal() {
        return directionHorizontal;
    }

    public void setDirectionHorizontal(String directionHorizontal) {
        this.directionHorizontal = directionHorizontal;
    }
    
    public boolean[] getSizeBox() {
        return sizeBox;
    }

    public void setSizeBox(boolean[] sizeBox) {
        this.sizeBox = sizeBox;
    }
    
    public boolean isUnderFleet() {
        return underFleet;
    }

    public void setUnderFleet(boolean underFleet) {
        this.underFleet = underFleet;
    }
    //VarBox
    private String directionHorizontal;
    private ImageIcon imgHorizontal;
    private int imgHorizontalX;
    private int imgHorizontalY;
    private int imgHorizontalX1;
    private int imgHorizontalY1;
    private boolean[] sizeBox;
    private boolean underFleet;
    //VarBox
}