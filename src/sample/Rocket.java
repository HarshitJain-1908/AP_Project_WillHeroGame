package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Rocket extends Weapon {

    private TranslateTransition rocket;
    private ImageView img;
    private Image icon;
    public Rocket(){
        super("Rocket");
        rocket=new TranslateTransition();
        icon = new Image("Rocket.jpeg");
        img=new ImageView(icon);
        img.setFitWidth(100);
        img.setFitHeight(25);
    }
    @Override
    public void useWeapon(double x){
        img.setTranslateX(x);
        rocket.setNode(img);
        rocket.setDuration(Duration.millis(1000));
        rocket.setByX(150);
        rocket.play();

    }
}
