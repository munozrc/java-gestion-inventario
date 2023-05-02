package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.SupplierFacade;
import view.SupplierForm;

public class SupplierController implements ActionListener {

    private final SupplierFacade modelFacade;
    private final SupplierForm view;

    public SupplierController(SupplierFacade modelFacade, SupplierForm view) {
        this.modelFacade = modelFacade;
        this.view = view;
        initializeListeners();
    }

    public void launchView() {
        this.view.setTitle("Proveedor");
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }

    private void initializeListeners() {
        view.buttonAccept.addActionListener(this);
        view.buttonCancel.addActionListener(this);
    }

    private void addProvider() {
        modelFacade.setName(view.nameText.getText());
        modelFacade.setEmail(view.emailText.getText());

        if (!modelFacade.AddNewSupplier()) {
            return;
        }

        view.dispose();
        this.cleanFields();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.buttonAccept) {
            addProvider();
        } else if (e.getSource() == view.buttonCancel) {
            view.dispose();
            this.cleanFields();
        }
    }

    // Utility methods
    private void cleanFields() {
        view.nameText.setText("");
        view.emailText.setText("");
    }

}
