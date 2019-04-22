package model.entity;

public abstract class Credit implements Givable {
    private Integer creditSize;
    private Integer term;
    private Integer percent;
    private boolean earlyRepayment;
    private boolean riseCreditLine;

    Credit(Integer creditSize, Integer term, Integer percent, boolean earlyRepayment, boolean riseCreditLine) {
        this.creditSize = creditSize;
        this.term = term;
        this.percent = percent;
        this.earlyRepayment = earlyRepayment;
        this.riseCreditLine = riseCreditLine;
    }

    public abstract String getBankName();

    public abstract String getPurpose();

    public int getCreditSize() {
        return creditSize;
    }

    public void setCreditSize(int creditSize) {
        this.creditSize = creditSize;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public boolean isEarlyRepayment() {
        return earlyRepayment;
    }

    public void setEarlyRepayment(boolean earlyRepayment) {
        this.earlyRepayment = earlyRepayment;
    }

    public boolean isRiseCreditLine() {
        return riseCreditLine;
    }

    public void setRiseCreditLine(boolean riseCreditLine) {
        this.riseCreditLine = riseCreditLine;
    }
}
