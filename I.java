import java.awt.*;

public class I extends Tetromino{

    public I(int x, int y) {
        super(x, y, new Color(0,170,200));
    }

    @Override
    public void draw(Graphics g,Cell[][] grid,Color c) {
        super.draw(g,grid,c);
        if(rotation == Rotation.Base) {
            grid[x-1][y].setColor(c);
            grid[x][y].setColor(c);
            grid[x+1][y].setColor(c);
            grid[x+2][y].setColor(c);
            xMax = 7;
            xMin = 1;
            yMax = 0;
        }else if(rotation == Rotation.One){
            grid[x+1][y-1].setColor(c);
            grid[x+1][y].setColor(c);
            grid[x+1][y+1].setColor(c);
            grid[x+1][y+2].setColor(c);
            xMax = 8;
            xMin = -1;
            yMax = 2;
        }else if(rotation == Rotation.Two){
            grid[x-1][y+1].setColor(c);
            grid[x][y+1].setColor(c);
            grid[x+1][y+1].setColor(c);
            grid[x+2][y+1].setColor(c);
            xMax = 7;
            xMin = 1;
            yMax = 1;
        }else{
            grid[x][y-1].setColor(c);
            grid[x][y].setColor(c);
            grid[x][y+1].setColor(c);
            grid[x][y+2].setColor(c);
            xMax = 9;
            xMin = 0;
            yMax = 2;
        }
    }

    @Override
    public void lock(Cell[][] grid) {
        super.lock(grid);
        if(rotation == Rotation.Base) {
            grid[x-1][y].fill();
            grid[x][y].fill();
            grid[x+1][y].fill();
            grid[x+2][y].fill();
        }else if(rotation == Rotation.One){
            grid[x+1][y-1].fill();
            grid[x+1][y].fill();
            grid[x+1][y+1].fill();
            grid[x+1][y+2].fill();
        }else if(rotation == Rotation.Two){
            grid[x-1][y+1].fill();
            grid[x][y+1].fill();
            grid[x+1][y+1].fill();
            grid[x+2][y+1].fill();
        }else{
            grid[x][y-1].fill();
            grid[x][y].fill();
            grid[x][y+1].fill();
            grid[x][y+2].fill();
        }
    }

    @Override
    public boolean isFloating(Cell[][] grid) {
        boolean bc = super.isFloating(grid);
        if(!bc){ // this avoids the case of trying to index above 21 when the tetromino reaches the floor.
            return false;
        }
        boolean c1;
        boolean c2 = true;
        boolean c3 = true;
        boolean c4 = true;
        if(rotation == Rotation.Base) {
            c1 = !grid[x-1][y+1].isFilled();
            c2 = !grid[x][y+1].isFilled();
            c3 = !grid[x+1][y+1].isFilled();
            c4 = !grid[x+2][y+1].isFilled();
        }else if(rotation == Rotation.One){
            c1 = !grid[x+1][y+3].isFilled();
        }else if(rotation == Rotation.Two){
            c1 = !grid[x-1][y+2].isFilled();
            c2 = !grid[x][y+2].isFilled();
            c3 = !grid[x+1][y+2].isFilled();
            c4 = !grid[x+2][y+2].isFilled();
        }else{
            c1 = !grid[x][y+3].isFilled();
        }
        return bc && c1 && c2 && c3 && c4;
    }

    @Override
    public boolean isBlockedRight(Cell[][] grid) {
        boolean bc = super.isBlockedRight(grid);
        if(bc){ // this avoids the case of trying to index above 21 when the tetromino reaches the floor.
            return true;
        }
        boolean c1;
        boolean c2 = false;
        boolean c3 = false;
        boolean c4 = false;
        if(rotation == Rotation.Base) {
            c1 = grid[x+3][y].isFilled();
        }else if(rotation == Rotation.One){
            c1 = grid[x+2][y-1].isFilled();
            c2 = grid[x+2][y].isFilled();
            c3 = grid[x+2][y+1].isFilled();
            c4 = grid[x+2][y+2].isFilled();
        }else if(rotation == Rotation.Two){
            c1 = grid[x+3][y+1].isFilled();
        }else{
            c1 = grid[x+1][y-1].isFilled();
            c2 = grid[x+1][y].isFilled();
            c3 = grid[x+1][y+1].isFilled();
            c4 = grid[x+1][y+2].isFilled();
        }
        return bc || c1 || c2 || c3 || c4;
    }

    @Override
    public boolean isBlockedLeft(Cell[][] grid) {
        boolean bc = super.isBlockedLeft(grid);
        if(bc){ // this avoids the case of trying to index above 21 when the tetromino reaches the floor.
            return true;
        }
        boolean c1;
        boolean c2 = false;
        boolean c3 = false;
        boolean c4 = false;
        if(rotation == Rotation.Base) {
            c1 = grid[x-2][y].isFilled();
        }else if(rotation == Rotation.One){
            c1 = grid[x][y-1].isFilled();
            c2 = grid[x][y].isFilled();
            c3 = grid[x][y+1].isFilled();
            c4 = grid[x][y+2].isFilled();
        }else if(rotation == Rotation.Two){
            c1 = grid[x-2][y+1].isFilled();
        }else{
            c1 = grid[x-1][y-1].isFilled();
            c2 = grid[x-1][y].isFilled();
            c3 = grid[x-1][y+1].isFilled();
            c4 = grid[x-1][y+2].isFilled();
        }
        return bc || c1 || c2 || c3 || c4;
    }
}
