package controller;

import view.StockWindow;

public class StockController {

    private final StockWindow window;

    public StockController(StockWindow view) {
        this.window = view;
    }

    public void launchStockWindow() {
        this.window.setTitle("Gestion de Inventario");
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);
    }

}
