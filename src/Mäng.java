import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Mäng extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group juur = new Group();

        Canvas lõuend = new Canvas(500, 500);

        List<Sprite> loomad = new ArrayList<>();

        Player karjakoer = new Player(250, 400, 20, 20);

        loomad.add(karjakoer);

        List<Sprite> lambad = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            while (true) {
                try {
                    Lammas lammas = new Lammas(Math.random() * 500, Math.random() * 500, 20, 20);
                    for (Sprite loom : loomad) {
                        if (loom.intersects(lammas)) {
                            throw new LoomEeesErind("");
                        }
                    }
                    lambad.add(lammas);
                    loomad.add(lammas);
                    break;
                } catch (LoomEeesErind ignored) {
                }
            }
        }

        GraphicsContext gc = lõuend.getGraphicsContext2D();

        juur.getChildren().add(lõuend);

        Scene steen = new Scene(juur, 500, 500);

        primaryStage.setScene(steen);

        new AnimationTimer() {
            double lastNanoTime = System.nanoTime();

            public void handle(long currentNanoTime) {
                double möödunudAeg = (currentNanoTime - lastNanoTime) / 1000000000.0;
                lastNanoTime = currentNanoTime;

                gc.setFill(Color.GREEN);
                gc.fillRect(0, 0, 500, 500);

                for (Sprite loom : loomad) {
                    loom.update(möödunudAeg);
                    loom.render(gc);
                }
            }
        }.start();

        primaryStage.show();

    }
}
