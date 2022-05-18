package ru.gb.zaripov;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cell extends JButton {
    private final int size;
    private boolean isFlagged;
    private final ImageIcon flag;
    private final ImageIcon grass;

    private final int X_COORDINATE;
    private final int Y_COORDINATE;


    public Cell(int y, int x, int size) {
//        ImageIcon flag1;
//        BufferedImage image;
//        try {
//            image = ImageIO.read(new File("src/main/resources/red-flag.png"));
//            flag1 = new ImageIcon("src/main/resources/red-flag.png");
//        } catch (IOException e) {
//            e.printStackTrace();
//            flag1 = new ImageIcon();
//        }
        X_COORDINATE = x;
        Y_COORDINATE = y;
        flag = new ImageIcon("src/main/resources/flag.jpg");
        grass = new ImageIcon("src/main/resources/grass.jpg");
        this.setIcon(grass);
        isFlagged = false;
        this.size = size;
        this.setBounds(x,y,size,size);
        this.setPreferredSize(new Dimension(size,size));
    }


    public void setFlagged() {
        if (!isFlagged) {
            this.setIcon(flag);
        }
        else {
            this.setIcon(grass);
        }
        this.setContentAreaFilled(false);

        isFlagged = !isFlagged;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public int getX_COORDINATE() {
        return X_COORDINATE;
    }

    public int getY_COORDINATE() {
        return Y_COORDINATE;
    }
}
