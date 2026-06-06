package com.airtribe.meditrack.Interfaces;

public interface Payable {

    default double calculateTax(double amount) {
        return amount * 1.18;
    }
}
