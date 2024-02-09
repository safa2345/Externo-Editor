package Component;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MyImageView extends ImageView {

    public MyImageView(Image image) {
        this.setFitHeight(20);
        this.setFitWidth(20);
        this.setImage(image);
    }
}
