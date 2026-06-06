package com.airtribe.meditrack.Entity;


public class BillSummary {

    private static BillSummary Instance;

    private BillSummary (){};

    public static synchronized BillSummary getInstance() {
        if (Instance == null) {
            Instance = new BillSummary();
        }
        return Instance;
    }

    public void getBillSummary (Bill b) {
        System.out.println("Bill for "
            + b.getId() + " for patient "
                + b.getAppointment().getPatient().getName() + " visiting doctor Dr."
                + b.getAppointment().getDoctor().getName() + ", total amount is "
                + b.calculateAmount()
        );
    }
}
