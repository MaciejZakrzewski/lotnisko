package KlientPack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class DodajKlientaWindow extends JFrame {

  private JPanel contentPane;
  

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DodajKlientaWindow frame = new DodajKlientaWindow(null, null);
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
  public DodajKlientaWindow(List<Klient> lista, DefaultTableModel model) {
  
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 603, 487);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblImi = new JLabel("Imi\u0119");
    lblImi.setBounds(21, 33, 92, 26);
    contentPane.add(lblImi);
    
    JEditorPane imie = new JEditorPane();
    imie.setBounds(174, 33, 106, 32);
    contentPane.add(imie);
    
    JLabel lblNazwisko = new JLabel("Nazwisko");
    lblNazwisko.setBounds(21, 114, 92, 26);
    contentPane.add(lblNazwisko);
    
    JEditorPane nazwisko = new JEditorPane();
    nazwisko.setBounds(174, 108, 106, 32);
    contentPane.add(nazwisko);
    
    JLabel lblTypIdentyfikatora = new JLabel("Identyfikator");
    lblTypIdentyfikatora.setBounds(21, 194, 176, 26);
    contentPane.add(lblTypIdentyfikatora);
    
    JComboBox idTyp = new JComboBox();
    idTyp.setModel(new DefaultComboBoxModel(new String[] {"Paszport", "Dowod"}));
    idTyp.setBounds(174, 191, 106, 32);
    contentPane.add(idTyp);
    
    JEditorPane idWartosc = new JEditorPane();
    idWartosc.setBounds(301, 188, 106, 32);
    contentPane.add(idWartosc);
    
    JLabel imieError = new JLabel("Pole wymagane!");
    imieError.setBounds(329, 33, 176, 26);
    contentPane.add(imieError);
    imieError.setVisible(false);
    
    JLabel nazwiskoError = new JLabel("Pole wymagane!");
    nazwiskoError.setBounds(329, 114, 176, 26);
    contentPane.add(nazwiskoError);
    nazwiskoError.setVisible(false);
    
    JLabel idError = new JLabel("Pole wymagane!");
    idError.setBounds(428, 194, 176, 26);
    contentPane.add(idError);
    idError.setVisible(false);
    
    JButton btnDodaj = new JButton("Dodaj");
    btnDodaj.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        boolean isError = false;
        
        if(imie.getText() == null || imie.getText().isEmpty()) {
          imieError.setVisible(true);
          isError = true;
        }
        else {
          imieError.setVisible(false);
        }
        
        if(nazwisko.getText() == null || nazwisko.getText().isEmpty()) {
          nazwiskoError.setVisible(true);
          isError = true;
        }
        else {
          nazwiskoError.setVisible(false);
        }
        
        if(idWartosc.getText() == null || idWartosc.getText().isEmpty()) {
          idError.setVisible(true);
          isError = true;
        }
        else {
          idError.setVisible(false);
        }
        if(isError) {
          return;
        }
        Klient nowyKlient = new Klient();
        nowyKlient.setImie(imie.getText());
        nowyKlient.setNazwisko(nazwisko.getText());
        
        Identyfikator nowyIdentyfikator = new Identyfikator();
        if(idTyp.getSelectedItem().toString().compareTo("Paszport") == 0) {
          nowyIdentyfikator.setTyp("Paszport");
        } else {
          nowyIdentyfikator.setTyp("Dowód osobisty");
        }
        nowyIdentyfikator.setWartosc(idWartosc.getText());
        
        nowyKlient.setIdentyfikator(nowyIdentyfikator);
        
        BazaKlientow.zarejestrujKlienta(nowyKlient);
        
        
        
        if(lista != null && model != null) {
          model.addRow(new Object[]{nowyKlient.getId(),
                                    nowyKlient.getImie(),
                                    nowyKlient.getNazwisko(),
                                    nowyKlient.getIdentyfikator().getTyp(),
                                    nowyKlient.getIdentyfikator().getWartosc()});
          lista.add(nowyKlient);
        }
        
        dispose();
        
      }
    });
    btnDodaj.setBounds(41, 360, 141, 35);
    contentPane.add(btnDodaj);
    
    JButton btnWyjcie = new JButton("Wyj\u015Bcie");
    btnWyjcie.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    btnWyjcie.setBounds(280, 360, 141, 35);
    contentPane.add(btnWyjcie);
    
    
  }
}
