package game;

import ast.EndCriteriaType;

import java.util.Map;

public class EndCriteria {
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

    // Require, the entity exists in the nameMap
    public boolean hasWon(Map<String, Tile> nameMap) {
        Tile tile = nameMap.get(winEntityName);
        switch (winType) {
            case AMOUNT -> {
                return GameManager.getInstance().getScore() == winValue;
            }
            case HEALTH -> {
                // no other way
                if (tile instanceof Player player) {
                    return player.getHealth() == winValue;
                }
                if (tile instanceof Enemy enemy) {
                    return enemy.getHealth() == winValue;
                }

            }
        }
        return false;
    }

    public boolean hasLost(Map<String, Tile> nameMap) {
        Tile tile = nameMap.get(loseEntityName);
        switch (loseType) {
            case AMOUNT -> {
                return GameManager.getInstance().getScore() == loseValue;
            }
            case HEALTH -> {
                if (tile instanceof Player player) {
                    return player.getHealth() == loseValue;
                }
                if (tile instanceof Enemy enemy) {
                    return enemy.getHealth() == loseValue;
                }
            }
        }
        return false;
    }
}
