
package friend.media.player;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Sayyam
 */
public class FriendMediaPlayer extends Application{

    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       Group root=new Group();
       Media media = new Media("file:///C:/Users/Sayyam/Downloads/Video/scable.mp4");
       MediaPlayer player=new MediaPlayer(media);
       MediaView view = new MediaView(player);
       
       final VBox vbox=new VBox();
       Slider slider=new Slider();
       
       vbox.getChildren().add(slider);
       root.getChildren().add(view);
       root.getChildren().add(vbox);
       Scene scene=new Scene(root,400,400,Color.BLACK);
       primaryStage.setScene(scene);
       primaryStage.show();
       player.play();
      player.setOnReady(new Runnable() {
           @Override
            public void run() {
               int w = player.getMedia().getWidth();
               int h =player.getMedia().getHeight();
               
               primaryStage.setMinWidth(w);
               primaryStage.setMinHeight(h);
               
               vbox.setMinSize(w, 100);
               vbox.setTranslateY(h-100);
               
             
               slider.setMax(player.getTotalDuration().toSeconds());
               
           }
         });
         
      
      

          
         
     }
 }