package com.airtribe.meditrack.factory;

import com.airtribe.meditrack.Constants.BillType;
import com.airtribe.meditrack.Entity.Appointment;
import com.airtribe.meditrack.Entity.Bill;
import com.airtribe.meditrack.Exceptions.InvalidDataException;
import com.airtribe.meditrack.Utils.IdGenerator;
import com.airtribe.meditrack.bills.SeniorCitizenBill;
import com.airtribe.meditrack.bills.StandardBill;

public class BillFactory {
    public static Bill create (BillType type, Appointment ap) {
        return switch (type) {
            case BillType.STANDARD -> new StandardBill(
                    IdGenerator.getInstance().generateId(),
                    ap
            );
            case BillType.SENIOR -> new SeniorCitizenBill(
                    IdGenerator.getInstance().generateId(),
                    ap
            );
            default -> throw new InvalidDataException("Not applicable");
        };
    }
}
