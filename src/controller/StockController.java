package controller;

import app.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.ProductModel;
import model.StockModel;
import model.SupplierFacade;
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
        searchProductsByName("");
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
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchProductsByName(view.inputSearch.getText());
                }
            }
        });
    }

    private void searchProductsByName(String query) {
        int height = 33;
        view.cleanTable();

        for (StockModel product : model.getProductsByName(query)) {
            JPanel cellName = view.createCellTable(product.getProductName());
            view.name.add(cellName, new AbsoluteConstraints(2, height, 308, 35));

            String price = formatCurrencyCOP(product.getProductPrice());
            JPanel cellPrice = view.createCellTable(price);
            view.price.add(cellPrice, new AbsoluteConstraints(2, height, 213, 35));

            String quantity = String.valueOf(product.getProductQuantity());
            JPanel cellQuantity = view.createCellTable(quantity);
            view.quantity.add(cellQuantity, new AbsoluteConstraints(2, height, 130, 35));

            JPanel cellActions = view.createActionTable();
            JButton btnEditProduct = (JButton) cellActions.getComponent(0);
            JButton btnDeleteProduct = (JButton) cellActions.getComponent(1);

            btnEditProduct.addActionListener((ActionEvent e) -> {
                // TODO: Implements edit product
                System.out.println("EditProduct");
            });

            btnDeleteProduct.addActionListener((ActionEvent e) -> {
                deleteProduct(product.getProductID());
            });

            view.actions.add(cellActions, new AbsoluteConstraints(2, height, 111, 35));

            height += 35;
        }

        view.revalidate();
        view.repaint();
    }

    private void showProductForm() {
        ProductModel productModel = new ProductModel();
        ProductForm productView = ProductForm.getInstance();
        (new ProductController(productModel, productView)).launchView();
        productModel.attach(this);
    }

    private void showSupplierForm() {
        SupplierFacade supplierFacade = new SupplierFacade();
        SupplierForm supplierView = SupplierForm.getInstance();
        (new SupplierController(supplierFacade, supplierView)).launchView();
    }

    private void deleteProduct(int productID) {
        ProductModel productModel = new ProductModel();
        productModel.attach(this);
        productModel.setId(productID);

        if (!productModel.delete()) {
            // TODO: Show JOptionPane with message "Fallo al eliminar el producto"
            // return;
        }

        // TODO: Show JOptionPane with message "Producto eliminado!"
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
        searchProductsByName("");
    }

    private String formatCurrencyCOP(float value) {
        Locale localeColombia = new Locale("es", "CO");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(localeColombia);
        return currencyFormat.format(value);
    }
}
