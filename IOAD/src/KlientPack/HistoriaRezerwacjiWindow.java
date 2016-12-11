package KlientPack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class HistoriaRezerwacjiWindow extends JFrame {

  private JPanel contentPane;
  private JTable table;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          HistoriaRezerwacjiWindow frame = new HistoriaRezerwacjiWindow(null);
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
  public HistoriaRezerwacjiWindow(Klient klient) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 654, 408);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    
    table = new JTable();
    table.setEnabled(false);
    table.setModel(new DefaultTableModel(
      new Object[][] {
      },
      new String[] {
        "Id_rez", "Id_lotu", "Wylot", "Data wylotu", "Przylot", "Data przylotu"
      }
    ));
    table.getColumnModel().getColumn(1).setPreferredWidth(106);
    table.getColumnModel().getColumn(2).setPreferredWidth(118);
    table.getColumnModel().getColumn(3).setPreferredWidth(139);
    table.getColumnModel().getColumn(4).setPreferredWidth(133);
    table.getColumnModel().getColumn(5).setPreferredWidth(157);

    
    DefaultTableModel model = (DefaultTableModel)table.getModel();
    
    model.addRow(new Object[] {"Id_rez", "Id_lotu", "Wylot", "Data wylotu", "Przylot", "Data przylotu"});
    
    for(int i = 0; i < klient.getListaRezerwacji().size(); i++) {
      model.addRow(new Object[]{klient.getListaRezerwacji().get(i).getIdRezerwacji(),
                                klient.getListaRezerwacji().get(i).getIdLotu(),
                                BazaKlientow.wyszukajLot(klient.getListaRezerwacji().get(i).getIdLotu()).getMiejsceWylotu(),
                                BazaKlientow.wyszukajLot(klient.getListaRezerwacji().get(i).getIdLotu()).getDataWylotu(),
                                BazaKlientow.wyszukajLot(klient.getListaRezerwacji().get(i).getIdLotu()).getMiejscePrzylotu(),
                                BazaKlientow.wyszukajLot(klient.getListaRezerwacji().get(i).getIdLotu()).getDataPrzylotu()});
    }
    
    contentPane.add(table, BorderLayout.CENTER);
    
    JButton btnWyjcie = new JButton("Wyj\u015Bcie");
    btnWyjcie.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    contentPane.add(btnWyjcie, BorderLayout.SOUTH);
  }

}
