public class Player {
    private String name;
    private int level;
    private int score;
    private int rowsCleared;
    private Tetromino active;
    private Tetromino held;

    public Player(String name){
        this.name = name;
        level = 1;
        score = 0;
        rowsCleared = 0;
        held = new I(50,50);
        spawnActive();
    }

    public void increaseScore(int numLines){
        if(numLines == 0){

        }else if(numLines == 1){
            score += 100*level;
        }else if(numLines == 2){
            score += 300*level;
        }else if(numLines == 3){
            score += 500*level;
        }else{
            score += 800*level;
        }
    }

    public void addLine(){
        rowsCleared++;
        if(rowsCleared % 10 == 0){
            level++;
        }
    }

    public void spawnActive(){
        double p = Math.random()*7;
        if(p<1){
            active = new I(4,1);
        }else if(p<2){
            active = new J(4,1);
        }else if(p<3){
            active = new L(4,1);
        }else if(p<4){
            active = new O(4,1);
        }else if(p<5){
            active = new S(4,1);
        }else if(p<6){
            active = new T(4,1);
        }else{
            active = new Z(4,1);
        }
    }

    public void swap(){
        Tetromino temp = active;
        active = held;
        held = temp;
        held.setX(50);
        held.setY(50);
        active.setX(temp.getX());
        active.setY(temp.getY());
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public int getRowsCleared() {
        return rowsCleared;
    }

    public String getName() {
        return name;
    }

    public Tetromino getActive() {
        return active;
    }

    public Tetromino getHeld() {
        return held;
    }
}
