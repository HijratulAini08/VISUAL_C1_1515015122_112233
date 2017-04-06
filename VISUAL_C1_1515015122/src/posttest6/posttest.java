package posttest6;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class posttest extends javax.swing.JFrame {
    
    private DefaultTableModel model;
    private Connection con = koneksi.getConnection();
    private Statement stt;
    private ResultSet rss;
    private PreparedStatement pst;
    
    public posttest() {
        initComponents();
    }
    
    private void InitTable(){
        model = new DefaultTableModel();
        model.addColumn("nama_pasien");
        model.addColumn("tl");
        model.addColumn("usia");
        model.addColumn("jk");
        model.addColumn("diagnosa");
        model.addColumn("dokter");
        model.addColumn("ruangan");
        model.addColumn("tgl_masuk");
        jTable2.setModel(model);
    }
    
    private void TampilData(){
        try{
            String sql = "SELECT *FROM rumahsakit";
            stt =con.createStatement();
            rss =stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[9];
                o[0] = rss.getString("nama_pasien");
                o[1] = rss.getDate("tl");
                o[2] = rss.getInt("usia");
                o[3] = rss.getString("jk");
                o[4] = rss.getString("diagnosa");
                o[5] = rss.getString("dokter");
                o[6] = rss.getString("ruangan");
                o[7] = rss.getDate("tgl_masuk");
                model.addRow(o);
            }
            stt.close();
            rss.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    private void TambahData(String nama_pasien, String tl, String usia, String jk, String diagnosa, String dokter, String ruangan, String tgl_masuk){
        try{
            String sql= "INSERT INTO rumahsakit VALUES (NULL,'"+nama_pasien+"','"+tl+"','"+usia+"','"+jk+"','"+diagnosa+"','"+dokter+"','"+ruangan+"','"+tgl_masuk+"')";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            model.addRow(new Object[]{nama_pasien,tl,usia,jk,diagnosa,dokter,ruangan,tgl_masuk});
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        form = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pria = new javax.swing.JRadioButton();
        wanita = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        diagnosa1 = new javax.swing.JList<>();
        tambah = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        Dokter = new javax.swing.JComboBox<>();
        txt_masuk = new javax.swing.JTextField();
        Ruangan = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        diagnosa2 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        cari = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_lahir = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_pasien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_umur = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(241, 243, 240));

        form.setBackground(new java.awt.Color(238, 238, 241));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Tanggal Lahir");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Jenis Kelamin");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("Diagnosa");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("Nama Dokter");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setText("Ruangan");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 153));
        jLabel8.setText("Tanggal Masuk");

        buttonGroup2.add(pria);
        pria.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        pria.setForeground(new java.awt.Color(255, 153, 153));
        pria.setText("L");
        pria.setEnabled(false);

        buttonGroup2.add(wanita);
        wanita.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        wanita.setForeground(new java.awt.Color(255, 153, 153));
        wanita.setText("P");
        wanita.setEnabled(false);
        wanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wanitaActionPerformed(evt);
            }
        });

        diagnosa1.setBackground(new java.awt.Color(255, 204, 204));
        diagnosa1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Migren", "Insomnia", "Buta Senja", "Vulvitis", "Fimosis" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        diagnosa1.setEnabled(false);
        diagnosa1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosa1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diagnosa1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(diagnosa1);

        tambah.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posttest6/Actions-list-add-user-icon.png"))); // NOI18N
        tambah.setText("TAMBAH");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        simpan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posttest6/Save-icon.png"))); // NOI18N
        simpan.setText("SIMPAN");
        simpan.setEnabled(false);
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        keluar.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        keluar.setText("KELUAR");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        Dokter.setBackground(new java.awt.Color(255, 204, 204));
        Dokter.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Dokter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dr.Hijratul Aini", "dr.Kencana" }));
        Dokter.setEnabled(false);

        txt_masuk.setEditable(false);
        txt_masuk.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_masukCaretUpdate(evt);
            }
        });

        Ruangan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Ruangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bangsal 1", "Bangsal 2", "Bangsal 3" }));
        Ruangan.setEnabled(false);
        Ruangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RuanganActionPerformed(evt);
            }
        });

        diagnosa2.setBackground(new java.awt.Color(255, 204, 204));
        diagnosa2.setColumns(20);
        diagnosa2.setRows(5);
        diagnosa2.setEnabled(false);
        diagnosa2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                diagnosa2CaretUpdate(evt);
            }
        });
        jScrollPane2.setViewportView(diagnosa2);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 153));
        jLabel11.setText("YYYY-MM-DD");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 153));
        jLabel12.setText("YYYYMMDD");

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        cari.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nama_pasien", "dokter" }));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("BY");

        txt_cari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_cariCaretUpdate(evt);
            }
        });
        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posttest6/search-icon.png"))); // NOI18N
        jLabel9.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel9)
                .addGap(46, 46, 46)
                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_lahir.setEditable(false);
        txt_lahir.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_lahirCaretUpdate(evt);
            }
        });
        txt_lahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lahirActionPerformed(evt);
            }
        });
        txt_lahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_lahirKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("Nama Pasien");

        txt_pasien.setEditable(false);
        txt_pasien.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_pasienCaretUpdate(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("Umur");

        txt_umur.setEditable(false);
        txt_umur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_umurActionPerformed(evt);
            }
        });
        txt_umur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_umurKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(formLayout.createSequentialGroup()
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formLayout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(tambah)
                                .addGap(75, 75, 75)
                                .addComponent(simpan))
                            .addGroup(formLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(formLayout.createSequentialGroup()
                                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(formLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(53, 53, 53))
                                            .addGroup(formLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(53, 53, 53)))
                                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(formLayout.createSequentialGroup()
                                                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(formLayout.createSequentialGroup()
                                                        .addGap(2, 2, 2)
                                                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txt_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(formLayout.createSequentialGroup()
                                                                .addComponent(txt_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel11))))
                                                    .addComponent(Ruangan, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_umur, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(107, 107, 107)
                                                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addGroup(formLayout.createSequentialGroup()
                                                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel8)
                                                            .addComponent(jLabel6))
                                                        .addGap(31, 31, 31)
                                                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(Dokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(formLayout.createSequentialGroup()
                                                                .addComponent(txt_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(formLayout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                            .addGroup(formLayout.createSequentialGroup()
                                                .addComponent(pria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(wanita, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Dokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(formLayout.createSequentialGroup()
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formLayout.createSequentialGroup()
                                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_umur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(wanita, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pria, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txt_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Ruangan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambah)
                            .addComponent(simpan))))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keluar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel13.setText("HOSPITAL");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel14.setText("CENTER");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posttest6/Hospital-red-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(576, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(33, 33, 33))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        InitTable();
        TampilData();
    }//GEN-LAST:event_formComponentShown

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();//mendeklarasikan model yang mmengambil data vector dan meremove semua ellements
        model.fireTableDataChanged();//mendeklarasikan model yang di fireTableDataChanged
        String caridengan = cari.getSelectedItem().toString();//mendeklarasikan variabel caridengan yang mengambil nilai dari combocari yang di jadikan string
        try {

            String sql="select * from rumahsakit where "+caridengan+" like'%"+txt_cari.getText()+"%'";////mendeklarasikan variabel sql dengan query untuk mencari data sesuai nilai dari combocari yang mengandung data sesuai nilai yang diinput di textfield cari
            stt = con. createStatement();//pembuatan statement
            rss = stt. executeQuery(sql);//eksekusi query
            ResultSet rss=stt.executeQuery(sql);
            while (rss.next()) { // perulangan result set dari variable rss hingga tidak terpenuhi untuk perulangan
                //menampilkan data sesuai array :
                Object[] o=new Object[9];
                o[0]=rss.getString("nama_pasien");
                o[1]=rss.getDate("tl");
                o[2]=rss.getString("usia");
                o[3]=rss.getString("jk");
                o[4]=rss.getString("diagnosa");
                o[5]=rss.getString("dokter");
                o[6]=rss.getString("ruangan");
                o[7]=rss.getString("tgl_masuk");

                model.addRow(o);
            }
            stt.close();//menutup stt
            rss.close();//menutup rss
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_txt_cariKeyTyped

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void txt_cariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_cariCaretUpdate
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_cariCaretUpdate

    private void diagnosa2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_diagnosa2CaretUpdate
        // TODO add your handling code here:
        if (txt_pasien.getText().length() !=0 && txt_lahir.getText().length() !=0 && txt_umur.getText().length() !=0 && txt_masuk.getText().length() !=0 && diagnosa2.getText().length() !=0 )
        {
            simpan.setEnabled(true);
        }
        else
        {
            simpan.setEnabled(false);
        }
    }//GEN-LAST:event_diagnosa2CaretUpdate

    private void RuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RuanganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RuanganActionPerformed

    private void txt_masukCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_masukCaretUpdate
        // TODO add your handling code here:
        if (txt_pasien.getText().length() !=0 && txt_lahir.getText().length() !=0 && txt_umur.getText().length() !=0 && txt_masuk.getText().length() !=0 && diagnosa2.getText().length() !=0 )
        {
            simpan.setEnabled(true);
        }
        else
        {
            simpan.setEnabled(false);
        }
    }//GEN-LAST:event_txt_masukCaretUpdate

    private void txt_lahirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lahirKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lahirKeyPressed

    private void txt_lahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lahirActionPerformed

    private void txt_lahirCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_lahirCaretUpdate
        // TODO add your handling code here:
        if (txt_pasien.getText().length() !=0 && txt_lahir.getText().length() !=0 && txt_umur.getText().length() !=0 && txt_masuk.getText().length() !=0 && diagnosa2.getText().length() !=0 )
        {
            simpan.setEnabled(true);
        }
        else
        {
            simpan.setEnabled(false);
        }
    }//GEN-LAST:event_txt_lahirCaretUpdate

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_keluarActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        String nama_pasien = txt_pasien.getText();
        String tl = txt_lahir.getText();
        String usia = txt_umur.getText();
        String jk;
        if(pria.isSelected()){
            jk=pria.getText();
        }
        else{
            jk=wanita.getText();
        }
        String diagnosa = diagnosa1.getSelectedValue();
        String ruangan = Ruangan.getSelectedItem().toString();
        String dokter = Dokter.getSelectedItem().toString();
        String tgl_masuk = txt_masuk.getText();
        TambahData(nama_pasien,tl,usia,jk,diagnosa,dokter,ruangan,tgl_masuk);
    }//GEN-LAST:event_simpanActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        txt_pasien.setEditable(true);
        txt_umur.setEditable(true);
        txt_lahir.setEditable(true);
        txt_masuk.setEditable(true);
        Ruangan.setEnabled(true);
        Dokter.setEnabled(true);
        pria.setEnabled(true);
        wanita.setEnabled(true);
        diagnosa1.setEnabled(true);
        diagnosa2.setEnabled(true);
    }//GEN-LAST:event_tambahActionPerformed

    private void diagnosa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diagnosa1MouseClicked
        // TODO add your handling code here:
        diagnosa2.append(diagnosa1.getSelectedValue()+"\n");
    }//GEN-LAST:event_diagnosa1MouseClicked

    private void diagnosa1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosa1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosa1AncestorAdded

    private void wanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wanitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wanitaActionPerformed

    private void txt_umurKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_umurKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_umurKeyPressed

    private void txt_umurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_umurActionPerformed
        // TODO add your handling code here:
        if (txt_pasien.getText().length() !=0 && txt_lahir.getText().length() !=0 && txt_umur.getText().length() !=0 && txt_masuk.getText().length() !=0 && diagnosa2.getText().length() !=0 )
        {
            simpan.setEnabled(true);
        }
        else
        {
            simpan.setEnabled(false);
        }
    }//GEN-LAST:event_txt_umurActionPerformed

    private void txt_pasienCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_pasienCaretUpdate
        // TODO add your handling code here:
        if (txt_pasien.getText().length() !=0 && txt_lahir.getText().length() !=0 && txt_umur.getText().length() !=0 && txt_masuk.getText().length() !=0 && diagnosa2.getText().length() !=0 )
        {
            simpan.setEnabled(true);
        }
        else
        {
            simpan.setEnabled(false);
        }
    }//GEN-LAST:event_txt_pasienCaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(posttest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(posttest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(posttest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(posttest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new posttest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Dokter;
    private javax.swing.JComboBox<String> Ruangan;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cari;
    private javax.swing.JList<String> diagnosa1;
    private javax.swing.JTextArea diagnosa2;
    private javax.swing.JPanel form;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton keluar;
    private javax.swing.JRadioButton pria;
    private javax.swing.JButton simpan;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_lahir;
    private javax.swing.JTextField txt_masuk;
    private javax.swing.JTextField txt_pasien;
    private javax.swing.JTextField txt_umur;
    private javax.swing.JRadioButton wanita;
    // End of variables declaration//GEN-END:variables
}
