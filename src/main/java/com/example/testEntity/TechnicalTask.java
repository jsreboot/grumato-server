package com.example.testEntity;

public class TechnicalTask {
    private int ttCode;
    private String tkDescription;
    private String cost;

    public int getTtCode() {
        return ttCode;
    }

    public void setTtCode(int ttCode) {
        this.ttCode = ttCode;
    }

    public String getTkDescription() {
        return tkDescription;
    }

    public void setTkDescription(String tkDescription) {
        this.tkDescription = tkDescription;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TechnicalTask that = (TechnicalTask) o;

        if (ttCode != that.ttCode) return false;
        if (tkDescription != null ? !tkDescription.equals(that.tkDescription) : that.tkDescription != null)
            return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ttCode;
        result = 31 * result + (tkDescription != null ? tkDescription.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}
