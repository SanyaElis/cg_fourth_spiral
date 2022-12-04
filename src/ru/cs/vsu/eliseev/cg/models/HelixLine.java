package ru.cs.vsu.eliseev.cg.models;

import ru.cs.vsu.eliseev.cg.math.Vector3;
import ru.cs.vsu.eliseev.cg.third.IModel;
import ru.cs.vsu.eliseev.cg.third.PolyLine3D;

import java.util.LinkedList;
import java.util.List;

public class HelixLine implements IModel {
    private List<Vector3> points;

    public HelixLine(float a, float b, float from, float to) {
        points = new LinkedList<>();
        for (float t = from; t <= to;t += 0.1 ){
            double x = a * Math.cos(t);
            double y = a * Math.sin(t);
            double z = b * t;
            points.add(new Vector3((float) x, (float) y, (float) z));
        }
    }

    @Override
    public List<PolyLine3D> getLines() {
        List<PolyLine3D> lines = new LinkedList<>();
        lines.add(new PolyLine3D(points, false));
        return lines;
    }
}
