package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ProductModel;
import model.StockModel;
import model.SupplierModel;
import view.ProductForm;
import view.StockView;
import view.SupplierForm;

public class StockController implements ActionListener {

    private final StockModel model;
    private final StockView window;

    public StockController(StockModel model, StockView view) {
        this.model = model;
        this.window = view;
        initializeListeners();
    }

    public void launchView() {
        window.setTitle("Gestion de Inventario");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void initializeListeners() {
        window.buttonAddProduct.addActionListener(this);
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
        if (e.getSource() == window.buttonAddProduct) {
            showProductForm();
        }
    }

}
