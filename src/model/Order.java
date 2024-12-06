package model;

public class Order {
    private int id;             // ID Pesanan
    private int userId;         // ID Pengguna yang melakukan pesanan
    private double totalPrice;  // Total harga pesanan
    private String status;      // Status pesanan (misalnya, pending, completed)

    // Constructor dengan semua parameter
    public Order(int id, int userId, double totalPrice, String status) {
        this.id = id;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    // Constructor tanpa ID (digunakan untuk membuat pesanan baru)
    public Order(int userId, double totalPrice, String status) {
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
