package KlientPack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsunKlientaWindow extends JFrame {

  private JPanel contentPane;
  private Klient wyszukanyKlient = null;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          UsunKlientaWindow frame = new UsunKlientaWindow();
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
  public UsunKlientaWindow() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 613, 505);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblIdentyfikator = new JLabel("Identyfikator");
    lblIdentyfikator.setBounds(46, 37, 129, 26);
    contentPane.add(lblIdentyfikator);
    
    JComboBox typComboBox = new JComboBox();
    typComboBox.setModel(new DefaultComboBoxModel(new String[] {"Paszport", "Dow\u00F3d"}));
    typComboBox.setBounds(196, 34, 123, 32);
    contentPane.add(typComboBox);
    
    JEditorPane wartoscPane = new JEditorPane();
    wartoscPane.setBounds(340, 37, 106, 32);
    contentPane.add(wartoscPane);
    
    JLabel lblZnaleziono = new JLabel("Znaleziono!");
    lblZnaleziono.setBounds(56, 84, 119, 26);
    contentPane.add(lblZnaleziono);
    lblZnaleziono.setVisible(false);
    
    JLabel lblImi = new JLabel("Imi\u0119:");
    lblImi.setBounds(46, 156, 92, 26);
    contentPane.add(lblImi);
    
    JLabel lblNazwisko = new JLabel("Nazwisko:");
    lblNazwisko.setBounds(46, 203, 106, 26);
    contentPane.add(lblNazwisko);
    
    JLabel foundImieLabel = new JLabel("Imie");
    foundImieLabel.setBounds(196, 156, 92, 26);
    contentPane.add(foundImieLabel);
    foundImieLabel.setVisible(false);
    
    JLabel foundNazwiskoLabel = new JLabel("Nazwisko");
    foundNazwiskoLabel.setBounds(196, 203, 92, 26);
    contentPane.add(foundNazwiskoLabel);
    foundNazwiskoLabel.setVisible(false);
    
    JButton btnSzukaj = new JButton("Szukaj");
    btnSzukaj.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Identyfikator wyszukiwanyId = null;
        String typ = null;
        String wartosc = null;
        if(typComboBox.getSelectedItem().toString().compareTo("Paszport") == 0) {
          typ = "Paszport";
        } else {
          typ = "Dowód osobisty";
        }
        wartosc = wartoscPane.getText();
        wyszukiwanyId = BazaKlientow.wyszukajIdentyfikator(typ, wartosc);
        if(wyszukiwanyId == null) {
          lblZnaleziono.setText("Nie znaleziono klienta!");
          lblZnaleziono.setVisible(true);
          return;
        }
        wyszukanyKlient = BazaKlientow.wyszukajKlienta(wyszukiwanyId);
        if(wyszukanyKlient.getId() == null) {
          lblZnaleziono.setText("Nie znaleziono klienta!");
          lblZnaleziono.setVisible(true);
          return;
        } else {
          lblZnaleziono.setText("Znaleziono!");
          lblZnaleziono.setVisible(true);
          foundImieLabel.setText(wyszukanyKlient.getImie());
          foundNazwiskoLabel.setText(wyszukanyKlient.getNazwisko());
          foundImieLabel.setVisible(true);
          foundNazwiskoLabel.setVisible(true);
        }
      }
    });
    btnSzukaj.setBounds(206, 87, 141, 35);
    contentPane.add(btnSzukaj);
    
    JButton btnUsu = new JButton("Usu\u0144");
    btnUsu.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(wyszukanyKlient.getId() == null) {
          return;
        }
        if(typComboBox.getSelectedItem().toString().compareTo("Paszport") == 0) {
          wyszukanyKlient.getIdentyfikator().setTyp("Paszport");
        } else {
          wyszukanyKlient.getIdentyfikator().setTyp("Dowód osobisty");
        }
        wyszukanyKlient.getIdentyfikator().setWartosc(wartoscPane.getText());
        
        wyszukanyKlient.setImie(foundImieLabel.getText());
        wyszukanyKlient.setNazwisko(foundNazwiskoLabel.getText());
        
        BazaKlientow.usunKlienta(wyszukanyKlient);
        
        dispose();
      }
    });
    btnUsu.setBounds(34, 289, 141, 35);
    contentPane.add(btnUsu);
    
    JButton btnAnuluj = new JButton("Anuluj");
    btnAnuluj.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    btnAnuluj.setBounds(206, 289, 141, 35);
    contentPane.add(btnAnuluj);
  }

}
