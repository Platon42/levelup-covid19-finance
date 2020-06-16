package ru.levelup.covid19.finance.jpa;

import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "finance_history", schema = "public", catalog = "covid")
@ToString
public class FinanceHistoryEntity {
    private int financeHistoryId;
    private Boolean isPending;
    private Integer firstTradeDate;
    private String id;
    private String timeZone;

    @Id
    @Column(name = "finance_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getFinanceHistoryId() {
        return financeHistoryId;
    }

    public void setFinanceHistoryId(int financeHistoryId) {
        this.financeHistoryId = financeHistoryId;
    }

    @Basic
    @Column(name = "is_pending")
    public Boolean getPending() {
        return isPending;
    }

    public void setPending(Boolean pending) {
        isPending = pending;
    }

    @Basic
    @Column(name = "first_trade_date")
    public Integer getFirstTradeDate() {
        return firstTradeDate;
    }

    public void setFirstTradeDate(Integer firstTradeDate) {
        this.firstTradeDate = firstTradeDate;
    }

    @Basic
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time_zone")
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceHistoryEntity that = (FinanceHistoryEntity) o;
        return financeHistoryId == that.financeHistoryId &&
                Objects.equals(isPending, that.isPending) &&
                Objects.equals(firstTradeDate, that.firstTradeDate) &&
                Objects.equals(id, that.id) &&
                Objects.equals(timeZone, that.timeZone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(financeHistoryId, isPending, firstTradeDate, id, timeZone);
    }
}
