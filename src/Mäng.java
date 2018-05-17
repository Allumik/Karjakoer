import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Mäng extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        int lammasteKogus = loeLammasteKogus();
        long algusHetk = (System.currentTimeMillis() / 1000);

        Group juur = new Group();

        Canvas lõuend = new Canvas(500, 500);

        List<Sprite> loomad = new ArrayList<>();

        Player karjakoer = new Player(250, 400, 20, 20);

        loomad.add(karjakoer);

        List<Sprite> lambad = new ArrayList<>();

        for (int i = 0; i < lammasteKogus; i++) {
            while (true) {
                try {
                    Lammas lammas = new Lammas(Math.random() * 480, Math.random() * 480, 20, 20);
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

        steen.setOnMouseMoved(event -> {
            karjakoer.liigu(event.getX(), event.getY(), 200);
        });

        steen.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.SPACE)) {
                for (Sprite lammas : lambad) {
                    double vahemaaX = lammas.getAsukohtX() - karjakoer.getAsukohtX();
                    double vahemaaY = lammas.getAsukohtY() - karjakoer.getAsukohtY();
                    double kaugus = Math.sqrt(vahemaaX * vahemaaX + vahemaaY * vahemaaY);
                    if (kaugus < 100) {
                        lammas.liigu(lammas.getAsukohtX() + ((vahemaaX / kaugus) * 50), lammas.getAsukohtY() + ((vahemaaY / kaugus) * 50), 20);
                    }
                }
            }
        });

        primaryStage.setTitle("Vajuta tühik, et haukuda");

        primaryStage.setScene(steen);

        new AnimationTimer() {
            double lastNanoTime = System.nanoTime();

            public void handle(long currentNanoTime) {
                double möödunudAeg = (currentNanoTime - lastNanoTime) / 1000000000.0;
                lastNanoTime = currentNanoTime;

                gc.setFill(Color.GREEN);
                gc.fillRect(0, 0, 500, 500);

                gc.setFill(Color.YELLOWGREEN);
                gc.fillRect(150, 50, 200, 100);

                int lambadRuudus = 0;
                for (Sprite lammas : lambad) {
                    if (lammas.getKiirusX() == 0 && lammas.getKiirusY() == 0) {
                        lammas.liigu(lammas.getAsukohtX() - 75 + Math.random() * 150, lammas.getAsukohtY() - 75 + Math.random() * 150, 2 + Math.random() * 10);
                    }
                    if (150 < lammas.getAsukohtX() + 10
                            && lammas.getAsukohtX() + 10 < 350
                            && 50 < lammas.getAsukohtY() + 10
                            && lammas.getAsukohtY() + 10 < 150) {
                        lambadRuudus += 1;
                    }
                }

                if (lambadRuudus == lammasteKogus) {
                    try { // ei ole õrna aimugi kuidas õige lahendus sellele erindile välja nägema peaks.
                        logi("Mängu kestus : " + ((System.currentTimeMillis() / 1000) - algusHetk) + " Raskusel : " + lammasteKogus);
                    } catch (FileNotFoundException | UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    primaryStage.close();
                }

                for (Sprite loom : loomad) {
                    if (0 > loom.getSihtX()
                            || loom.getSihtX() > lõuend.getWidth()
                            || 0 > loom.getSihtY()
                            || loom.getSihtY() > lõuend.getHeight()) {
                        loom.setKiirusX(0);
                        loom.setKiirusY(0);
                    }
                    loom.update(möödunudAeg);
                    loom.render(gc);
                }
            }
        }.start();

        primaryStage.show();

    }

    private static void logi(String sõnum) throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("WinLog.txt", true), "UTF-8")))) {
            out.println(sõnum);
        }
    }

    private static int loeLammasteKogus() throws IOException {
        int lammasteKogus;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Config.txt"), "UTF-8"))) {
            br.readLine();
            lammasteKogus = Integer.parseInt(br.readLine());
        }
        return lammasteKogus;
    }

}
