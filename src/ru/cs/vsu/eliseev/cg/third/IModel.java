package ru.cs.vsu.eliseev.cg.third;

import java.util.List;

/**
 * Описывает в общем виде любую модель
 */
public interface IModel {
    /**
     * Любая модель - это набор полилиний.
     * @return Список полилиний модели.
     */
    List<PolyLine3D> getLines();
}
