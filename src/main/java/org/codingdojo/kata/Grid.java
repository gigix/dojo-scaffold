package org.codingdojo.kata;

public class Grid {
    private final int x;
    private final int y;

    private Grid right;
    private Grid left;
    private Grid above;
    private Grid below;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    public void rightLinkTo(Grid another) {
        this.right = another;
        another.left = this;
    }

    public Grid right() {
        return right;
    }

    public Grid left() {
        return left;
    }

    public Grid above() {
        return above;
    }

    void upLinkTo(Grid another) {
        this.above = another;
        another.below = this;
    }

    public Grid below() {
        return below;
    }

    void sendToNext(Rover rover, Direction direction) {
        Grid nextGrid = direction.nextGrid(this);
        rover.setGrid(nextGrid);
    }
}
