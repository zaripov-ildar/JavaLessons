package ru.gb.zaripov;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private boolean isFlagged;
    private final ImageIcon flag;
    private final ImageIcon grass;

    private final int X_COORDINATE;
    private final int Y_COORDINATE;


    public Cell(int y, int x, int size) {
        X_COORDINATE = x;
        Y_COORDINATE = y;
        flag = new ImageIcon("src/main/resources/flag.jpg");
        grass = new ImageIcon("src/main/resources/grass.jpg");
        this.setIcon(grass);
        isFlagged = false;
        this.setBounds(x, y, size, size);
        this.setPreferredSize(new Dimension(size, size));
    }


    public void setFlagged() {
        if (!isFlagged) {
            this.setIcon(flag);
        } else {
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
