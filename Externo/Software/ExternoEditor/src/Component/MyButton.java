package Component;

import javafx.scene.control.Button;

public class MyButton extends Button {

    public MyButton(MyImageView myImageView){
        this.setGraphic(myImageView);
    }


}
