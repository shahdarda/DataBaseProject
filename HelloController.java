package com.example.demo1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.Alert;

public class HelloController {

    private ArrayList<Customer> customer_data;
    private ArrayList<Delivery> delivery_data;
    private ArrayList<material> material_data;
    private ArrayList<Purchase> PurchaseData;
    private ObservableList<Purchase> PurchaseList;
    private ArrayList<Order> orderData;
    private ObservableList<Order> OrderList;
    private ObservableList<Customer> customer_dataList;
    private ObservableList<Delivery> delivery_dataList;
    private ObservableList<material> material_dataList;
    private ArrayList<OrderItem> orderitems;
    private ArrayList<Product> products;
    private ObservableList<OrderItem> orderitemsList;
    private ObservableList<Product> productsList;
    private String dbURL;
    private String dbUsername = "root";
    private String dbPassword = "1234";
    private String URL = "127.0.0.1";
    private String port = "3306";
    private String dbName = "sac";
    private Connection con;
    @FXML
    private AnchorPane DeliveryScreen;

    @FXML
    private TableView<Delivery> DeliveryTable;

    @FXML
    private VBox DeliveryVb;

    @FXML
    private TableColumn<Delivery, String> Estimated_Delivery_Time;
    @FXML
    private TextField Shipping_companyTf;
    @FXML
    private Button clearDelivery;
    @FXML
    private Button deleteDelivery;
    @FXML
    private TextField delivery_IdTf;

    @FXML
    private TableColumn<Delivery, String> delivery_address;

    @FXML
    private TableColumn<Delivery, String> delivery_date;

    @FXML
    private TableColumn<Delivery, Integer> delivery_id;

    @FXML
    private TableColumn<Delivery, String> delivery_status;
    @FXML
    private TableColumn<Delivery, Integer> order_id;
    @FXML
    private TableColumn<Delivery, String> shipping_company;
    @FXML
    private ComboBox<String> delivery_statusCHB;

    void selectAllDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from delivery where order_id = " + Order_Id_DeliveryTf.getText() + " and shipping_Company= '" + Shipping_companyTf.getText() + "' and delivery_Statuse= '" + delivery_statusCHB.getValue() + "'";
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                delivery_dataList.add(new Delivery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + delivery_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectIdDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from delivery where delivery_id = " + delivery_IdTf.getText();
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                delivery_dataList.add(new Delivery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + delivery_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectOrderIdDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from delivery where order_id = " + Order_Id_DeliveryTf.getText();
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                delivery_dataList.add(new Delivery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + delivery_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectShippingDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from delivery where shipping_Company= '" + Shipping_companyTf.getText() + "'";
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                delivery_dataList.add(new Delivery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + delivery_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectStatusDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from delivery where delivery_Statuse= '" + delivery_statusCHB.getValue() + "'";
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                delivery_dataList.add(new Delivery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + delivery_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectOrderIdAndShippingDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from delivery where order_id = " + Order_Id_DeliveryTf.getText() + " and shipping_Company= '" + Shipping_companyTf.getText() + "'";
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                delivery_dataList.add(new Delivery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + delivery_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectOrderIdAndStatusDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from delivery where order_id = " + Order_Id_DeliveryTf.getText() + " and delivery_Statuse= '" + delivery_statusCHB.getValue() + "'";
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                delivery_dataList.add(new Delivery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + delivery_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectShippingAndStatusDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from delivery where shipping_Company= '" + Shipping_companyTf.getText() + "' and delivery_Statuse= '" + delivery_statusCHB.getValue() + "'";
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                delivery_dataList.add(new Delivery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + delivery_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectEveryThingDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from delivery";
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                delivery_dataList.add(new Delivery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + delivery_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchDeliveryHandler(ActionEvent event) {
        if (!delivery_IdTf.getText().isEmpty()) {
            delivery_dataList.clear();
            selectIdDelivery();
        } else if (!Order_Id_DeliveryTf.getText().isEmpty() || !Shipping_companyTf.getText().isEmpty() || !delivery_statusCHB.getValue().equals("empty")) {
            if (!Order_Id_DeliveryTf.getText().isEmpty() && !Shipping_companyTf.getText().isEmpty() && !delivery_statusCHB.getValue().equals("empty")) {
                delivery_dataList.clear();
                selectAllDelivery();
            } else if (Order_Id_DeliveryTf.getText().isEmpty() && !Shipping_companyTf.getText().isEmpty() && !delivery_statusCHB.getValue().equals("empty")) {
                delivery_dataList.clear();
                selectShippingAndStatusDelivery();
            } else if (!Order_Id_DeliveryTf.getText().isEmpty() && Shipping_companyTf.getText().isEmpty() && !delivery_statusCHB.getValue().equals("empty")) {
                delivery_dataList.clear();
                selectOrderIdAndStatusDelivery();
            } else if (!Order_Id_DeliveryTf.getText().isEmpty() && !Shipping_companyTf.getText().isEmpty() && delivery_statusCHB.getValue().equals("empty")) {
                delivery_dataList.clear();
                selectOrderIdAndShippingDelivery();
            } else if (!Order_Id_DeliveryTf.getText().isEmpty() && Shipping_companyTf.getText().isEmpty() && delivery_statusCHB.getValue().equals("empty")) {
                delivery_dataList.clear();
                selectOrderIdDelivery();
            } else if (Order_Id_DeliveryTf.getText().isEmpty() && !Shipping_companyTf.getText().isEmpty() && delivery_statusCHB.getValue().equals("empty")) {
                delivery_dataList.clear();
                selectShippingDelivery();
            } else if (Order_Id_DeliveryTf.getText().isEmpty() && Shipping_companyTf.getText().isEmpty() && !delivery_statusCHB.getValue().equals("empty")) {
                delivery_dataList.clear();
                selectStatusDelivery();
            }
        }

    }

    @FXML
    void deleteDeliveryHandler(ActionEvent event) {
        ObservableList<Delivery> selectedRows = DeliveryTable.getSelectionModel().getSelectedItems();
        ArrayList<Delivery> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> {
            DeliveryTable.getItems().remove(row);
            deleteDeliveryRow(row);
            DeliveryTable.refresh();
        });
    }

    private void deleteDeliveryRow(Delivery row) {

        try {
            System.out.println("delete from  delivery where delivery_id=" + row.getDelivery_Id() + ";");
            connectDB();
            ExecuteStatement("delete from  delivery where delivery_id=" + row.getDelivery_Id() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void clearDeliveryHandler(ActionEvent event) {
        for (Delivery row : delivery_dataList) {
            deleteDeliveryRow(row);
            DeliveryTable.refresh();
        }
        DeliveryTable.getItems().removeAll(delivery_dataList);
    }

    @FXML
    private TextField Order_Id_DeliveryTf;
    @FXML
    private Button Reset_btn;

    @FXML
    void resetHandler(ActionEvent event) {
        delivery_dataList.clear();
        selectEveryThingDelivery();
        delivery_IdTf.clear();
        Order_Id_DeliveryTf.clear();
        Shipping_companyTf.clear();
        delivery_statusCHB.setValue("empty");
    }

    @FXML
    private StackedBarChart<String, Integer> deliveryChart;

    public int totalLostDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select count(*) from delivery d where delivery_Statuse = 'Lost' ;" ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalSub = rs.getInt(1);
                return totalSub;
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public int totalInTransitDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select count(*) from delivery d where delivery_Statuse = 'In Transit' ;" ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalSub = rs.getInt(1);
                return totalSub;
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public int totalRetrievedDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select count(*) from delivery d where delivery_Statuse = 'Retrieved' ;" ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalSub = rs.getInt(1);
                return totalSub;
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

//    public int totalDeliveredDelivery1() {
//        ObservableList<String> del = FXCollections.observableArrayList();
//        for (Delivery d : delivery_dataList) {
//            String tran = delivery_status.getCellData(d);
//            del.add(tran);
//            System.out.println(del);
//        }
//        int totalS = 0;
//        for (String s : del) {
//            if (s.equals("Delivered"))
//                totalS = totalS + 1;
//        }
//
//        return totalS;
//    }

//    public int totalSuccessDelivery() {
//        ObservableList<String> del = FXCollections.observableArrayList();
//        for (Delivery d : delivery_dataList) {
//            String tran = delivery_status.getCellData(d);
//            del.add(tran);
//        }
//        int totalS = 0;
//        for (String s : del) {
//            if (s.equals("Success"))
//                totalS = totalS + 1;
//        }
//
//        return totalS;
//    }
    public int totalSuccessDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select count(*) from delivery d where delivery_Statuse = 'Success' ;" ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalSub = rs.getInt(1);
                return totalSub;
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int totalDeliveredDelivery() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select count(*) from delivery d where delivery_Statuse = 'Delivered' ;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalSub = rs.getInt(1);
                return totalSub;
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }


    void createDeliveryChart() {
            XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
            series1.setName("Series 1");
            ObservableList<String> del = FXCollections.observableArrayList();
            for (Delivery d : delivery_dataList) {
                String tran = delivery_status.getCellData(d);
                if (!del.contains(tran)) {
                    del.add(tran);
                }
            }

            series1.getData().add(new XYChart.Data<>("Success", totalSuccessDelivery()));

            series1.getData().add(new XYChart.Data<>("Delivered", totalDeliveredDelivery()));

            series1.getData().add(new XYChart.Data<>("Retrieved", totalRetrievedDelivery()));

            series1.getData().add(new XYChart.Data<>("In Transit", totalInTransitDelivery()));

            series1.getData().add(new XYChart.Data<>("Lost", totalLostDelivery()));


            deliveryChart.getData().addAll(series1);

        }





    private void insertDelivery(int size, String date, String address) {

        try {
            System.out.println("INSERT INTO Delivery (delivery_Id, order_Id, delivery_Date, estimated_Delivery_Time, delivery_Statuse, shipping_Company, delivery_Address)  values(" + size
                    + "," + orderIdTf11.getText() + ",'" + date + "','" + "2-3 days" + "','" + "In Transit" + "','" + "EPS" + "','" + address + "');");

            connectDB();
            ExecuteStatement("INSERT INTO Delivery (delivery_Id, order_Id, delivery_Date, estimated_Delivery_Time, delivery_Statuse, shipping_Company, delivery_Address)  values(" + size
                    + "," + orderIdTf11.getText() + ",'" + date + "','" + "2-3 days" + "','" + "In Transit" + "','" + "EPS" + "','" + address + "');");

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //---------------------------------Delivery---------------------------------------------------------
    @FXML
    private TableColumn<material, Integer> M_idCol;

    @FXML
    private TableColumn<material, String> M_nameCol;

    @FXML
    private AnchorPane MaterialScreen;

    @FXML
    private TableView<material> MaterialTable;

    @FXML
    private VBox MaterialVb;
    @FXML
    private Button ResetMaterial;
    @FXML
    private TableColumn<material, String> S_infoCol;
    @FXML
    private TableColumn<material, String> Stock_quantityCol;
    @FXML
    private TableColumn<material, String> DescriptionCol;

    @FXML
    private TableColumn<material, String> SupplierCol;

    @FXML
    private TableColumn<material, String> U_coastCol;
    @FXML
    private TextField addM_id;

    @FXML
    private TextField addM_name;

    @FXML
    private Button addMaterial;

    @FXML
    private TextField addS_info;

    @FXML
    private TextField addStock_quantity;

    @FXML
    private TextField addSupplier;

    @FXML
    private TextField addU_coast;
    @FXML
    private Button clearMaterial;
    @FXML
    private Button deleteMaterial;
    @FXML
    private Button searchMaterialId;

    @FXML
    private Button searchMaterialName;
    @FXML
    private StackedBarChart<String, Integer> MaterialChart;

    @FXML
    void ResetMaterialHandler(ActionEvent event) {
        material_dataList.clear();
        selectEveryThingMaterial();

    }

    @FXML
    void addMaterialHandler(ActionEvent event) {
        material rc;
        rc = new material(
                Integer.valueOf(addM_id.getText()),
                addM_name.getText(),
                addS_info.getText(),
                addU_coast.getText(),
                addStock_quantity.getText(),
                addSupplier.getText(),
                addDescription.getText());
        material_dataList.add(rc);
        insertData(rc);
        addM_id.clear();
        addM_name.clear();
        addS_info.clear();
        addU_coast.clear();
        addStock_quantity.clear();
        addSupplier.clear();
        addDescription.clear();
    }

    @FXML
    void clearMaterialHandler(ActionEvent event) {
        for (material row : material_dataList) {
            deleteRow(row);
            MaterialTable.refresh();
        }
        MaterialTable.getItems().removeAll(material_dataList);
    }


    @FXML
    void deleteMaterialHandler(ActionEvent event) {
        ObservableList<material> selectedRows = MaterialTable.getSelectionModel().getSelectedItems();
        ArrayList<material> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> {
            MaterialTable.getItems().remove(row);
            deleteRow(row);
            MaterialTable.refresh();
        });
    }

    @FXML
    void searchMaterialIdHandler(ActionEvent event) {
        material_dataList.clear();
        selectIdMaterial();
        addM_id.clear();
    }

    @FXML
    void searchMaterialNameHandler(ActionEvent event) {
        material_dataList.clear();
        selectNameMaterial();
        addM_name.clear();
    }

    @FXML
    private TextField addDescription;

    private void material_tableView() {
        MaterialTable.setEditable(true);
        M_idCol.setCellValueFactory(new PropertyValueFactory<material, Integer>("M_id"));
        M_nameCol.setCellValueFactory(new PropertyValueFactory<material, String>("M_name"));
        S_infoCol.setCellValueFactory(new PropertyValueFactory<material, String>("S_info"));
        U_coastCol.setCellValueFactory(new PropertyValueFactory<material, String>("U_coast"));
        Stock_quantityCol.setCellValueFactory(new PropertyValueFactory<material, String>("Stock_quantity"));
        SupplierCol.setCellValueFactory(new PropertyValueFactory<material, String>("Supplier"));
        DescriptionCol.setCellValueFactory(new PropertyValueFactory<material, String>("Description"));
        M_nameCol.setCellFactory(TextFieldTableCell.<material>forTableColumn());
        M_nameCol.setOnEditCommit(
                (CellEditEvent<material, String> t) -> {
                    if (!t.getRowValue().equals("White Fabric") || !t.getRowValue().equals("Black Fabric") ) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Import Information");
                        alert.setHeaderText(null);
                        alert.setContentText("FORBIDDEN ACTION FOR THIS Material NAME!");
                        alert.showAndWait();
                    }
                    else {
                    ((material) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setM_name(t.getNewValue());
                    updateM_name(t.getRowValue().getM_id(), t.getNewValue());
                }});
        S_infoCol.setCellFactory(TextFieldTableCell.<material>forTableColumn());

        S_infoCol.setOnEditCommit(
                (CellEditEvent<material, String> t) -> {
                    ((material) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setM_name(t.getNewValue());
                    updateS_info(t.getRowValue().getM_id(), t.getNewValue());
                });
        U_coastCol.setCellFactory(TextFieldTableCell.<material>forTableColumn());
        U_coastCol.setOnEditCommit(
                (CellEditEvent<material, String> t) -> {
                    ((material) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setU_coast(t.getNewValue());
                    updateU_coast(t.getRowValue().getM_id(), t.getNewValue());
                });
        Stock_quantityCol.setCellFactory(TextFieldTableCell.<material>forTableColumn());
        Stock_quantityCol.setOnEditCommit(
                (CellEditEvent<material, String> t) -> {
                    ((material) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setStock_quantity(t.getNewValue());
                    updateStockQuantity(t.getRowValue().getM_id(), t.getNewValue());
                });
        SupplierCol.setCellFactory(TextFieldTableCell.<material>forTableColumn());
        SupplierCol.setOnEditCommit(
                (CellEditEvent<material, String> t) -> {
                    ((material) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setSupplier(t.getNewValue());
                    updateSupplier(t.getRowValue().getM_id(), t.getNewValue());
                });
        SupplierCol.setCellFactory(TextFieldTableCell.<material>forTableColumn());
        SupplierCol.setOnEditCommit(
                (CellEditEvent<material, String> t) -> {
                    ((material) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setDescription(t.getNewValue());
                    updateDescription(t.getRowValue().getM_id(), t.getNewValue());
                });
        MaterialTable.setItems(material_dataList);
    }

    public void updateM_name(int M_id, String M_name) {

        try {
            MaterialChart.getData().clear();
            createMaterialChart();
            System.out.println("update  material set M_name = '" + M_name + "' where M_id = " + M_id);
            connectDB();
            ExecuteStatement("update  material set M_name = '" + M_name + "' where M_id = " + M_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateS_info(int M_id, String S_info) {

        try {
            MaterialChart.getData().clear();
            createMaterialChart();
            System.out.println("update  material set `supplier contact info` = '" + S_info + "' where M_id = " + M_id);
            connectDB();
            ExecuteStatement("update  material set `supplier contact info` = '" + S_info + "' where M_id = " + M_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateU_coast(int M_id, String U_coast) {

        try {
            MaterialChart.getData().clear();
            createMaterialChart();
            System.out.println("update  material set `unit cost` = '" + U_coast + "' where M_id = " + M_id);
            connectDB();
            ExecuteStatement("update  material set `unit cost` = '" + U_coast + "' where M_id = " + M_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateStockQuantity(int M_id, String Stock_quantity) {

        try {
            MaterialChart.getData().clear();
            createMaterialChart();
            System.out.println("update  Material set `stock quantity` = '" + Stock_quantity + "' where M_id = " + M_id);
            connectDB();
            ExecuteStatement("update  Material set `stock quantity` = '" + Stock_quantity + "' where M_id = " + M_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateSupplier(int M_id, String Supplier) {

        try {
            MaterialChart.getData().clear();
            createMaterialChart();
            System.out.println("update  material set supplier = '" + Supplier + "' where M_id = " + M_id);
            connectDB();
            ExecuteStatement("update  material set supplier = '" + Supplier + "' where M_id = " + M_id);
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateDescription(int M_id, String Description) {

        try {
            MaterialChart.getData().clear();
            createMaterialChart();
            System.out.println("update  material set Description = '" + Description + "' where M_id = " + M_id);
            connectDB();
            ExecuteStatement("update  material set Description = '" + Description + "' where M_id = " + M_id);
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteRow(material row) {

        try {

            System.out.println("delete from  material where M_id=" + row.getM_id() + ";");
            connectDB();
            ExecuteStatement("delete from  material where M_id=" + row.getM_id() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void insertData(material rc) {

        try {
            System.out.printf("M_id,M_name,`supplier contact info`, `unit cost`,`stock quantity`,`supplier`,`Description`) values(%d,'%s','%s',%s, '%s',%s','%s')", rc.getM_id(), rc.getM_name(), rc.getS_info(), rc.getU_coast(), rc.getStock_quantity(), rc.getSupplier(), rc.getDescription());

            connectDB();
            ExecuteStatement(String.format("Insert into material (M_id,M_name,`supplier contact info`, `unit cost`,`stock quantity`,`supplier`,`Description`) values(%d,'%s','%s','%s', '%s','%s','%s');", rc.getM_id(), rc.getM_name(), rc.getS_info(), rc.getU_coast(), rc.getStock_quantity(), rc.getSupplier(), rc.getDescription()));
            con.close();
            System.out.println("Connection closed" + material_data.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectIdMaterial() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from material where M_id = " + addM_id.getText();
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                material_dataList.add(new material(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + material_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectNameMaterial() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from material where M_name = '" + addM_name.getText() + "'";
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                material_dataList.add(new material(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + material_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectEveryThingMaterial() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from material";
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                material_dataList.add(new material(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + material_dataList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void createMaterialChart() {
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        series1.setName("Series 1");
        ObservableList<String> del = FXCollections.observableArrayList();
        ObservableList<String> StockOB = FXCollections.observableArrayList();
        for (material m : material_dataList) {
            String tran = M_nameCol.getCellData(m);
            String Stock = Stock_quantityCol.getCellData(m);
            if (!del.contains(tran)) {
                del.add(tran);
                StockOB.add(Stock);
            }
        }
        for (int i = 0; i < del.size(); i++) {
            int StockNum = Integer.parseInt(StockOB.get(i));
            series1.getData().add(new XYChart.Data<>(del.get(i), StockNum));
        }
        MaterialChart.getData().addAll(series1);


    }
    @FXML
    void produceBlackbagHandler(ActionEvent event) {

        try {
            connectDB();
            System.out.println("Connection established");

            ExecuteStatement("update material m set `stock quantity` = `stock quantity` - 1 where m.M_id IN = (2,3,4,5,7,8);");
            ExecuteStatement("update product p set stock_quantity = stock quantity + 1 where p.p_id = 2;");

            for (material m : material_dataList) {
                int id = m.getM_id();
                if ( id == 2 || id == 3 || id == 4 || id == 5 || id == 7 || id == 8  ) {
                    int quantity= Integer.parseInt(m.getStock_quantity()) - 1;
                    m.setStock_quantity(""+ quantity);
                }
            }
            for (Product p : productsList) {
                int id = p.getPid();
                if ( id == 2 ) {
                    int quantity= p.getStockQuantity() + 1 ;
                    p.setStockQuantity(quantity);
                }
            }
            MaterialTable.refresh();
            productTable.refresh();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    @FXML
    void produceWhiteBagHandler(ActionEvent event) {
        try {
            connectDB();
            System.out.println("Connection established");

            ExecuteStatement("update material m set `stock quantity` = `stock quantity` - 1 where m.M_id IN = (1,3,4,6,7,8);");
            ExecuteStatement("update product p set stock_quantity = stock quantity + 1 where p.p_id = 1;");

            for (material m : material_dataList) {
                int id = m.getM_id();
                if ( id == 1 || id == 3 || id == 4 || id == 6 || id == 7 || id == 8  ) {
                    int quantity= Integer.parseInt(m.getStock_quantity()) - 1;
                    m.setStock_quantity(""+ quantity);
                }
            }
            for (Product p : productsList) {
                int id = p.getPid();
                if ( id == 1 ) {
                    int quantity= p.getStockQuantity() + 1 ;
                    p.setStockQuantity(quantity);
                }
            }
            MaterialTable.refresh();
            productTable.refresh();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    //---------------------------------Material---------------------------------------------------------
    private void getOrderData() throws SQLException, ClassNotFoundException {

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from orderT order by or_id";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            orderData.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
        }
        rs.close();
        stmt.close();
        con.close();

    }

    public void updateTotalAmount(int O_id, String total_Amount) {

        try {
            System.out.println("update orderT set total_amount= '" + total_Amount + "' where or_id = " + O_id + ";");
            connectDB();
            ExecuteStatement("update orderT set total_amount= '" + total_Amount + "' where or_id = " + O_id + ";");
            XYChart.Series<String, Double> series1 = new XYChart.Series<>();
            series1.setName("Series 1");
            OrderChart.getData().clear();
            series1.getData().add(new XYChart.Data<>("Total Amount", calc_total_amount()));
            OrderChart.getData().addAll(series1);
            con.close();
            System.out.println("Connection closed");


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateDate(int O_id, String date) {

        try {
            System.out.println("update  orderT set Odate= '" + date + "' where or_id = " + O_id + ";");
            connectDB();
            ExecuteStatement("update  orderT set Odate= '" + date + "' where or_id = " + O_id + ";");
            con.close();
            System.out.println("Connection closed");


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void orderTable1() {

        orderTable1.setEditable(true);

        Order_ID1.setCellValueFactory(new PropertyValueFactory<Order, Integer>("or_id"));
        Customer_ID1.setCellValueFactory(new PropertyValueFactory<Order, Integer>("c_id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
        totalAmount.setCellValueFactory(new PropertyValueFactory<Order, String>("totalAmount"));

        dateColumn.setCellFactory(TextFieldTableCell.<Order>forTableColumn());
        totalAmount.setCellFactory(TextFieldTableCell.<Order>forTableColumn());

        dateColumn.setOnEditCommit((CellEditEvent<Order, String> t) -> {
            Order o = t.getRowValue();
            o.setDate(t.getNewValue());
            updateDate(o.getOr_id(), String.valueOf(t.getNewValue()));
        });

        totalAmount.setOnEditCommit((CellEditEvent<Order, String> t) -> {
            Order o = t.getRowValue();
            o.setTotalAmount(t.getNewValue());
            updateTotalAmount(o.getOr_id(), t.getNewValue());
        });


        orderTable1.setItems(OrderList);
    }

    void selectOrder_OrderTable() {
        try {
            String SQL;
            connectDB();
            System.out.println("Connection established");

            SQL = "select * from orderT where or_id = " + orderIdTf11.getText();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);


            while (rs.next()) {
                orderData.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectDate_OrderTable() {
        try {
            String SQL;
            connectDB();
            System.out.println("Connection established");

            SQL = "select * from orderT where Odate = '" + date_picker.getValue().toString() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);


            while (rs.next()) {
                orderData.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectCustomerAndDate_OrderTable() {
        try {
            String SQL;
            connectDB();
            System.out.println("Connection established");

            SQL = "select * from orderT where Odate = '" + date_picker.getValue().toString() + "' and cu_id= '" + customerIDTf11.getText() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);


            while (rs.next()) {
                orderData.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectCustomer_OrderTable() {
        try {
            String SQL;
            connectDB();
            System.out.println("Connection established");

            SQL = "select * from orderT where cu_id = " + customerIDTf11.getText();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);


            while (rs.next()) {
                orderData.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SearchOrderHandler(ActionEvent event) {

        if (!orderIdTf11.getText().isEmpty()) {
            OrderList.clear();
            selectOrder_OrderTable();
        } else if (!customerIDTf11.getText().isEmpty() || !date_picker.getValue().equals(null)) {
            if (!customerIDTf11.getText().isEmpty() && date_picker.getValue().equals(null)) {
                OrderList.clear();
                selectCustomer_OrderTable();
            } else if (customerIDTf11.getText().isEmpty() && !date_picker.getValue().equals(null)) {
                OrderList.clear();
                selectDate_OrderTable();
            } else if (!customerIDTf11.getText().isEmpty() && !date_picker.getValue().equals(null)) {
                OrderList.clear();
                selectCustomerAndDate_OrderTable();
            }
        }
    }



//    public double calc_total_amount_on_click(ActionEvent event) {
//        ObservableList<String> amt = FXCollections.observableArrayList();
//        for (Order o : OrderList) {
//            String am = totalAmount.getCellData(o);
//            amt.add(am);
//
//        }
//        double total = 0;
//        for (String s : amt) {
//            double listValue = Double.parseDouble(s);
//            total = total + listValue;
//        }
//        System.out.println(total);
//        String value = String.valueOf(total);
//        totalAmountLabel.setText(value);
//        return total;
//
//    }
    @FXML
    public void calc_total_amount_on_click(ActionEvent event) {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select sum(o.total_amount) from orderT o  ;" ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalSub = rs.getInt(1);
                totalAmountLabel.setText(totalSub+"");
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
}
    public double calc_total_amount() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select sum(o.total_amount) from orderT o  ;" ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalSub = rs.getInt(1);
                return totalSub;
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }



//    public double calc_total_amount() {
//        ObservableList<String> amt = FXCollections.observableArrayList();
//        for (Order o : OrderList) {
//            String am = totalAmount.getCellData(o);
//            amt.add(am);
//
//        }
//        double total = 0;
//        for (String s : amt) {
//            double listValue = Double.parseDouble(s);
//            total = total + listValue;
//        }
//        System.out.println(total);
//        String value = String.valueOf(total);
//        totalAmountLabel.setText(value);
//        return total;
//
//    }

    @FXML
    void clearOrderHandler(ActionEvent event) {
        for (Order row : OrderList) {
            deleteOrderRow(row);
            customerTable.refresh();
        }
        orderTable1.getItems().removeAll(OrderList);
    }

    @FXML
    void customerId_on_click(ActionEvent event) {

    }

    @FXML
    void deleteOrderHandler(ActionEvent event) {
        ObservableList<Order> selectedRows = orderTable1.getSelectionModel().getSelectedItems();
        ArrayList<Order> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> {
            orderTable1.getItems().remove(row);
            deleteOrderRow(row);
            purchaseTable.refresh();
            DeliveryTable.refresh();
        });


    }

    @FXML
    void orderId_on_click(ActionEvent event) {

    }

    @FXML
    void viewOrderData_on_Click(ActionEvent event) throws SQLException, ClassNotFoundException {
        OrderList.clear();
        orderTable1.refresh();
        getOrderData();
        orderTable1();
        orderIdTf11.clear();
        customerIDTf11.clear();
        totalAmountLabel.setText("");
    }


    private void insertOrderData(Order rc) {

        try {

            System.out.println("Insert into orderT (or_id, cu_id, Odate, total_amount)  values(" + rc.getOr_id()
                    + ",'" + rc.getC_id() + "','" + rc.getDate() + "','" + Double.parseDouble(rc.getTotalAmount()) + "');");

            connectDB();
            ExecuteStatement("Insert into orderT (or_id, cu_id, Odate, total_amount) values(" + rc.getOr_id() + ",'"
                    + rc.getC_id() + "','" + rc.getDate() + "','" + Double.parseDouble(rc.getTotalAmount())+ "');");

            con.close();
            System.out.println("Connection closed" + orderData.size());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void addOrderHandler(ActionEvent event) {
        Order rc;

        rc = new Order(Integer.valueOf(orderIdTf11.getText()), Integer.valueOf(customerIDTf11.getText()), date_picker.getValue().toString(),
                "0.00");
        Purchase p;
        int indexP = 0;
        int keyP;
        if (PurchaseList.size() == 0) {
            keyP = 1;
        } else {
            indexP = PurchaseList.size() - 1;
            keyP = PurchaseList.get(indexP).getPurchase_id() + 1;
        }
        //-----------------------------------------------------------
        int keyD;
        int indexD;
        if (delivery_dataList.size() == 0) {
            keyD = 1;
        } else {
            indexD = delivery_dataList.size() - 1;
            keyD = delivery_dataList.get(indexD).getDelivery_Id() + 1;
        }
        //----------------------------------------------------------


//        System.out.println(findCustomerAddress(Integer.parseInt(customerIDTf11.getText())));
        Delivery d = new Delivery(keyD, Integer.valueOf(orderIdTf11.getText()), date_picker.getValue().toString(), "2-3 Days", "In Transit", selectShippingCompany.getValue(), findCustomerAddress());
        p = new Purchase(keyP, Integer.valueOf(orderIdTf11.getText()), "Not Confirmed", selectPaymentMethodCombo.getValue(), "Pending");
        orderData.add(rc);
        PurchaseData.add(p);
        PurchaseList.add(p);
        System.out.println(PurchaseList);
        insertOrderData(rc);
        insertPurchaseData(keyP);
        insertDelivery(keyD, date_picker.getValue().toString(), findCustomerAddress());
        delivery_dataList.add(d);
        orderTable1.refresh();
        purchaseTable.refresh();
        DeliveryTable.refresh();
        orderIdTf1.clear();
        customerIdTf.clear();
        totalAmountLabel.setText("");
    }

    private void deleteOrderRow(Order row) {

        try {
            System.out.println("delete from  orderT where or_id=" + row.getOr_id() + ";");
            connectDB();
            ExecuteStatement("delete from  orderT where or_id=" + row.getOr_id() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private double calculate_on_specific_date() {
        ObservableList<String> amt = FXCollections.observableArrayList();
        OrderList.clear();
        selectDate();
        for (Order o : OrderList) {
            String am = totalAmount.getCellData(o);
            amt.add(am);

        }
        double total = 0;

        for (String s : amt) {
            double listValue = Double.parseDouble(s);
            total = total + listValue;
        }
        System.out.println(total);
        String value = String.valueOf(total);
        totalAmountLabel.setText(value);
        return total;

    }

    @FXML
    void getOrderAmountHandler(ActionEvent event) {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select sum(ot.subtotal) from order_item ot Join orderT o on o.or_id = ot.or_id where o.or_id = ot.or_id;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalSub = rs.getInt(1);
                getOrderAmountLabel1.setText(totalSub + "");
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    void updateOrderTotalAmountFromOrderItem (int totalAmount) {
        try {


            connectDB();
            System.out.println("Connection established");

         ExecuteStatement("update orderT o set total_amount = " +  totalAmount + " where o.or_id = " + orderIdTf.getText() + ";");
            for (Order o : OrderList) {
                int id = o.getOr_id();
                System.out.println(orderIdTf1.getText());
                if ( id == Integer.parseInt(orderIdTf.getText())) {
                    o.setTotalAmount(""+totalAmount);
                }
            }
            orderTable1.refresh();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void toDatePickerHandler(ActionEvent event) {
        double result = calculate_on_specific_date();

        resultOfDateLabel.setText(String.valueOf(result));
    }

    private void selectDate() {

        try {
            String SQL;
            connectDB();
            System.out.println("Connection established");

            SQL = "select * from orderT where Odate between '" + fromDatePicker.getValue().toString() + "' and '" + toDatePicker.getValue().toString() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);


            while (rs.next()) {
                orderData.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private BarChart<String, Double> OrderChart;
    @FXML
    private TableColumn<Order, Integer> Customer_ID1;
    @FXML
    private AnchorPane OrderScreen1;
    @FXML
    private TableColumn<Order, Integer> Order_ID1;
    @FXML
    private Button addOrder;
    @FXML
    private Button calculate_total_amount;
    @FXML
    private Button clearOrder1;
    @FXML
    private TextField customerIDTf11;
    @FXML
    private TextField orderIdTf11;
    @FXML
    private TableColumn<Order, String> dateColumn;
    @FXML
    private Button deleteOrder1;

    @FXML
    private DatePicker date_picker;
    @FXML
    private Button searchOrder1;
    @FXML
    private TableColumn<Order, String> totalAmount;
    @FXML
    private Label resultOfDateLabel;

    @FXML
    private Label totalAmountLabel;
    @FXML
    private Button viewOrderDataButton;
    @FXML
    private TableView<Order> orderTable1;
    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private Button getOrderAmountButton;

    @FXML
    private Label getOrderAmountLabel1;
    @FXML
    private ComboBox<String> selectPaymentMethodCombo;

    @FXML
    private ComboBox<String> selectShippingCompany;

    @FXML
    private DatePicker toDatePicker;

//    String findCustomerAddress(int c_id) {
//
//
//        for (Customer c : customer_dataList) {
//            if (c.getC_id() == c_id) {
//                return c.getAddress();
//            }
//        }
//
//        return null;
//    }
    private String findCustomerAddress() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select c.address from Customer c Join orderT o on o.cu_id = c.c_id " ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                String address = rs.getString(1);
                return address;
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    //---------------------------------Order------------------------------------------------------------
    @FXML
    private TableColumn<Purchase, Integer> Order_ID;

    @FXML
    private TableColumn<Purchase, Integer> PR_ID;

    @FXML
    private TableColumn<Purchase, String> PaymentConfirmation;

    @FXML
    private TableColumn<Purchase, String> PaymentMethod;

    @FXML
    private AnchorPane PurchaseScreen;

    @FXML
    private TableColumn<Purchase, String> TransactionStatus;
    @FXML
    private Button deletePurchase1;
    @FXML
    private ComboBox<String> paymentConfCombo;

    @FXML
    private ComboBox<String> paymentMethodCombo;
    @FXML
    private StackedBarChart<String, Integer> purchaseChart;

    @FXML
    private VBox purchaseVb1;
    @FXML
    private Button calculatePurchaseButton;
    @FXML
    private Label resultLabel;


    @FXML
    private Button searchPurchase;

    @FXML
    private ComboBox<String> transactionStatusCombo;
    @FXML
    private TextField orderIdTf1;


    @FXML
    private TextField purchaseIdTf1;

    @FXML
    private TableView<Purchase> purchaseTable;

    private void getPurchaseData() throws SQLException, ClassNotFoundException {

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from purchase order by pr_id";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            PurchaseData.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + PurchaseData.size());

    }

    private void selectPurchaseID() {

        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where pr_id = " + purchaseIdTf1.getText();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);


            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void insertPurchaseData(int size) {

        try {
            System.out.println(size);
            System.out.println("insert into purchase (pr_id, o_id, payment_confirmation, transaction_status, payment_method)  values(" + size
                    + ",'" + orderIdTf11.getText() + "','" + "Not Confirmed" + "','" + "Pending" + "','" + "Cash" + "');");

            connectDB();
            ExecuteStatement("insert into purchase (pr_id, o_id, payment_confirmation, transaction_status, payment_method)  values(" + size
                    + ",'" + orderIdTf11.getText() + "','" + "Not Confirmed" + "','" + "Pending" + "','" + "Cash" + "');");

            con.close();
            System.out.println("Connection closed" + orderData.size());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void deleteRow1(Purchase row) {

        try {
            System.out.println("delete from  purchase where pr_id=" + row.getPurchase_id() + ";");
            connectDB();
            ExecuteStatement("delete from  purchase where pr_id=" + row.getPurchase_id() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void deletePurchaseHandler(ActionEvent event) {
        ObservableList<Purchase> selectedRows = purchaseTable.getSelectionModel().getSelectedItems();
        ArrayList<Purchase> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> {
            purchaseTable.getItems().remove(row);
            deleteRow1(row);
            purchaseTable.refresh();
        });

    }

    @FXML
    void clearPurchaseHandler(ActionEvent event) {
        for (Purchase row : PurchaseList) {
            deleteRow1(row);
            purchaseTable.refresh();
        }
        purchaseTable.getItems().removeAll(PurchaseList);
        purchaseTable.refresh();


    }

    private void purchaseTable() {

        purchaseTable.setEditable(true);

        PR_ID.setCellValueFactory(new PropertyValueFactory<Purchase, Integer>("purchase_id"));
        Order_ID.setCellValueFactory(new PropertyValueFactory<Purchase, Integer>("order_id"));
        PaymentConfirmation.setCellValueFactory(new PropertyValueFactory<Purchase, String>("paymentConfirmation"));
        TransactionStatus.setCellValueFactory(new PropertyValueFactory<Purchase, String>("transactionStatus"));
        PaymentMethod.setCellValueFactory(new PropertyValueFactory<Purchase, String>("paymentMethod"));
        TransactionStatus.setCellFactory(TextFieldTableCell.<Purchase>forTableColumn());
        PaymentMethod.setCellFactory(TextFieldTableCell.<Purchase>forTableColumn());

        PaymentConfirmation.setCellFactory(TextFieldTableCell.<Purchase>forTableColumn());
        PaymentConfirmation.setOnEditCommit((CellEditEvent<Purchase, String> t) -> {
            Purchase p = t.getRowValue();
            p.setPaymentConfirmation(t.getNewValue());
            updatePaymentConfirmation(p.getPurchase_id(), t.getNewValue());
        });

        TransactionStatus.setOnEditCommit((CellEditEvent<Purchase, String> t) -> {
            Purchase p = t.getRowValue();
            p.setTransactionStatus(t.getNewValue());
            updateTransactionStatus(p.getPurchase_id(), t.getNewValue());
        });

        PaymentMethod.setOnEditCommit((CellEditEvent<Purchase, String> t) -> {
            Purchase p = t.getRowValue();
            p.setPaymentMethod(t.getNewValue());
            updatePaymentMethod(p.getPurchase_id(), t.getNewValue());
        });

        purchaseTable.setItems(PurchaseList);

    }

    public void updatePaymentMethod(int Purchase_id, String PaymentMethod) {

        try {
            System.out.println("update  purchase set payment_method= '" + PaymentMethod + "' where pr_id = " + Purchase_id + ";");
            connectDB();
            ExecuteStatement("update  purchase set payment_method= '" + PaymentMethod + "' where pr_id = " + Purchase_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updatePaymentConfirmation(int Purchase_id, String PaymentMethod) {

        try {
            System.out.println("update  purchase set payment_confirmation= '" + PaymentMethod + "' where pr_id = " + Purchase_id + ";");
            connectDB();
            ExecuteStatement("update  purchase set payment_confirmation= '" + PaymentMethod + "' where pr_id = " + Purchase_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectAllPurchase() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established212125");
            SQL = "select * from purchase where o_id = " + orderIdTf1.getText() + " and payment_confirmation= '" + paymentConfCombo.getValue() + "' and transaction_status= '" + transactionStatusCombo.getValue() + "' and payment_method= '" + paymentMethodCombo.getValue() + "'";
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed" + PurchaseData.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectOrderPurchase() {
        try {
            String SQL;
            connectDB();
            System.out.println("Connection establishedsss");

            SQL = "select * from purchase where o_id = " + orderIdTf1.getText();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);


            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectTransactionPurchase() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where transaction_status = '" + transactionStatusCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectPaymentMethodPurchase() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where payment_method= '" + paymentMethodCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectPaymentConfPurchase() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where payment_confirmation= '" + paymentConfCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectOrderAndPaymentConf() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where o_id = " + orderIdTf1.getText() + " and payment_confirmation= '" + paymentConfCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectOrderPaymentConfPaymentMethod() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where o_id = " + orderIdTf1.getText() + " and payment_confirmation= '" + paymentConfCombo.getValue() + "' and payment_method= '" + paymentMethodCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectOrderAndTransaction() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where o_id = " + orderIdTf1.getText() + " and transaction_method= '" + transactionStatusCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectOrderAndPaymentMethod() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where o_id = " + orderIdTf1.getText() + " and payment_method= '" + paymentMethodCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectTransactionPaymentMethod() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where transaction_status = '" + transactionStatusCombo.getValue() + "' and payment_method= '" + paymentMethodCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectTransactionPaymentConf() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where transaction_status = '" + transactionStatusCombo.getValue() + "' and payment_confirmation= '" + paymentConfCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectPaymentConfMethod() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where payment_confirmation= '" + paymentConfCombo.getValue() + "' and payment_method= '" + paymentMethodCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectOrderTransactionPaymentConf() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where o_id = " + orderIdTf1.getText() + " and payment_confirmation= '" + paymentConfCombo.getValue() + "' and transaction_status= '" + transactionStatusCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectOrderTransactionPaymentMethod() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where o_id = " + orderIdTf1.getText() + " and payment_method= '" + paymentMethodCombo.getValue() + "' and transaction_status= '" + transactionStatusCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectTransactionPaymentMethodPaymConf() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase where transaction_method = '" + transactionStatusCombo.getValue() + "' and payment_method= '" + paymentMethodCombo.getValue() + "' and payment_confirmation= '" + paymentConfCombo.getValue() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateTransactionStatus(int Purchase_id, String transactionStatus) {

        try {
            System.out.println("update  purchase set transaction_status= '" + transactionStatus + "' where pr_id = " + Purchase_id + ";");
            connectDB();
            ExecuteStatement("update  purchase set transaction_status= '" + transactionStatus + "' where pr_id = " + Purchase_id + ";");
            XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
            series1.setName("Series 1");
            purchaseChart.getData().clear();
            series1.getData().add(new XYChart.Data<>("Success", totalSuccessTransactionStatus()));
            series1.getData().add(new XYChart.Data<>("Pending", totalPendingTransactionStatus()));
            series1.getData().add(new XYChart.Data<>("Failed", totalFailedTransactionStatus()));
            purchaseChart.getData().addAll(series1);
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SearchPurchaseHandler(ActionEvent event) {

        if (!purchaseIdTf1.getText().isEmpty()) {
            System.out.println(purchaseIdTf1.getText().isEmpty());
            PurchaseList.clear();
            selectPurchaseID();

        } else if (!orderIdTf1.getText().isEmpty() && !transactionStatusCombo.getValue().equals("Empty") && !paymentConfCombo.getValue().equals("Empty") && !paymentMethodCombo.getValue().equals("Empty")) {
            PurchaseList.clear();
            selectAllPurchase();

        } else if (!orderIdTf1.getText().isEmpty() || !transactionStatusCombo.getValue().equals("Empty") || !paymentConfCombo.getValue().equals("Empty") || !paymentMethodCombo.getValue().equals("Empty")) {
            if (!orderIdTf1.getText().isEmpty()) {
                PurchaseList.clear();
                selectOrderPurchase();
            } else if (!orderIdTf1.getText().isEmpty() && !paymentConfCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectOrderAndPaymentConf();
            } else if (!orderIdTf1.getText().isEmpty() && !transactionStatusCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectOrderAndTransaction();
            } else if (!orderIdTf1.getText().isEmpty() && !paymentMethodCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectOrderAndPaymentMethod();
            } else if (!transactionStatusCombo.getValue().equals("Empty") && !paymentConfCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectTransactionPaymentConf();
            } else if (!transactionStatusCombo.getValue().equals("Empty") && !paymentMethodCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectTransactionPaymentMethod();
            } else if (!paymentConfCombo.getValue().equals("Empty") && !paymentMethodCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectPaymentConfMethod();
            } else if (!transactionStatusCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectTransactionPurchase();
            } else if (!paymentMethodCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectPaymentMethodPurchase();
            } else if (!paymentConfCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectPaymentConfPurchase();
            } else if (!orderIdTf1.getText().isEmpty() && !transactionStatusCombo.getValue().equals("Empty") && !paymentConfCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectOrderTransactionPaymentConf();
            } else if (!orderIdTf1.getText().isEmpty() && !transactionStatusCombo.getValue().equals("Empty") && !paymentMethodCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectOrderTransactionPaymentMethod();
            } else if (!orderIdTf1.getText().isEmpty() && !paymentConfCombo.getValue().equals("Empty") && !paymentMethodCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectOrderPaymentConfPaymentMethod();
            } else if (!transactionStatusCombo.getValue().equals("Empty") && !paymentConfCombo.getValue().equals("Empty") && !paymentMethodCombo.getValue().equals("Empty")) {
                PurchaseList.clear();
                selectTransactionPaymentMethodPaymConf();
            }


        }


    }

    /*public int totalPurchases() {
        ObservableList<String> confs = FXCollections.observableArrayList();
        for (Purchase p : PurchaseList) {
            String conf = PaymentConfirmation.getCellData(p);
            confs.add(conf);
        }

        int total = 0;
        for (String s : confs) {
            if (s.equals("Confirmed"))
                total = total + 1;
        }
        System.out.println(total);
        return total;
    }*/
    public int totalPurchases() {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select count(*) from purchase p where payment_confirmation = 'Confirmed' ;" ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalSub = rs.getInt(1);
                return totalSub;
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @FXML
    void calculatePurchaseOnClick(ActionEvent event) {
        String result = "" + totalPurchases();
        resultLabel.setText(result);
    }

//    public int totalSuccessTransactionStatus() {
//        ObservableList<String> trans = FXCollections.observableArrayList();
//        for (Purchase p : PurchaseList) {
//            String tran = TransactionStatus.getCellData(p);
//            trans.add(tran);
//
//        }
//        int totalS = 0;
//        for (String s : trans) {
//            if (s.equals("Success"))
//                totalS = totalS + 1;
//        }
//
//        return totalS;
//    }
public int totalSuccessTransactionStatus() {
    try {
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select count(*) from purchase p where transaction_status = 'Success' ;" ;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        if (rs.next()) {
            int totalSub = rs.getInt(1);
            return totalSub;
        }
        rs.close();
        stmt.close();

        con.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return 0;
}


//    public int totalPendingTransactionStatus() {
//        ObservableList<String> trans = FXCollections.observableArrayList();
//        for (Purchase p : PurchaseList) {
//            String tran = TransactionStatus.getCellData(p);
//            trans.add(tran);
//
//        }
//        int totalS = 0;
//        for (String s : trans) {
//            if (s.equals("Pending"))
//                totalS = totalS + 1;
//        }
//        return totalS;
//    }
public int totalPendingTransactionStatus() {
    try {
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select count(*) from purchase p where transaction_status = 'Pending' ;" ;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        if (rs.next()) {
            int totalSub = rs.getInt(1);
            return totalSub;
        }
        rs.close();
        stmt.close();

        con.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return 0;
}

//    public int totalFailedTransactionStatus() {
//        ObservableList<String> trans = FXCollections.observableArrayList();
//        for (Purchase p : PurchaseList) {
//            String tran = TransactionStatus.getCellData(p);
//            trans.add(tran);
//
//        }
//        int totalS = 0;
//        for (String s : trans) {
//            if (s.equals("Failed"))
//                totalS = totalS + 1;
//        }
//        return totalS;
//    }
public int totalFailedTransactionStatus() {
    try {
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select count(*) from purchase p where transaction_status = 'Failed' ;" ;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        if (rs.next()) {
            int totalSub = rs.getInt(1);
            return totalSub;
        }
        rs.close();
        stmt.close();

        con.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return 0;
}

    @FXML
    void viewData_on_Click(ActionEvent event) {

        try {
            String SQL;
            PurchaseList.clear();
            connectDB();
            System.out.println("Connection established");

            SQL = "select * from purchase";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
           while(rs.next()) {
               PurchaseList.add(new Purchase(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
           }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        transactionStatusCombo.setValue("Empty");
        paymentConfCombo.setValue("Empty");
        paymentMethodCombo.setValue("Empty");
        purchaseIdTf1.clear();
        orderIdTf1.clear();


    }

    private void joinOrderAndPurchase() {

        try {
            String SQL;
            connectDB();
            System.out.println("Connection established");

            SQL = "SELECT * FROM orderT JOIN purchase ON orderT.or_id = purchase.o_id";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //---------------------------------Purchases--------------------------------------------------------
    @FXML
    private TextField CustomerNumberTf;

    @FXML
    private Button addCustomer;


    @FXML
    private Button clearCustomers;
    @FXML
    private Button totalCustomerCount;
    @FXML
    private Label totalCusNum;
    @FXML
    private ComboBox<String> sortOrderItemBy;
    @FXML
    private Label totalQuantity;

    @FXML
    private Label totalSubTotals;




    @FXML
    private TextField customerAdressTf;

    @FXML
    private TextField customerIdTf;

    @FXML
    private TextField customerNameTf;

    @FXML
    private AnchorPane customerScreen;

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private VBox customerVb;

    @FXML
    private Button deleteCustomer;

    @FXML
    private TextField emailTf;
    @FXML
    private ImageView sacImg;
    @FXML
    private Line line;

    @FXML
    private Button logInBtn;

    @FXML
    private VBox menuVb;

    @FXML
    private Label passLbl;

    @FXML
    private PasswordField passTf;

    @FXML
    private Label userLbl;

    @FXML
    private TextField userTf;

    @FXML
    private TableColumn<Customer, Integer> c_id;

    @FXML
    private TableColumn<Customer, String> c_name;

    @FXML
    private TableColumn<Customer, String> phone;

    @FXML
    private TableColumn<Customer, String> address;

    @FXML
    private TableColumn<Customer, String> email;

    @FXML
    private Label passLblWarning;

    @FXML
    private Label userLblWarning;

    @FXML
    private Button customerBtn;

    @FXML
    private HBox customerHB;

    @FXML
    private Button materialBtn;

    @FXML
    private HBox materialHB;

    @FXML
    private Button orderBtn;

    @FXML
    private HBox orderHb;

    @FXML
    private Button orderIBtn;

    @FXML
    private HBox OrderIHb;

    @FXML
    private Button productBtn;

    @FXML
    private HBox productHb;

    @FXML
    private Button purchaseBtn;

    @FXML
    private HBox purchaseHb;

    @FXML
    private HBox deliveryHb;

    @FXML
    private Button deliveryBtn;
    @FXML
    private Button produceBlackBag;

    @FXML
    private Button produceWhiteBag;



    @FXML
    void customerHandler(ActionEvent event) {
        customerScreen.setVisible(true);
        MaterialScreen.setVisible(false);
        DeliveryScreen.setVisible(false);
        PurchaseScreen.setVisible(false);
        OrderScreen1.setVisible(false);
        productScreen.setVisible(false);
        orderItemScreen.setVisible(false);
        customerHB.setStyle("-fx-background-color:#cfba8b");
        customerBtn.setStyle("-fx-background-color:#cfba8b");
        productHb.setStyle("-fx-background-color: #F7E9C6");
        productBtn.setStyle("-fx-background-color: #F7E9C6");
        purchaseHb.setStyle("-fx-background-color: #F7E9C6");
        purchaseBtn.setStyle("-fx-background-color: #F7E9C6");
        deliveryHb.setStyle("-fx-background-color: #F7E9C6");
        deliveryBtn.setStyle("-fx-background-color: #F7E9C6");
        orderHb.setStyle("-fx-background-color: #F7E9C6");
        orderBtn.setStyle("-fx-background-color: #F7E9C6");
        OrderIHb.setStyle("-fx-background-color: #F7E9C6");
        orderIBtn.setStyle("-fx-background-color: #F7E9C6");
        materialHB.setStyle("-fx-background-color: #F7E9C6");
        materialBtn.setStyle("-fx-background-color: #F7E9C6");

    }

    @FXML
    void deliveryHandler(ActionEvent event) {
        customerScreen.setVisible(false);
        MaterialScreen.setVisible(false);
        DeliveryScreen.setVisible(true);
        PurchaseScreen.setVisible(false);
        OrderScreen1.setVisible(false);
        productScreen.setVisible(false);
        orderItemScreen.setVisible(false);
        delivery_dataList.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                deliveryChart.getData().clear();
                createDeliveryChart();
            }
        });

        customerHB.setStyle("-fx-background-color:#F7E9C6");
        customerBtn.setStyle("-fx-background-color:#F7E9C6");
        productHb.setStyle("-fx-background-color: #F7E9C6");
        productBtn.setStyle("-fx-background-color: #F7E9C6");
        purchaseHb.setStyle("-fx-background-color: #F7E9C6");
        purchaseBtn.setStyle("-fx-background-color: #F7E9C6");
        deliveryHb.setStyle("-fx-background-color: #cfba8b");
        deliveryBtn.setStyle("-fx-background-color: #cfba8b");
        orderHb.setStyle("-fx-background-color: #F7E9C6");
        orderBtn.setStyle("-fx-background-color: #F7E9C6");
        OrderIHb.setStyle("-fx-background-color: #F7E9C6");
        orderIBtn.setStyle("-fx-background-color: #F7E9C6");
        materialHB.setStyle("-fx-background-color: #F7E9C6");
        materialBtn.setStyle("-fx-background-color: #F7E9C6");
    }

    @FXML
    void materialHandler(ActionEvent event) {
        customerScreen.setVisible(false);
        MaterialScreen.setVisible(true);
        DeliveryScreen.setVisible(false);
        PurchaseScreen.setVisible(false);
        OrderScreen1.setVisible(false);
        productScreen.setVisible(false);
        orderItemScreen.setVisible(false);

        material_dataList.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                MaterialChart.getData().clear();
                createMaterialChart();
            }
        });
        customerHB.setStyle("-fx-background-color:#F7E9C6");
        customerBtn.setStyle("-fx-background-color:#F7E9C6");
        productHb.setStyle("-fx-background-color: #F7E9C6");
        productBtn.setStyle("-fx-background-color: #F7E9C6");
        purchaseHb.setStyle("-fx-background-color: #F7E9C6");
        purchaseBtn.setStyle("-fx-background-color: #F7E9C6");
        deliveryHb.setStyle("-fx-background-color: #F7E9C6");
        deliveryBtn.setStyle("-fx-background-color: #F7E9C6");
        orderHb.setStyle("-fx-background-color: #F7E9C6");
        orderBtn.setStyle("-fx-background-color: #F7E9C6");
        OrderIHb.setStyle("-fx-background-color: #F7E9C6");
        orderIBtn.setStyle("-fx-background-color: #F7E9C6");
        materialHB.setStyle("-fx-background-color: #cfba8b");
        materialBtn.setStyle("-fx-background-color: #cfba8b");
    }

    @FXML
    void orderHandler(ActionEvent event) {
        customerScreen.setVisible(false);
        MaterialScreen.setVisible(false);
        DeliveryScreen.setVisible(false);
        PurchaseScreen.setVisible(false);
        OrderScreen1.setVisible(true);
        productScreen.setVisible(false);
        orderItemScreen.setVisible(false);


        customerHB.setStyle("-fx-background-color:#F7E9C6");
        customerBtn.setStyle("-fx-background-color:#F7E9C6");
        productHb.setStyle("-fx-background-color: #F7E9C6");
        productBtn.setStyle("-fx-background-color: #F7E9C6");
        purchaseHb.setStyle("-fx-background-color: #F7E9C6");
        purchaseBtn.setStyle("-fx-background-color: #F7E9C6");
        deliveryHb.setStyle("-fx-background-color: #F7E9C6");
        deliveryBtn.setStyle("-fx-background-color: #F7E9C6");
        orderHb.setStyle("-fx-background-color: #cfba8b");
        orderBtn.setStyle("-fx-background-color: #cfba8b");
        OrderIHb.setStyle("-fx-background-color: #F7E9C6");
        orderIBtn.setStyle("-fx-background-color: #F7E9C6");
        materialHB.setStyle("-fx-background-color: #F7E9C6");
        materialBtn.setStyle("-fx-background-color: #F7E9C6");
    }

    @FXML
    void orderIHandler(ActionEvent event) {
        customerScreen.setVisible(false);
        MaterialScreen.setVisible(false);
        DeliveryScreen.setVisible(false);
        PurchaseScreen.setVisible(false);
        OrderScreen1.setVisible(false);
        productScreen.setVisible(false);
        orderItemScreen.setVisible(true);


        customerHB.setStyle("-fx-background-color:#F7E9C6");
        customerBtn.setStyle("-fx-background-color:#F7E9C6");
        productHb.setStyle("-fx-background-color: #F7E9C6");
        productBtn.setStyle("-fx-background-color: #F7E9C6");
        purchaseHb.setStyle("-fx-background-color: #F7E9C6");
        purchaseBtn.setStyle("-fx-background-color: #F7E9C6");
        deliveryHb.setStyle("-fx-background-color: #F7E9C6");
        deliveryBtn.setStyle("-fx-background-color: #F7E9C6");
        orderHb.setStyle("-fx-background-color: #F7E9C6");
        orderBtn.setStyle("-fx-background-color: #F7E9C6");
        OrderIHb.setStyle("-fx-background-color: #cfba8b");
        orderIBtn.setStyle("-fx-background-color: #cfba8b");
        materialHB.setStyle("-fx-background-color: #F7E9C6");
        materialBtn.setStyle("-fx-background-color: #F7E9C6");
    }

    @FXML
    void productHandler(ActionEvent event) {
        customerScreen.setVisible(false);
        MaterialScreen.setVisible(false);
        DeliveryScreen.setVisible(false);
        PurchaseScreen.setVisible(false);
        OrderScreen1.setVisible(false);
        productScreen.setVisible(true);
        orderItemScreen.setVisible(false);
        customerHB.setStyle("-fx-background-color:#F7E9C6");
        customerBtn.setStyle("-fx-background-color:#F7E9C6");
        productHb.setStyle("-fx-background-color: #cfba8b");
        productBtn.setStyle("-fx-background-color: #cfba8b");
        purchaseHb.setStyle("-fx-background-color: #F7E9C6");
        purchaseBtn.setStyle("-fx-background-color: #F7E9C6");
        deliveryHb.setStyle("-fx-background-color: #F7E9C6");
        deliveryBtn.setStyle("-fx-background-color: #F7E9C6");
        orderHb.setStyle("-fx-background-color: #F7E9C6");
        orderBtn.setStyle("-fx-background-color: #F7E9C6");
        OrderIHb.setStyle("-fx-background-color: #F7E9C6");
        orderIBtn.setStyle("-fx-background-color: #F7E9C6");
        materialHB.setStyle("-fx-background-color: #F7E9C6");
        materialBtn.setStyle("-fx-background-color: #F7E9C6");
    }

    @FXML
    void purchaseHandler(ActionEvent event) {
        customerScreen.setVisible(false);
        MaterialScreen.setVisible(false);
        DeliveryScreen.setVisible(false);
        OrderScreen1.setVisible(false);
        purchaseChart.getData().clear();
        PurchaseScreen.setVisible(true);
        orderItemScreen.setVisible(false);
        productScreen.setVisible(false);
        purchaseHb.setVisible(true);
        purchaseVb1.setVisible(true);
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        series1.setName("Series 1");
        series1.getData().add(new XYChart.Data<>("Success", totalSuccessTransactionStatus()));
        series1.getData().add(new XYChart.Data<>("Pending", totalPendingTransactionStatus()));
        series1.getData().add(new XYChart.Data<>("Failed", totalFailedTransactionStatus()));
        purchaseChart.getData().addAll(series1);
        customerHB.setStyle("-fx-background-color:#F7E9C6");
        customerBtn.setStyle("-fx-background-color:#F7E9C6");
        productHb.setStyle("-fx-background-color: #F7E9C6");
        productBtn.setStyle("-fx-background-color: #F7E9C6");
        purchaseHb.setStyle("-fx-background-color: #cfba8b");
        purchaseBtn.setStyle("-fx-background-color: #cfba8b");
        deliveryHb.setStyle("-fx-background-color: #F7E9C6");
        deliveryBtn.setStyle("-fx-background-color: #F7E9C6");
        orderHb.setStyle("-fx-background-color: #F7E9C6");
        orderBtn.setStyle("-fx-background-color: #F7E9C6");
        OrderIHb.setStyle("-fx-background-color: #F7E9C6");
        orderIBtn.setStyle("-fx-background-color: #F7E9C6");
        materialHB.setStyle("-fx-background-color: #F7E9C6");
        materialBtn.setStyle("-fx-background-color: #F7E9C6");
    }

    @FXML
    void logInHandler(ActionEvent event) {
        int flag = 0;

        if (!userTf.getText().equals("root")) {
            System.out.println(userTf.getText());
            userLblWarning.setText("username is not correct");
            flag = 1;
        } else if (userTf.getText().equals(null)) {
            System.out.println("username");

            userLblWarning.setText("please enter username");
            flag = 1;
        } else {
            userLblWarning.setText("");

        }


        if (!passTf.getText().equals("1234")) {
            System.out.println(passTf.getText());
            passLblWarning.setText("password is not correct");
            flag = 1;
        } else if (passTf.getText().equals(null)) {
            System.out.println("password");

            passLblWarning.setText("please enter password");
            flag = 1;
        } else {
            passLblWarning.setText("");

        }

        if (flag == 0) {
            sacImg.setVisible(false);
            userLbl.setVisible(false);
            passLbl.setVisible(false);
            userTf.setVisible(false);
            passTf.setVisible(false);
            line.setVisible(false);
            logInBtn.setVisible(false);
            customerBtn.fire();
            menuVb.setVisible(true);
        }

    }

    public void initialize() {
        customer_data = new ArrayList<>();
        delivery_data = new ArrayList<>();
        material_data = new ArrayList<>();
        orderData = new ArrayList<Order>();
        PurchaseData = new ArrayList<>();
        orderitems = new ArrayList<>();
        products = new ArrayList<>();
        try {
            getCustomerData();
            getDelvieryData();
            getMaterialData();
            getOrderData();
            getPurchaseData();
            getDataOrderItem();
            getDataProduct();
            customer_dataList = FXCollections.observableArrayList(customer_data);
            delivery_dataList = FXCollections.observableArrayList(delivery_data);
            material_dataList = FXCollections.observableArrayList(material_data);
            OrderList = FXCollections.observableList(orderData);
            PurchaseList = FXCollections.observableArrayList(PurchaseData);
            orderitemsList = FXCollections.observableArrayList(orderitems);

            productsList = FXCollections.observableArrayList(products);


            for (Object item : customer_dataList) {
                System.out.println(item);
            }
            for (Object item : delivery_dataList) {
                System.out.println(item);
            }

            customer_tableView();
            Delivery_tableView();
            material_tableView();
            orderTable1();
            purchaseTable();
            tableViewOrderItem();
            tableViewProduct();
            createDeliveryChart();
            createMaterialChart();

            ObservableList<String> sortOrderOptions = FXCollections.observableArrayList("Product ID", "Order ID",
                    "Quantity", "Subtotal");
            sortOrderItemBy.setItems(sortOrderOptions);
            sortOrderItemBy.setValue("Product Id");

            XYChart.Series<String, Double> series1 = new XYChart.Series<>();
            series1.setName("Series 1");
            series1.getData().add(new XYChart.Data<>("Total Amount", calc_total_amount()));
            OrderChart.getData().addAll(series1);
            OrderList.addListener(new ListChangeListener<Order>() {
                @Override
                public void onChanged(ListChangeListener.Change change) {
                    OrderChart.getData().clear();
                    series1.getData().add(new XYChart.Data<>("Total Amount", calc_total_amount()));

                    OrderChart.getData().add(series1);
                }
            });
            showProductChart();
            productsList.addListener(new ListChangeListener<Product>() {
                @Override
                public void onChanged(ListChangeListener.Change change) {
                    productChart.getData().clear();
                   showProductChart();

                }
            });
            // convert data from arraylist to observable arraylist
            subtotalTf.setOnMouseClicked(e->{
                try {
                    String SQL;
                    connectDB();
                    System.out.println("Connection established");
                    SQL = "select price from product p where p.pid = "+productIdTf.getText()+";";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(SQL);
                    double price = 0;
                    int quan = Integer.parseInt(quanityTf.getText());
                    if (rs.next()) {
                        price = rs.getDouble(1);
                        subtotalTf.setText(price*quan +"");
                    }
                    rs.close();
                    stmt.close();
                    con.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            });


        }

        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        delivery_statusCHB.getItems().addAll("empty", "In Transit", "Retrieved", "Lost", "Delivered");
        delivery_statusCHB.setValue("empty");
        selectPaymentMethodCombo.getItems().addAll("Cash", "Credit Card");
        selectShippingCompany.getItems().addAll("EPS", "United Express");
        paymentMethodCombo.getItems().addAll("Cash", "Credit Card");
        paymentConfCombo.getItems().addAll("Confirmed", "Not Confirmed");
        transactionStatusCombo.getItems().addAll("Success", "Pending", "Failed");
        paymentConfCombo.setValue("Empty");
        paymentMethodCombo.setValue("Empty");
        transactionStatusCombo.setValue("Empty");


    }

    @SuppressWarnings("unchecked")

    private void customer_tableView() {

        customerTable.setEditable(true);

        c_id.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("c_id"));
        c_name.setCellValueFactory(new PropertyValueFactory<Customer, String>("c_name"));
        email.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
        address.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<Customer, String>("phone"));
        c_name.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());
        email.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());
        address.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());
        phone.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());
        c_name.setOnEditCommit((CellEditEvent<Customer, String> t) -> {
            Customer c = t.getRowValue();
            c.setC_name(t.getNewValue());
            updateCustomerName(c.getC_id(), t.getNewValue());
        });

        email.setOnEditCommit((CellEditEvent<Customer, String> t) -> {
            Customer c = t.getRowValue();
            c.setEmail(t.getNewValue());
            updateCustomerEmail(c.getC_id(), t.getNewValue());
        });

        phone.setOnEditCommit((CellEditEvent<Customer, String> t) -> {
            Customer c = t.getRowValue();
            c.setPhone(t.getNewValue());
            updateCustomerPhone(c.getC_id(), t.getNewValue());
        });

        address.setOnEditCommit((CellEditEvent<Customer, String> t) -> {
            Customer c = t.getRowValue();
            c.setAddress(t.getNewValue());
            updateCustomerAddress(c.getC_id(), t.getNewValue());
        });

        customerTable.setItems(customer_dataList);

    }

    private void Delivery_tableView() {

        DeliveryTable.setEditable(true);

        delivery_id.setCellValueFactory(new PropertyValueFactory<Delivery, Integer>("Delivery_Id"));
        order_id.setCellValueFactory(new PropertyValueFactory<Delivery, Integer>("Order_Id"));
        delivery_date.setCellValueFactory(new PropertyValueFactory<Delivery, String>("Delivery_Date"));
        delivery_address.setCellValueFactory(new PropertyValueFactory<Delivery, String>("Delivery_Statuse"));
        Estimated_Delivery_Time.setCellValueFactory(new PropertyValueFactory<Delivery, String>("Estimated_Delivery_Time"));
        delivery_status.setCellValueFactory(new PropertyValueFactory<Delivery, String>("Delivery_Address"));
        shipping_company.setCellValueFactory(new PropertyValueFactory<Delivery, String>("Shipping_Company"));
        delivery_date.setCellFactory(TextFieldTableCell.<Delivery>forTableColumn());
        delivery_address.setCellFactory(TextFieldTableCell.<Delivery>forTableColumn());
        Estimated_Delivery_Time.setCellFactory(TextFieldTableCell.<Delivery>forTableColumn());
        delivery_status.setCellFactory(TextFieldTableCell.<Delivery>forTableColumn());
        shipping_company.setCellFactory(TextFieldTableCell.<Delivery>forTableColumn());
        delivery_date.setOnEditCommit((CellEditEvent<Delivery, String> t) -> {
            Delivery d = t.getRowValue();
            d.setDelivery_Date(t.getNewValue());
            updateDeliveryDate(d.getDelivery_Id(), t.getNewValue());
        });
        shipping_company.setOnEditCommit((CellEditEvent<Delivery, String> t) -> {
            Delivery d = t.getRowValue();
            d.setShipping_Company(t.getNewValue());
            updateShippingCompany(d.getDelivery_Id(), t.getNewValue());
        });
        delivery_address.setOnEditCommit((CellEditEvent<Delivery, String> t) -> {
            Delivery d = t.getRowValue();
            d.setDelivery_Address(t.getNewValue());
            updateDeliveryAddress(d.getDelivery_Id(), t.getNewValue());
        });

        Estimated_Delivery_Time.setOnEditCommit((CellEditEvent<Delivery, String> t) -> {
            Delivery d = t.getRowValue();
            d.setEstimated_Delivery_Time(t.getNewValue());
            updateEstimatedDeliveryTime(d.getDelivery_Id(), t.getNewValue());
        });

        delivery_status.setOnEditCommit((CellEditEvent<Delivery, String> t) -> {
            Delivery d = t.getRowValue();
            d.setDelivery_Statuse(t.getNewValue());
            updateDeliveryStatus(d.getDelivery_Id(), t.getNewValue());
        });

        DeliveryTable.setItems(delivery_dataList);

    }

    private void insertData(Customer rc) {

        try {
            System.out.println("Insert into customer (c_id, c_name, address, email, phone)  values(" + rc.getC_id()
                    + ",'" + rc.getC_name() + "','" + rc.getAddress() + "','" + rc.getEmail() + "', '" + rc.getPhone()
                    + "');");

            connectDB();
            ExecuteStatement("Insert into customer (c_id, c_name, address, email, phone)  values(" + rc.getC_id() + ",'"
                    + rc.getC_name() + "','" + rc.getAddress() + "','" + rc.getEmail() + "', '" + rc.getPhone()
                    + "');");

            con.close();
            System.out.println("Connection closed" + customer_data.size());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void getCustomerData() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select c_id,c_name,email, address,phone from Customer order by c_id";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            customer_data.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + customer_data.size());

    }

    private void getDelvieryData() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select delivery_Id, order_Id, delivery_Date, estimated_Delivery_Time, delivery_Statuse, shipping_Company, delivery_Address from delivery order by delivery_id";
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            delivery_data.add(new Delivery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }
        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + delivery_data.size());

    }

    private void getMaterialData() throws SQLException, ClassNotFoundException {
        connectDB();
        System.out.println("Connection established");
        String SQL;
        SQL = "select M_id,M_name,`supplier contact info`, `unit cost`,`stock quantity`,`supplier`,`Description` From material ";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        while (rs.next()) {
            System.out.println(rs.getString(1));
            material_data.add(new material(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)));
        }
        rs.close();
        stmt.close();
        con.close();
        System.out.println("Connection closed" + material_data.size());
    }

    private void connectDB() throws ClassNotFoundException, SQLException {

        dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
        Properties p = new Properties();
        p.setProperty("user", dbUsername);
        p.setProperty("password", dbPassword);
        p.setProperty("useSSL", "false");
        p.setProperty("autoReconnect", "true");
        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection(dbURL, p);

    }

    public void ExecuteStatement(String SQL) throws SQLException {

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();

        } catch (SQLException s) {
            s.printStackTrace();
            System.out.println("SQL statement is not executed!");

        }

    }

    public void updateCustomerName(int c_id, String c_name) {

        try {
            System.out.println("update  customer set c_name= '" + c_name + "' where c_id = " + c_id + ";");
            connectDB();
            ExecuteStatement("update  customer  set c_name = '" + c_name + "' where c_id= " + c_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomerAddress(int c_id, String address) {

        try {
            System.out.println("update  customer set address= '" + address + "' where c_id = " + c_id + ";");
            connectDB();
            ExecuteStatement("update  customer set address = '" + address + "' where c_id = " + c_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomerEmail(int c_id, String email) {

        try {
            System.out.println("update  customer  set email= '" + email + "' where c_id = " + c_id + ";");
            connectDB();
            ExecuteStatement("update  customer set email = '" + email + "' where c_id = " + c_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomerPhone(int c_id, String phone) {

        try {
            System.out.println("update  customer  set phone= '" + phone + "' where c_id = " + c_id + ";");
            connectDB();
            ExecuteStatement("update  customer set phone = '" + phone + "' where c_id = " + c_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void deleteCustomerRow(Customer row) {

        try {
            System.out.println("delete from  customer where c_id=" + row.getC_id() + ";");
            connectDB();
            ExecuteStatement("delete from  customer where c_id=" + row.getC_id() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void addCustomerHandler(ActionEvent event) {
        Customer rc;
        rc = new Customer(Integer.valueOf(customerIdTf.getText()), customerNameTf.getText(), emailTf.getText(),
                customerAdressTf.getText(), CustomerNumberTf.getText());
        System.out.println(rc.toString());
        customer_dataList.add(rc);
        insertData(rc);
        customerIdTf.clear();
        customerNameTf.clear();
        emailTf.clear();
        customerAdressTf.clear();
        CustomerNumberTf.clear();
    }

    @FXML
    void clearCustomersHandler(ActionEvent event) {
        for (Customer row : customer_dataList) {
            deleteCustomerRow(row);
            customerTable.refresh();
        }
        customerTable.getItems().removeAll(customer_dataList);
    }

    @FXML
    void deleteCustomerHandler(ActionEvent event) {
        ObservableList<Customer> selectedRows = customerTable.getSelectionModel().getSelectedItems();
        ArrayList<Customer> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> {
            customerTable.getItems().remove(row);
            deleteCustomerRow(row);
            customerTable.refresh();
        });

    }

    public void updateDeliveryDate(int delivery_id, String delivery_date) {

        try {
            System.out.println("update  delivery set delivery_date= '" + delivery_date + "' where delivery_id = " + delivery_id + ";");
            connectDB();
            ExecuteStatement("update  delivery set delivery_date= '" + delivery_date + "' where delivery_id = " + delivery_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateEstimatedDeliveryTime(int delivery_id, String Estimated_Delivery_Time) {

        try {
            System.out.println("update  delivery set estimated_delivery_time= '" + Estimated_Delivery_Time + "' where delivery_id = " + delivery_id + ";");
            connectDB();
            ExecuteStatement("update  delivery set estimated_delivery_time= '" + Estimated_Delivery_Time + "' where delivery_id = " + delivery_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateDeliveryStatus(int delivery_id, String Delivery_Status) {

        try {
            deliveryChart.getData().clear();
            createDeliveryChart();
            System.out.println("update  delivery set delivery_statuse= '" + Delivery_Status + "' where delivery_id = " + delivery_id + ";");
            connectDB();
            ExecuteStatement("update  delivery set delivery_statuse= '" + Delivery_Status + "' where delivery_id = " + delivery_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateShippingCompany(int delivery_id, String Shipping_Company) {

        try {
            System.out.println("update  delivery set shipping_company= '" + Shipping_Company + "' where delivery_id = " + delivery_id + ";");
            connectDB();
            ExecuteStatement("update  delivery set shipping_company= '" + Shipping_Company + "' where delivery_id = " + delivery_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateDeliveryAddress(int delivery_id, String Delivery_Address) {

        try {
            System.out.println("update  delivery set delivery_address= '" + Delivery_Address + "' where delivery_id = " + delivery_id + ";");
            connectDB();
            ExecuteStatement("update  delivery set delivery_address= '" + Delivery_Address + "' where delivery_id = " + delivery_id + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //------------------------OrderItemAndProduct-----------------
    @FXML
    private Button addOrderItem;

    @FXML
    private Button clearOrderItem;

    @FXML
    private Button deleteOrderItem;

    @FXML
    private TextField orderIdTf;

    @FXML
    private AnchorPane orderItemScreen;

    @FXML
    private TableColumn<OrderItem, Integer> orderIdC;

    @FXML
    private TableColumn<OrderItem, Integer> productIdC;

    @FXML
    private TableColumn<OrderItem, Integer> quantityC;

    @FXML
    private TableColumn<OrderItem, Double> subtotalC;

    @FXML
    private TableView<OrderItem> orderItemTable;

    @FXML
    private VBox orderItemVb;

    @FXML
    private TextField productIdTf;

    @FXML
    private TextField quanityTf;

    @FXML
    private TextField subtotalTf;

    @FXML
    private AnchorPane productScreen;

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, Integer> p_id;

    @FXML
    private TableColumn<Product, String> p_name;

    @FXML
    private TableColumn<Product, String> description;

    @FXML
    private TableColumn<Product, Double> price;

    @FXML
    private TableColumn<Product, Integer> stockQuan;

    @FXML
    private Button addProduct;

    @FXML
    private Button clearProduct;

    @FXML
    private Button deleteProduct;

    @FXML
    private TextField priceTf;

    @FXML
    private TextField productDescriptionTf;

    @FXML
    private TextField p_IdTf;

    @FXML
    private TextField productNameTf;

    @FXML
    private TextField stockQuanTf;
    @FXML
    private StackedBarChart<String, Integer> productChart;

    private void tableViewProduct() {

        productTable.setEditable(true);

        p_id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("pid"));
        p_name.setCellValueFactory(new PropertyValueFactory<Product, String>("pname"));
        description.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));
        price.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        stockQuan.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stockQuantity"));

        p_name.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
        description.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
        price.setCellFactory(TextFieldTableCell.<Product, Double>forTableColumn(new DoubleStringConverter()));
        stockQuan.setCellFactory(TextFieldTableCell.<Product, Integer>forTableColumn(new IntegerStringConverter()));

        p_name.setOnEditCommit((CellEditEvent<Product, String> t) -> {
            Product p = t.getRowValue();
            p.setPname(t.getNewValue());
            updateNameProduct(p.getPid(), t.getNewValue());
        });
        description.setOnEditCommit((CellEditEvent<Product, String> t) -> {
            Product p = t.getRowValue();
            p.setDescription(t.getNewValue());
            updateDescriptionProduct(p.getPid(), t.getNewValue());
        });
        price.setOnEditCommit((CellEditEvent<Product, Double> t) -> {
            Product p = t.getRowValue();
            p.setPrice(t.getNewValue());
            updatePriceProduct(p.getPid(), t.getNewValue());
        });
        stockQuan.setOnEditCommit((CellEditEvent<Product, Integer> t) -> {
            Product p = t.getRowValue();
            p.setStockQuantity(t.getNewValue());
            updateStockQuantityProduct(p.getPid(), t.getNewValue());
        });
        productTable.setItems(productsList);
    }

    private void insertDataProduct(Product rc) {

        try {
            System.out.println("Insert into Product (pid, pname,price, stock_quantity, `description`) values(" + rc.getPid() + ",'"
                    + rc.getPname() + "','" + rc.getPrice() + "'," + rc.getStockQuantity() + ", '" + rc.getDescription() + "')");
            connectDB();
            ExecuteStatement("Insert into Product (pid, pname,price, stock_quantity, `description`) values(" + rc.getPid() + ",'"
                    + rc.getPname() + "','" + rc.getPrice() + "'," + rc.getStockQuantity() + ", '" + rc.getDescription() + "')");

            con.close();
            System.out.println("Connection closed" + products.size());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void getDataProduct() throws SQLException, ClassNotFoundException {
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select pid,pname,price, stock_quantity, `description` from Product order by pid";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            products.add(
                    new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5)));
        }
        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + orderitems.size());

    }

    public void updateNameProduct(int pid, String pname) {

        try {
            System.out.println("update  product set pname = '" + pname + "' where pid = " + pid);
            connectDB();
            ExecuteStatement("update  product set pname = '" + pname + "' where pid = " + pid + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updatePriceProduct(int pid, double price) {

        try {
            System.out.println("update  product set price = " + price + " where pid = " + pid);
            connectDB();
            ExecuteStatement("update  product set price = " + price + " where pid = " + pid + ";");

            // Update only the rows in order_item that correspond to the given product ID
            String SQL = "SELECT * FROM order_item WHERE pid = " + pid;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Integer or_id = rs.getInt(2);
                Integer quan = rs.getInt(3);
                ExecuteStatement("update  order_item set subtotal= " + quan * price
                        + " where pid = " + pid + " AND or_id = " + or_id + ";");
            }

            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            orderitems.clear();
            getDataOrderItem();
            orderitemsList.setAll(orderitems);
            tableViewOrderItem();
            orderItemTable.refresh();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateStockQuantityProduct(int pid, int stock_quantity) {

        try {

            System.out.println("update  product set stock_quantity = '" + stock_quantity + "' where pid = " + pid);
            connectDB();
            ExecuteStatement("update  product set stock_quantity = '" + stock_quantity + "' where pid = " + pid + ";");
            con.close();
            productChart.getData().clear();
            showProductChart();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateDescriptionProduct(int pid, String description) {

        try {
            System.out.println("update  product set `description` = '" + description + "' where pid = " + pid);
            connectDB();
            ExecuteStatement("update  product set `description` = '" + description + "' where pid = " + pid + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteRowProduct(Product row) {

        try {
            System.out.println("delete from  product where pid=" + row.getPid() + ";");
            connectDB();
            ExecuteStatement("delete from  product where pid=" + row.getPid() + ";");
            ExecuteStatement("delete from  order_item where pid=" + row.getPid() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            orderitems.clear();
            getDataOrderItem();
            orderitemsList.setAll(orderitems);
            tableViewOrderItem();
            orderItemTable.refresh();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addOrderItemHandler(ActionEvent event) {
        OrderItem rc;
        rc = new OrderItem(Integer.valueOf(productIdTf.getText()), Integer.valueOf(orderIdTf.getText()), Integer.valueOf(quanityTf.getText()),
                Double.valueOf(subtotalTf.getText()));

        System.out.println(rc.toString());
        orderitemsList.add(rc);
        insertDataOrderItem(rc);
        try {
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select sum(ot.subtotal) from order_item ot Join orderT o on o.or_id = ot.or_id ;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
            int totalSub=0;
            if (rs.next()) {
             totalSub = rs.getInt(1);
            getOrderAmountLabel1.setText(totalSub + "");
        }
        updateOrderTotalAmountFromOrderItem(totalSub);
        rs.close();
        stmt.close();
            orderIdTf.clear();
            productIdTf.clear();
            quanityTf.clear();
            subtotalTf.clear();

        con.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    }


    @FXML
    void clearOrderItemHandler(ActionEvent event) {
        for (OrderItem row : orderitemsList) {
            deleteRowOrderItem(row);
            orderItemTable.refresh();
        }
        orderItemTable.getItems().removeAll(orderitemsList);
    }

    @FXML
    void deleteOrderItemHandler(ActionEvent event) {
        ObservableList<OrderItem> selectedRows = orderItemTable.getSelectionModel().getSelectedItems();
        ArrayList<OrderItem> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> {
            orderItemTable.getItems().remove(row);
            deleteRowOrderItem(row);
            orderItemTable.refresh();
        });
    }

    private void tableViewOrderItem() {

        orderItemTable.setEditable(true);
        productIdC.setCellValueFactory(new PropertyValueFactory<OrderItem, Integer>("product_id"));
        orderIdC.setCellValueFactory(new PropertyValueFactory<OrderItem, Integer>("order_id"));
        quantityC.setCellValueFactory(new PropertyValueFactory<OrderItem, Integer>("quantity"));
        subtotalC.setCellValueFactory(new PropertyValueFactory<OrderItem, Double>("subtotal"));
        quantityC.setCellFactory(TextFieldTableCell.<OrderItem, Integer>forTableColumn(new IntegerStringConverter()));
        quantityC.setOnEditCommit((CellEditEvent<OrderItem, Integer> t) -> {
            OrderItem oi = t.getRowValue();
            oi.setQuantity(t.getNewValue());
            updateQuanOrderItem(oi.getProduct_id(), oi.getOrder_id(), t.getNewValue());
        });
        orderItemTable.setItems(orderitemsList);
    }

    private void insertDataOrderItem(OrderItem rc) {

        try {
            System.out.println("Insert into order_item (pid, or_id, quantity, subtotal)  values(" + rc.getProduct_id()
                    + ",'" + rc.getOrder_id() + "','" + rc.getQuantity() + "','" + rc.getSubtotal() + "');");

            connectDB();
            ExecuteStatement("Insert into order_item (pid, or_id, quantity, subtotal)  values(" + rc.getProduct_id()
                    + ",'" + rc.getOrder_id() + "','" + rc.getQuantity() + "','" + rc.getSubtotal() + "');");

            con.close();
            System.out.println("Connection closed" + orderitems.size());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void getDataOrderItem() throws SQLException, ClassNotFoundException {
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select pid,or_id,quantity, subtotal from order_item";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            orderitems.add(
                    new OrderItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4)));
        }
        rs.close();
        stmt.close();
        con.close();
        System.out.println("Connection closed" + orderitems.size());

    }

    public void updateQuanOrderItem(int product_id, int order_id, int newQuantity) {

        try {
            System.out.println("update  order_item set quantity= " + newQuantity + " where or_id = " + order_id
                    + " and pid = " + product_id + ";");

            connectDB();

            ExecuteStatement("update  order_item set quantity= " + newQuantity + " where or_id = " + order_id
                    + " and pid = " + product_id + ";");

            String SQL = "select price from product P where P.pid=" + product_id + ";";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                Double price = rs.getDouble(1);
                ExecuteStatement("update  order_item set subtotal= " + newQuantity * price
                        + " where or_id = " + order_id + " and pid = " + product_id + ";");
            }
            con.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            orderitems.clear();
            getDataOrderItem();
            orderitemsList.setAll(orderitems);
            tableViewOrderItem();
            orderItemTable.refresh();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    private void deleteRowOrderItem(OrderItem row) {

        try {
            System.out.println("delete from order_item where or_id=" + row.getOrder_id() + " and pid = " + row.getProduct_id() + ";");
            connectDB();
            ExecuteStatement("delete from order_item where or_id=" + row.getOrder_id() + " and pid = " + row.getProduct_id() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void addProductHandler(ActionEvent event) {
        Product rc;

        rc = new Product(Integer.valueOf(p_IdTf.getText()), productNameTf.getText(), Double.valueOf(priceTf.getText()), Integer.valueOf(stockQuanTf.getText()),
                productDescriptionTf.getText());
        System.out.println(rc.toString());
        productsList.add(rc);
        insertDataProduct(rc);
        p_IdTf.clear();
        productNameTf.clear();
        priceTf.clear();
        stockQuanTf.clear();
        productDescriptionTf.clear();
    }

    @FXML
    void clearProductHandler(ActionEvent event) {
        for (Product row : productsList) {
            deleteRowProduct(row);
            productTable.refresh();
        }
        productTable.getItems().removeAll(productsList);
    }


    @FXML
    void deleteProductHandler(ActionEvent event) {
        ObservableList<Product> selectedRows = productTable.getSelectionModel().getSelectedItems();
        ArrayList<Product> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> {
            if (row.getPid() == 1 || row.getPid() == 2 ) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Import Information");
                alert.setHeaderText(null);
                alert.setContentText("FORBIDDEN ACTION FOR THIS PRODUCT ID!");
                alert.showAndWait();
            }
            else {
            productTable.getItems().remove(row);
            deleteRowProduct(row);
            productTable.refresh();
        } });
    }
    @FXML
    private Label cheapestPro;
    @FXML
    private Button cheapestProBtn;
    @FXML
    private Label totalStockQuantity;
    @FXML
    private Label avgPrice;
    @FXML
    private Label mostExpPro;
    @FXML
    void totalStockQuantityBtnHandler(ActionEvent event) {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select sum(p.stock_quantity) from product p;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalSQuan = rs.getInt(1);
                totalStockQuantity.setText(totalSQuan + "");
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void cheapestProBtnHandler(ActionEvent event) {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select pname from product p where p.price =(select min(p.price) from product p);";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                String cheapest = rs.getString(1);
                cheapestPro.setText(cheapest);
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void orderItemTotalQuantityHandler(ActionEvent event) {

        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select sum(oi.quantity) from order_item oi;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalQuan = rs.getInt(1);
                totalQuantity.setText(totalQuan+"");
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void orderItemTotalPriceHandler(ActionEvent event) {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select sum(oi.subtotal) from order_item oi;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int totalSub = rs.getInt(1);
                totalSubTotals.setText(totalSub + "");
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void searchByProductNameHandler(ActionEvent event) {
        try {
            String SQL;
            String pname = productNameTf.getText();

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from product p where p.pname like '" + pname + "';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            productsList.clear();
            getDataProduct();
            while (rs.next()) {
                productsList.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5)));
            }
            tableViewProduct();
            productTable.refresh();
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void avgPriceBtnHandler(ActionEvent event) {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select avg(p.price) from product p;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                double avgprice = rs.getDouble(1);
                avgPrice.setText(avgprice + "");
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void mostExpProBtnHandler(ActionEvent event) {
        try {
            String SQL;

            connectDB();
            System.out.println("Connection established");

            SQL = "select pname from product p where p.price =(select max(p.price) from product p);";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                String mostExp = rs.getString(1);
                mostExpPro.setText(mostExp);
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void filterAddressBtnHandler(ActionEvent event) {
        try {
            String SQL;
            String adress = customerAdressTf.getText();

            connectDB();
            System.out.println("Connection established");

            SQL = "select * from customer C where C.address like '" + adress + "';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            customer_dataList.clear();
            getCustomerData();
            while (rs.next()) {
                customer_dataList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            customer_tableView();
            customerTable.refresh();
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void filterNameBtnHandler(ActionEvent event)  {
        try {
        String SQL;
        String name = customerNameTf.getText();

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from customer C where C.c_name like '" + name + "';";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        customer_dataList.clear();
        getCustomerData();
        while (rs.next()) {
            customer_dataList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        customer_tableView();
        customerTable.refresh();
        rs.close();
        stmt.close();
        con.close();

    } catch(
    SQLException e)

    {
        e.printStackTrace();
    } catch(
    ClassNotFoundException e)

    {
        e.printStackTrace();
    }
}
    @FXML
    void totalCustomerCountHandler(ActionEvent event) {
        try {
            String SQL;
            connectDB();
            System.out.println("Connection established");
            SQL = "select count(*) from customer;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int customerCount = rs.getInt(1);
                totalCusNum.setText(Integer.toString(customerCount));
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }






}

    @FXML
    void sortOrderItemTableHandler(ActionEvent event) {
            String sortingCategory = "";

            if ("Product ID".equals(sortOrderItemBy.getValue())) {
                sortingCategory = "pid";
            } else if ("Order ID".equals(sortOrderItemBy.getValue())) {
                sortingCategory = "or_id";
            } else if ("Quantity".equals(sortOrderItemBy.getValue())) {
                sortingCategory = "quantity";
            } else if ("Subtotal".equals(sortOrderItemBy.getValue())) {
                sortingCategory = "subtotal";
            }

            System.out.println(sortingCategory);

            try {
                String SQL;

                connectDB();
                System.out.println("Connection established");
                if (!sortingCategory.isEmpty()) {
                    SQL = "SELECT * FROM order_item oi ORDER BY oi." + sortingCategory + ";";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(SQL);

                    orderitemsList.clear();
                    getDataOrderItem();
                    while (rs.next()) {
                        orderitemsList.add(new OrderItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4)));
                    }
                    tableViewOrderItem();
                    orderItemTable.refresh();

                    rs.close();
                    stmt.close();
                }

                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    public int totals(String str) {
        int stockQuanityCalc=0;
        try {
            String SQL;
            connectDB();
            System.out.println("Connection established");

            SQL = "select stock_quantity from product p where p.pname = '"+str+"';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            if (rs.next()) {
                stockQuanityCalc = rs.getInt(1);
            }
            rs.close();
            stmt.close();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return stockQuanityCalc;
    }
    public void showProductChart() {

        XYChart.Series<String, Integer> production = new XYChart.Series<>();
        production.setName("Production Chart");
        ObservableList<String> pro = FXCollections.observableArrayList();
        for (Product p : productsList) {
            String product = p_name.getCellData(p);
        }

        production.getData().add(new XYChart.Data<>("Black Bags", totals("Black Bag")));

        production.getData().add(new XYChart.Data<>("White Bags", totals("White Bag")));

        production.getData().add(new XYChart.Data<>("Pins", totals("Pins")));


        productChart.getData().addAll(production);

    }







}










