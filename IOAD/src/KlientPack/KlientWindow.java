package KlientPack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KlientWindow extends JFrame {

  private JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          KlientWindow frame = new KlientWindow();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public KlientWindow() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 543, 430);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JButton btnDodaj = new JButton("Dodaj");
    btnDodaj.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DodajKlientaWindow dodajKlientaWindow = new DodajKlientaWindow(null, null);
        dodajKlientaWindow.setVisible(true);
      }
    });
    btnDodaj.setBounds(187, 55, 141, 35);
    contentPane.add(btnDodaj);
    
    JButton btnZmieDane = new JButton("Zmie\u0144 dane");
    btnZmieDane.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ModyfikacjaKlientaWindow modyfikacjaKlientaWindow = new ModyfikacjaKlientaWindow(null, null, null);
        modyfikacjaKlientaWindow.setVisible(true);
      }
    });
    btnZmieDane.setBounds(187, 111, 141, 35);
    contentPane.add(btnZmieDane);
    
    JButton btnUsu = new JButton("Usu\u0144");
    btnUsu.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        UsunKlientaWindow usunKlientaWindow = new UsunKlientaWindow();
        usunKlientaWindow.setVisible(true);
      }
    });
    btnUsu.setBounds(187, 167, 141, 35);
    contentPane.add(btnUsu);
    
    JButton btnWywietl = new JButton("Wy\u015Bwietl");
    btnWywietl.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ListaKlientowWindow listaKlientowWindow = new ListaKlientowWindow();
        listaKlientowWindow.setVisible(true);
      }
    });
    btnWywietl.setBounds(187, 223, 141, 35);
    contentPane.add(btnWywietl);
  }

}
