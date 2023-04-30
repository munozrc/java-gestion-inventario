package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Product;
import model.ProductRepository;
import view.ProductForm;

public class ProductController implements ActionListener {

    private final ProductForm view;
    private final ProductRepository model;

    public ProductController(ProductRepository model, ProductForm view) {
        this.model = model;
        this.view = view;
        initializeListeners();
    }

    public void launchView() {
        this.view.setTitle("Producto");
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }

    private void initializeListeners() {
        view.buttonAccept.addActionListener(this);
        view.buttonCancel.addActionListener(this);
    }

    private void addProduct() {

        String barcodeText = view.barcodeText.getText().trim();
        String nameText = view.nameText.getText().trim();
        String priceText = view.priceText.getText().trim();
        String stockText = view.stockText.getText().trim();

        if (barcodeText.equals("")
                || nameText.equals("")
                || priceText.equals("")
                || stockText.equals("")) {
            return;
        }

        float price;
        int stock;

        try {
            price = Float.parseFloat(priceText);
            stock = Integer.parseInt(stockText);
        } catch (NumberFormatException e) {
            return;
        }

        Product product = new Product(nameText, barcodeText, price, stock);
        boolean addedSuccessfully = model.addProduct(product);

        if (!addedSuccessfully) {
            return;
        }

        view.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.buttonAccept) {
            addProduct();
        } else if (e.getSource() == view.buttonCancel) {
            view.dispose();
        }
    }

}
