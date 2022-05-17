package ru.gb.zaripov;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlaggingMouseAdapter extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        Cell button = (Cell) e.getSource();
        if (e.getButton() == MouseEvent.BUTTON1)
            button.setVisible(false);
        else if (e.getButton() == MouseEvent.BUTTON3)
            button.setFlagged();
    }
}
