import java.awt.*;

public class O extends Tetromino {
    public O(int x, int y) {
        super(x, y, new Color(200,200,0));
    }

    @Override
    public void draw(Graphics g,Cell[][] grid,Color c) {
        super.draw(g,grid,c);
        grid[x][y].setColor(c);
        grid[x][y-1].setColor(c);
        grid[x+1][y-1].setColor(c);
        grid[x+1][y].setColor(c);
        xMax = 8;
        xMin = 0;
        yMax = 0;
    }

    @Override
    public void lock(Cell[][] grid) {
        super.lock(grid);
        grid[x][y].fill();
        grid[x][y-1].fill();
        grid[x+1][y-1].fill();
        grid[x+1][y].fill();
    }

    @Override
    public boolean isFloating(Cell[][] grid) {
        boolean bc = super.isFloating(grid);
        if(!bc){ // this avoids the case of trying to index above 21 when the tetromino reaches the floor.
            return false;
        }
        boolean c1 = !grid[x][y+1].isFilled();
        boolean c2 = !grid[x+1][y+1].isFilled();
        return bc && c1 && c2;
    }

    @Override
    public boolean isBlockedRight(Cell[][] grid) {
        boolean bc = super.isBlockedRight(grid);
        if(bc){ // this avoids the case of trying to index above 21 when the tetromino reaches the floor.
            return true;
        }
        boolean c1 = grid[x+2][y-1].isFilled();
        boolean c2 = grid[x+2][y].isFilled();
        return bc || c1 || c2;
    }

    @Override
    public boolean isBlockedLeft(Cell[][] grid) {
        boolean bc = super.isBlockedLeft(grid);
        if(bc){ // this avoids the case of trying to index above 21 when the tetromino reaches the floor.
            return true;
        }
        boolean c1 = grid[x-1][y-1].isFilled();
        boolean c2 = grid[x-1][y].isFilled();
        return bc || c1 || c2;
    }
}
