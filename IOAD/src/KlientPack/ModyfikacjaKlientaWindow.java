package KlientPack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModyfikacjaKlientaWindow extends JFrame {

  private JPanel contentPane;
  private Klient wyszukanyKlient = null;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ModyfikacjaKlientaWindow frame = new ModyfikacjaKlientaWindow(null, null, null);
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
  public ModyfikacjaKlientaWindow(JTable table, Klient klient, DefaultTableModel model) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 626, 523);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblWyszIdent = new JLabel("Identyfikator:");
    lblWyszIdent.setBounds(21, 21, 141, 26);
    contentPane.add(lblWyszIdent);
    
    JComboBox typComboBox = new JComboBox();
    typComboBox.setModel(new DefaultComboBoxModel(new String[] {"Paszport", "Dow\u00F3d"}));
    typComboBox.setBounds(159, 18, 116, 32);
    contentPane.add(typComboBox);
    
    JEditorPane numerPane = new JEditorPane();
    numerPane.setBounds(296, 18, 116, 32);
    contentPane.add(numerPane);
    
    JLabel foundLabel = new JLabel("Znaleziono!");
    foundLabel.setBounds(21, 145, 116, 26);
    contentPane.add(foundLabel);
    foundLabel.setVisible(false);
    
    JLabel lblImie = new JLabel("Imie:");
    lblImie.setBounds(21, 202, 92, 26);
    contentPane.add(lblImie);
    
    JLabel lblNazwisko = new JLabel("Nazwisko:");
    lblNazwisko.setBounds(21, 249, 92, 26);
    contentPane.add(lblNazwisko);
    
    JEditorPane imiePane = new JEditorPane();
    imiePane.setBounds(134, 196, 106, 32);
    contentPane.add(imiePane);
    
    JEditorPane nazwiskoPane = new JEditorPane();
    nazwiskoPane.setBounds(134, 249, 106, 32);
    contentPane.add(nazwiskoPane);
    
    JComboBox comboBox = new JComboBox();
    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paszport", "Dow\u00F3d"}));
    comboBox.setBounds(159, 301, 116, 32);
    contentPane.add(comboBox);
    
    JEditorPane valuePane = new JEditorPane();
    valuePane.setBounds(296, 304, 106, 32);
    contentPane.add(valuePane);
    
    
    
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
        wartosc = numerPane.getText();
        wyszukiwanyId = BazaKlientow.wyszukajIdentyfikator(typ, wartosc);
        if(wyszukiwanyId == null) {
          foundLabel.setText("Nie znaleziono klienta!");
          foundLabel.setVisible(true);
          return;
        }
        wyszukanyKlient = BazaKlientow.wyszukajKlienta(wyszukiwanyId);
        if(wyszukanyKlient.getId() == null) {
          foundLabel.setText("Nie znaleziono klienta!");
          foundLabel.setVisible(true);
          return;
        } else {
          foundLabel.setText("Znaleziono!");
          foundLabel.setVisible(true);
        }
        imiePane.setText(wyszukanyKlient.getImie());
        nazwiskoPane.setText(wyszukanyKlient.getNazwisko());
        if(typComboBox.getSelectedItem().toString().compareTo("Paszport") == 0) {
          comboBox.setSelectedIndex(0);
        } else {
          comboBox.setSelectedIndex(1);
        }
        valuePane.setText(wyszukanyKlient.getIdentyfikator().getWartosc());
      }
    });
    btnSzukaj.setBounds(207, 71, 141, 35);
    contentPane.add(btnSzukaj);
    
    if(klient != null && model != null) {
      wyszukanyKlient = klient;
      lblWyszIdent.setVisible(false);
      typComboBox.setVisible(false);
      numerPane.setVisible(false);
      btnSzukaj.setVisible(false);
      foundLabel.setText("Znaleziono!");
      foundLabel.setVisible(true);
      imiePane.setText(wyszukanyKlient.getImie());
      nazwiskoPane.setText(wyszukanyKlient.getNazwisko());
      if(typComboBox.getSelectedItem().toString().compareTo("Paszport") == 0) {
        comboBox.setSelectedIndex(0);
      } else {
        comboBox.setSelectedIndex(1);
      }
      valuePane.setText(wyszukanyKlient.getIdentyfikator().getWartosc());
    }
    
    JButton btnZapisz = new JButton("Zapisz");
    btnZapisz.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(wyszukanyKlient.getId() == null) {
          return;
        }
        if(comboBox.getSelectedItem().toString().compareTo("Paszport") == 0) {
          wyszukanyKlient.getIdentyfikator().setTyp("Paszport");
        } else {
          wyszukanyKlient.getIdentyfikator().setTyp("Dowód osobisty");
        }
        wyszukanyKlient.getIdentyfikator().setWartosc(valuePane.getText());
        
        wyszukanyKlient.setImie(imiePane.getText());
        wyszukanyKlient.setNazwisko(nazwiskoPane.getText());
        
        BazaKlientow.modyfikujDaneKlienta(wyszukanyKlient);
        
        if(klient != null && model != null) {
          model.removeRow(table.getSelectedRow());
          model.addRow(new Object[] {wyszukanyKlient.getId(),
                                    wyszukanyKlient.getImie(),
                                    wyszukanyKlient.getNazwisko(),
                                    wyszukanyKlient.getIdentyfikator().getTyp(),
                                    wyszukanyKlient.getIdentyfikator().getWartosc()});
        }
        
        dispose();
      }
    });
    btnZapisz.setBounds(21, 396, 141, 35);
    contentPane.add(btnZapisz);
    
    JButton btnAnuluj = new JButton("Anuluj");
    btnAnuluj.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    btnAnuluj.setBounds(220, 396, 141, 35);
    contentPane.add(btnAnuluj);
    
    JLabel lblIdentyfikator = new JLabel("Identyfikator:");
    lblIdentyfikator.setBounds(21, 304, 141, 26);
    contentPane.add(lblIdentyfikator);
    
    
  }

}
