package com.bsu.avizhen.ui;

import com.bsu.avizhen.enums.FiguresEnum;
import com.bsu.avizhen.util.FigureDataPicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Александр on 12.03.2017.
 */
public class MyFrame extends JFrame {
    private JToggleButton circleBtn = new JToggleButton("Circle");
    private JToggleButton lineBtn = new JToggleButton("Line");
    private JToggleButton segmentBtn = new JToggleButton("Segment");
    private JToggleButton rayBtn = new JToggleButton("Ray");
    private JToggleButton ellipseBtn = new JToggleButton("Ellipse");
    private JToggleButton polygonBtn = new JToggleButton("Polygon");
    private JToggleButton regularPolygonBtn = new JToggleButton("Regular polygon");
    //    private JToggleButton symmetricPolygonBtn = new JToggleButton("Symmetric polygon");
    private JToggleButton rectangleBtn = new JToggleButton("Rectangle");
    private JToggleButton triangleBtn = new JToggleButton("Triangle");
    private JButton selectLineColorBtn = new JButton("Line color");
    private JButton selectBackgroundColorBtn = new JButton("Background color");
    private ButtonGroup buttonGroup;

    private PaintFigureBtnListener commonListener = new PaintFigureBtnListener();

    private DrawPanel drawPanel = new DrawPanel();

    private JLabel helpLabel = new JLabel("Select figure");
    private JLabel currentLineColorLabel = new JLabel("Line");
    private JLabel currentBgColorLabel = new JLabel("Bg");

    private Color currentLineColor = Color.black;
    private Color currentBackgroundColor = Color.WHITE;
    {
        currentBgColorLabel.setForeground(currentBackgroundColor);
        currentLineColorLabel.setForeground(currentLineColor);
    }

    public MyFrame(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(circleBtn);
        buttonGroup.add(lineBtn);
        buttonGroup.add(segmentBtn);
        buttonGroup.add(rayBtn);
        buttonGroup.add(ellipseBtn);
        buttonGroup.add(polygonBtn);
        buttonGroup.add(regularPolygonBtn);
//        buttonGroup.add(symmetricPolygonBtn);
        buttonGroup.add(rectangleBtn);
        buttonGroup.add(triangleBtn);
        JPanel toolPanel = new JPanel(new FlowLayout());
        circleBtn.addActionListener(commonListener);
        toolPanel.add(circleBtn);
        lineBtn.addActionListener(commonListener);
        toolPanel.add(lineBtn);
        segmentBtn.addActionListener(commonListener);
        toolPanel.add(segmentBtn);
        rayBtn.addActionListener(commonListener);
        toolPanel.add(rayBtn);
        ellipseBtn.addActionListener(commonListener);
        toolPanel.add(ellipseBtn);
        polygonBtn.addActionListener(commonListener);
        toolPanel.add(polygonBtn);
        regularPolygonBtn.addActionListener(commonListener);
        toolPanel.add(regularPolygonBtn);
//        symmetricPolygonBtn.addActionListener(commonListener);
//        toolPanel.add(symmetricPolygonBtn);
        rectangleBtn.addActionListener(commonListener);
        toolPanel.add(rectangleBtn);
        triangleBtn.addActionListener(commonListener);
        toolPanel.add(triangleBtn);
        selectLineColorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentLineColor = JColorChooser.showDialog(MyFrame.this, "Select line color", currentLineColor);
                currentLineColorLabel.setForeground(currentLineColor);
            }
        });
        toolPanel.add(selectLineColorBtn);
        selectBackgroundColorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentBackgroundColor = JColorChooser.showDialog(MyFrame.this, "Select line color", currentBackgroundColor);
                currentBgColorLabel.setForeground(currentBackgroundColor);
            }
        });
        toolPanel.add(selectBackgroundColorBtn);
        toolPanel.add(currentLineColorLabel);
        toolPanel.add(currentBgColorLabel);
        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.clear();
                MyFrame.this.repaint();
            }
        });
        toolPanel.add(clearBtn);
        add(BorderLayout.NORTH, toolPanel);
        drawPanel.addMouseListener(commonListener);
        add(BorderLayout.CENTER, drawPanel);
        add(BorderLayout.SOUTH, helpLabel);

        setVisible(true);
    }

    //you should add this listener to buttons and paint panel
    private class PaintFigureBtnListener extends MouseAdapter implements ActionListener {
        private FiguresEnum currentFigure;
        private JToggleButton sourceButton;
        private FigureDataPicker dataPicker;

        private Map<FiguresEnum, String> helpMessages = new HashMap<>();

        {
            helpMessages.put(FiguresEnum.CIRCLE, "Select 2 points(center and on circle");
            helpMessages.put(FiguresEnum.LINE, "Select 2 points");
            helpMessages.put(FiguresEnum.POLYGON, "Select n points");
            helpMessages.put(FiguresEnum.RAY, "Select 2 points");
            helpMessages.put(FiguresEnum.REGULAR_POLYGON, "Select 2 points(center and angle");
            helpMessages.put(FiguresEnum.SEGMENT, "Select 2 points");
            helpMessages.put(FiguresEnum.ELLIPSE, "Select 2 points");
//            helpMessages.put(FiguresEnum.SYMMETRIC_POLYGON, "Select 2 points");
            helpMessages.put(FiguresEnum.RECTANGLE, "Select 2 points");
            helpMessages.put(FiguresEnum.TRIANGLE, "Select 2 points");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            sourceButton = (JToggleButton) e.getSource();
            currentFigure = FiguresEnum.getFigureByName(sourceButton.getText().toLowerCase());
            MyFrame.this.helpLabel.setText(helpMessages.get(currentFigure));
            dataPicker = new FigureDataPicker(currentFigure);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (buttonGroup.getSelection() != null) {
                dataPicker.provideActions(e);
                if (dataPicker.isFigureCanBeCreated()) {
                    drawPanel.addFigure(dataPicker.createFigure(currentLineColor, currentBackgroundColor));
//                    buttonGroup.clearSelection();
                    MyFrame.this.repaint();
                }
            }

        }


    }


}
