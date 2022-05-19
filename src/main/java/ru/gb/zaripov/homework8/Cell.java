package ru.gb.zaripov.homework8;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private boolean isFlagged;
    private final ImageIcon flag;
    private final ImageIcon grass;

    public Cell(int y, int x, int size) {
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

}
