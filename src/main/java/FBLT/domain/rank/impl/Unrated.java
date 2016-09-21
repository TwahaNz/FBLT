package FBLT.domain.rank.impl;

import FBLT.domain.rank.Rank;

/**
 *
 * If a user has never send a rating request they will be unrated
 *
 */
public class Unrated extends Rank {

    public String handleRequest(int averageRating) {
        if(averageRating == 0){
            return "Unrated";
        }
        else{
            if(nextRank != null){
                return nextRank.handleRequest(averageRating);
            }
        }
        return null;
    }
}
