package controller;

import app.Observer;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import model.ProductModel;
import model.StockModel;
import model.SupplierModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import view.ProductForm;
import view.StockView;
import view.SupplierForm;

public class StockController implements ActionListener, Observer {

    private final StockModel model;
    private final StockView view;

    public StockController(StockModel model, StockView view) {
        this.model = model;
        this.view = view;
        filterProductsByName();
        initializeListeners();
    }

    public void launchView() {
        view.setTitle("Gestion de Inventario");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void initializeListeners() {
        view.btnAddProduct.addActionListener(this);
        view.btnAddSupplier.addActionListener(this);

        view.inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER
                        && !view.inputSearch.getText().equals("")) {
                    filterProductsByName();
                }
            }
        });
    }

    // TODO: Move create and persistan cell titles to view - refactor
    private void filterProductsByName() {
        model.setProductName(view.inputSearch.getText());

        Component titleName = view.name.getComponents()[0];
        Component titlePrice = view.price.getComponents()[0];
        Component titleQuantity = view.quantity.getComponents()[0];

        view.name.removeAll();
        view.price.removeAll();
        view.quantity.removeAll();

        view.name.add(titleName, new AbsoluteConstraints(2, 2, 308, 33));
        view.price.add(titlePrice, new AbsoluteConstraints(2, 2, 173, 33));
        view.quantity.add(titleQuantity, new AbsoluteConstraints(2, 2, 93, 33));

        int height = 35;
        int index = 0;

        for (StockModel product : model.getAllProductsByName()) {
            JPanel cellName = view.createCellTable(product.getProductName());
            view.name.add(cellName, new AbsoluteConstraints(2, height, 308, 40));

            JPanel cellPrice = view.createCellTable(String.valueOf(product.getProductPrice()));
            view.price.add(cellPrice, new AbsoluteConstraints(2, height, 173, 40));

            JPanel cellQuantity = view.createCellTable(String.valueOf(product.getProductQuantity()));
            view.quantity.add(cellQuantity, new AbsoluteConstraints(2, height, 93, 40));

            height += 40;
            index++;
        }

        view.revalidate();
        view.repaint();
    }

    private void showProductForm() {
        ProductModel productModel = new ProductModel();
        ProductForm productView = ProductForm.getInstance();
        ProductController controller = new ProductController(productModel, productView);

        controller.attach(this);
        controller.launchView();
    }

    private void showSupplierForm() {
        SupplierModel supplierModel = new SupplierModel();
        SupplierForm supplierView = SupplierForm.getInstance();
        (new SupplierController(supplierModel, supplierView)).launchView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnAddProduct) {
            showProductForm();
        } else if (e.getSource() == view.btnAddSupplier) {
            showSupplierForm();
        }
    }

    @Override
    public void update() {
        filterProductsByName();
    }
}
