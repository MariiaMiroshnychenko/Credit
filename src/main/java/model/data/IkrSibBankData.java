package model.data;

import model.entity.IkrSibBankCredit;

public enum IkrSibBankData {
    BUY_APARTMENTS(new IkrSibBankCredit(70000, 120, 40, true, false, IkrSibBankCredit.IkrSibBankPurpose.FOR_REAL_ESTATE)),
    BUY_CAR(new IkrSibBankCredit(50000, 60, 25, false, false, IkrSibBankCredit.IkrSibBankPurpose.FOR_CAR)),
    BUY_EQUIPMENT(new IkrSibBankCredit(1000, 10, 0, true, true, IkrSibBankCredit.IkrSibBankPurpose.FOR_DEVICE)),
    BEGIN_STUDY(new IkrSibBankCredit(3000, 60, 20, true, true, IkrSibBankCredit.IkrSibBankPurpose.FOR_EDUCATION));

    IkrSibBankCredit ikrSibBankCredit;

    IkrSibBankData(IkrSibBankCredit ikrSibBankCredit) {
        this.ikrSibBankCredit = ikrSibBankCredit;
    }

    public IkrSibBankCredit getIkrSibBankCredit() {
        return ikrSibBankCredit;
    }
}
