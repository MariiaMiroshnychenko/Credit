package model.entity;

import view.MessageConstant;

public class IkrSibBankCredit extends Credit implements MessageConstant{
    public enum IkrSibBankPurpose {

        FOR_CAR(CAR), FOR_REAL_ESTATE(REAL_ESTATE), FOR_DEVICE(DEVICE), FOR_EDUCATION(EDUCATION);

        private String purposeName;

        IkrSibBankPurpose(String purposeName) {
            this.purposeName = purposeName;
        }

        public String getPurposeName() {
            return purposeName;
        }
    }

    private IkrSibBankPurpose purpose;

    public IkrSibBankCredit(Integer creditSize, Integer term, Integer percent, boolean earlyRepayment, boolean riseCreditLine, IkrSibBankPurpose purpose) {
        super(creditSize, term, percent, earlyRepayment, riseCreditLine);
        this.purpose = purpose;
    }

    @Override
    public String getPurpose() {
        return purpose.getPurposeName();
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

    public Givable giveCredit() {
        return this;
    }
}

