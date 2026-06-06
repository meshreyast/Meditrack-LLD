package com.airtribe.meditrack.bills;

import com.airtribe.meditrack.Entity.Appointment;
import com.airtribe.meditrack.Entity.Bill;

public class SeniorCitizenBill extends Bill {

    public SeniorCitizenBill (int id, Appointment ap) {
        super(id, ap);
    }

    @Override
    public double calculateAmount() {
        return calculateTax(this.getAmount()) * 1.10;
    }
}
