package FBLT.domain.rank;

import FBLT.factories.rank.RankFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tayfer01 on 9/21/2016.
 */
public class RankTest {


    @Test
    public void whenTheRatingIsZero_thentheUserIsUnrated() throws Exception {
        String result = RankFactory.getRanking(0);

        Assert.assertTrue(result.equalsIgnoreCase("Unrated"));
    }

    @Test
    public void whenTheRatingIs1to2_thentheUserIsPoor() throws Exception {
        String result = RankFactory.getRanking(1);

        Assert.assertTrue(result.equalsIgnoreCase("not so good"));
    }

    @Test
    public void whenTheRatingIs3to4_thentheUserIsGood() throws Exception {
        String result = RankFactory.getRanking(3);

        Assert.assertTrue(result.equalsIgnoreCase("good"));
    }

    @Test
    public void whenTheRatingIsFive_thentheUserIsGreat() throws Exception {
        String result = RankFactory.getRanking(5);

        Assert.assertTrue(result.equalsIgnoreCase("Great"));
    }
}
