package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.ProductModel;
import model.StockModel;
import model.SupplierModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import view.ProductForm;
import view.StockView;
import view.SupplierForm;

public class StockController implements ActionListener {

    private final StockModel model;
    private final StockView view;

    public StockController(StockModel model, StockView view) {
        this.model = model;
        this.view = view;
        initializeListeners();
        printProduct();
    }

    public void launchView() {
        view.setTitle("Gestion de Inventario");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void initializeListeners() {
        view.btnAddProduct.addActionListener(this);
        view.btnAddSupplier.addActionListener(this);
    }

    private void showProductForm() {
        ProductModel productModel = new ProductModel();
        ProductForm productView = ProductForm.getInstance();
        (new ProductController(productModel, productView)).launchView();
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

    private void printProduct() {
        int height = 35;
        int index = 0;

        for (StockModel product : model.getAllProducts()) {
            JPanel cellName = view.createCellTable((index + 1) + ". " + product.getProductName());
            view.name.add(cellName, new AbsoluteConstraints(2, height, 308, 40));

            JPanel cellPrice = view.createCellTable(String.valueOf(product.getProductPrice()));
            view.price.add(cellPrice, new AbsoluteConstraints(2, height, 173, 40));

            JPanel cellQuantity = view.createCellTable(String.valueOf(product.getProductQuantity()));
            view.quantity.add(cellQuantity, new AbsoluteConstraints(2, height, 93, 40));

            height += 40;
            index++;
        }
    }
}
