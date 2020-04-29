import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel implements ActionListener,MouseListener, MouseMotionListener,KeyListener {

//    enum PossibleShapes{
//        Line, Oval, Rectangle
//    }
//    //Rectangle rects[];
//    //ArrayList<Rectangle> rects;
//    int lastX = -1;
//    int lastY = -1;

    //PossibleShapes currentShape = PossibleShapes.Line;
    protected Player player = new Player("Kyle");
    protected boolean noInput = true;
    protected Graphics g;

    protected ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(player.getActive().isFloating(grids)){
                player.getActive().moveDown(g, grids);
            }else{
                player.getActive().lock(grids);
                player.spawnActive();
            }
        }
    };

    protected Timer fall = new Timer(500,al);

    protected Cell[][] grids = new Cell[10][22];

    //boolean isAnimating = false;

    public DrawingPanel(){
        //rects = new Rectangle[30];
        //rects = new ArrayList<Rectangle>();
        //Cell[][] grids = new Cell[10][22];
        //fall.start();
        //fall.setRepeats(false);

        for(int i =0;i<10;i++) {
            for(int j=0;j<22;j++) {
                grids[i][j] = new Cell(i,j);
            }
            //rects[i] = new Rectangle(i*40, i*60, 40, 60, 1, 1, Color.red);

        }
        fall.start();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.g = g;
        g.drawString(player.getName(),300,100);
        g.drawString("Score: "+String.valueOf(player.getScore()),300,200);
        g.drawString("Level: "+String.valueOf(player.getLevel()),300,300);
        g.drawString("Lines: "+String.valueOf(player.getRowsCleared()),300,400);



        for(Cell[] grid: grids){
            for(Cell cell: grid){
                cell.draw(g);
            }
        }

        player.getActive().draw(g,grids,player.getActive().getColor());
    }

    public void clearLine(int y){
        player.addLine();
        for(int i=0;i<10;i++){
            grids[i][y].empty();
            grids[i][y].setColor(new Color(0,0,0));
        }
        for(int j=y;j>0;j--){
            for(int i=0;i<10;i++){
                grids[i][j].setColor(grids[i][j-1].getColor());
                if(grids[i][j-1].isFilled()){
                    grids[i][j].fill();
                }else{
                    grids[i][j].empty();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numLines = 0;
        for(int j=2;j<22;j++){
            if(grids[0][j].isFilled() && grids[1][j].isFilled() && grids[2][j].isFilled() && grids[3][j].isFilled() && grids[4][j].isFilled() && grids[5][j].isFilled() && grids[6][j].isFilled() && grids[7][j].isFilled() && grids[8][j].isFilled() && grids[9][j].isFilled()){
                numLines++;
                clearLine(j);
            }
        }
        player.increaseScore(numLines);
        repaint();

//        if(!fall.isRunning()) {
//            if(player.getActive().isFloating(grids)){
//                player.getActive().moveDown(g, grids);
//            }else{
//                player.getActive().lock(grids);
//                player.spawnActive();
//            }
//        }
//        fall.restart();
//        fall.setRepeats(false);
        //noInput = true;

//        if(isAnimating) {
//            for (Shape shape : shapes) {
//                shape.moveAutomatically();
//            }
//        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("Key Typed");
        noInput = false;
        char keyPressed = e.getKeyChar();
        if(keyPressed == 'w'){
            //System.out.println("Line");
            player.getActive().teleportDown();
        } else if (keyPressed == 'a'){
            player.getActive().moveLeft(g,grids);
        } else if (keyPressed == 'd'){
            player.getActive().moveRight(g,grids);
        } else if (keyPressed == 's'){
            if(player.getActive().isFloating(grids)) {
                player.getActive().moveDown(g, grids);
            }
        } else if (keyPressed == '['){
            player.getActive().rotateCCW(g,grids);
        } else if (keyPressed == ']'){
            player.getActive().rotateCW(g,grids);
        } else if (keyPressed == ' '){

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
