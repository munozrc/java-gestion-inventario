package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.Product;
import model.Provider;
import model.ProductRepository;
import model.ProviderRepository;
import view.ProductForm;

public class ProductController implements ActionListener {

    private final ProductForm view;
    private final ProductRepository model;

    public ProductController(ProductRepository model, ProductForm view) {
        this.model = model;
        this.view = view;
        this.initializeListeners();
        this.getListOfProviders();
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

        Provider provider = (Provider) view.providerComboBox.getSelectedItem();
        int providerID = provider.getId();

        if (barcodeText.equals("")
                || nameText.equals("")
                || priceText.equals("")
                || stockText.equals("")
                || providerID == 0) {
            return;
        }

        float price;
        int stock;

        // TODO: Add column for provider in products table
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

    private void getListOfProviders() {
        ArrayList<Provider> listOfProviders = (new ProviderRepository()).getListOfProviders();
        listOfProviders.add(0, new Provider(0, "Selecciona", ""));

        Provider[] providers = new Provider[listOfProviders.size()];
        listOfProviders.toArray(providers);

        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(providers);
        view.providerComboBox.setModel(comboBoxModel);
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
