import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    Container cp;
    private JTextField jtf = new JTextField();
    int FrameW =600 ,FrameH=400;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel jpn = new JPanel(new GridLayout(3,3));
    JButton jbtn[] =new JButton[9];

    LoginFrame lgf ;
    public MainFrame (LoginFrame loginFrame){
        lgf=loginFrame;
        init();
    }

    private void init(){
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setBounds(dim.width/2-FrameW/2,dim.height/2-FrameH/2,FrameW,FrameH);
        cp.add(jtf,BorderLayout.NORTH);
        cp.add(jpn,BorderLayout.CENTER);
        jtf.setEnabled(false);
        Random rnd = new Random();
        int rndNum [] = new int[9];
        for(int i=0;i<9;i++){
            rndNum[i]=rnd.nextInt(9);
            for(int j=0;j<i;j++){
                if(rndNum[j]==rndNum[i]){
                    i--;
                }
            }
        }

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                lgf.setVisible(true);

            }
        });
        setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
        for(int i=0;i<9;i++){
            jbtn[i] = new JButton(Integer.toString(rndNum[i]));
            jpn.add(jbtn[i]);
            jbtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tembtn  =(JButton)e.getSource();
                    jtf.setText(jtf.getText()+tembtn.getText());
                }
            });
        }

    }
}
