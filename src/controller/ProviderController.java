package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Provider;
import model.ProviderRepository;
import view.ProviderForm;

public class ProviderController implements ActionListener {

    private final ProviderRepository model;
    private final ProviderForm view;

    public ProviderController(ProviderRepository model, ProviderForm view) {
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
            return;
        }

        if (!checkEmail(email)) {
            System.out.println("Email no valid!");
            return;
        }

        Provider provider = new Provider(name, email);
        boolean addedSuccessfully = model.addProvider(provider);

        if (!addedSuccessfully) {
            return;
        }

        view.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.buttonAccept) {
            addProvider();
        } else if (e.getSource() == view.buttonCancel) {
            view.dispose();
        }
    }

    // Utility methods
    private boolean checkEmail(String text) {
        String regex = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

}
