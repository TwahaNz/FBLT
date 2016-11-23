package FBLT.domain.rank.impl;

import FBLT.domain.rank.Rank;

/**
 * Top ranking
 */
public class GreatRank extends Rank {

    public String handleRequest(int averageRating) {
        if (averageRating == 5) {
            return "Great";
        } else {
            if (nextRank != null) {
                return nextRank.handleRequest(averageRating);
            }
        }
        return null;
    }
}
