package application;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Data;
import model.MyListener;
import static utility.Format.*;
import static utility.TemperatureIconMapper.*;

public class ItemController {

    @FXML
    private VBox containerItem;

    @FXML
    private ImageView img;

    @FXML
    private Label cityNameLabel;

    @FXML
    private Label dateLabel;

    @FXML
    void click(MouseEvent event) {
        myListener.onClickListener(data);
    }

    private Data data;
    private MyListener myListener;

    public Data getFruit() {
        return data;
    }

    public void setFruit(Data data) {
        this.data = data;
    }

    public MyListener getMyListener() {
        return myListener;
    }

    public void setMyListener(MyListener myListener) {
        this.myListener = myListener;
    }

    public void setData(Data data, MyListener myListener) {
        this.setFruit(data);
        this.setMyListener(myListener);
        cityNameLabel.setText(data.getCity().getName());
        dateLabel.setText(formatDate(data.getDt()));
        Image image = new Image(getClass().getResourceAsStream(getIconForTemperature(data.getTemp().getDay(), "Kelvin")));
        
        img.setImage(image);
        Color rgbColor = Color.rgb(255, 255, 255); 
	    Lighting lighting = new Lighting();
	    lighting.setLight(new Light.Distant(45, 45, rgbColor)); 
	    lighting.setSurfaceScale(5.0); 
        img.setEffect(lighting);
    }

    public void setSelected(boolean selected) {
        if (selected) {
            containerItem.getStyleClass().add("selected-item"); 
            
        } else {
            containerItem.getStyleClass().remove("selected-item"); 
        }
    }
}
