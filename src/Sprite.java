import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
    private Image image;
    private double asukohtX;
    private double asukohtY;
    private double kiirusX;
    private double kiirusY;
    private double laius;
    private double kõrgus;

    public Sprite(Image image, double asukohtX, double asukohtY, double laius, double kõrgus) {
        this.image = image;
        this.asukohtX = asukohtX;
        this.asukohtY = asukohtY;
        this.laius = laius;
        this.kõrgus = kõrgus;
    }

    public double getAsukohtX() {
        return asukohtX;
    }

    public void setAsukohtX(double asukohtX) {
        this.asukohtX = asukohtX;
    }

    public double getAsukohtY() {
        return asukohtY;
    }

    public void setAsukohtY(double asukohtY) {
        this.asukohtY = asukohtY;
    }

    public double getKiirusX() {
        return kiirusX;
    }

    public void setKiirusX(double kiirusX) {
        this.kiirusX = kiirusX;
    }

    public double getKiirusY() {
        return kiirusY;
    }

    public void setKiirusY(double kiirusY) {
        this.kiirusY = kiirusY;
    }

    public Rectangle2D getPiirid() {
        return new Rectangle2D(asukohtX, asukohtY, laius, kõrgus);
    }

    public void update(double aeg) {
        asukohtX += kiirusX * aeg;
        asukohtY += kiirusY * aeg;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, asukohtX, asukohtY);
    }

    public boolean intersects(Sprite s) {
        return s.getPiirid().intersects(this.getPiirid());
    }
}
