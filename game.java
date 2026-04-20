import java.util.Scanner;

class Ghost{
//  attributes 
    public String GhostLasttile;
    String ghost_char;
    int x;
    int y;
    // constructor
    public Ghost(String ghost_char,int x,int y){
    this.GhostLasttile=" ";
    this.ghost_char = ghost_char;
    this.x=x;
    this.y=y;} 

// getters
public int  get_xcor(){
    return this.x;}
public int get_ycor(){
    return this.y;}

// setters
public void set_xcor(int newx){
    this.x=newx;} 
public void set_ycor(int newy){
    this.y=newy;} 

 // ghost walk 
public void random_walk(int i, int j,String [][]gamemap){
    double surprise=Math.random()*11;
    int newi; int newj;
            if( surprise<0.9|| (3.6<surprise && surprise<4.5)|| (7.2<surprise && surprise<8.1)){
                newi=i-1;newj=j;
                if(i==0 || gamemap[i-1][j]=="X"){
                    this.random_walk(i, j, gamemap);;}
                else{
                    gamemap[i][j]=this.GhostLasttile;
                    this.GhostLasttile=gamemap[newi][j];
                    this.set_xcor(newi);
                    gamemap[newi][j]="G";} }
            else if( surprise<1.8|| (4.5<surprise && surprise<5.4)|| (8.1<surprise && surprise<9.1)){
                newi=i+1; newj=j;
                if(i==18|| gamemap[i+1][j]=="X"){
                     this.random_walk(i, j, gamemap);}
                else{
                    gamemap[i][j]=this.GhostLasttile;
                    this.GhostLasttile=gamemap[newi][j];
                    this.set_xcor(newi);
                    gamemap[newi][j]="G";}}
            else if( surprise<2.7|| (5.4<surprise && surprise<6.3)|| (9.1<surprise && surprise<10.1)){
                newi=i;newj=j+1;
                if(j==19 || gamemap[i][j+1]=="X"){
                    this.random_walk(i, j, gamemap);}
                else{
                    gamemap[i][j]=this.GhostLasttile;
                    this.GhostLasttile=gamemap[i][newj];
                    this.set_ycor(newj);
                    gamemap[i][newj]="G";}}
            else if( surprise<3.6|| (6.3<surprise && surprise<7.2)|| (10.1<surprise && surprise<11)){
                newi=i;newj=j-1;
                if(j==0 || gamemap[i][j-1]=="X"){
                    this.random_walk(i, j, gamemap);}
                else{
                    gamemap[i][j]=this.GhostLasttile;
                    this.GhostLasttile=gamemap[i][newj];
                    this.set_ycor(newj);
                    gamemap[i][newj]="G";}}
}   

// jaisa ke naam me hai
public void setting_ghost_after_life_lost(int a,int b,game board){
     board.gamemap[this.get_xcor()][this.get_ycor()] = this.GhostLasttile;
     this.GhostLasttile=" ";
     this.set_xcor(a);
     this.set_ycor(b);
     board.gamemap[this.x][this.y]="G";
}
}


class Pacman{
    String pacman_char;
    int score;
    int lives;
    int xcor;
    int ycor;
    // constructor
    public Pacman(String pc){
        this.score=0;
        this.lives=3;
        pacman_char = pc;
        xcor=14;
        ycor=9;
    }
    // getters
    public int get_Xcor(){
    return this.xcor;}
    public int get_Ycor(){
    return this.ycor;}
    
    // setters
    public void set_Xcor(int x){
    this.xcor=x;}
    public void set_Ycor(int y){
    this.ycor=y;}
    // methods
    public void lives_count(){
        this.lives--;}
    public int get_lives(){
        return this.lives;} 
// score methods
    public void  score_count(){
        score+=10;}
    public  int get_score(){
        return score;}

// MOVE UP
public void move_up(int i, int j, String [][] game_map){
    if(i==0 || game_map[i-1][j]=="X"){
        this.set_Xcor(i);}
    else{
    game_map[i][j]=" ";
    this.set_Xcor(i-1); 
    if (game_map[i-1][j].equals("*")){
       this.score_count();}
    game_map[i-1][j]="P";}}

// MOVE DOWN
public void move_down(int i,int j, String [][] game_map){
    if(i==18|| game_map[i+1][j]=="X"){
        this.set_Xcor(i);}
    else{
        game_map[i][j]=" ";
        this.set_Xcor(i+1);
        if (game_map[i+1][j].equals("*")){
        this.score_count();} 
        game_map[i+1][j]="P";} }

// MOVE RIGHT
public void move_right(int i,int j, String [][] game_map){
    if(j==19 || game_map[i][j+1]=="X"){
        this.set_Ycor(j);}
        else{ 
            this.set_Ycor(j+1);
            game_map[i][j]=" "; 
            if (game_map[i][j+1].equals("*")){
            this.score_count();}
             game_map[i][j+1]="P";}
}

// MOVE LEFT
public void  move_left(int i,int j, String [][] game_map){
    if(j==0 || game_map[i][j-1]=="X"){
         this.set_Ycor(j);}
        else{
            this.set_Ycor(j-1);
            game_map[i][j]=" ";
            if (game_map[i][j-1].equals("*")){ 
            this.score_count();}
            game_map[i][j-1]="P";}
}     

//   pacman walk combined with movement
 public void walk(String [][] gamemap){
        System.out.print(" WASD ");
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        switch (input) {
            case "w"://move up
            this.move_up(this.xcor, this.ycor, gamemap );
            break;
            case "s"://move down
            this.move_down(this.xcor, this.ycor, gamemap);
            break;
            case "a"://move left
            this.move_left(this.xcor, this.ycor, gamemap);
            break;
            case "d"://move right
            this.move_right(this.xcor, this.ycor, gamemap);
            break;
            default:
                System.out.println("invalid input");
                break;}}

public void setting_pacman_after_life_lost (game board){
        board.gamemap[this.get_Xcor()][this.get_Ycor()] = " ";
        this.set_Xcor(14);
        this.set_Ycor(9);
        board.gamemap[board.pc.xcor][board.pc.ycor]="P";}  
             }  

    


public class game{
    Pacman pc;
    Ghost g1;
    // Ghost g2;
    // Ghost g3;
    // Ghost g4;
    String[][] gamemap = {
    {"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"},
    {"X"," ","*"," "," "," "," "," "," "," "," "," ","*"," "," "," "," "," "," ","X"},
    {"X"," ","X","X","*","X","X","*","X","X","X"," ","X","X","X"," ","X","X"," ","X"},
    {"X"," ","X","X"," ","X"," "," ","X","X","X"," ","X"," ","X","*","X","X","*","X"},
    {"X","*"," "," "," ","X"," "," "," ","*"," "," "," ","*","X"," ","*"," "," ","X"},
    {"X","X","X","X"," ","X","X","X","X"," ","X","X","X","X","X"," ","X","X"," ","X"},
    {"X"," "," ","X"," ","X"," ","*"," "," "," "," "," "," ","X"," ","X","*"," ","X"},
    {"X","X","X","X"," ","X"," ","X","X","*","X","X","X"," ","X","*","X","X","X","X"},
    {"X"," "," "," ","*"," "," ","*"," "," "," ","*"," "," "," "," "," "," ","*","X"},
    {"X","X","X","X"," ","X","*","X","X","X","X","X","X"," ","X"," ","X","X","X","X"},
    {"X"," "," ","X"," ","X"," ","*"," "," "," "," "," ","*","X"," ","X"," "," ","X"},
    {"X","X","X","X"," ","X"," ","X","X","X","X","X","X"," ","X"," ","X","X","X","X"},
    {"X"," ","*"," "," "," "," "," "," ","X"," "," "," "," ","*"," "," "," "," ","X"},
    {"X"," ","X","X"," ","X","X","X"," ","X"," ","X","X","X","X"," ","X","X"," ","X"},
    {"X","*"," ","X"," "," ","*"," "," "," ","*"," "," "," "," "," ","X","*"," ","X"},
    {"X"," ","X","X","*","X","*","X","X","X","X","X"," ","X"," ","X","X","X"," ","X"},
    {"X"," "," ","X"," ","X"," "," "," ","X"," "," "," ","X"," "," ","X","*"," ","X"},
    {"X"," ","*"," "," "," "," "," "," ","X"," "," ","*"," "," "," "," "," "," ","X"},
    {"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}};
    
    // constructors
    public game(){
        pc=new Pacman("P");
        g1=new Ghost ("G",4,3);
        // g2=new Ghost ("G",12,3);
        // g3=new Ghost ("G",4,17);
        // g4=new Ghost ("G",12,17);
        gamemap[pc.xcor][pc.ycor]=pc.pacman_char;
        gamemap[g1.x][g1.y]=g1.ghost_char;
        // gamemap[g2.x][g2.y]=g2.ghost_char;
        // gamemap[g3.x][g3.y]=g3.ghost_char; 
        // gamemap[g4.x][g4.y]=g4.ghost_char;
    }
    
            
    //  printing map
    public  void printMap() {
        for (String[] row : gamemap) {
            for (String cell : row) {
                System.out.print(cell + " "); }
            System.out.println(); }}

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    // Front pagee
    game board = new game();
    System.out.println("                                               . ||||||||||||||||||||| .");
    System.out.println("                                               . --------------------- .");
    System.out.println("                                               . | WELCOME TO PACMAN | .");
    System.out.println("                                               . --------------------- .");
    System.out.println("                                               . ||||||||||||||||||||| .");
    System.out.println("INSTRUCTIONS:\n \n 1) pacman is display by P. \n 2) Ghost are reprisented by g \n 3) Food is represented by * \n 4) For every food yr pacman eats,it gains 10 points. \n 5) Your pacman has 3 lives, meaning that u can interact with ghost only 3 times,after that its game over. \n 6) After eating all the foods u have to go to the gate to finish the game. \n 7) w for up(↑), s for down(↓) , a for left(←) ,d for right(→) \n \n ");
    System.out.println("                                                  Press S to start the game, \n                                                               OR        \n                                                  Press E to exit the game. ");
    // taking input and runing the loop
    String in=sc.next();
    if("S".equals(in)){
        while(true){
            System.out.println("Lives left    :"+ board.pc.get_lives());    
            System.out.println("Current Score :" + board.pc.get_score());
            board.printMap();
            board.pc.walk(board.gamemap);
            board.g1.random_walk(board.g1.x,board.g1.y,board.gamemap);
            // board.g2.random_walk(board.g2.x,board.g2.y,board.gamemap);
            // board.g3.random_walk(board.g3.x,board.g3.y,board.gamemap);
            // board.g4.random_walk(board.g4.x,board.g4.y,board.gamemap);
            if((board.pc.get_Xcor()==board.g1.get_xcor()) && (board.pc.get_Ycor()==board.g1.get_ycor())){
            //    ||(board.pc.get_Xcor()==board.g2.get_xcor()) && (board.pc.get_Ycor()==board.g2.get_ycor())||
            //    (board.pc.get_Xcor()==board.g3.get_xcor()) && (board.pc.get_Ycor()==board.g3.get_ycor())||
            //    (board.pc.get_Xcor()==board.g4.get_xcor()) && (board.pc.get_Ycor()==board.g4.get_ycor())){
                // when G and P meet it will show only G at that cell showing G killed pacman.
                // board.gamemap[board.pc.get_Xcor()][board.pc.get_Ycor()]="G";
                board.pc.lives_count();
                board.printMap();
                System.out.println("YOU LOST A LIFE! BE CAREFUL.");
                // after losing each live the P and G will go back to initial coordinates
                // updating ghost and pacman after losing life
                board.g1.setting_ghost_after_life_lost(4,3,board);
                // board.g2.setting_ghost_after_life_lost(12,3,board);
                // board.g3.setting_ghost_after_life_lost(4,17,board);
                // board.g4.setting_ghost_after_life_lost(12,17,board);
                board.pc.setting_pacman_after_life_lost(board);
                if(board.pc.lives==0){
                    System.out.println("        GAME OVER! \n you have lost better luck next time.");
                    break;}
                }
                if(board.pc.get_score()==310){
                    System.out.println("CONGRATULATIONSSS!  , YOU WONN");
                    break ;
                }
                System.out.println("\033[H\033[2J");
                System.out.flush();}}
    else if("E".equals(in)){
        System.out.println("HOPE YOU HAD FUN!!!");}  
}}