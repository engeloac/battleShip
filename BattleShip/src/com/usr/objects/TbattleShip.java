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
public class TbattleShip extends Tbox{
    
    public TbattleShip(String direction, String direction1, int imgHorizontalX, int imgHorizontalY,
                                                            int imgVerticalX, int imgVerticalY,boolean [] sizeBox,boolean orientation, 
                                                            boolean state) {
        super(direction, imgHorizontalX, imgHorizontalY, state,sizeBox);
        this.direction1 = direction1;
        this.orientation = orientation;
        this.imgVertical = new ImageIcon(new ImageIcon(getClass().getResource(direction1)).getImage());
        this.imgVerticalX = imgVerticalX;
        this.imgVerticalY = imgVerticalY;

        this.imgVerticalX1 = this.imgVerticalX + 48;
        this.imgVerticalY1 = this.imgVerticalY + (48*getSizeBox().length);
    }
    @Override
    public void paint(Graphics g) {
        if (orientation) g.drawImage(getImgHorizontal().getImage(), getImgHorizontalX(), getImgHorizontalY(),
                                    this.imgVerticalX + (48*getSizeBox().length), 48, null);
        else {
            g.drawImage(getImgHorizontal().getImage(), getImgHorizontalX(), getImgHorizontalY(),
                                    48, this.imgVerticalY + (48*getSizeBox().length), null);
        }
    }
    //----------------------------------------------------------------------------
    
    public String getDirection1() {
        return direction1;
    }

    public void setDirection1(String direction1) {
        this.direction1 = direction1;
    }

    public ImageIcon getImgVertical() {
        return imgVertical;
    }
    public void setImgVertical(ImageIcon imgVertical) {
            this.imgVertical = imgVertical;
    }
    
    public boolean getOrientation() {
        return orientation;
    }

    public void setOrientation(boolean orientation) {
        this.orientation = orientation;
    }

    public int getImgVerticalX() {
        return imgVerticalX;
    }

    public void setImgVerticalX(int imgVerticalX) {
        this.imgVerticalX = imgVerticalX;
    }

    public int getImgVerticalY() {
        return imgVerticalY;
    }

    public void setImgVerticalY(int imgVerticalY) {
        this.imgVerticalY = imgVerticalY;
    }

    public int getImgVerticalX1() {
        return imgVerticalX1;
    }

    public void setImgVerticalX1(int imgVerticalX1) {
        this.imgVerticalX1 = imgVerticalX1;
    }

    public int getImgVerticalY1() {
        return imgVerticalY1;
    }

    public void setImgVerticalY1(int imgVerticalY1) {
        this.imgVerticalY1 = imgVerticalY1;
    }
    
    //VarBox 
    private boolean orientation;
    private String direction1;
    private ImageIcon imgVertical;
    private int imgVerticalX;
    private int imgVerticalY;
    private int imgVerticalX1;
    private int imgVerticalY1;
    //VarBox
}
