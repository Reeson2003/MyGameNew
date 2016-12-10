package ru.reeson2003.model.characters.items;

/**
 * Created by nimtego_loc on 08.12.2016.
 */
final public class Gold {
    private long numberOfGold;

    public Gold() {
        this(0);
    }
    public Gold(final long numberOfGold) {
        this.numberOfGold = numberOfGold;
    }
    public Gold(final Gold gold) {
        this.numberOfGold = gold.getNumberOfGold();
    }
    public Gold removePartOfGold(final long numberOfGold) throws IllegalArgumentException {
        if (this.numberOfGold - numberOfGold < 0 || numberOfGold < 0) {
            throw new IllegalArgumentException();
        }
        this.numberOfGold -= numberOfGold;
        return new Gold(numberOfGold);
    }
    public Gold removePartOfGold(final Gold gold) throws IllegalArgumentException {
        if (this.numberOfGold - gold.getNumberOfGold() < 0) {
            throw new IllegalArgumentException();
        }
        this.numberOfGold -= gold.getNumberOfGold();
        return new Gold(numberOfGold);
    }
    public void addGold(final Gold gold) {
        this.numberOfGold += gold.getNumberOfGold();
    }
    public void addGold(final long gold) throws IllegalArgumentException {
        if (gold < 0 || this.numberOfGold - gold < 0)
            throw new IllegalArgumentException();
        this.numberOfGold += gold;
    }
    public Gold mergeGold(Gold ... gold) {
        Gold merge = new Gold();
        for (Gold forMergeGold : gold) {
            merge.addGold(forMergeGold);
            this.addGold(forMergeGold);
        }
        return merge;
    }
    @Override
    public String toString() {
        return Long.toString(numberOfGold);
    }

    public long getNumberOfGold() {return numberOfGold;}
    public void setNumberOfGold(final long numberOfGold) {this.numberOfGold = numberOfGold;}


}
