package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.ProductModel;
import model.ProviderModel;
import view.ProductForm;

public class ProductController implements ActionListener {

    private final ProductForm view;
    private final ProductModel model;

    public ProductController(ProductModel model, ProductForm view) {
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

        ProviderModel provider = (ProviderModel) view.providerComboBox.getSelectedItem();
        int id = provider.getId();

        if (barcodeText.equals("")
                || nameText.equals("")
                || priceText.equals("")
                || stockText.equals("")
                || id == 0) {
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

        ProductModel product = new ProductModel(nameText, barcodeText, price, stock, id);
        boolean addedSuccessfully = model.addProduct(product);

        if (!addedSuccessfully) {
            return;
        }

        view.dispose();
    }

    private void getListOfProviders() {
        ArrayList<ProviderModel> listOfProviders = (new ProviderModel()).getListOfProviders();
        listOfProviders.add(0, new ProviderModel(0, "Selecciona", ""));

        ProviderModel[] providers = new ProviderModel[listOfProviders.size()];
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
