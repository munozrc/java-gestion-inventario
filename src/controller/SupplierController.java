package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.SupplierModel;
import view.SupplierForm;

public class SupplierController implements ActionListener {

    private final SupplierModel model;
    private final SupplierForm view;

    public SupplierController(SupplierModel model, SupplierForm view) {
        this.model = model;
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
        String name = view.nameText.getText().trim();
        String email = view.emailText.getText().trim();

        if (name.equals("") || email.equals("")) {
            // TODO: show JOptionPane "Campos vacios"
            return;
        }

        if (!checkEmail(email)) {
            // TODO: show JOptionPane "Email no valido"
            return;
        }

        model.setName(name);
        model.setEmail(email);

        if (!model.addProvider()) {
            // TODO: show JOptionPane "Fallo al guardar proveedor"
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
    private boolean checkEmail(String text) {
        String regex = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    private void cleanFields() {
        view.nameText.setText("");
        view.emailText.setText("");
    }

}
