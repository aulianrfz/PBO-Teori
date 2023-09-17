package com.bank;

// Kelas untuk merepresentasikan akun
class Account {
    private int accountId;              // Variabel untuk menyimpan ID akun
    private double initialBalance;      // Variabel untuk menyimpan saldo awal
    private double balance;             // Variabel untuk menyimpan saldo yang dapat diubah

    // Konstruktor untuk inisialisasi objek akun dengan ID dan saldo awal
    public Account(int accountId, double initialBalance) {
        this.accountId = accountId;
        this.initialBalance = initialBalance;
        this.balance = initialBalance;
    }

    // Getter untuk mendapatkan ID akun
    public int getAccountId() {
        return accountId;
    }

     // Getter untuk mendapatkan saldo awal
    public double getInitialBalance() {
        return initialBalance;
    }

    // Getter untuk mendapatkan saldo saat ini
    public double getBalance() {
        return balance;
    }

    // Setter untuk mengubah saldo saat ini
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
}
