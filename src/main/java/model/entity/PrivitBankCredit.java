package model.entity;

import view.MessageConstant;

public class PrivitBankCredit extends Credit implements MessageConstant {
    public enum PrivitBankPurpose {
        FOR_CAR, FOR_REAL_ESTATE, FOR_DEVICE, FOR_BUSINESS
    }

    private PrivitBankPurpose purpose;

    public PrivitBankCredit(int creditSize, int term, int percent, boolean earlyRepayment, boolean riseCreditLine, PrivitBankPurpose purpose) {
        super(creditSize, term, percent, earlyRepayment, riseCreditLine);
        this.purpose = purpose;
    }

    @Override
    public String getBankName() {
        return PRIVIT_BANK_NAME;
    }

    public PrivitBankPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(PrivitBankPurpose purpose) {
        this.purpose = purpose;
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

    public Givable giveCredit() {
        return this;
    }
}
