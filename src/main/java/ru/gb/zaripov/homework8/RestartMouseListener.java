package ru.gb.zaripov.homework8;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RestartMouseListener implements MouseListener {
    private final Window w;
    private final JLayeredPane layeredPane;


    public RestartMouseListener(Window w, JLayeredPane layeredPane) {
        this.w = w;
        this.layeredPane = layeredPane;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        w.remove(layeredPane);
        w.initiateWindow();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
