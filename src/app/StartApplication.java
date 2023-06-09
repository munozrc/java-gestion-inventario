package app;

import controller.StockController;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.StockModel;
import view.StockView;

public class StartApplication {

    public static void main(String[] args) {
        setLookAndFeel();
        StockModel model = new StockModel();
        StockView view = new StockView();
        (new StockController(model, view)).launchView();
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
