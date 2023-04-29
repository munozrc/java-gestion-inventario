package app;

import controller.StockController;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.StockRepository;
import view.StockWindow;

public class StartApplication {

    public static void main(String[] args) {

        setLookAndFeel();

        StockWindow view = new StockWindow();
        StockRepository model = new StockRepository();
        StockController controller = new StockController(model, view);

        controller.launchView();

    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
