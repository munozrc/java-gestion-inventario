package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ProductModel;
import model.StockModel;
import view.ProductForm;
import view.StockView;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == window.buttonAddProduct) {
            ProductModel proModel = new ProductModel();
            ProductForm viewModel = ProductForm.getInstance();
            (new ProductController(proModel, viewModel)).launchView();
        }
    }

}
