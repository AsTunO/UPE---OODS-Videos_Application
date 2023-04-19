package Videos;

import javax.swing.*;

public class Janela {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Titulo");
        janela.setBounds(50, 100, 800, 600);
        janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        janela.setVisible(true);

        JPanel miJpanel = new JPanel();
        miJpanel.setSize(500, 600);

    }
}
