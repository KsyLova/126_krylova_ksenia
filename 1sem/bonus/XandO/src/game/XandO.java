package game;

import java.util.*;

public class XandO {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    char[][] table;

    int countX  = 0;
    int countO  = 0;
    int free    = 0;

    public XandO(){
        table=new char[3][3];
        this.initTable();
    }

    void initTable() {
        for(int row=0;row<3;row++){
            for (int col=0;col<3;col++){
                table[row][col]=SIGN_EMPTY;
            }
        }
    }

    public void game(){
        while (true){
            manWalk();
            if (checkWin(SIGN_X)){
                System.out.println("Вы победили!");
                break;
            }
            if (isFullTable()){
                System.out.println("Таблица заполнена");
                break;
            }
            programWalk();
            printTable();
            if(checkWin(SIGN_O)){
                System.out.println("Компьютер выиграл:(");
                break;
            }
        }
        System.out.println("Игра окончена");
        printTable();
    }

    void printTable(){
        for (int row=0; row<3;row++){
            for (int col=0;col<3;col++){
                System.out.print(table[row][col]+" ");
            }
            System.out.print("\n");
        }
    }

    void manWalk(){
        Scanner sc = new Scanner(System.in);
        int x,y;
        do{
            System.out.println("Введите x и y из диапазона(1-3):");
            x=getNumber(sc)-1;
            y=getNumber(sc)-1;
        }
        while (!isCellValidMan(x,y));
        table[x][y]=SIGN_X;
    }

    int getNumber(Scanner sc){
        int trying = 0;
        String buf;
        while (true){
            if (sc.hasNextInt()) {
                trying = sc.nextInt();
                break;
            }
            else {
                buf=sc.next();
                System.out.println("Введены неверные символы:"+ buf);

            }
        }
        return trying;
    }

    boolean isCellValidMan(int x, int y){
        if(x<0||x>2||y<0||y>2){
            System.out.println("Ошибка.Число взято не из диапазона (1-3)");
            return false;
        }
        if (this.table[x][y] != SIGN_EMPTY){
            System.out.println("Ячейка занята");
            return false;
        }
        return true;
    }

    boolean isFullTable(){
        for (int row=0;row<3;row++){
            for (int col=0;col<3;col++){
                if(table[row][col]==SIGN_EMPTY)
                    return false;
            }
        }
        return true;
    }

    void programWalk(){
        if (!checkFirstDiag() && !checkSecondDiag() && !checkRows() && !checkCols()){
            randomWalk();
        }
    }

    void count(int row, int col){
        if (table[row][col] == SIGN_X) {
            countX++;
        }
        if (table[row][col] == SIGN_O) {
            countO++;
        }
        if (table[row][col] == SIGN_EMPTY) {
            free++;
        }
    }

    boolean checkWin(char dot){
        return checkWinRows(dot) || checkWinDiags(dot);
    }

    boolean checkWinRows(char dot){
        for (int i = 0; i < 3; i++) {
            if ((table[i][0] == dot && table[i][1] == dot && table[i][2] == dot) ||
                    (table[0][i] == dot && table[1][i] == dot && table[2][i] == dot))
                return true;
        }
        return false;
    }

    boolean checkWinDiags(char dot){
        return ((table[0][0] == dot && table[1][1] == dot && table[2][2] == dot) ||
                (table[2][0] == dot && table[1][1] == dot && table[0][2] == dot));
    }

    void randomWalk(){
        Random random = new Random();
        int x,y;
        do {
            x=random.nextInt(3);
            y=random.nextInt(3);
        }
        while (!isCellValidProg(x,y));
        this.table[y][x]=SIGN_O;
    }

    boolean isCellValidProg(int x, int y) {
        return table[y][x] == SIGN_EMPTY;
    }

    boolean checkFirstDiag(){
        initCount();
        for (int row=0;row<3;row++){
            count(row,row);
        }
        if (isWinNear()|| isLoseNear()){
            for (int row=0;row<3;row++){
                if (putO(row,row))
                    return true;
            }
        }
        return false;
    }

    boolean checkSecondDiag(){
        this.initCount();
        int col=2;
        for (int row=0;row<3;row++){
            this.count(row,col);
            col--;
        }
        if (this.isWinNear()||this.isLoseNear()){
            col=2;
            for (int row=0;row<3;row++){
                if (this.putO(row,col))
                    return true;
                col--;
            }
        }
        return false;
    }

    boolean checkRows(){
        for (int row=0;row<3;row++){
            this.initCount();
            for (int col=0;col<3;col++){
                this.count(row,col);
            }
            if (this.isWinNear()||this.isLoseNear()){
                for (int col=0;col<3;col++){
                    if (this.putO(row,col))
                        return true;
                }
            }
        }
        return false;
    }

    boolean checkCols(){
        for (int col=0;col<3;col++){
            this.initCount();
            for (int row=0;row<3;row++){
                this.count(row,col);
            }
            if (this.isWinNear()||this.isLoseNear()){
                for (int row=0;row<3;row++){
                    if (this.putO(row,col))
                        return true;
                }
            }
        }
        return false;
    }

    boolean isLoseNear() {
        return free == 1 && countX == 2;
    }

    boolean isWinNear() {
        return free == 1 && countO == 2;
    }

    void initCount() {
        this.countX = 0;
        this.countO = 0;
        this.free  = 0;
    }

    boolean putO(int row,int col){
        if (this.table[row][col]==SIGN_EMPTY){
            this.table[row][col]=SIGN_O;
            return true;
        }
        return false;
    }
}