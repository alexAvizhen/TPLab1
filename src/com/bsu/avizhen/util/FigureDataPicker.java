package com.bsu.avizhen.util;

import com.bsu.avizhen.enums.FiguresEnum;
import com.bsu.avizhen.geom.*;
import com.bsu.avizhen.geom.Polygon;
import com.bsu.avizhen.geom.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by Александр on 12.03.2017.
 */
public class FigureDataPicker {
    private FiguresEnum currentFigure;

    private java.util.List<Point2D> points;
    private int amountOfSides;

    public FigureDataPicker(FiguresEnum currentFigure) {
        this.currentFigure = currentFigure;
        points = new ArrayList<>();
        resetParams();
    }

    public void provideActions(MouseEvent e) {
        switch (currentFigure) {
            case SEGMENT:
            case LINE:
            case RAY:
            case CIRCLE:
            case ELLIPSE:
            case TRIANGLE:
            case RECTANGLE:
                if (points.size() < 2) {
                    points.add(new Point(e.getX(), e.getY()));
                }
                return;
            case POLYGON:
            case REGULAR_POLYGON:
//            case SYMMETRIC_POLYGON:
                if (amountOfSides == -1) {
                    boolean isValidInput = false;
                    while (!isValidInput) {
                        String value = JOptionPane.showInputDialog("Enter number of sides: ");
                        try {
                            amountOfSides = Integer.valueOf(value);
                            if (amountOfSides > 0) {
                                isValidInput = true;
                            } else {
                                throw new NumberFormatException();
                            }
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null, "Invalid input");
                        }
                    }
                } else {
                    if (currentFigure.equals(FiguresEnum.REGULAR_POLYGON)) {
                        if (points.size() < 2) {
                            points.add(new Point(e.getX(), e.getY()));
                        }
                    } else {
                        if (currentFigure.equals(FiguresEnum.SYMMETRIC_POLYGON)) {
                            if (points.size() < (amountOfSides + 1) / 2) {
                                points.add(new Point(e.getX(), e.getY()));
                            }
                        } else {
                            if (points.size() < amountOfSides) {
                                points.add(new Point(e.getX(), e.getY()));
                            }
                        }
                    }
                }
                return;
            default:


        }
    }

    public boolean isFigureCanBeCreated() {
        switch (currentFigure) {
            case SEGMENT:
            case LINE:
            case RAY:
            case CIRCLE:
            case ELLIPSE:
            case RECTANGLE:
            case TRIANGLE:
                return points.size() >= 2;
            case POLYGON:
                return amountOfSides != -1 && points.size() >= amountOfSides;
            case REGULAR_POLYGON:
                return amountOfSides != -1 && points.size() >= 2;
            case SYMMETRIC_POLYGON:
                return amountOfSides != -1 && points.size() >= (amountOfSides + 1) / 2;
            default:
                return false;
        }
    }

    public Figure createFigure(Color color, Color backgroundColor) {
        if (!isFigureCanBeCreated()) {
            return null;
        }
        switch (currentFigure) {
            case SEGMENT:
                Segment segment = new Segment(points.get(0), points.get(1));
                segment.setLineColor(color);
                resetParams();
                return segment;
            case RAY:
                Ray ray = new Ray(points.get(0), points.get(1));
                ray.setLineColor(color);
                resetParams();
                return ray;
            case LINE:
                Line line = new Line(points.get(0), points.get(1));
                line.setLineColor(color);
                resetParams();
                return line;
            case CIRCLE:
                Circle circle = new Circle(points.get(0), points.get(1));
                circle.setLineColor(color);
                circle.setBgColor(backgroundColor);
                resetParams();
                return circle;
            case ELLIPSE:
                Ellipse ellipse = new Ellipse(points.get(0), points.get(1));
                ellipse.setLineColor(color);
                resetParams();
                return ellipse;
            case POLYGON:
                Polygon polygon = new Polygon(new ArrayList<>(points));
                polygon.setLineColor(color);
                polygon.setBgColor(backgroundColor);
                resetParams();
                return polygon;
            case REGULAR_POLYGON:
                RegularPolygon regularPolygon = new RegularPolygon(points.get(0), points.get(1), amountOfSides);
                regularPolygon.setLineColor(color);
                regularPolygon.setBgColor(backgroundColor);
                resetParams();
                return regularPolygon;
            case RECTANGLE:
                Rectangle rectangle = new Rectangle(points.get(0), points.get(1));
                rectangle.setLineColor(color);
                rectangle.setBgColor(backgroundColor);
                resetParams();
                return rectangle;
            case TRIANGLE:
                Triangle triangle = new Triangle(points.get(0), points.get(1));
                triangle.setLineColor(color);
                triangle.setBgColor(backgroundColor);
                resetParams();
                return triangle;
            default:
                return null;
        }
    }

    public void resetParams() {
        amountOfSides = -1;
        points.clear();
    }
}
