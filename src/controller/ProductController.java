package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.ProductModel;
import model.SupplierModel;
import view.ProductForm;

public class ProductController implements ActionListener {

    private final ProductForm view;
    private final ProductModel model;

    public ProductController(ProductModel model, ProductForm view) {
        this.model = model;
        this.view = view;
        this.getListOfSuppliers();
        this.initializeListeners();
    }

    public void launchView() {
        this.view.setTitle("Producto");
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }

    public void launchUpdateView(int quantity) {
        launchView();
        this.view.title.setText("Editar Producto");
        this.view.nameText.setText(model.getName());
        this.view.barcodeText.setText(model.getBarcode());
        this.view.priceText.setText(String.valueOf(model.getPrice()));
        this.view.stockText.setText(String.valueOf(quantity));
        this.view.providerComboBox.setSelectedIndex(model.getSupplier());
        this.view.buttonAccept.setText("Guardar");
    }

    private void initializeListeners() {
        view.buttonAccept.addActionListener(this);
        view.buttonCancel.addActionListener(this);
    }

    private void addProduct() {
        String barcodeText = view.barcodeText.getText().trim();
        String nameText = view.nameText.getText().trim();
        String priceText = view.priceText.getText().trim();
        String quantityText = view.stockText.getText().trim();

        SupplierModel supplier = (SupplierModel) view.providerComboBox.getSelectedItem();
        int idSupplier = supplier.getId();

        if (barcodeText.equals("")
                || nameText.equals("")
                || priceText.equals("")
                || quantityText.equals("")
                || idSupplier == 0) { // if it is equal to zero it is the option "Selecciona"
            // TODO: show JOptionPane "Campos vacios"
            return;
        }

        float price;
        int quantity;

        try {
            price = Float.parseFloat(priceText);
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            // TODO: show JOptionPane "Campos invalidos"
            return;
        }

        this.model.setBarcode(barcodeText);
        this.model.setName(nameText);
        this.model.setPrice(price);
        this.model.setSupplier(idSupplier);

        if (!model.save(quantity)) {
            // TODO: show JOptionPane "Fallo al guardar producto"
            return;
        }

        view.dispose();
        this.cleanFields();
    }

    private void updateProduct() {
        String barcodeText = view.barcodeText.getText().trim();
        String nameText = view.nameText.getText().trim();
        String priceText = view.priceText.getText().trim();
        String quantityText = view.stockText.getText().trim();

        SupplierModel supplier = (SupplierModel) view.providerComboBox.getSelectedItem();
        int idSupplier = supplier.getId();

        if (barcodeText.equals("")
                || nameText.equals("")
                || priceText.equals("")
                || quantityText.equals("")
                || idSupplier == 0) { // if it is equal to zero it is the option "Selecciona"
            // TODO: show JOptionPane "Campos vacios"
            return;
        }

        float price;
        int quantity;

        try {
            price = Float.parseFloat(priceText);
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            // TODO: show JOptionPane "Campos invalidos"
            return;
        }

        this.model.setBarcode(barcodeText);
        this.model.setName(nameText);
        this.model.setPrice(price);
        this.model.setSupplier(idSupplier);

        if (!model.update(quantity)) {
            // TODO: show JOptionPane "Fallo al guardar producto"
            return;
        }

        view.dispose();
        this.cleanFields();
    }

    private void getListOfSuppliers() {
        ArrayList<SupplierModel> listOfSuppliers = (new SupplierModel()).getListOfProviders();
        listOfSuppliers.add(0, new SupplierModel(0, "Selecciona", ""));

        SupplierModel[] providers = new SupplierModel[listOfSuppliers.size()];
        listOfSuppliers.toArray(providers);

        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(providers);
        view.providerComboBox.setModel(comboBoxModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.buttonAccept && view.buttonAccept.getText().equals("Guardar")) {
            updateProduct();
        } else if (e.getSource() == view.buttonAccept && view.buttonAccept.getText().equals("Añadir")) {
            addProduct();
        } else if (e.getSource() == view.buttonCancel) {
            view.dispose();
            this.cleanFields();
        }
    }

    private void cleanFields() {
        view.barcodeText.setText("");
        view.nameText.setText("");
        view.priceText.setText("");
        view.stockText.setText("");
        view.providerComboBox.setSelectedIndex(0);
    }

}
