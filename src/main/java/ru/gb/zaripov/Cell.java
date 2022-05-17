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


    public Cell(int x, int y, int size) {
//        ImageIcon flag1;
//        BufferedImage image;
//        try {
//            image = ImageIO.read(new File("src/main/resources/red-flag.png"));
//            flag1 = new ImageIcon("src/main/resources/red-flag.png");
//        } catch (IOException e) {
//            e.printStackTrace();
//            flag1 = new ImageIcon();
//        }

        flag = new ImageIcon("src/main/resources/flag.jpg");
        grass = new ImageIcon("src/main/resources/grass.jpg");
        this.setIcon(grass);
        isFlagged = false;
        this.size = size;
        this.setBackground(Color.GRAY);
        this.setBounds(x,y,x+size,y+size);
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
}
