package kalkulatorbalok;

import javax.swing.*;
import java.awt.event.*;

public class KalkulatorBalok extends JFrame implements ActionListener{
    JLabel LJudul = new JLabel("Kalkulator Balok");
    JLabel LPanjang = new JLabel("Panjang");
    JLabel LLebar = new JLabel("Lebar");
    JLabel LTinggi = new JLabel("Tinggi");
    JLabel LHasil = new JLabel("Hasil : ");
    JLabel LLuas = new JLabel();
    JLabel LKeliling = new JLabel();
    JLabel LVolume = new JLabel();
    JLabel LLuasPermukaan = new JLabel();
        
    JTextField TPanjang = new JTextField();
    JTextField TLebar = new JTextField();
    JTextField TTinggi = new JTextField();
        
    JButton BHitung = new JButton("Hitung");
    JButton BReset = new JButton("Reset");
    
    public KalkulatorBalok(){
        setVisible(true);
        setSize(570,610);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        add(LJudul);
        add(LPanjang);
        add(LLebar);
        add(LTinggi);
        add(LHasil);
        add(LLuas);
        add(LKeliling);
        add(LVolume);
        add(LLuasPermukaan);
        add(TPanjang);
        add(TLebar);
        add(TTinggi);
        add(BHitung);
        add(BReset);
        
        LJudul.setBounds(220,30,200,30);
        LPanjang.setBounds(80,110,100,40);
        LLebar.setBounds(80,175,100,40);
        LTinggi.setBounds(80,240,100,40);
        LHasil.setBounds(207,294,100,40);
        LLuas.setBounds(80,349,400,40);
        LKeliling.setBounds(80,381,400,40);
        LVolume.setBounds(80,413,400,40);
        LLuasPermukaan.setBounds(80,445,400,40);
        TPanjang.setBounds(200,120,240,25);
        TLebar.setBounds(200,183,240,25);
        TTinggi.setBounds(200,250,240,25);
        BHitung.setBounds(185,540,100,23);
        BReset.setBounds(295,540,100,23);
        
        BHitung.addActionListener(this);
        BReset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent reason) {
        if(reason.getSource() == BHitung){
            try{
                double p =  Double.parseDouble(TPanjang.getText());
                double l =  Double.parseDouble(TLebar.getText());
                double t =  Double.parseDouble(TTinggi.getText());
                
                Balok block = new Balok(t, p, l);

                LLuas.setText(String.format("Luas Persegi Panjang : %.2f",block.hitungLuas()));
                LKeliling.setText(String.format("Keliling Persegi Panjang : %.2f", block.hitungKeliling()));
                LVolume.setText(String.format("Volume Balok : %.2f", block.hitungVolume()));
                LLuasPermukaan.setText(String.format("Luas Permukaan Balok : %.2f", block.hitungLuasPermukaan()));
            } catch(NumberFormatException NFE){
                JOptionPane.showMessageDialog(null, NFE.getMessage(), "Message", JOptionPane.INFORMATION_MESSAGE);
            } catch(Exception E){
                JOptionPane.showMessageDialog(null, "Unknown Error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(reason.getSource() == BReset){
            TPanjang.setText(null);
            TLebar.setText(null);
            TTinggi.setText(null);
            LLuas.setText(null);
            LKeliling.setText(null);
            LVolume.setText(null);
            LLuasPermukaan.setText(null);
        }
    }
    
    public static void main(String[] args) {
        KalkulatorBalok kalkulator = new KalkulatorBalok();
    }
}
