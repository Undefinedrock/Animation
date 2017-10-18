/**
 * Created by zhang on 10/18/2017.
 */



import javafx.application.Application;

import java.util.ArrayList;
import java.util.Stack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Stackanimation extends Application {

    private Stack stack= new Stack<>();
    private DisplayStack view= new DisplayStack();



    private Button insert= new Button("push");
    private Button delete= new Button (" pop");

    private TextField txfieldnum= new TextField();

    public void start (Stage primary_Stage){

        HBox box = new HBox(5);
        box.getChildren().addAll(new Label("Enter a value:"),txfieldnum,insert,delete);
        box.setAlignment(Pos.TOP_CENTER);
        BorderPane border_Pane=new BorderPane();
        border_Pane.setCenter(view);
        border_Pane.setBottom(box);
        Label Status= new Label();
        border_Pane.setTop(Status);

        BorderPane.setAlignment(Status,Pos.CENTER);
        border_Pane.setPadding(new Insets(10,10,10,10));
        Scene Obeject = new Scene(border_Pane,350,450);
        primary_Stage.setTitle("Stack Animation");
        primary_Stage.setScene(Obeject);
        primary_Stage.show();
        view.repaintMethod();
        txfieldnum.setPrefColumnCount(2);
        insert.setOnAction(event -> {
            if (stack.size()>0)
                stack.pop();
            view.repaintMethod();
        });






    }
public static void main (String[] args){
        launch(args);
}
    public class DisplayStack extends Pane{

        private int x=20;
        private int y =20;
        private int width=35;
        private int height=25;

        public DisplayStack(){

            this.setStyle("-fx-border-color: black");


        }
    protected  void repaintMethod(){
        getChildren().clear();
        if (stack.size()==0){

            getChildren().add(new Text(x,y,"Empty"));

        }
        else {getChildren().add(new Text(x,y,"top"));
        int x2=x+100;
        int y2=y+0;
        draw_ArrowLine(x+15,y,x2,y2);
        ArrayList list= new ArrayList<>(stack);
        for(int i=list.size()-1;i>=0;i--){

            Rectangle rectangle=new Rectangle(x2,y2,width,height);
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLACK);
            getChildren().add(rectangle);
            getChildren().add(new Text(x2+10,y2+15,list.get(i)+""));
            y2=y2+height;


        }
        }
}
        public void draw_ArrowLine(double x1,double y1,double x2,double y2){
            getChildren().add(new Line(x1,y1,x2,y2));
            double slope=((((double)y1)-(double)y2))/(((double)x1)-(((double)x1)-(((double)x2))));
            double arcVar=Math.atan(slope);
            double setVar=1.57/2;
            if(x1<x2){

                setVar=-1.57*2;


            }
            int arrLength=15;
            getChildren().add(new Line(x2,y2,(x2+(Math.cos(arcVar+setVar)*arrLength)),((y2))+(Math.sin(arcVar+setVar)*arrLength)));
            getChildren().add(new Line(x2,y2,(x2+(Math.cos(arcVar-setVar)*arrLength)),((y2))+(Math.sin(arcVar-setVar)*arrLength)));




        }
}

}
