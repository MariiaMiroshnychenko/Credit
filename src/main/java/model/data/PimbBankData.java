package model.data;

import model.entity.PimbBankCredit;

public enum PimbBankData {
    FLAT_CREDIT(new PimbBankCredit(100000, 240, 45, false, true, PimbBankCredit.PimbBankPurpose.FOR_REAL_ESTATE)),
    FLAT_REPAIR(new PimbBankCredit(10000, 60, 15, true, false, PimbBankCredit.PimbBankPurpose.FOR_APARTMENT_REPAIR)),
    EQUIPMENT_CREDIT(new PimbBankCredit(2000, 36, 0, false, false, PimbBankCredit.PimbBankPurpose.FOR_DEVICE)),
    CARD_CREDIT(new PimbBankCredit(2500, 36, 5, true, true, PimbBankCredit.PimbBankPurpose.CREDIT_CARD));

    PimbBankCredit pimbBankCredit;

    PimbBankData(PimbBankCredit pimbBankCredit) {
        this.pimbBankCredit = pimbBankCredit;
    }

    public PimbBankCredit getPimbBankCredit() {
        return pimbBankCredit;
    }
}
