package com.bank;

/**
 * Program transaksi perbankan sederhana. Program ini memungkinkan pengguna untuk melakukan setoran
 * dan penarikan pada akun bank, serta melihat informasi transaksi dan saldo akun.
 *
 * Program ini mencakup konsep inheritance, dependency, dan aggregation.
 *
 * @author Aulia Nurul Fauziah
 * @version 1.0
 * @since 2023-09-17
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Customer customer = null;       // Inisialisasi variabel pelanggan
        double initialBalance;
        int accountId;

        System.out.println("======= PROGRAM BANK SEDERHANA =======");
        // Meminta input ID Akun dari pengguna
        while (true) {
            System.out.print("Masukkan ID Akun (4 digit): ");
            accountId = scanner.nextInt();
            if (String.valueOf(accountId).length() == 4) {
                break;  
            } else {
                System.out.println("ID Akun harus memiliki 4 digit. Silakan coba lagi.");
            }
        }
        
        // Meminta input Nama Pelanggan dari pengguna
        System.out.print("Masukkan Nama Pelanggan\t: ");
        scanner.nextLine();
        String customerName = scanner.nextLine();
        
        // Meminta input Saldo Awal dari pengguna
        System.out.print("Masukkan Saldo Awal\t: Rp.");
        initialBalance = scanner.nextDouble();

        // Membuat objek akun dengan ID dan saldo awal
        Account account = new Account(accountId, initialBalance);
        
        System.out.println("=====================================");
        
        // Menampilkan pilihan operasi (setoran atau penarikan)
        System.out.println("Pilihan:");
        System.out.println("1. Setoran");
        System.out.println("2. Penarikan");
        System.out.print("Pilih tindakan (1/2): ");
        int choice = scanner.nextInt();
        
        // Jika pengguna memilih setoran
        if (choice == 1) {
            
            // Memasukkan jumlah setoran
            System.out.print("Masukkan Jumlah Deposit: Rp.");
            double depositAmount = scanner.nextDouble();

            // Membuat transaksi setoran
            DepositTransaction depositTransaction = new DepositTransaction(depositAmount);
            
            // Menyimpan saldo baru setelah setoran
            account.setBalance(depositTransaction.execute(account.getBalance()));

            // Membuat pelanggan jika belum ada
            if (customer == null) {
                customer = new Customer(accountId, customerName);
            }
            
            // Menambahkan transaksi ke daftar transaksi pelanggan
            customer.addTransaction(depositTransaction);
            
            // Jika pengguna memilih penarikan
        } else if (choice == 2) {
            // Memasukkan jumlah penarikan
            System.out.print("Masukkan Jumlah Penarikan: Rp.");
            double withdrawalAmount = scanner.nextDouble();
            
            // Membuat transaksi penarikan
            WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(withdrawalAmount);
            
            // Menyimpan saldo baru setelah penarikan
            account.setBalance(withdrawalTransaction.execute(account.getBalance()));

            // Membuat pelanggan jika belum ada
            if (customer == null) {
                customer = new Customer(accountId, customerName);
            }
            
            // Menambahkan transaksi ke daftar transaksi pelanggan
            customer.addTransaction(withdrawalTransaction);
        } else {
            // Jika pengguna memilih opsi tidak valid
            System.out.println("Pilihan tidak valid.");
            scanner.close();
            return;
        }
        
        System.out.println("=====================================");
        // Menampilkan informasi akun
        System.out.println("Informasi Akun");
        System.out.println("ID Akun\t: " + account.getAccountId());
        System.out.println("Saldo Awal\t: Rp. " + account.getInitialBalance());

        System.out.println("=====================================");
        if (customer != null) {
            // Menampilkan informasi pelanggan
            System.out.println("Informasi Pelanggan");
            System.out.println("ID Pelanggan\t: " + customer.getCustomerId());
            System.out.println("Nama Pelanggan : " + customer.getName());
            
            System.out.println("=====================================");
            // Menampilkan informasi transaksi
            System.out.println("Transaksi");
            for (Transaction transaction : customer.getTransactions()) {
                System.out.println("Jenis Transaksi : " + transaction.getType());
                System.out.println("Jumlah\t: Rp. " + transaction.getAmount());
            }
        }
        
        System.out.println("=====================================");
        // Menampilkan saldo akhir
        System.out.println("Saldo Sekarang :\t Rp. " + account.getBalance());
        
        System.out.println("=====================================");

        // Menutup scanner
        scanner.close();
    }
}