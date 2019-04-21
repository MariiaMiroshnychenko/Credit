package model.entity;

import view.MessageConstant;

public class IkrSibBankCredit extends Credit implements MessageConstant{
    public enum IkrSibBankPurpose {
        FOR_CAR, FOR_REAL_ESTATE, FOR_DEVICE, FOR_EDUCATION
    }

    private IkrSibBankPurpose purpose;

    public IkrSibBankCredit(Integer creditSize, Integer term, Integer percent, boolean earlyRepayment, boolean riseCreditLine, IkrSibBankPurpose purpose) {
        super(creditSize, term, percent, earlyRepayment, riseCreditLine);
        this.purpose = purpose;
    }

    public IkrSibBankPurpose getPurpose() {
        return purpose;
    }

    @Override
    public int getCreditSize() {
        return super.getCreditSize();
    }

    @Override
    public void setCreditSize(int creditSize) {
        super.setCreditSize(creditSize);
    }

    @Override
    public int getTerm() {
        return super.getTerm();
    }

    @Override
    public void setTerm(int term) {
        super.setTerm(term);
    }

    @Override
    public int getPercent() {
        return super.getPercent();
    }

    @Override
    public void setPercent(int percent) {
        super.setPercent(percent);
    }

    @Override
    public boolean isEarlyRepayment() {
        return super.isEarlyRepayment();
    }

    @Override
    public void setEarlyRepayment(boolean earlyRepayment) {
        super.setEarlyRepayment(earlyRepayment);
    }

    @Override
    public boolean isRiseCreditLine() {
        return super.isRiseCreditLine();
    }

    @Override
    public void setRiseCreditLine(boolean riseCreditLine) {
        super.setRiseCreditLine(riseCreditLine);
    }

    @Override
    public String getBankName() {
        return IKR_SIB_BANK_NAME;
    }

    //    @Override
//    public String toString() {
//        return "IkrSibBank: " +
//                SIZE + getCreditSize() +
//                TERM + getTerm() +
//                PERCENT + getPercent() +
//                EARLY_REPAYMENT + isEarlyRepayment() +
//                RISE_CREDIT_LINE + isRiseCreditLine(); //+
//                //PURPOSE ;
//    }

    public Givable giveCredit() {
        return this;
    }
}

