package com.robertocannella;

import java.awt.BorderLayout;               // Lays out a container. to fit in North South East West and Center
import java.awt.Graphics;                   // Abstract base class for all graphics (drawing)
import java.awt.Point;                      // For specifying point x,y axis
import java.awt.event.MouseAdapter;         // Receives mouse events (creating listener objects)
import java.awt.event.MouseEvent;           // Indicate mouse actions occurring in a particular component
import java.awt.event.MouseMotionAdapter;   // Receive mouse motion events
import java.awt.Graphics2D;

import javax.swing.*;

class graphics extends JPanel{

    private Point lastPoint;
    public graphics(){
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                lastPoint = new Point(e.getX(), e.getY());

            }

        });
        addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e){
                    Graphics g = getGraphics();
                    g.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());
                    g.dispose();
                }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Great Graphics Program");
        frame.getContentPane().add(new graphics(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

}
