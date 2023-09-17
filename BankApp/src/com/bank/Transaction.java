package com.bank;

// Kelas untuk merepresentasikan transaksi
class Transaction {
    private double amount;  // Jumlah transaksi
    private String type;    // Jenis transaksi (Deposit atau Withdrawal)

     // Konstruktor untuk membuat objek Transaksi dengan jumlah dan jenis transaksi
    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    // Getter untuk mendapatkan jumlah transaksi
    public double getAmount() {
        return amount;
    }

    // Getter untuk mendapatkan jenis transaksi
    public String getType() {
        return type;
    }
}

// Kelas turunan dari Transaction untuk merepresentasikan transaksi setoran
class DepositTransaction extends Transaction {
    public DepositTransaction(double amount) {
        super(amount, "Deposit");
    }
    
    // Metode untuk melakukan deposit dan mengembalikan saldo yang baru
    public double execute(double balance) {
        return balance + getAmount();
    }
}

// Kelas turunan dari Transaction untuk merepresentasikan transaksi penarikan
class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(double amount) {
        super(amount, "Withdrawal");
    }
    
    // Metode untuk melakukan penarikan dan mengembalikan saldo yang baru
    public double execute(double balance) {
        return balance - getAmount();
    }
}