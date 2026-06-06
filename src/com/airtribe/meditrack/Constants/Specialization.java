package com.airtribe.meditrack.Constants;

public enum Specialization {
    GENERAL_PHYSICIAN,
    NEUROLOGY,
    OBGYN,
    CARDIOLOGY,
    DERMATOLOGIST,
    ONCOLOGIST,
    COSMETIC_SURGERY,
    PSYCHIATRIST,
    ORTHOPEDIST;

    public static Specialization fromChoice(int choice) {
        return values()[choice - 1];
    }
}
