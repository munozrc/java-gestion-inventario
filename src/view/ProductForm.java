package view;

public class ProductForm extends javax.swing.JFrame {

    private static ProductForm instance = null;

    public ProductForm() {
        initComponents();
    }

    public static ProductForm getInstance() {
        if (instance == null) {
            instance = new ProductForm();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        container = new javax.swing.JPanel();
        titleContainer = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameWrapper = new javax.swing.JPanel();
        nameText = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        priceWrapper = new javax.swing.JPanel();
        priceText = new javax.swing.JTextField();
        barcodeLabel = new javax.swing.JLabel();
        barcodeWrapper = new javax.swing.JPanel();
        barcodeText = new javax.swing.JTextField();
        stockLabel = new javax.swing.JLabel();
        stockWrapper = new javax.swing.JPanel();
        stockText = new javax.swing.JTextField();
        providerLabel = new javax.swing.JLabel();
        providerComboBox = new javax.swing.JComboBox<>();
        buttonGroup = new javax.swing.JPanel();
        buttonAccept = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("ProductForm"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(435, 281));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        container.setBackground(new java.awt.Color(246, 246, 246));
        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleContainer.setBackground(new java.awt.Color(16, 16, 16));

        title.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        title.setForeground(new java.awt.Color(250, 250, 250));
        title.setText("Nuevo Producto");

        javax.swing.GroupLayout titleContainerLayout = new javax.swing.GroupLayout(titleContainer);
        titleContainer.setLayout(titleContainerLayout);
        titleContainerLayout.setHorizontalGroup(
            titleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleContainerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(title)
                .addContainerGap(192, Short.MAX_VALUE))
        );
        titleContainerLayout.setVerticalGroup(
            titleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleContainerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(title)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        container.add(titleContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(118, 118, 118));
        nameLabel.setLabelFor(nameText);
        nameLabel.setText("NOMBRE");
        container.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        nameWrapper.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(229, 229, 229), 2, true));
        nameWrapper.setLayout(new javax.swing.BoxLayout(nameWrapper, javax.swing.BoxLayout.LINE_AXIS));

        nameText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        nameWrapper.add(nameText);

        container.add(nameWrapper, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 116, 190, 33));

        priceLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(118, 118, 118));
        priceLabel.setLabelFor(nameText);
        priceLabel.setText("PRECIO");
        container.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 100, -1, -1));

        priceWrapper.setBackground(new java.awt.Color(255, 255, 255));
        priceWrapper.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(229, 229, 229), 2, true));
        priceWrapper.setLayout(new java.awt.BorderLayout());

        priceText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        priceWrapper.add(priceText, java.awt.BorderLayout.CENTER);

        container.add(priceWrapper, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 116, 170, 33));

        barcodeLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        barcodeLabel.setForeground(new java.awt.Color(118, 118, 118));
        barcodeLabel.setLabelFor(nameText);
        barcodeLabel.setText("BARCODE");
        container.add(barcodeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        barcodeWrapper.setBackground(new java.awt.Color(255, 255, 255));
        barcodeWrapper.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(229, 229, 229), 2, true));
        barcodeWrapper.setLayout(new java.awt.BorderLayout());

        barcodeText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        barcodeWrapper.add(barcodeText, java.awt.BorderLayout.CENTER);

        container.add(barcodeWrapper, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 176, 90, 33));

        stockLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        stockLabel.setForeground(new java.awt.Color(118, 118, 118));
        stockLabel.setLabelFor(nameText);
        stockLabel.setText("STOCK");
        container.add(stockLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        stockWrapper.setBackground(new java.awt.Color(255, 255, 255));
        stockWrapper.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(229, 229, 229), 2, true));
        stockWrapper.setLayout(new java.awt.BorderLayout());

        stockText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        stockWrapper.add(stockText, java.awt.BorderLayout.CENTER);

        container.add(stockWrapper, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 176, 90, 33));

        providerLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        providerLabel.setForeground(new java.awt.Color(118, 118, 118));
        providerLabel.setLabelFor(nameText);
        providerLabel.setText("STOCK");
        container.add(providerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 160, -1, -1));

        providerComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(229, 229, 229)));
        container.add(providerComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 176, 170, 33));

        buttonGroup.setBackground(new java.awt.Color(246, 246, 246));
        buttonGroup.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(230, 230, 230)));

        buttonAccept.setText("Añadir");

        buttonCancel.setText("Cancelar");

        javax.swing.GroupLayout buttonGroupLayout = new javax.swing.GroupLayout(buttonGroup);
        buttonGroup.setLayout(buttonGroupLayout);
        buttonGroupLayout.setHorizontalGroup(
            buttonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonGroupLayout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        buttonGroupLayout.setVerticalGroup(
            buttonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonGroupLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(buttonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAccept)
                    .addComponent(buttonCancel))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        container.add(buttonGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 435, 50));

        getContentPane().add(container);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barcodeLabel;
    public javax.swing.JTextField barcodeText;
    private javax.swing.JPanel barcodeWrapper;
    public javax.swing.JButton buttonAccept;
    public javax.swing.JButton buttonCancel;
    private javax.swing.JPanel buttonGroup;
    private javax.swing.JPanel container;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameLabel;
    public javax.swing.JTextField nameText;
    private javax.swing.JPanel nameWrapper;
    private javax.swing.JLabel priceLabel;
    public javax.swing.JTextField priceText;
    private javax.swing.JPanel priceWrapper;
    public javax.swing.JComboBox<String> providerComboBox;
    private javax.swing.JLabel providerLabel;
    private javax.swing.JLabel stockLabel;
    public javax.swing.JTextField stockText;
    private javax.swing.JPanel stockWrapper;
    private javax.swing.JLabel title;
    private javax.swing.JPanel titleContainer;
    // End of variables declaration//GEN-END:variables
}
