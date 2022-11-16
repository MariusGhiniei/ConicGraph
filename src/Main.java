import java.awt.*;

class Conic extends Frame{
    Toolkit tool;
    int width, height;
    public InputPanel inPanel;
    public OutputPanel outPanel;
    public DrawPanel drawPanel;

    Button resolve;

    Conic(){
        tool = getToolkit();
        Dimension resolution = tool.getScreenSize();

        width = resolution.width;
        height = resolution.height;

        setResizable(false);
        setTitle("Graficul conicei de ecuatie generala");
        setBackground(Color.DARK_GRAY);
        setLayout(null);


        inPanel = new InputPanel(this);
        add(inPanel);
        inPanel.setBounds(0,0,width/2,height/2+20);

        outPanel = new OutputPanel(this);
        add(outPanel);
        outPanel.setBounds(0,height/2+20,width/2,height/2-20);

        drawPanel = new DrawPanel(this);
        add(drawPanel);
        drawPanel.setBounds(width/2+1,0,width/2,height);

        resize(width-10,height);
        move(0,0);
        setVisible(true);


    }
    public static void main(String args[]){
        Conic conic = new Conic();
    }


    class InputPanel extends Panel{
        public int a11,a12,a22,a13,a23,a33;
        Font f = new Font("TimesRoman",1,14);
        Font g = new Font("TimesRoman",2,10);

        Font h = new Font("TimesRoman",1,16);


        public InputPanel(Conic conic){

            setBackground(Color.DARK_GRAY);

            setLayout(new GridLayout(8,2));

            Label resolve = new Label("     Rezolvarea ecuatiei: ",Label.CENTER);
            Label equation = new Label("a11 x^2 + 2*a12 xy + a22 y^2 + 2*a13 x + 2*a23 y + a33 = 0",
                    Label.CENTER);
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

            tf1.setForeground(Color.cyan);
            tf2.setForeground(Color.cyan);
            tf3.setForeground(Color.cyan);
            tf4.setForeground(Color.cyan);
            tf5.setForeground(Color.cyan);
            tf6.setForeground(Color.cyan);

            tf1.setFont(g);
            tf2.setFont(g);
            tf3.setFont(g);
            tf4.setFont(g);
            tf5.setFont(g);
            tf6.setFont(g);

            add(resolve); add(equation);

            add(l1); add(tf1);

            add(l2); add(tf2);

            add(l3); add(tf3);

            add(l4); add(tf4);

            add(l5); add(tf5);

            add(l6); add(tf6);

            Button draw = new Button("Deseneaza");
            draw.setFont(g);
            Label drawNull = new Label();

            add(draw); add(drawNull);

        }

    }
    class OutputPanel extends Panel{
        public int delta;
        Font f = new Font("TimesRoman",1,14);

        public OutputPanel(Conic conic){
            setBackground(Color.YELLOW);
            TextField tf1 = new TextField("delta: ");
            tf1.setForeground(Color.cyan);
            tf1.setFont(f);
            //tf1.requestFocus();

            add(tf1);

        }

    }

    class DrawPanel extends Panel{
        //momentan nimic
        Font f = new Font("TimesRoman",1,14);

        public DrawPanel(Conic conic){
            setBackground(Color.BLUE);

        }

    }
}