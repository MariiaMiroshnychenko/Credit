package model.data;

import model.entity.PrivitBankCredit;

public enum PrivitBankData {
    CHANGE_CAR_CREDIT(new PrivitBankCredit(45000, 60, 15, false, true, PrivitBankCredit.PrivitBankPurpose.FOR_CAR)),
    CHANGE_FLAT_CREDIT(new PrivitBankCredit(75000, 72, 35, true, false, PrivitBankCredit.PrivitBankPurpose.FOR_REAL_ESTATE)),
    CHANGE_DEVICE_CREDIT(new PrivitBankCredit(1500, 20, 0, false, true, PrivitBankCredit.PrivitBankPurpose.FOR_DEVICE)),
    CREATE_BUSINESS_CREDIT(new PrivitBankCredit(50000, 360, 40, true, false, PrivitBankCredit.PrivitBankPurpose.FOR_BUSINESS));

    PrivitBankCredit privitBankCredit;

    PrivitBankData(PrivitBankCredit privitBankCredit) {
        this.privitBankCredit = privitBankCredit;
    }

    public PrivitBankCredit getPrivitBankCredit() {
        return privitBankCredit;
    }
}
