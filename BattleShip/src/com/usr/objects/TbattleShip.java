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
    
    public TbattleShip(String direction, String direction1, int positionX, int positionY, int positionX1, int positionY1,boolean [] battleShipSize,boolean orientation, boolean state) {
        super(direction, positionX, positionY, positionX*battleShipSize.length, positionY1, state);
        this.battleShipeSize = battleShipSize;
        this.direction1 = direction1;
        this.orientation = orientation;
        this.imgVertical = new ImageIcon(new ImageIcon(getClass().getResource(direction1)).getImage());
    }
    @Override
    public void paint(Graphics g) {
        if (orientation) g.drawImage(getImgHorizontal().getImage(), getPositionX(), getPositionY(), 48*battleShipeSize.length, 48, null);
    }
    //----------------------------------------------------------------------------
    public boolean[] getBattleShipeSize() {
        return battleShipeSize;
    }

    public void setBattleShipeSize(boolean[] battleShipeSize) {
        this.battleShipeSize = battleShipeSize;
    }

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
    
    public boolean isOrientation() {
        return orientation;
    }

    public void setOrientation(boolean orientation) {
        this.orientation = orientation;
    }
    //VarBox 
    private boolean[] battleShipeSize;
    private String direction1;
    private ImageIcon imgVertical;
    private boolean orientation;
    //VarBox

    
}
