import javafx.scene.image.Image;

public class Player extends Sprite {
    public Player(double asukohtX, double asukohtY, double laius, double kõrgus) {
        super(new Image("Karjakoer.png"), asukohtX, asukohtY, laius, kõrgus);
    }
}
