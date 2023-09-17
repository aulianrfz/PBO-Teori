package com.bank;

import java.util.ArrayList;
import java.util.List;

// Kelas untuk merepresentasikan pelanggan
class Customer {
    private int customerId ;    // ID Pelanggan
    private String name;        // Nama Pelanggan
    private List<Transaction> transactions; // Daftar transaksi yang dilakukan oleh pelanggan

    // Konstruktor untuk membuat objek Customer dengan ID dan nama
    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.transactions = new ArrayList<>(); // Inisialisasi daftar transaksi
    }
    
    // Getter untuk mendapatkan ID pelanggan
    public int getCustomerId() {
        return customerId;
    }

    // Getter untuk mendapatkan nama pelanggan
    public String getName() {
        return name;
    }

    // Getter untuk mendapatkan daftar transaksi
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Metode untuk menambahkan transaksi ke daftar transaksi pelanggan
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}