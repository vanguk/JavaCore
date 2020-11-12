package main.module1;

public enum RockScissorsPaper {
    ROCK,
    SCISSORS,
    PAPER;

    public int compareMove(RockScissorsPaper otherMove) {
        if (this == otherMove) {
            return 0;
        } else {
            switch (this) {
                case ROCK:
                    return otherMove == SCISSORS ? 1 : -1;
                case PAPER:
                    return otherMove == ROCK ? 1 : -1;
                case SCISSORS:
                    return otherMove == PAPER ? 1 : -1;
            }
        }
        return 0;
    }
}
