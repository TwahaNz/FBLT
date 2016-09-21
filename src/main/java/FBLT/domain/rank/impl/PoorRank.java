package FBLT.domain.rank.impl;

import FBLT.domain.rank.Rank;

/**
 * lowest rating
 */
public class PoorRank extends Rank {

    public String handleRequest(int averageRating) {
        if(averageRating >=1 && averageRating <=2){
            return "Not so good";
        }
        else{
            if(nextRank != null){
                return nextRank.handleRequest(averageRating);
            }
        }
        return null;
    }
}
