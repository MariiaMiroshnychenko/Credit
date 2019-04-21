package model.entity;

import view.MessageConstant;

public class PimbBankCredit extends Credit implements MessageConstant{
    public enum PimbBankPurpose {
        FOR_REAL_ESTATE(REAL_ESTATE), FOR_DEVICE(DEVICE), FOR_APARTMENT_REPAIR(APARTMENT_REPAIR), CREDIT_CARD(CARD);

        private String purposeName;

        PimbBankPurpose(String purposeName) {
            this.purposeName = purposeName;
        }

        public String getPurposeName() {
            return purposeName;
        }
    }

    private PimbBankPurpose purpose;

    public PimbBankCredit(int creditSize, int term, int percent, boolean earlyRepayment, boolean riseCreditLine, PimbBankPurpose purpose) {
        super(creditSize, term, percent, earlyRepayment, riseCreditLine);
        this.purpose = purpose;
    }



    @Override
    public String getBankName() {
        return PIMB_BANK_NAME;
    }

    @Override
    public String getPurpose() {
        return purpose.getPurposeName();
    }

    public void setPurpose(PimbBankPurpose purpose) {
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
