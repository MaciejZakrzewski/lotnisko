package KlientPack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaKlientowWindow extends JFrame {
  
  private Klient selectedKlient = null;

  private JPanel contentPane;
  private JTable table;
  
  private List<Klient> listaKlientow;
  private JPanel panel;
  private JButton btnWywietlHistori;
  private JButton btnUsu;
  private JButton btnDodaj;
  private JButton btnModyfikuj;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ListaKlientowWindow frame = new ListaKlientowWindow();
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
  public ListaKlientowWindow() {
    listaKlientow = BazaKlientow.pobierzListeKlientow();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 567, 431);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    
    
    table = new JTable();
    table.setModel(new DefaultTableModel(
      new Object[][] {
      },
      new String[] {
        "Id", "Imi\u0119", "Nazwisko", "Typ dokumentu", "Numer"
      }
    ));
    table.getColumnModel().getColumn(1).setPreferredWidth(115);
    table.getColumnModel().getColumn(2).setPreferredWidth(142);
    table.getColumnModel().getColumn(3).setPreferredWidth(184);
    table.getColumnModel().getColumn(4).setPreferredWidth(172);
    
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    
    //model.addRow(new Object[]{"Id", "Imiê", "Nazwisko", "Typ dokumentu", "Numer"});
    
    for(int i = 0; i < listaKlientow.size(); i++) {
      model.addRow(new Object[]{listaKlientow.get(i).getId(), 
                                listaKlientow.get(i).getImie(),
                                listaKlientow.get(i).getNazwisko(),
                                listaKlientow.get(i).getIdentyfikator().getTyp(),
                                listaKlientow.get(i).getIdentyfikator().getWartosc()});
    }
    contentPane.add(table, BorderLayout.CENTER);
    
    JButton btnWyjcie = new JButton("Wyj\u015Bcie");
    btnWyjcie.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    contentPane.add(btnWyjcie, BorderLayout.SOUTH);
    
    panel = new JPanel();
    contentPane.add(panel, BorderLayout.NORTH);
    
    btnWywietlHistori = new JButton("Wy\u015Bwietl histori\u0119");
    btnWywietlHistori.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        selectedKlient = listaKlientow.get(table.getSelectedRow());
        BazaKlientow.pobierzListeRezerwacji(selectedKlient);
        HistoriaRezerwacjiWindow historiaRezerwacjiWindow = new HistoriaRezerwacjiWindow(selectedKlient);
        historiaRezerwacjiWindow.setVisible(true);
      }
    });
    panel.add(btnWywietlHistori);
    
    btnUsu = new JButton("Usu\u0144");
    btnUsu.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        selectedKlient = listaKlientow.get(table.getSelectedRow());      
        BazaKlientow.usunKlienta(selectedKlient);
        listaKlientow.remove(table.getSelectedRow());
        model.removeRow(table.getSelectedRow());
      }
    });
    panel.add(btnUsu);
    
    btnDodaj = new JButton("Dodaj");
    btnDodaj.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DodajKlientaWindow dodajKlientaWindow = new DodajKlientaWindow(listaKlientow, model);
        dodajKlientaWindow.setVisible(true);
        table.repaint();
      }
    });
    panel.add(btnDodaj);
    
    btnModyfikuj = new JButton("Modyfikuj");
    btnModyfikuj.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        selectedKlient = listaKlientow.get(table.getSelectedRow());
        ModyfikacjaKlientaWindow modyfikacjaKlientaWindow = new ModyfikacjaKlientaWindow(table, selectedKlient, model);
        modyfikacjaKlientaWindow.setVisible(true);
        table.repaint();
      }
    });
    panel.add(btnModyfikuj);
  }
}
