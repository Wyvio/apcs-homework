// Stuart Reges
// 5/23/06
//
// Stone objects are displayed as S and always stay put.

public class Stone implements Critter {
    public char getChar() {
        return 'S';
    }

    public int getMove(CritterInfo info) {
        return CENTER;
    }
}
