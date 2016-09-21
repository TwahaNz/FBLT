package FBLT.factories.rank;

import FBLT.domain.rank.Rank;
import FBLT.domain.rank.impl.GoodRank;
import FBLT.domain.rank.impl.GreatRank;
import FBLT.domain.rank.impl.PoorRank;
import FBLT.domain.rank.impl.Unrated;

/**
 * Created by tayfer01 on 9/21/2016.
 */
public class RankFactory {

    public static String getRanking(int rank){
        Rank rankChain = setUpChain();

        return rankChain.handleRequest(rank);
    }

    public static Rank setUpChain(){
        Rank unrated = new Unrated();
        Rank poorRanking = new PoorRank();
        Rank goodRank = new GoodRank();
        Rank greatRank = new GreatRank();

        unrated.setNextRank(poorRanking);
        poorRanking.setNextRank(goodRank);
        goodRank.setNextRank(greatRank);

        return unrated;

    }
}
