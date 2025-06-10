package ast;

import java.util.Objects;

public class EndCriteria extends Node {
    private final String winEntityName;
    private final EndCriteriaType winType;
    private final Integer winValue;
    private final String loseEntityName;
    private final EndCriteriaType loseType;
    private final Integer loseValue;

    public EndCriteria(String winEntityName, EndCriteriaType winType, Integer winValue, String loseEntityName, EndCriteriaType loseType, Integer loseValue) {
        this.winEntityName = winEntityName;
        this.winType = winType;
        this.winValue = winValue;
        this.loseEntityName = loseEntityName;
        this.loseType = loseType;
        this.loseValue = loseValue;
    }

    // getters
    public Integer getLoseValue() {
        return loseValue;
    }

    public EndCriteriaType getLoseType() {
        return loseType;
    }

    public String getLoseEntityName() {
        return loseEntityName;
    }

    public Integer getWinValue() {
        return winValue;
    }

    public EndCriteriaType getWinType() {
        return winType;
    }

    public String getWinEntityName() {
        return winEntityName;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EndCriteria other) {
            boolean win = true;
            if (winEntityName != null) {
                win = winEntityName.equals(other.winEntityName) && winType == other.winType && Objects.equals(winValue, other.winValue);
            }
            boolean lose = true;
            if (loseEntityName != null) {
                lose = loseEntityName.equals(other.loseEntityName) && loseType == other.loseType && Objects.equals(loseValue, other.loseValue);
            }
            return win && lose;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winEntityName, winType, winValue, loseEntityName, loseType, loseValue);
    }

    @Override
    public String toString() {
        String win = "";
        if (winEntityName != null) {
            win += "win: " + winEntityName;
            win += winType == EndCriteriaType.AMOUNT ? " amount " : " health ";
            win += "equals" + winValue + " ";
        }
        String lose = "";
        if (loseEntityName != null) {
            lose += "lose: " + loseEntityName;
            lose += loseType == EndCriteriaType.AMOUNT ? " amount " : " health ";
            lose += "equals" + loseValue + " ";
        }
        return win + lose;
    }
}
