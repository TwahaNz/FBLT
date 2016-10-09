package FBLT.domain.rank.impl;

import FBLT.domain.rank.Rank;

/**
 * Created by tayfer01 on 9/21/2016.
 */
public class GoodRank extends Rank {

    public String handleRequest(int averageRating) {
        if (averageRating >= 3 && averageRating <= 4) {
            return "Good";
        } else {
            if (nextRank != null) {
                return nextRank.handleRequest(averageRating);
            }
        }
        return null;
    }
}
