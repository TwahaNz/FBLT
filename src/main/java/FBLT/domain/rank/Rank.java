package FBLT.domain.rank;

/**
 * This class acts as a chain of responsibility, gets in an average of the
 * users rating and returns a ranking accordingly
 */

public abstract class Rank {

    public Rank nextRank;

    public void setNextRank(Rank rank) {
        this.nextRank = rank;
    }

    public abstract String handleRequest(int averageRating);
}
