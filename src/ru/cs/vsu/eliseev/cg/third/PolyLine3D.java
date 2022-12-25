package ru.cs.vsu.eliseev.cg.third;


import ru.cs.vsu.eliseev.cg.math.Vector3;

import java.awt.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Полилиния в трёхмерном пространстве.
 * Описывает ломанную в трёхмерном пространстве по опорным точкам
 */
public class PolyLine3D {
    private List<Vector3> points;
    private boolean closed;
    private Color color;

    /**
     * Создаёт новую полилинию на основе трёхмерных точек.
     * @param points список точек-вершин ломанной
     * @param closed признак замкнутостит линии
     */
    public PolyLine3D(Collection<Vector3> points, boolean closed) {
        this.points = new LinkedList<>(points);
        this.closed = closed;
        this.color = Color.BLACK;
    }


    public PolyLine3D(Collection<Vector3> points, boolean closed, Color color){
        this.points = new LinkedList<>(points);
        this.closed = closed;
        this.color = color;
    }
    /**
     * Признак закрытости
     * @return возвращает истину, если линия замкнута, иначе - ложь.
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * Список вершин линии
     * @return возвращает список точек.
     */
    public List<Vector3> getPoints() {
        return points;
    }
    
    /**
     * Вычисляет среднее арифметическое по оси Z.
     * @return среднее по Z для полилинии.
     */
    public float avgZ() {
        if (points == null || points.size() == 0)
            return 0;
        float sum = 0;
        for (Vector3 v : points)
            sum += v.getZ();
        return sum / points.size();
    }

    public Color getColor() {
        return color;
    }
}
