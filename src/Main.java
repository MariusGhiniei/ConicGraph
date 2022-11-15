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
        inPanel.setBounds(0,0,width/2,height/2);

        outPanel = new OutputPanel(this);
        add(outPanel);
        outPanel.setBounds(0,height/2+1,width/2,height/2);

        drawPanel = new DrawPanel(this);
        add(drawPanel);
        drawPanel.setBounds(width/2+1,0,width/2,height);

        resize(width,height);
        move(0,0);
        setVisible(true);

    }
    public static void main(String args[]){
        Conic conic = new Conic();
    }


    class InputPanel extends Panel{
        public int a11,a12,a22,a13,a23,a33;
        Font f = new Font("TimesRoman",1,14);

        public InputPanel(Conic conic){
            setBackground(Color.RED);
            Label info = new Label("rezolvarea ecuatiei: ..");
            add(info);
            info.setBounds(30,30,width/6,height/6);
            TextField tf1 = new TextField("a11: ");
            TextField tf2 = new TextField("a12: ");
            TextField tf3 = new TextField("a22: ");
            TextField tf4 = new TextField("a13: ");
            TextField tf5 = new TextField("a23: ");
            TextField tf6 = new TextField("a33: ");

            tf1.setForeground(Color.cyan);
            tf2.setForeground(Color.cyan);
            tf3.setForeground(Color.cyan);
            tf4.setForeground(Color.cyan);
            tf5.setForeground(Color.cyan);
            tf6.setForeground(Color.cyan);

            tf1.setFont(f);
            tf2.setFont(f);
            tf3.setFont(f);
            tf4.setFont(f);
            tf5.setFont(f);
            tf6.setFont(f);

            add(tf1);
            add(tf2);
            add(tf3);
            add(tf4);
            add(tf5);
            add(tf6);
            Button btn1 = new Button("idk");
            add(btn1);
            btn1.setLocation(100,100);
            tf1.setBounds(100,15,100,25);

            tf2.setBounds(120,35,100,25);
            tf3.setBounds(120,60,100,25);
            tf4.setBounds(120,85,100,25);
            tf5.setBounds(120,110,100,25);
            tf6.setBounds(120,135,100,25);
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