package ru.cs.vsu.eliseev.cg;


import ru.cs.vsu.eliseev.cg.draw.IDrawer;
import ru.cs.vsu.eliseev.cg.draw.SimpleEdgeDrawer;
import ru.cs.vsu.eliseev.cg.math.Vector3;
import ru.cs.vsu.eliseev.cg.models.Helix3D;
import ru.cs.vsu.eliseev.cg.models.HelixLine;
import ru.cs.vsu.eliseev.cg.models.Parallelepiped;
import ru.cs.vsu.eliseev.cg.screen.ScreenConverter;
import ru.cs.vsu.eliseev.cg.third.Camera;
import ru.cs.vsu.eliseev.cg.third.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel
        implements CameraController.RepaintListener {
    private Scene scene;
    private ScreenConverter sc;
    private Camera cam;
    private CameraController camController;

    public DrawPanel() {
        super();
        sc = new ScreenConverter(-1, 1, 2, 2, 1, 1);
        cam = new Camera();
        camController = new CameraController(cam, sc);
        scene = new Scene(Color.WHITE.getRGB());
        scene.showAxes();

//        scene.getModelsList().add(new Parallelepiped(
//                new Vector3(-0.4f, -0.4f, -0.4f),
//                new Vector3(0.4f, 0.4f, 0.4f)
//        ));

//        scene.getModelsList().add(
//                new HelixLine(0.01f, 0.01f, 0, 100 * (float) Math.PI));
        //scene.getModelsList().add(
//                new Helix3D());
//        scene.getModelsList().add(new
//                Helix3D(1f, 1f, 1f, 2 * (float) Math.PI));
        scene.getModelsList().add(
                new Helix3D(3, 0.1, 0.5, 0.1));

        camController.addRepaintListener(this);
        addMouseListener(camController);
        addMouseMotionListener(camController);
        addMouseWheelListener(camController);
    }

    @Override
    public void paint(Graphics g) {
        sc.setScreenSize(getWidth(), getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) bi.getGraphics();
        IDrawer dr = new SimpleEdgeDrawer(sc, graphics);
        scene.drawScene(dr, cam);
        g.drawImage(bi, 0, 0, null);
        graphics.dispose();
    }

    @Override
    public void shouldRepaint() {
        repaint();
    }
}
