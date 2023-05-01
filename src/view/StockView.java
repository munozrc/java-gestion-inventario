package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StockView extends javax.swing.JFrame {

    public StockView() {
        initComponents();
    }

    public JPanel createCellTable(String value) {
        JPanel cell = new JPanel();
        cell.setBackground(new java.awt.Color(255, 255, 255));
        cell.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(227, 227, 227)));
        cell.setLayout(new BoxLayout(cell, BoxLayout.LINE_AXIS));

        JLabel text = new JLabel();
        text.setFont(new Font("Segoe UI", 1, 12));
        text.setForeground(new Color(91, 93, 95));
        text.setText("    " + value);
        cell.add(text);

        return cell;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        brand = new javax.swing.JLabel();
        branddot = new javax.swing.JLabel();
        searchbar = new javax.swing.JPanel();
        searchIcon = new javax.swing.JLabel();
        inputSearch = new javax.swing.JTextField();
        table = new javax.swing.JPanel();
        name = new javax.swing.JPanel();
        nameWrapper = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        price = new javax.swing.JPanel();
        priceWrapper = new javax.swing.JPanel();
        priceLabel = new javax.swing.JLabel();
        quantity = new javax.swing.JPanel();
        quantityWrapper = new javax.swing.JPanel();
        quantityLabel = new javax.swing.JLabel();
        actions = new javax.swing.JPanel();
        actionsWrapper = new javax.swing.JPanel();
        actionsLabel = new javax.swing.JLabel();
        buttonGroup = new javax.swing.JPanel();
        btnAddSupplier = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Window"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        container.setBackground(new java.awt.Color(247, 247, 247));

        menu.setBackground(new java.awt.Color(16, 16, 16));
        menu.setMaximumSize(new java.awt.Dimension(800, 45));
        menu.setMinimumSize(new java.awt.Dimension(800, 45));
        menu.setPreferredSize(new java.awt.Dimension(800, 45));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        brand.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        brand.setForeground(new java.awt.Color(250, 250, 250));
        brand.setText("Stock");
        menu.add(brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        branddot.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        branddot.setForeground(new java.awt.Color(255, 102, 102));
        branddot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        branddot.setText(".");
        branddot.setAlignmentX(0.5F);
        menu.add(branddot, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 0, 10, 30));

        searchbar.setBackground(new java.awt.Color(64, 64, 64));

        searchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search_icon.png"))); // NOI18N

        inputSearch.setBackground(new java.awt.Color(64, 64, 64));
        inputSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputSearch.setForeground(new java.awt.Color(204, 204, 204));
        inputSearch.setBorder(null);
        inputSearch.setCaretColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout searchbarLayout = new javax.swing.GroupLayout(searchbar);
        searchbar.setLayout(searchbarLayout);
        searchbarLayout.setHorizontalGroup(
            searchbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(searchIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        searchbarLayout.setVerticalGroup(
            searchbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchbarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(searchIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        menu.add(searchbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 300, 45));

        table.setBackground(new java.awt.Color(255, 255, 255));
        table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 0, new java.awt.Color(227, 227, 227)));
        name.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameWrapper.setBackground(new java.awt.Color(246, 246, 246));
        nameWrapper.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(227, 227, 227)));
        nameWrapper.setLayout(new javax.swing.BoxLayout(nameWrapper, javax.swing.BoxLayout.LINE_AXIS));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(150, 149, 157));
        nameLabel.setText("    Nombre");
        nameWrapper.add(nameLabel);

        name.add(nameWrapper, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 308, 33));

        table.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 340));

        price.setBackground(new java.awt.Color(255, 255, 255));
        price.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 0, new java.awt.Color(227, 227, 227)));
        price.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        priceWrapper.setBackground(new java.awt.Color(246, 246, 246));
        priceWrapper.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(227, 227, 227)));
        priceWrapper.setToolTipText("");
        priceWrapper.setLayout(new javax.swing.BoxLayout(priceWrapper, javax.swing.BoxLayout.LINE_AXIS));

        priceLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(150, 149, 157));
        priceLabel.setText("    Precio");
        priceWrapper.add(priceLabel);

        price.add(priceWrapper, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 173, 33));

        table.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 175, 340));

        quantity.setBackground(new java.awt.Color(255, 255, 255));
        quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 0, new java.awt.Color(227, 227, 227)));
        quantity.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        quantityWrapper.setBackground(new java.awt.Color(246, 246, 246));
        quantityWrapper.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(227, 227, 227)));
        quantityWrapper.setLayout(new javax.swing.BoxLayout(quantityWrapper, javax.swing.BoxLayout.LINE_AXIS));

        quantityLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        quantityLabel.setForeground(new java.awt.Color(150, 149, 157));
        quantityLabel.setText("    Cantidad");
        quantityWrapper.add(quantityLabel);

        quantity.add(quantityWrapper, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 93, 33));

        table.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 0, 95, 340));

        actions.setBackground(new java.awt.Color(255, 255, 255));
        actions.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(227, 227, 227)));
        actions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        actionsWrapper.setBackground(new java.awt.Color(246, 246, 246));
        actionsWrapper.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(227, 227, 227)));
        actionsWrapper.setLayout(new javax.swing.BoxLayout(actionsWrapper, javax.swing.BoxLayout.LINE_AXIS));

        actionsLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        actionsLabel.setForeground(new java.awt.Color(150, 149, 157));
        actionsLabel.setText("    Acciones");
        actionsWrapper.add(actionsLabel);

        actions.add(actionsWrapper, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 186, 33));

        table.add(actions, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 190, 340));

        buttonGroup.setBackground(new java.awt.Color(243, 243, 243));
        buttonGroup.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(229, 229, 229)));
        buttonGroup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddSupplier.setBackground(new java.awt.Color(234, 234, 234));
        btnAddSupplier.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnAddSupplier.setForeground(new java.awt.Color(102, 102, 102));
        btnAddSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/add_icon.png"))); // NOI18N
        btnAddSupplier.setText("Proveedor  ");
        btnAddSupplier.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(229, 229, 229)));
        btnAddSupplier.setContentAreaFilled(false);
        btnAddSupplier.setFocusPainted(false);
        buttonGroup.add(btnAddSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 130, 36));

        btnAddProduct.setBackground(new java.awt.Color(234, 234, 234));
        btnAddProduct.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(102, 102, 102));
        btnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/add_icon.png"))); // NOI18N
        btnAddProduct.setText("Producto  ");
        btnAddProduct.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 1, new java.awt.Color(229, 229, 229)));
        btnAddProduct.setContentAreaFilled(false);
        btnAddProduct.setFocusPainted(false);
        buttonGroup.add(btnAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 130, 36));

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(buttonGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(container);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel actions;
    private javax.swing.JLabel actionsLabel;
    private javax.swing.JPanel actionsWrapper;
    private javax.swing.JLabel brand;
    private javax.swing.JLabel branddot;
    public javax.swing.JButton btnAddProduct;
    public javax.swing.JButton btnAddSupplier;
    private javax.swing.JPanel buttonGroup;
    private javax.swing.JPanel container;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JPanel menu;
    public javax.swing.JPanel name;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel nameWrapper;
    public javax.swing.JPanel price;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JPanel priceWrapper;
    public javax.swing.JPanel quantity;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JPanel quantityWrapper;
    private javax.swing.JLabel searchIcon;
    private javax.swing.JPanel searchbar;
    private javax.swing.JPanel table;
    // End of variables declaration//GEN-END:variables
}
