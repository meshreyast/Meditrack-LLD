package com.airtribe.meditrack.Services;

import com.airtribe.meditrack.Entity.Bill;
import com.airtribe.meditrack.Interfaces.Searchable;
import com.airtribe.meditrack.Utils.DataStore;

public class BillingService implements Searchable<Bill> {
    private DataStore<Bill> bills;

    public BillingService() {
        this.bills = new DataStore<>();
    }

    public DataStore<Bill> getBills() {
        return bills;
    }

    @Override
    public Bill searchById(int id) {
        for (Bill b: bills.getAll()) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public Bill getBillById (int id) {
        return searchById(id);
    }

    public void addBill(Bill bill) {
        this.bills.add(bill);
    }
}
