import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
    private Image image;
    private Image imageParem;
    private double asukohtX;
    private double asukohtY;
    private double kiirusX;
    private double kiirusY;
    private double sihtX;
    private double sihtY;
    private double kiirus; // kiirusfaktor, mitte liikumiseks
    private double laius;
    private double kõrgus;

    public Sprite(String image, double asukohtX, double asukohtY, double laius, double kõrgus) {
        this.image = new Image(image + ".png");
        this.imageParem = new Image(image + "right.png");
        this.asukohtX = asukohtX;
        this.asukohtY = asukohtY;
        this.laius = laius;
        this.kõrgus = kõrgus;
        this.sihtX = asukohtX;
        this.sihtY = asukohtY;
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

    public double getSihtX() {
        return sihtX;
    }

    public double getSihtY() {
        return sihtY;
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
        if (Math.abs(asukohtX - sihtX + laius / 2) < kiirus / 30 && Math.abs(asukohtY - sihtY + kõrgus / 2) < kiirus / 30) {
            setKiirusX(0);
            setKiirusY(0);
        }
    }

    public void liigu(double sihtX, double sihtY, double kiirus) {
        double vahemaaX = sihtX - this.getAsukohtX() - laius / 2;
        double vahemaaY = sihtY - this.getAsukohtY() - laius / 2;
        double vahemaaFaktor = Math.sqrt(vahemaaX * vahemaaX + vahemaaY * vahemaaY);
        this.setKiirusX(vahemaaX / vahemaaFaktor * kiirus);
        this.setKiirusY(vahemaaY / vahemaaFaktor * kiirus);
        this.sihtX = sihtX;
        this.sihtY = sihtY;
        this.kiirus = kiirus;
    }

    public void render(GraphicsContext gc) {
        Image imagen = (getKiirusX() < 0) ? image : imageParem;
        gc.drawImage(imagen, asukohtX, asukohtY);
    }

    public boolean intersects(Sprite s) {
        return s.getPiirid().intersects(this.getPiirid());
    }
}