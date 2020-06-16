package ru.levelup.covid19.finance.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "price", schema = "public", catalog = "covid")
public class PriceEntity {
    private int priceId;
    private Integer date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double adjclose;
    private FinanceHistoryEntity financeHistoryByFinanceHistoryId;

    @Id
    @Column(name = "price_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    @Basic
    @Column(name = "date")
    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Basic
    @Column(name = "open")
    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    @Basic
    @Column(name = "high")
    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    @Basic
    @Column(name = "low")
    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    @Basic
    @Column(name = "close")
    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    @Basic
    @Column(name = "adjclose")
    public Double getAdjclose() {
        return adjclose;
    }

    public void setAdjclose(Double adjclose) {
        this.adjclose = adjclose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceEntity that = (PriceEntity) o;
        return priceId == that.priceId &&
                Objects.equals(date, that.date) &&
                Objects.equals(open, that.open) &&
                Objects.equals(high, that.high) &&
                Objects.equals(low, that.low) &&
                Objects.equals(close, that.close) &&
                Objects.equals(adjclose, that.adjclose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceId, date, open, high, low, close, adjclose);
    }

    @ManyToOne
    @JoinColumn(name = "finance_history_id", referencedColumnName = "finance_history_id")
    public FinanceHistoryEntity getFinanceHistoryByFinanceHistoryId() {
        return financeHistoryByFinanceHistoryId;
    }

    public void setFinanceHistoryByFinanceHistoryId(FinanceHistoryEntity financeHistoryByFinanceHistoryId) {
        this.financeHistoryByFinanceHistoryId = financeHistoryByFinanceHistoryId;
    }
}
