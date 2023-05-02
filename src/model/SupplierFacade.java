package model;

public class SupplierFacade {

    private int id;
    private String name;
    private String email;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean AddNewSupplier() {
        SupplierModel objSupplier = new SupplierModel(id, name, email);

        boolean isValidData = true;
        String error = "";

        if (!objSupplier.isValidField()) {
            error = "Existen campos vacios!";
            isValidData = false;
        }

        if (!objSupplier.isValidEmail() && isValidData) {
            error = "Email no valido!";
            isValidData = false;
        }

        if (!isValidData) {
            // TODO: Show JOPtionPane with error;
            System.out.println("ERROR_SUPPLIER_FACADE: " + error);
            return false;
        }

        return objSupplier.addProvider();
    }
}
