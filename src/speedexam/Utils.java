/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speedexam;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class Utils extends JFrame{
    private JScrollPane pTable;
    private JPanel pButton,pQL,pTK;
    private JTable tb;
    DefaultTableModel tm;
    private JTextField txtsoluong;
    private JComboBox cbmaS,cbmBD;
    private JButton btadd,btdelete,btedit,btsave,btreadfile,btsxsl,btsxtt,btTKDS;
    private JTextArea txttk;
    private String fileS,fileBD,fileQL;
   private ArrayList<Sach> listsach;
    private ArrayList<BanDoc> listbd;
     private ArrayList<QLMS> listql;
    public Utils(){
          setSize(1000,800);
          setLocation(100,20);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          initGUI();
          initvalue();
          init3file();
          loadfile();
          loadcombobox();
          btadd.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  //To change body of generated methods, choose Tools | Templates.
                  int mas=Integer.parseInt(cbmaS.getSelectedItem().toString());
                  int mabd=Integer.parseInt(cbmBD.getSelectedItem().toString());
                
                  if(getQLbyMa(mas, mabd)==-1)
                  {
                       if(getDauSachbyMa(mabd)>5)
                       {
                        JOptionPane.showMessageDialog(null, "ko muon qua 5 dau sach");
                       }
                       else
                       {
                           if(Integer.parseInt(txtsoluong.getText())>3)
                           {
                            JOptionPane.showMessageDialog(null, "ko muon qua 3 cuon");
                           }
                           else
                           {
                              Sach a=getSachbyMa(mas);
                              BanDoc b=getBanDocbyMa(mabd);
                             QLMS c=new QLMS(b, a, Integer.parseInt(txtsoluong.getText()));
                             listql.add(c);
                             tm.addRow(c.toObject());
                           }
                       }
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(null, "ba da muon cuon nay roi");
                  }
              }
          });
          btdelete.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  //To change body of generated methods, choose Tools | Templates.
                  int row=tb.getSelectedRow();
                  if(row<0||row>tb.getRowCount())
                  {
                  JOptionPane.showMessageDialog(null, "chon 1 cai de xoa ");
                  }
                  else
                  {
                  listql.remove(row);
                  tm.removeRow(row);
                  }
              }
          });
          btsave.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
                 FileIO.writefile(listql, fileQL);
              }
          });
          btreadfile.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
                 FileIO.readfile(listql, fileQL);
                 tm.setRowCount(0);
                 for(QLMS o:listql)
                     tm.addRow(o.toObject());
              }
          });
          btsxsl.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   //To change body of generated methods, choose Tools | Templates.
                   for(int i=0;i<listql.size()-1;i++)
                   {
                       for(int j=0;j<listql.size()-1-i;j++)
                       {
                          if(listql.get(j).getSoLuong()>listql.get(j+1).getSoLuong())
                          {
                             QLMS a=listql.get(j);
                             QLMS b=listql.get(j+1);
                             listql.set(j, b);
                             listql.set(j+1, a);
                          }
                       }
                   }
                    tm.setRowCount(0);
                 for(QLMS o:listql)
                     tm.addRow(o.toObject());
              }
              
          });
       btsxtt.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  //To change body of generated methods, choose Tools | Templates.
                  for(int i=0;i<listql.size()-1;i++)
                   {
                       for(int j=0;j<listql.size()-1-i;j++)
                       {
                          if(listql.get(j).getHoten().compareTo(listql.get(j+1).getHoten())>0)
                          {
                             QLMS a=listql.get(j);
                             QLMS b=listql.get(j+1);
                             listql.set(j, b);
                             listql.set(j+1, a);
                          }
                       }
                   }
                    tm.setRowCount(0);
                 for(QLMS o:listql)
                     tm.addRow(o.toObject());
                  
              }
          });
       btTKDS.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  //To change body of generated methods, choose Tools | Templates.
                  int k=0;
                  String tt;
                  int count;
                  txttk.setText("STT\thho ten\tso dau sach\n");
                  for(int i=0;i<listbd.size();i++)
                  {
                    k++;
                    count=getDauSachbyMa(listbd.get(i).getMaBanDoc());
                    tt=k+"\t"+listbd.get(i).getHoTen()+"\t"+count+"\n";
                    txttk.append(tt);
                  }
              }
          });
    }
    public static void main(String[] args) {
        Utils n=new Utils();
        n.setVisible(true);
    }
    public Sach getSachbyMa(int mas)
    {
        for(Sach o:listsach)
            if(mas==o.getMaSach())
                return o;
        return null;
    }
        public BanDoc getBanDocbyMa(int mabd)
    {
        for(BanDoc o:listbd)
            if(mabd==o.getMaBanDoc())
                return o;
        return null;
    }
        public int getQLbyMa(int mas,int mabd)
        {
           for(int i=0;i<listql.size();i++)
           {
               if(listql.get(i).getMaBanDoc()==mabd&&listql.get(i).getMaSach()==mas)
               {
                   return i;
               }
           }
           return -1;
        }
          public int getDauSachbyMa(int mabd)
        {
            int count=0;
           for(int i=0;i<listql.size();i++)
           {
               if(listql.get(i).getMaBanDoc()==mabd)
               {
                   count++;
               }
           }
           return count;
        }

    private void initGUI() {
        //To change body of generated methods, choose Tools | Templates.
        setLayout(new BorderLayout());
        // phan bang
        
        pTable=new JScrollPane();
        String cols[]={"ma ban doc","ten ban doc","ma sach","ten sach","so luong"};
        add(pTable,BorderLayout.NORTH);
        tm=new DefaultTableModel(cols,0);
        tb=new JTable(tm);
        pTable.setViewportView(tb);
        
        // pha quan ly
        pQL=new JPanel();
        add(pQL,BorderLayout.CENTER);
        txtsoluong=new JTextField("");
        txtsoluong.setPreferredSize(new Dimension(100,20));
        cbmBD=new JComboBox();
        cbmBD.setPreferredSize(new Dimension(100,20));
          cbmaS=new JComboBox();
        cbmaS.setPreferredSize(new Dimension(100,20));
        pQL.add(new JLabel("ma ban doc"));
        pQL.add(cbmBD);
        pQL.add(new JLabel("ma ban doc"));
        pQL.add(cbmaS);
        pQL.add(new JLabel("ma ban doc"));
        pQL.add(txtsoluong);
        pQL.setLayout(new GridLayout(4,2,5,5));
        
        // phan btutton
        
        pButton=new JPanel();
        add(pButton,BorderLayout.EAST);
        btadd=new JButton("add");
        btedit=new JButton("edit");
        btdelete=new JButton("delete");
        btsave=new JButton("save");
        btreadfile=new JButton("readfile");
        btsxsl=new JButton("sxsl");
        btsxtt=new JButton("sxtt");
        btTKDS=new JButton("TKDS");
        pButton.add(btadd);
        pButton.add(btedit);
        pButton.add(btdelete);
        pButton.add(btsave);
        pButton.add(btreadfile);
        pButton.add(btsxsl);
        pButton.add(btsxtt);
        pButton.add(btTKDS);
        pButton.setLayout(new GridLayout(0,2,5,5));
        // phan thong ke
        
        pTK=new JPanel();
        add(pTK,BorderLayout.SOUTH);
        txttk=new JTextArea("thong ke hear");
        pTK.add(txttk);
        
    }

    private void initvalue() {
        //To change body of generated methods, choose Tools | Templates.
        fileS="src/speedexam/SACH.txt";
        fileBD="src/speedexam/BANDOC.txt";
        fileQL="src/speedexam/QLMS.txt";
        listsach=new ArrayList<>();
        listql=new ArrayList<>();
        listbd=new ArrayList<>();
    }

    private void init3file() {
        //To change body of generated methods, choose Tools | Templates.
        Sach a=new Sach(10000, "sach a", "cntt", "nhu", 2019, 20);
         Sach b=new Sach(10001, "sach b", "cntt", "nhu", 2019, 20);
          Sach c=new Sach(10002, "sach c", "cntt", "nhu", 2019, 20);
           Sach d=new Sach(10003, "sach d", "cntt", "nhu", 2019, 20);
            Sach e=new Sach(10004, "sach e", "cntt", "nhu", 2019, 20); 
            Sach f=new Sach(10005, "sach f", "cntt", "nhu", 2019, 20);
            listsach.add(a);
            listsach.add(b);
            listsach.add(c);
            listsach.add(d);
            listsach.add(e);
            listsach.add(f);
            
            BanDoc na=new BanDoc(10000, "nguyen van a", "ha noi", "111111");
            BanDoc nb=new BanDoc(10001, "nguyen van b", "ha noi", "111111");
            BanDoc nc=new BanDoc(10002, "nguyen van c", "ha noi", "111111");
            
            listbd.add(na);
            listbd.add(nb);
            listbd.add(nc);
            
            listql.add(new QLMS(na, a, 3));
             listql.add(new QLMS(na, b, 2));
              listql.add(new QLMS(nb, c, 1));
               listql.add(new QLMS(nc, d, 3));
               FileIO.writefile(listbd, fileBD);
               FileIO.writefile(listsach, fileS);
               FileIO.writefile(listql, fileQL);
            
    }

    private void loadfile() {
         //To change body of generated methods, choose Tools | Templates.
         FileIO.readfile(listql, fileQL);
         for(QLMS o:listql)
             tm.addRow(o.toObject());
    }

    private void loadcombobox() {
        //To change body of generated methods, choose Tools | Templates.
        for(Sach o:listsach)
            cbmaS.addItem(o.getMaSach());
        for(BanDoc o:listbd)
            cbmBD.addItem(o.getMaBanDoc());
    }
    
}
