package ru.cs.vsu.eliseev.cg.models;

import ru.cs.vsu.eliseev.cg.math.Vector3;
import ru.cs.vsu.eliseev.cg.third.IModel;
import ru.cs.vsu.eliseev.cg.third.PolyLine3D;

import java.util.LinkedList;
import java.util.List;

public class Helix3D implements IModel {
    private List<Vector3> points = new LinkedList<>();

    public Helix3D() {

        for (double u = 0; u <= 2 *Math.PI;u += 0.05 ){
            for (double v = -Math.PI; v <=  Math.PI;v += 0.05 ){
                double x = Math.cos(u) * (Math.cos(v) + 3);
                double y= Math.sin(u)* (Math.cos(v) + 3);
                double z=Math.sin(v)+u;
                points.add(new Vector3((float) x, (float) y, (float) z));
            }
        }
    }

    public Helix3D(float a, float radius, float thickness, float w) {
        for (double u = 0; u <= 2 * Math.PI; u += 0.05) {
            for (double v = -Math.PI; v <=  Math.PI;v += 0.05 ){
                double x = Math.cos(u) * (thickness * Math.cos(v) + radius);
                double y = Math.sin(u) * (thickness * Math.cos(v) + radius);
                double z = Math.sin(v) + a * u;
                points.add(new Vector3((float) x, (float) y, (float) z));
            }
        }
    }

    public Helix3D(int numberOfLoops, double a, double r, double h){
        double d = Math.sqrt(r * r + h * h);
        for (double t = 0; t <= 2 * numberOfLoops * Math.PI; t += 0.03){
            for (double u = 0; u <= 2 * Math.PI; u += 0.03) {
                double x = h * t + (r * a * Math.sin(u)) / d;
                double y = r * Math.cos(t) - a * Math.cos(t) * Math.cos(u) + (h * a * Math.sin(t) * Math.sin(u)) / d;
                double z = r * Math.sin(t) - a * Math.sin(t) * Math.cos(u) - (h * a * Math.cos(t) * Math.sin(u)) / d;
                points.add(new Vector3((float) x, (float) y, (float) z));
            }
        }
    }
    @Override
    public List<PolyLine3D> getLines() {
        List<PolyLine3D> lines = new LinkedList<>();
        lines.add(new PolyLine3D(points, false));
        return lines;
    }
}
