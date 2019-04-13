package com.gitschwifty.cs2340.gatech.space_trader.Model;

/**
 * Difficulty
 */
public enum Difficulty {
    BEGINNER("Beginner"),
    EASY("Easy"),
    NORMAL("Normal"),
    HARD("Hard"),
    IMPOSSIBLE("Impossible");


    private final String returnDifficulty;
    Difficulty (String returnDifficulty){
        this.returnDifficulty = returnDifficulty;
    }

    /**
     * @return returnDifficulty
     */
    public String getReturnDifficulty() {
        return returnDifficulty;
    }
}
