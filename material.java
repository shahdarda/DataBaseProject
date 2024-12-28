package com.example.demo1;


public class material {
    private int M_id;
    private String M_name;
    private String S_info;
    private String U_coast;
    private String Stock_quantity;
    private String Supplier;
    private String Description;

    public material() {
    }

    public material(int m_id, String m_name, String s_info, String u_coast, String stock_quantity, String supplier, String description) {
        M_id = m_id;
        M_name = m_name;
        S_info = s_info;
        U_coast = u_coast;
        Stock_quantity = stock_quantity;
        Supplier = supplier;
        Description = description;
    }

    public int getM_id() {
        return M_id;
    }

    public String getM_name() {
        return M_name;
    }

    public String getS_info() {
        return S_info;
    }

    public String getU_coast() {
        return U_coast;
    }

    public String getStock_quantity() {
        return Stock_quantity;
    }

    public String getSupplier() {
        return Supplier;
    }

    public String getDescription() {
        return Description;
    }

    public void setM_id(int m_id) {
        M_id = m_id;
    }

    public void setM_name(String m_name) {
        M_name = m_name;
    }

    @Override
    public String toString() {
        return "material{" +
                "M_id=" + M_id +
                ", M_name='" + M_name + '\'' +
                ", S_info='" + S_info + '\'' +
                ", U_coast='" + U_coast + '\'' +
                ", Stock_quantity=" + Stock_quantity +
                ", Supplier='" + Supplier + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }

    public void setS_info(String s_info) {
        S_info = s_info;
    }

    public void setU_coast(String u_coast) {
        U_coast = u_coast;
    }

    public void setStock_quantity(String stock_quantity) {
        Stock_quantity = stock_quantity;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
