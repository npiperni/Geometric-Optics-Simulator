package view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class AboutView extends GridPane {

    private final Label heading = new Label("This Program Simulates the Refraction of Light Through Lenses");

    private final Label p1 = new Label("Light rays refract when they strike a lens. There are two types of lenses,\n" +
            "converging and diverging. For converging lenses, the focal point is on\n" +
            "the right side and for diverging it is on the left side (the focal distance\n" +
            "is negative). For converging lenses, all parallel light rays refract and\n" +
            "converge at the focal point. In diverging lenses, all parallel rays diverge\n" +
            "but can be traced back to the focal point.");

    private final Label p2 = new Label("Light rays passing through the center will not refract and light rays aimed\n" +
            "at the secondary focal point will refract to become parallel. When light\n" +
            "rays converge, a real image is formed, seen here. If the light rays don't\n" +
            "converge, but can be traced back and converge on the other side of the lens,\n" +
            "a virtual image is formed. Diverging lenses always form virtual images and a\n" +
            "converging lens can form a virtual image if the object is positioned within\n" +
            "the focal length.");

    private final Label subHeading = new Label("How To Use This Program");

    private final Label subHeading1 = new Label("Setting Data and Animating");

    private final Label p3 = new Label("Go to File > Settings. Under the 'Data Input' tab some sample data is provided. To add your own, enter the values for the object distance,\n" +
            "object height, focal length and type of lens. Then click the 'ADD' button. Your entry will be saved in the table. Entries can be removed using\n" +
            "the corresponding 'DELETE' button. When you are ready to see the animation, select an entry using its corresponding button on the left and\n" +
            "close the settings tab. Then go to File > Play.\n" +
            "* It should be noted that the inputted values for object distance and focal length should not be negative. While diverging lenses use a\n" +
            "negative value for focal length, this is accounted for when the type of lens is chosen. Also note that an object exactly at the focal\n" +
            "point will not produce an image due to the rays never converging.");

    private final Label subHeading2 = new Label("Changing Theme");

    private final Label p4 = new Label("To change the them go to File > Settings and go to the 'Theme' tab. Select the desired theme from the options available. Note that the selected\n" +
            "theme will apply to the main window once the Settings window is closed.");

    private final Label subHeading3 = new Label("Import Data From Another File");

    private final Label p5 = new Label("The default file used to save data is in the data folder provided with this program. To use another file, Go to File > Settings and go to the\n" +
            "'Import Data' tab. You can specify the path to this new file by either typing in the field or by clicking 'Browse' and selecting the file. When the\n" +
            "path is set, click the 'Set Path' button and the new file will be accessed and will be used to save new data.\n" +
            "* Note that this file must be a database file compatible with this program.");

    private final ImageView lensesImg = new ImageView(new Image(getClass().getResourceAsStream("images/lenses.png")));
    private final ImageView convergingImg = new ImageView(new Image(getClass().getResourceAsStream("images/converging.png")));

    public AboutView() {

        heading.setStyle("-fx-font-size: 30; -fx-font-weight: bold");
        p1.setStyle("-fx-font-size: 14");
        p2.setStyle("-fx-font-size: 14");

        subHeading.setStyle("-fx-font-size: 22; -fx-font-weight: bold");

        subHeading1.setStyle("-fx-font-size: 18; -fx-font-weight: bold");
        p3.setStyle("-fx-font-size: 14");

        subHeading2.setStyle("-fx-font-size: 18; -fx-font-weight: bold");
        p4.setStyle("-fx-font-size: 14");

        subHeading3.setStyle("-fx-font-size: 18; -fx-font-weight: bold");
        p5.setStyle("-fx-font-size: 14");

        this.setHgap(10);
        this.setVgap(10);


        lensesImg.setFitWidth(400);
        lensesImg.setPreserveRatio(true);

        convergingImg.setFitWidth(300);
        convergingImg.setPreserveRatio(true);

        this.add(heading, 0, 0,2,1);

        this.add(p1, 0, 1);
        this.add(lensesImg, 1, 1);

        this.add(p2, 0, 2);
        this.add(convergingImg, 1, 2);

        this.add(subHeading, 0, 3, 2, 1);

        this.add(subHeading1, 0, 4, 2, 1);
        this.add(p3, 0, 5, 2, 1);

        this.add(subHeading2, 0, 6, 2, 1);
        this.add(p4, 0, 7, 2, 1);

        this.add(subHeading3, 0, 8, 2, 1);
        this.add(p5, 0, 9, 2, 1);

    }

}
