import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;

class Conic extends Frame{
    Toolkit tool;
    int width, height;
    public InputPanel inPanel;
    public OutputPanel outPanel;
    public DrawPanel drawPanel;

    double[] values = new double[6];

    Conic(){
        tool = getToolkit();
        Dimension resolution = tool.getScreenSize();

        width = resolution.width;
        height = resolution.height;

        setResizable(false);
        setTitle("Graficul conicei de ecuație generală");
        setBackground(Color.DARK_GRAY);
        setLayout(null);

        inPanel = new InputPanel();
        add(inPanel);
        inPanel.setBounds(0,30,width/2,height/2);

        outPanel = new OutputPanel();
        add(outPanel);
        outPanel.setBounds(0,height/2,width/2,height/2-30);

        drawPanel = new DrawPanel();
        add(drawPanel);
        drawPanel.setBounds(width/2+1,0,width/2,height);

        resize(width,height);
        move(0,0);
        setVisible(true);

        addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                dispose();
            }
        });
    }
    public static void main(String args[]){
        Conic conic = new Conic();
    }

    class InputPanel extends Panel{

        Font f = new Font("TimesRoman",1,14);
        Font g = new Font("TimesRoman",2,13);

        Font h = new Font("TimesRoman",1,16);

        public InputPanel(){

            setBackground(Color.DARK_GRAY);

            setLayout(new GridLayout(8,2));

            Label resolve = new Label("     Rezolvarea ecuatiei: ",Label.CENTER);
            Label equation = new Label("a\u2081\u2081x\u00b2 + 2a\u2081\u2082xy + " +
                    "a\u2082\u2082y\u00b2 + 2a\u2081\u2083x + 2a\u2082\u2083y + a\u2083\u2083 = 0", Label.CENTER);

            resolve.setFont(f);
            equation.setFont(g);

            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            TextField tf3 = new TextField();
            TextField tf4 = new TextField();
            TextField tf5 = new TextField();
            TextField tf6 = new TextField();

            Label l1 = new Label("a11: ",Label.CENTER);
            Label l2 = new Label("a12: ",Label.CENTER);
            Label l3 = new Label("a22: ",Label.CENTER);
            Label l4 = new Label("a13: ",Label.CENTER);
            Label l5 = new Label("a23: ",Label.CENTER);
            Label l6 = new Label("a33: ",Label.CENTER);

            l1.setFont(h);
            l2.setFont(h);
            l3.setFont(h);
            l4.setFont(h);
            l5.setFont(h);
            l6.setFont(h);

            tf1.setForeground(Color.GRAY);
            tf2.setForeground(Color.GRAY);
            tf3.setForeground(Color.GRAY);
            tf4.setForeground(Color.GRAY);
            tf5.setForeground(Color.GRAY);
            tf6.setForeground(Color.GRAY);

            tf1.setBackground(Color.WHITE);
            tf2.setBackground(Color.WHITE);
            tf3.setBackground(Color.WHITE);
            tf4.setBackground(Color.WHITE);
            tf5.setBackground(Color.WHITE);
            tf6.setBackground(Color.WHITE);

            tf1.setFont(f);
            tf2.setFont(f);
            tf3.setFont(f);
            tf4.setFont(f);
            tf5.setFont(f);
            tf6.setFont(f);

            add(resolve); add(equation);

            add(l1); add(tf1);

            add(l2); add(tf2);

            add(l3); add(tf3);

            add(l4); add(tf4);

            add(l5); add(tf5);

            add(l6); add(tf6);

            Button draw = new Button("Deseneaza");
            draw.setFont(g);

            Label drawNull = new Label("",Label.CENTER);

            add(draw); add(drawNull);
            draw.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String error = "";
                    double a11,a12,a22,a13,a23,a33;
                    try {
                        a11 = Double.parseDouble(tf1.getText());
                        a12 = Double.parseDouble(tf2.getText());
                        a22 = Double.parseDouble(tf3.getText());
                        a13 = Double.parseDouble(tf4.getText());
                        a23 = Double.parseDouble(tf5.getText());
                        a33 = Double.parseDouble(tf6.getText());

                        double res = a11 *  a11 + a12 * a12 + a22 * a22;

                        if(res == 0){
                            error = "Coeficientii introdusi nu formeaza o conica.";
                            drawNull.setText(error);
                        } else {
                            values[0] = a11;
                            values[1] = a12;
                            values[2] = a22;
                            values[3] = a13;
                            values[4] = a23;
                            values[5] = a33;

                            outPanel.info();
                        }

                    }
                    catch(Exception ex){
                        error = "Valoarea unui camp sau mai multe nu este validă.";
                        drawNull.setText(error);
                    }

                }
            });
        }
    }

    class OutputPanel extends Panel{
        Font f = new Font("TimesRoman",1,13);
        Font g = new Font("TimesRoman",3,18);
        Font i = new Font("TimesRoman",1,9);

        Label delta = new Label();
        Label Delta = new Label();
        Label traceDelta = new Label();
        Label Delta1 = new Label();
        Label kind = new Label();
        Label type = new Label();
        Label name = new Label();
        Label center = new Label();

        public OutputPanel() {
            setBackground(Color.lightGray);

            setLayout(new GridLayout(5,4));

            delta.setFont(g);
            Delta.setFont(g);
            traceDelta.setFont(g);
            Delta1.setFont(g);
            kind.setFont(g);
            type.setFont(g);
            name.setFont(g);
            center.setFont(g);

            Label l1 = new Label("\u03b4 :", Label.CENTER);
            Label l2 = new Label("\u0394 :", Label.CENTER);
            Label l3 = new Label("\u0399\u0394 :", Label.CENTER);
            Label l4 = new Label("\u0394\u2081 :", Label.CENTER);
            Label l5 = new Label("Genul Conicei:", Label.CENTER);
            Label l6 = new Label("Tipul Conicei: ", Label.CENTER);
            Label l7 = new Label("Denumirea Conicei: ", Label.CENTER);
            Label l8 = new Label("Centrul Conicei: ", Label.CENTER);

            Label lastRow = new Label();

            l1.setFont(f);
            l2.setFont(f);
            l3.setFont(f);
            l4.setFont(f);
            l5.setFont(f);
            l6.setFont(f);
            l7.setFont(f);
            l8.setFont(f);

            add(l1); add(delta); add(l2); add(Delta);

            add(l3); add(traceDelta); add(l4); add(Delta1);

            add(l5); add(kind); add(l6); add(type);

            add(l7); add(name); add(l8); add(center);

            add(lastRow); add(lastRow); add(lastRow); add(lastRow);

        }
        private double getTrace(){
            return values[0] + values[2];
        }
        private double getDelta(){
            return values[0] * values[2] - values[1] * values[1];
        }
        private double getDet(){
            return values[0] * values[2] * values[5] +
                    2 * values[1] * values[4] * values[3] -
                    values[2] * values[3] * values[3] -
                    values[5] * values[1] * values[1] -
                    values[0] * values[4] * values[4];
        }
        private double getDelta1(){
            return values[0] * values[2] - values[1] * values[1] +
                    values[0] * values[5] - values[3] * values[3] +
                    values[2] * values[5] - values[4] * values[4];
        }
        private Point2D getCenter(){
            double delta = getDelta();
            double y0 = (values[1] * values[3] - values[0] * values[4]) / delta;
            double x0 = -(values[1] * y0 + values[3])/values[0];

            Point2D.Double C = new Point2D.Double(x0, y0);

            return C;
        }
        public void info(){
            DecimalFormat dfZero = new DecimalFormat("0.00");

            double trace = getTrace();
            double d = getDelta();
            double D = getDet();
            double D1 = getDelta1();
            double traceDeltaAD = trace * D;
            Point2D C0 = getCenter();
            String centerText = "";
            if(d == 0){
                centerText = "Nu are centru unic la distanta finita";
                center.setFont(i);
            } else {
                centerText = "(" + dfZero.format(C0.getX()) + " , " + dfZero.format(C0.getY()) + ")";
            }

            String kindText = "";
            String typeText = "";
            String nameText = "";

            if(d > 0) {
                if(D != 0) {
                    if(traceDeltaAD < 0) {
                        kindText = "Eliptic";
                        typeText = "Nedegenerat";
                        nameText = "Elipsa";
                    }
                    if(traceDeltaAD > 0) {
                            kindText = "Eliptic";
                            typeText = "Nedegenerat";
                            nameText = "Elipsa Imaginara";
                    }
                }

                if(D == 0) {
                        kindText = "Eliptic";
                        typeText = "Degenerat";
                        nameText = "Punct Dublu";
                }
            }

            if(d < 0){
                if(D != 0){
                        kindText = "Hiperbolic";
                        typeText = "Nedegenerat";
                        nameText = "Hiperbola";
                }
                if(D == 0){
                    kindText = "Hiperbolic";
                    typeText = "Degenerat";
                    nameText = "Drepte concurente";
                }
            }

            if(d == 0){
                if(D != 0){
                    kindText = "Parabolic";
                    typeText = "Nedegenerat";
                    nameText = "Prabola";
                }
                if (D == 0) {
                    if(D1 < 0){
                        kindText = "Parabolic";
                        typeText = "Degenerat";
                        nameText = "Drepte Paralele";
                    }
                    if(D1 == 0) {
                        kindText = "Parabolic";
                        typeText = "Degenerat";
                        nameText = "Dreapta Dubla";
                    }
                    if(D1 > 0){
                        kindText = "Parabolic";
                        typeText = "Degenerat";
                        nameText = "Drepte imaginare paralele";
                    }
                }
            }

            delta.setText(String.valueOf(dfZero.format(d)));
            Delta.setText(String.valueOf(dfZero.format(D)));
            traceDelta.setText(String.valueOf(dfZero.format(traceDeltaAD)));
            Delta1.setText(String.valueOf(dfZero.format(D1)));
            kind.setText(kindText);
            type.setText(typeText);
            if(nameText == "Drepte imaginare paralele"){
                name.setFont(f);
            }
            name.setText(nameText);
            center.setText(centerText);


        }

    }

    class DrawPanel extends Panel{
        //momentan nimic
        Font f = new Font("TimesRoman",1,14);

        public DrawPanel(){
            setBackground(Color.BLUE);

        }

    }
}