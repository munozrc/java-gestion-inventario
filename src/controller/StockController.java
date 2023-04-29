package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.StockRepository;
import view.StockWindow;

public class StockController implements ActionListener {

    private final StockRepository model;
    private final StockWindow window;

    public StockController(StockRepository model, StockWindow view) {
        this.model = model;
        this.window = view;

        initializeListeners();
    }

    public void launchView() {
        this.window.setTitle("Gestion de Inventario");
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);
    }

    private void initializeListeners() {
        // TODO: Add actions listerners for buttons and text fields
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Add action view StockWindow
    }

}
