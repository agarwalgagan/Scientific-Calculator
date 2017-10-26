import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{

    TextField txt;
    public static String s;
    Button btnequal;
    double value;
    double a;
    double ans;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        txt = new TextField();
        txt.setText(s="");
        txt.setEditable(false);

        Button btnfact = new Button("!");
        btnfact.setOnAction(event -> fact());

        Button btnpower = new Button("^");
        btnpower.setOnAction(event -> power());

        Button btnsqrt = new Button("√");
        btnsqrt.setOnAction(event -> square_root());

        Button btncbrt = new Button("3√");
        btncbrt.setOnAction(event -> cube_root());

        Button btnac = new Button("C");
        btnac.setOnAction(event -> {
            s="";
            display(s);
        });

        Button btnsin = new Button("sin");
        btnsin.setOnAction(event -> sine());

        Button btnpi = new Button("pi");
        btnpi.setOnAction(event -> {
            s=""+22.0/7;
            display("3.14");
        });

        Button btnans = new Button("Ans");
        btnans.setOnAction(event -> {
            s+=ans;
            display(s);
        });

        Button btnexp = new Button("e");
        btnexp.setOnAction(event -> {
            s="2.71828183";
            display("2.7");
        });
        Button btnclc = new Button("clc");
        btnclc.setOnAction(event -> {
            s = s.substring(0,s.length()-1);
            display(s);
        });

        Button btncos = new Button("cos");
        btncos.setOnAction(event -> cosine());

        Button btntan = new Button("tan");
        btntan.setOnAction(event -> tangent());

        Button btnln = new Button("ln");
        btnln.setOnAction(event -> ln());

        Button btnlog = new Button("log");
        btnlog.setOnAction(event -> logarithm());

        Button btn0 = new Button("0");
        btn0.setOnAction(event -> {
            s+="0";
            display(s);
        });

        Button btn1 = new Button("1");
        btn1.setOnAction(event -> {
            s+="1";
            display(s);
        });

        Button btn2 = new Button("2");
        btn2.setOnAction(event -> {
            s+="2";
            display(s);
        });

        Button btn3 = new Button("3");
        btn3.setOnAction(event -> {
            s+="3";
            display(s);
        });

        Button btn4 = new Button("4");
        btn4.setOnAction(event -> {
            s+=4;
            display(s);
        });

        Button btn5 = new Button("5");
        btn5.setOnAction(event -> {
            s+=5;
            display(s);
        });

        Button btn6 = new Button("6");
        btn6.setOnAction(event -> {
            s+=6;
            display(s);
        });

        Button btn7 = new Button("7");
        btn7.setOnAction(event -> {
            s+=7;
            display(s);
        });

        Button btn8 = new Button("8");
        btn8.setOnAction(event -> {
            s+=8;
            display(s);
        });

        Button btn9 = new Button("9");
        btn9.setOnAction(event -> {
            s+=9;
            display(s);
        });

        Button btnmul = new Button("x");
        btnmul.setOnAction(event -> multiply());

        Button btndiv = new Button("/");
        btndiv.setOnAction(event -> divide());

        Button btnadd = new Button("+");
        btnadd.setOnAction(event -> add());

        Button btnsub = new Button("-");
        btnsub.setOnAction(event -> subtract());

        Button btndot = new Button(".");
        btndot.setOnAction(event -> {
            s+=".";
            display(s);
        });

        btnequal = new Button("=");

        GridPane layout = new GridPane();
        layout.add(txt,0,0,5,1);
        layout.add(btnfact,0,1);
        layout.add(btnpower,1,1);
        layout.add(btnsqrt,2,1);
        layout.add(btncbrt,3,1);
        layout.add(btnac,4,1);
        layout.add(btnsin,0,2);
        layout.add(btnpi,1,2);
        layout.add(btnexp,2,2);
        layout.add(btnclc,3,2);
        layout.add(btndiv,4,2);
        layout.add(btncos,0,3);
        layout.add(btn7,1,3);
        layout.add(btn8,2,3);
        layout.add(btn9,3,3);
        layout.add(btnmul,4,3);
        layout.add(btntan,0,4);
        layout.add(btn4,1,4);
        layout.add(btn5,2,4);
        layout.add(btn6,3,4);
        layout.add(btnsub,4,4);
        layout.add(btnln,0,5);
        layout.add(btn1,1,5);
        layout.add(btn2,2,5);
        layout.add(btn3,3,5);
        layout.add(btnadd,4,5);
        layout.add(btnlog,0,6);
        layout.add(btn0,1,6);
        layout.add(btndot,2,6);
        layout.add(btnequal,3,6);
        layout.add(btnans,4,6);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setHgap(5);
        layout.setVgap(5);

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Scientific calculator");
        primaryStage.show();
    }

    private void display(String str){
        txt.setText(str);
    }

    private Double get(String str){
        Double d = 0.0;
        try {
            d = Double.parseDouble(str);
        }catch (ArithmeticException e){
            display("Error : e");
        }
        return d;
    }

    private void fact(){
        a = Integer.parseInt(s);
        int f=1;
        for(int i=1;i<=a;i++){
            f*=i;
        }
        display(f+"");
        ans=f/1.0;
        s="";
    }

    private void power(){
        a = get(s);
        s = "";
        display(s);
        btnequal.setOnAction(event -> {
            double m = get(s);
            value = Math.pow(a,m);
            display(value+"");
            ans = value;
        });
        s="";
    }

    private void square_root(){
        s = "√";
        display(s);
        btnequal.setOnAction(event -> {
            a =  get(s);
            ans = Math.sqrt(a);
            s = ans+"";
            display(s);
        });
        s = "";
    }

    private void cube_root(){
        s = "3√";
        display(s);
        btnequal.setOnAction(event -> {
            double a = get(s);
            ans = Math.cbrt(a);
            s = ans + "";
            display(s);
        });
        s = "";
    }

    private void sine(){
        s = "sin ";
        display(s);
        btnequal.setOnAction(event -> {
            a = get(s);
            ans = Math.sin(a);
            s = ans + "";
            display(s);
        });
        s = "";
    }

    private void cosine(){
        s = "cos ";
        display(s);
        btnequal.setOnAction(event -> {
            a = get(s);
            ans = Math.cos(a);
            s = ans + "";
            display(s);
        });
        s="";
    }

    private void tangent(){
        s="tan ";
        display(s);
        btnequal.setOnAction(event -> {
            a = get(s);
            s = Math.tan(a) + "";
            display(s);
        });
        s = "";
    }

    private void logarithm(){
        s = "log ";
        display(s);
        btnequal.setOnAction(event -> {
            a = get(s);
            ans = Math.log10(a);
            s = ans + "";
            display(s);
        });
        s = "";
    }

    private void ln(){
        s = "ln ";
        display(s);
        btnequal.setOnAction(event -> {
            a = get(s);
            ans = Math.log(a);
            s = ans + "";
            display(s);
        });
        s = "";
    }

    private void add(){
        a = get(s);
        s = "0";
        display(s);
        btnequal.setOnAction(event -> {
            double b = get(s);
            ans = (a+b);
            s = ans + "";
            display(s);
        });
        s = "";
    }

    private void subtract(){
        a = get(s);
        s = "0";
        display(s);
        btnequal.setOnAction(event -> {
            double b = get(s);
            ans = (a-b);
            s = ans + "";
            display(s);
        });
        s = "";
    }

    private void multiply(){
        a = get(s);
        s = "0";
        display(s);
        btnequal.setOnAction(event -> {
            double b = get(s);
            ans = (a*b);
            s = ans + "";
            display(s);
        });
        s = "";
    }

    private void divide(){
        a = get(s);
        s = "0";
        display(s);
        btnequal.setOnAction(event -> {
            double b = get(s);
            ans = (a/b);
            s = ans + "";
            display(s);
        });
        s = "";
    }
}
