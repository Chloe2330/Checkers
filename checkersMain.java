package checkers;
import java.util.ArrayList;
import java.util.Scanner;

public class checkersMain 
{

	public static void main(String[] args) 
	{
	    // ArrayList stores the piece objects
        ArrayList<pieces> storage = new ArrayList<>();

        // create the board
        String[][] board = createBoard();

        // 24 chess pieces (12 black, 12 white)
        pieces w1 = new pieces(1,2,false,"white");
        pieces w2 = new pieces(1,4,false,"white");
        pieces w3 = new pieces(1,6,false,"white");
        pieces w4 = new pieces(1,8,false,"white");
        pieces w5 = new pieces(2,1,false,"white");
        pieces w6 = new pieces(2,3,false,"white");
        pieces w7 = new pieces(2,5,false,"white");
        pieces w8 = new pieces(2,7,false,"white");
        pieces w9 = new pieces(3,2,false,"white");
        pieces w10 = new pieces(3,4,false,"white");
        pieces w11 = new pieces(3,6,false,"white");
        pieces w12 = new pieces(3,8,false,"white");
        pieces b1 = new pieces(6,1,false,"black");
        pieces b2 = new pieces(6,3,false,"black");
        pieces b3 = new pieces(6,5,false,"black");
        pieces b4 = new pieces(6,7,false,"black");
        pieces b5 = new pieces(7,2,false,"black");
        pieces b6 = new pieces(7,4,false,"black");
        pieces b7 = new pieces(7,6,false,"black");
        pieces b8 = new pieces(7,8,false,"black");
        pieces b9 = new pieces(8,1,false,"black");
        pieces b10 = new pieces(8,3,false,"black");
        pieces b11 = new pieces(8,5,false,"black");
        pieces b12 = new pieces(8,7,false,"black");

        // uses object method (initial positions of pieces)
        pieces.placePiece(w1, board);
        pieces.placePiece(w2, board);
        pieces.placePiece(w3, board);
        pieces.placePiece(w4, board);
        pieces.placePiece(w5, board);
        pieces.placePiece(w6, board);
        pieces.placePiece(w7, board);
        pieces.placePiece(w8, board);
        pieces.placePiece(w9, board);
        pieces.placePiece(w10, board);
        pieces.placePiece(w11, board);
        pieces.placePiece(w12, board);
        pieces.placePiece(b1, board);
        pieces.placePiece(b2, board);
        pieces.placePiece(b3, board);
        pieces.placePiece(b4, board);
        pieces.placePiece(b5, board);
        pieces.placePiece(b6, board);
        pieces.placePiece(b7, board);
        pieces.placePiece(b8, board);
        pieces.placePiece(b9, board);
        pieces.placePiece(b10, board);
        pieces.placePiece(b11, board);
        pieces.placePiece(b12, board);

        // stores pieces in the ArrayList
        storage.add(0,w1);
        storage.add(1,w2);
        storage.add(2,w3);
        storage.add(3,w4);
        storage.add(4,w5);
        storage.add(5,w6);
        storage.add(6,w7);
        storage.add(7,w8);
        storage.add(8,w9);
        storage.add(9,w10);
        storage.add(10,w11);
        storage.add(11,w12);
        storage.add(12,b1);
        storage.add(13,b2);
        storage.add(14,b3);
        storage.add(15,b4);
        storage.add(16,b5);
        storage.add(17,b6);
        storage.add(18,b7);
        storage.add(19,b8);
        storage.add(20,b9);
        storage.add(21,b10);
        storage.add(22,b11);
        storage.add(23,b12);
        displayBoard(board);

        // counter keeps track of who's turn it is
        int counter = 0;

        // checker checks to see if someone has won
        boolean checker = true;
        while(checker)
        {
            if (counter % 2 == 0)
            {
                whitePlayer(board, storage);
            }
            else
            {
                blackPlayer(board, storage);
            }
            counter++;

            displayBoard(board);
            if (checkWin(board) != null)
            {
                if (checkWin(board) == ("W"))
                {
                    System.out.println("The black player has won.");
                }
                else if (checkWin(board) == ("B"))
                {
                    System.out.println("The white player has won.");
                }
                checker = false;
            }
        }
	}
	
	// creates the checker board
    public static String [][] createBoard()
    {
        String[][] board = new String[8][17];
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if(j % 2 == 0)
                {
                    board[i][j] = "|";
                }
                else
                {
                    board[i][j] = " ";
                }
            }
        }
        return board;
    }

    public static void whitePlayer(String [][]b, ArrayList <pieces> piecestorage)
    {
        boolean illegal = true;
        Scanner s = new Scanner(System.in);
        System.out.println("White kings have a small dot over the W: Ẇ");
        while(illegal)
        {
            System.out.println("White: Enter the row number of the piece you want to move (1-8).");
            int row = s.nextInt();
            s.nextLine();
            System.out.println("White: Enter the column number of the piece you want to move (1-8).");
            int column = s.nextInt();
            s.nextLine();
            System.out.println("White: Enter the row number of the square you want to move to (1-8).");
            int newrow = s.nextInt();
            s.nextLine();
            System.out.println("White: Enter the column number of the square you want to move to (1-8).");
            int newcolumn = s.nextInt();
            s.nextLine();

            // prevents user from going out of bounds
            if(row < 1 || row > 8 || column < 1 || column > 8 ||  newrow < 1 || newrow > 8 ||  newcolumn < 1 || newcolumn> 8)
            {
                System.out.println("out of bounds, pick again.");
                illegal = true;
            }
            else {
                // checks that the user has picked a white piece
                if(b[row-1][2*column-1].equals("W") || b[row-1][2*column-1].equals("Ẇ"))
                {
                    // white piece makes a jump (left forward)
                    if((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row + 2 && newcolumn == column-2 && (b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("B") || (b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("Ḃ")))))
                    {
                        for(pieces p : piecestorage)
                        {
                            if(p.getX() == row && p.getY() == column)
                            {
                                b[row-1][2*column-1] = " ";
                                p.setX(newrow);
                                p.setY(newcolumn);
                                if(p.getX() == 8)
                                {
                                    p.makeKing(true);
                                }
                                pieces.placePiece(p,b);
                                illegal = false;
                            }
                        }
                        for(int i = 0; i < piecestorage.size(); i++)
                        {
                            pieces p = piecestorage.get(i);
                            if(p.getX() == (row+newrow)/2 && p.getY() == (column+newcolumn)/2)
                            {
                                b[((row+newrow)/2)-1][(column+newcolumn)-1] = " ";
                                piecestorage.remove(p);
                                illegal = false;
                            }
                        }
                        // white: left jump (multi)
                        if(newrow <= 6 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("W") && (b[newrow][2*newcolumn-3].equals("B") || b[newrow][2*newcolumn-3].equals("Ḃ")) && b[newrow+1][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("can jump more than once, pick again.");
                            }
                        }
                        // white: right jump (multi)
                        if(newrow <= 6 && newcolumn <= 6)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("W") && (b[newrow][2*newcolumn+1].equals("B") || b[newrow][2*newcolumn+1].equals("Ḃ")) && b[newrow+1][2*newcolumn+3].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("can jump more than once, pick again.");
                            }
                        }
                    }
                    // white piece makes a jump (right forward)
                    else if((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row + 2 && newcolumn == column+2 && (b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("B") || b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("Ḃ"))))
                    {
                        for(pieces p : piecestorage)
                        {
                            if(p.getX() == row && p.getY() == column)
                            {
                                b[row-1][2*column-1] = " ";
                                p.setX(newrow);
                                p.setY(newcolumn);
                                if(p.getX() == 8)
                                {
                                    p.makeKing(true);
                                }
                                pieces.placePiece(p,b);
                                illegal = false;
                            }
                        }
                        for(int i = 0; i < piecestorage.size(); i++)
                        {
                            pieces p = piecestorage.get(i);
                            if(p.getX() == (row+newrow)/2 && p.getY() == (column+newcolumn)/2)
                            {
                                b[((row+newrow)/2)-1][(column+newcolumn)-1] = " ";
                                piecestorage.remove(p);
                                illegal = false;
                            }
                        }
                        // white: left jump (multi)
                        if(newrow <= 6 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("W") && (b[newrow][2*newcolumn-3].equals("B") || b[newrow][2*newcolumn-3].equals("Ḃ")) && b[newrow+1][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("can jump more than once, pick again.");
                            }
                        }
                        // white: right jump (multi)
                        if(newrow <= 6 && newcolumn <= 6)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("W") && (b[newrow][2*newcolumn+1].equals("B") || b[newrow][2*newcolumn+1].equals("Ḃ")) && b[newrow+1][2*newcolumn+3].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("can jump more than once, pick again.");
                            }
                        }
                    }
                    // white king makes a jump (left backward)
                    else if ( b[row-1][2*column-1].equals("Ẇ") && (b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row - 2 && newcolumn == column-2 && (b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("B") || b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("Ḃ"))))
                    {
                        for(pieces p : piecestorage)
                        {
                            if(p.getX() == row && p.getY() == column)
                            {
                                b[row-1][2*column-1] = " ";
                                p.setX(newrow);
                                p.setY(newcolumn);
                                if(p.getX() == 8)
                                {
                                    p.makeKing(true);
                                }
                                pieces.placePiece(p,b);
                                illegal = false;
                            }
                        }
                        for(int i = 0; i < piecestorage.size(); i++)
                        {
                            pieces p = piecestorage.get(i);
                            if(p.getX() == (row+newrow)/2 && p.getY() == (column+newcolumn)/2)
                            {
                                b[((row+newrow)/2)-1][(column+newcolumn)-1] = " ";
                                piecestorage.remove(i);
                                illegal = false;
                            }
                        }
                        // white: left jump (multi)
                        if(newrow <= 6 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ẇ") && (b[newrow][2*newcolumn-3].equals("B") || b[newrow][2*newcolumn-3].equals("Ḃ")) && b[newrow+1][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                        // white: right jump (multi)
                        if(newrow <= 6 && newcolumn <= 6)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ẇ") && (b[newrow][2*newcolumn+1].equals("B") || b[newrow][2*newcolumn+1].equals("Ḃ")) && b[newrow+1][2*newcolumn+3].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                        // white king: left jump backwards (multi)
                        if(newrow >=3 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ẇ") && (b[newrow-2][2*newcolumn-3].equals("B") || b[newrow-2][2*newcolumn-3].equals("Ḃ")) && b[newrow-3][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                        // white king : right jump backwards (multi)
                        if(newrow >=3 && newcolumn <= 6)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ẇ") && (b[newrow-2][2*newcolumn+1].equals("B") || b[newrow-2][2*newcolumn+1].equals("Ḃ")) && b[newrow-3][2*newcolumn+3].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                    }
                    // white king makes a jump (right backward)
                    else if (b[row-1][2*column-1].equals("Ẇ") && (b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row - 2 && newcolumn == column+2 && (b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("B") || b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("Ḃ"))))
                    {
                        for(pieces p : piecestorage)
                        {
                            if(p.getX() == row && p.getY() == column)
                            {
                                b[row-1][2*column-1] = " ";
                                p.setX(newrow);
                                p.setY(newcolumn);
                                if(p.getX() == 8)
                                {
                                    p.makeKing(true);
                                }
                                pieces.placePiece(p,b);
                                illegal = false;
                            }
                        }
                        for(int i = 0; i < piecestorage.size(); i++)
                        {
                            pieces p = piecestorage.get(i);
                            if(p.getX() == (row+newrow)/2 && p.getY() == (column+newcolumn)/2)
                            {
                                b[((row+newrow)/2)-1][(column+newcolumn)-1] = " ";
                                piecestorage.remove(i);
                                illegal = false;
                            }
                        }
                        // white: left jump (multi)
                        if(newrow <= 6 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ẇ") && (b[newrow][2*newcolumn-3].equals("B") || b[newrow][2*newcolumn-3].equals("Ḃ")) && b[newrow+1][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("can jump more than once, pick again.");
                            }
                        }
                        // white: right jump (multi)
                        if(newrow <= 6 && newcolumn <= 6)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ẇ") && (b[newrow][2*newcolumn+1].equals("B") || b[newrow][2*newcolumn+1].equals("Ḃ")) && b[newrow+1][2*newcolumn+3].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("can jump more than once, pick again.");
                            }
                        }
                        // white king: left jump backwards (multi)
                        if(newrow >=3 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ẇ") && (b[newrow-2][2*newcolumn-3].equals("B") || b[newrow-2][2*newcolumn-3].equals("Ḃ")) && b[newrow-3][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                        // white king : right jump backwards (multi)
                        if(newrow >=3 && newcolumn <= 6)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ẇ") && (b[newrow-2][2*newcolumn+1].equals("B") || b[newrow-2][2*newcolumn+1].equals("Ḃ")) && b[newrow-3][2*newcolumn+3].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                    }
                    else
                    {
                        boolean mustjump = false;
                        // iterates through the 2d array to make sure no jumps are available
                        for (int i = 0; i < b.length; i++)
                        {
                            for (int j = 0; j < b[i].length; j++)
                            {
                                // left forward jump is available
                                if(i <= 5 && j >= 5)
                                {
                                    if(((b[i][j].equals("W") || b[i][j].equals("Ẇ")) && (b[i+1][j-2].equals("B") || b[i+1][j-2].equals("Ḃ")) && b[i+2][j-4].equals(" ")))
                                    {
                                        mustjump = true;
                                    }
                                }
                                // right forward jump is available
                                if(i <= 5 && j <= 11)
                                {
                                    if(((b[i][j].equals("W") || b[i][j].equals("Ẇ")) && (b[i+1][j+2].equals("B") || b[i+1][j+2].equals("Ḃ")) && b[i+2][j+4].equals(" ")))
                                    {
                                        mustjump = true;
                                    }
                                }
                                // left backward jump is available
                                if(i >= 2 && j >= 5)
                                {
                                    if(((b[i][j].equals("Ẇ")) && (b[i-1][j-2].equals("B") || b[i-1][j-2].equals("Ḃ")) && b[i-2][j-4].equals(" ")))
                                    {
                                        mustjump = true;
                                    }
                                }
                                //right backward jump is available
                                if(i >= 2 && j <= 11)
                                {
                                    if(((b[i][j].equals("Ẇ")) && (b[i-1][j+2].equals("B") || b[i-1][j+2].equals("Ḃ")) && b[i-2][j+4].equals(" ")))
                                    {
                                        mustjump = true;
                                    }
                                }
                            }
                        }
                        // white piece makes a normal move (left forward)
                        if((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row + 1 && newcolumn == column-1) && mustjump == false)
                        {
                            for(pieces p : piecestorage)
                            {
                                if(p.getX() == row && p.getY() == column)
                                {
                                    b[row-1][2*column-1] = " ";
                                    p.setX(newrow);
                                    p.setY(newcolumn);
                                    if(p.getX() == 8)
                                    {
                                        p.makeKing(true);
                                    }
                                    pieces.placePiece(p,b);
                                    illegal = false;
                                }
                            }
                        }
                        // white piece makes a normal move (right forward)
                        else if ((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row + 1 && newcolumn == column+1) && mustjump == false)
                        {
                            for(pieces p : piecestorage)
                            {
                                if(p.getX() == row && p.getY() == column)
                                {
                                    b[row-1][2*column-1] = " ";
                                    p.setX(newrow);
                                    p.setY(newcolumn);
                                    if(p.getX() == 8)
                                    {
                                        p.makeKing(true);
                                    }
                                    pieces.placePiece(p,b);
                                    illegal = false;
                                }
                            }
                        }
                        // white king makes a normal move (left backward)
                        else if ((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row - 1 && newcolumn == column-1) && mustjump == false)
                        {
                            for(pieces p : piecestorage)
                            {
                                if(p.getX() == row && p.getY() == column)
                                {
                                    if(p.kingStatus() == true)
                                    {
                                        b[row-1][2*column-1] = " ";
                                        p.setX(newrow);
                                        p.setY(newcolumn);
                                        pieces.placePiece(p,b);
                                        illegal = false;
                                    }
                                    else
                                    {
                                        System.out.println("cannot do king move with regular piece.");
                                        illegal = true;
                                    }
                                }
                            }
                        }
                        // white king makes a normal move (right backward)
                        else if ((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row - 1 && newcolumn == column+1) && mustjump == false)
                        {
                            for(pieces p : piecestorage)
                            {
                                if(p.getX() == row && p.getY() == column)
                                {
                                    if(p.kingStatus() == true)
                                    {
                                        b[row-1][2*column-1] = " ";
                                        p.setX(newrow);
                                        p.setY(newcolumn);
                                        pieces.placePiece(p,b);
                                        illegal = false;
                                    }
                                    else
                                    {
                                        System.out.println("cannot do king move with regular piece.");
                                        illegal = true;
                                    }
                                }
                            }
                        }
                        // forces user to jump when it's available
                        else if(mustjump == true)
                        {
                            illegal = true;
                            System.out.println("must jump, pick again");
                        }
                        // does not allow user to make illegal move
                        else
                        {
                            illegal = true;
                            System.out.println("illegal move, pick again.");
                        }
                    }
                }
                // forces user to pick a white piece
                else
                {
                    illegal = true;
                    System.out.println("no white piece there, pick again.");
                }
            }
        }
    }

    public static void blackPlayer(String [][]b, ArrayList <pieces> piecestorage)
    {
        boolean illegal = true;
        Scanner s = new Scanner(System.in);
        System.out.println("Black kings have a small dot over the B: Ḃ");
        while(illegal)
        {
            System.out.println("Black: Enter the row number of the piece you want to move (1-8).");
            int row = s.nextInt();
            s.nextLine();
            System.out.println("Black: Enter the column number of the piece you want to move (1-8).");
            int column = s.nextInt();
            s.nextLine();
            System.out.println("Black: Enter the row number of the square you want to move to (1-8).");
            int newrow = s.nextInt();
            s.nextLine();
            System.out.println("Black: Enter the column number of the square you want to move to (1-8).");
            int newcolumn = s.nextInt();
            s.nextLine();

            // prevents user from going out of bounds
            if(row < 1 || row > 8 || column < 1 || column > 8 ||  newrow < 1 || newrow > 8 ||  newcolumn < 1 || newcolumn> 8)
            {
                System.out.println("out of bounds, pick again.");
                illegal = true;
            }
            else
            {
                // checks that the user has picked a black piece
                if(b[row-1][2*column-1].equals("B") || b[row-1][2*column-1].equals("Ḃ"))
                {
                    // black piece makes a jump (left forward)
                    if((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row - 2 && newcolumn == column-2 && (b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("W") || b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("Ẇ"))))
                    {
                        for(pieces p : piecestorage)
                        {
                            if(p.getX() == row && p.getY() == column)
                            {
                                b[row-1][2*column-1] = " ";
                                p.setX(newrow);
                                p.setY(newcolumn);
                                if(p.getX() == 1)
                                {
                                    p.makeKing(true);
                                }
                                pieces.placePiece(p,b);
                                illegal = false;
                            }
                        }
                        for(int i = 0; i < piecestorage.size(); i++)
                        {
                            pieces p = piecestorage.get(i);
                            if(p.getX() == (row+newrow)/2 && p.getY() == (column+newcolumn)/2)
                            {
                                b[((row+newrow)/2)-1][(column+newcolumn)-1] = " ";
                                piecestorage.remove(i);
                                illegal = false;
                            }
                        }
                        // black: left jump (multi)
                        if(newrow >= 3 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("B") && (b[newrow-2][2*newcolumn-3].equals("W") || b[newrow-2][2*newcolumn-3].equals("Ẇ")) && b[newrow-3][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("can jump more than once, pick again.");
                            }
                        }
                        // black: right jump (multi)
                        if(newrow >= 3 && newcolumn <= 6)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("B") && (b[newrow-2][2*newcolumn+1].equals("W") || b[newrow-2][2*newcolumn+1].equals("Ẇ")) && b[newrow-3][2*newcolumn+3].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("can jump more than once, pick again.");
                            }
                        }
                    }
                    // black piece makes a jump (right forward)
                    else if((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row - 2 && newcolumn == column+2 && (b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("W") || b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("Ẇ"))))
                    {
                        for(pieces p : piecestorage)
                        {
                            if(p.getX() == row && p.getY() == column)
                            {
                                b[row-1][2*column-1] = " ";
                                p.setX(newrow);
                                p.setY(newcolumn);
                                if(p.getX() == 1)
                                {
                                    p.makeKing(true);
                                }
                                pieces.placePiece(p,b);
                                illegal = false;
                            }
                        }
                        for(int i = 0; i < piecestorage.size(); i++)
                        {
                            pieces p = piecestorage.get(i);
                            if(p.getX() == (row+newrow)/2 && p.getY() == (column+newcolumn)/2)
                            {
                                b[((row+newrow)/2)-1][(column+newcolumn)-1] = " ";
                                piecestorage.remove(i);
                                illegal = false;
                            }
                        }
                        // black: left jump (multi)
                        if(newrow >= 3 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("B") && (b[newrow-2][2*newcolumn-3].equals("W") || b[newrow-2][2*newcolumn-3].equals("Ẇ")) && b[newrow-3][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("can jump more than once, pick again.");
                            }
                        }
                        // black: right jump (multi)
                        if(newrow >= 3 && newcolumn <= 6)
                        {
                            if(((b[newrow-1][2*newcolumn-1].equals("B") && (b[newrow-2][2*newcolumn+1].equals("W") || b[newrow-2][2*newcolumn+1].equals("Ẇ")) && b[newrow-3][2*newcolumn+3].equals(" "))))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("can jump more than once, pick again.");
                            }
                        }
                    }
                    // black king makes a jump (left backward)
                    else if ( b[row-1][2*column-1].equals("Ḃ") && (b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row + 2 && newcolumn == column-2 && (b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("W") || b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("Ẇ"))))
                    {
                        for(pieces p : piecestorage)
                        {
                            if(p.getX() == row && p.getY() == column)
                            {
                                b[row-1][2*column-1] = " ";
                                p.setX(newrow);
                                p.setY(newcolumn);
                                if(p.getX() == 1)
                                {
                                    p.makeKing(true);
                                }
                                pieces.placePiece(p,b);
                                illegal = false;
                            }
                        }
                        for(int i = 0; i < piecestorage.size(); i++)
                        {
                            pieces p = piecestorage.get(i);
                            if(p.getX() == (row+newrow)/2 && p.getY() == (column+newcolumn)/2)
                            {
                                b[((row+newrow)/2)-1][(column+newcolumn)-1] = " ";
                                piecestorage.remove(i);
                                illegal = false;
                            }
                        }
                        // black: left jump (multi)
                        if(newrow >= 3 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ḃ") && (b[newrow-2][2*newcolumn-3].equals("W") || b[newrow-2][2*newcolumn-3].equals("Ẇ")) && b[newrow-3][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                        // black: right jump (multi)
                        if(newrow >= 3 && newcolumn <= 6)
                        {
                            if(((b[newrow-1][2*newcolumn-1].equals("Ḃ") && (b[newrow-2][2*newcolumn+1].equals("W") || b[newrow-2][2*newcolumn+1].equals("Ẇ")) && b[newrow-3][2*newcolumn+3].equals(" "))))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                        // black king: left jump backwards (multi)
                        if(newrow <= 6 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ḃ") && (b[newrow][2*newcolumn-3].equals("W") || b[newrow][2*newcolumn-3].equals("Ẇ")) && b[newrow+1][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                        // black king : right jump backwards (multi)
                        if(newrow <= 6 && newcolumn <= 6)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ḃ") && (b[newrow][2*newcolumn+1].equals("W") || b[newrow][2*newcolumn+1].equals("Ẇ")) && b[newrow+1][2*newcolumn+3].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                    }
                    // black king makes a jump (right backward)
                    else if (b[row-1][2*column-1].equals("Ḃ") && (b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row + 2 && newcolumn == column+2 && (b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("W") || b[((row+newrow)/2)-1][(column+newcolumn)-1].equals("Ẇ"))))
                    {
                        for(pieces p : piecestorage)
                        {
                            if(p.getX() == row && p.getY() == column)
                            {
                                b[row-1][2*column-1] = " ";
                                p.setX(newrow);
                                p.setY(newcolumn);
                                if(p.getX() == 1)
                                {
                                    p.makeKing(true);
                                }
                                pieces.placePiece(p,b);
                                illegal = false;
                            }
                        }
                        for(int i = 0; i < piecestorage.size(); i++)
                        {
                            pieces p = piecestorage.get(i);
                            if(p.getX() == (row+newrow)/2 && p.getY() == (column+newcolumn)/2)
                            {
                                b[((row+newrow)/2)-1][(column+newcolumn)-1] = " ";
                                piecestorage.remove(i);
                                illegal = false;
                            }
                        }
                        // black: left jump (multi)
                        if(newrow >= 3 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ḃ") && (b[newrow-2][2*newcolumn-3].equals("W") || b[newrow-2][2*newcolumn-3].equals("Ẇ")) && b[newrow-3][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                        // black: right jump (multi)
                        if(newrow >= 3 && newcolumn <= 6)
                        {
                            if(((b[newrow-1][2*newcolumn-1].equals("Ḃ") && (b[newrow-2][2*newcolumn+1].equals("W") || b[newrow-2][2*newcolumn+1].equals("Ẇ")) && b[newrow-3][2*newcolumn+3].equals(" "))))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                        // black king: left jump backwards (multi)
                        if(newrow <= 6 && newcolumn >= 3)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ḃ") && (b[newrow][2*newcolumn-3].equals("W") || b[newrow][2*newcolumn-3].equals("Ẇ")) && b[newrow+1][2*newcolumn-5].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                        // black king : right jump backwards (multi)
                        if(newrow <= 6 && newcolumn <= 6)
                        {
                            if((b[newrow-1][2*newcolumn-1].equals("Ḃ") && (b[newrow][2*newcolumn+1].equals("W") || b[newrow][2*newcolumn+1].equals("Ẇ")) && b[newrow+1][2*newcolumn+3].equals(" ")))
                            {
                                illegal = true;
                                for (int i = 0; i < b.length; i++)
                                {
                                    for (int j = 0; j < b[i].length; j++)
                                    {
                                        System.out.print(b[i][j]);
                                    }
                                    System.out.println();
                                }
                                System.out.println("king: can jump more than once, pick again.");
                            }
                        }
                    }
                    else
                    {
                        boolean mustjump = false;
                        // iterates through the 2d array to make sure no jumps are available
                        for (int i = 0; i < b.length; i++)
                        {
                            for (int j = 0; j < b[i].length; j++)
                            {
                                // left forward jump is available
                                if(i >= 2 && j >= 5)
                                {
                                    if(((b[i][j].equals("B") || b[i][j].equals("Ḃ")) && (b[i-1][j-2].equals("W") || b[i-1][j-2].equals("Ẇ")) && b[i-2][j-4].equals(" ")))
                                    {
                                        mustjump = true;
                                    }
                                }
                                // right forward jump is available
                                if(i >= 2 && j <= 11)
                                {
                                    if(((b[i][j].equals("B") || b[i][j].equals("Ḃ")) && (b[i-1][j+2].equals("W") || b[i-1][j+2].equals("Ẇ")) && b[i-2][j+4].equals(" ")))
                                    {
                                        mustjump = true;
                                    }
                                }
                                // left backward jump is available
                                if(i <= 5 && j >= 5)
                                {
                                    if(((b[i][j].equals("Ḃ")) && (b[i+1][j-2].equals("W") || b[i+1][j-2].equals("Ẇ")) && b[i+2][j-4].equals(" ")))
                                    {
                                        mustjump = true;
                                    }
                                }
                                // right backward jump is available
                                if(i <= 5 && j <= 11)
                                {
                                    if(((b[i][j].equals("Ḃ")) && (b[i+1][j+2].equals("W") || b[i+1][j+2].equals("Ẇ")) && b[i+2][j+4].equals(" ")))
                                    {
                                        mustjump = true;
                                    }
                                }
                            }
                        }
                        // black piece makes a normal move (left forward)
                        if((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row - 1 && newcolumn == column-1)  && mustjump == false)
                        {
                            for(pieces p : piecestorage)
                            {
                                if(p.getX() == row && p.getY() == column)
                                {
                                    b[row-1][2*column-1] = " ";
                                    p.setX(newrow);
                                    p.setY(newcolumn);
                                    if(p.getX() == 1)
                                    {
                                        p.makeKing(true);
                                    }
                                    pieces.placePiece(p,b);
                                    illegal = false;
                                }
                            }
                        }
                        // black piece makes a normal move (right forward)
                        else if ((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row - 1 && newcolumn == column+1)  && mustjump == false)
                        {
                            for(pieces p : piecestorage)
                            {
                                if(p.getX() == row && p.getY() == column)
                                {
                                    b[row-1][2*column-1] = " ";
                                    p.setX(newrow);
                                    p.setY(newcolumn);
                                    if(p.getX() == 1)
                                    {
                                        p.makeKing(true);
                                    }
                                    pieces.placePiece(p,b);
                                    illegal = false;
                                }
                            }
                        }
                        // black king makes a normal move (left backward)
                        else if ((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row + 1 && newcolumn == column-1) && mustjump == false)
                        {
                            for(pieces p : piecestorage)
                            {
                                if(p.getX() == row && p.getY() == column)
                                {
                                    if(p.kingStatus() == true)
                                    {
                                        b[row-1][2*column-1] = " ";
                                        p.setX(newrow);
                                        p.setY(newcolumn);
                                        pieces.placePiece(p,b);
                                        illegal = false;
                                    }
                                    else
                                    {
                                        System.out.println("cannot do king move with regular piece.");
                                        illegal = true;
                                    }
                                }
                            }
                        }
                        // black king makes a normal move (right backward)
                        else if ((b[newrow-1][2*newcolumn-1].equals(" ") && newrow == row + 1 && newcolumn == column+1) && mustjump == false)
                        {
                            for(pieces p : piecestorage)
                            {
                                if(p.getX() == row && p.getY() == column)
                                {
                                    if(p.kingStatus() == true)
                                    {
                                        b[row-1][2*column-1] = " ";
                                        p.setX(newrow);
                                        p.setY(newcolumn);
                                        pieces.placePiece(p,b);
                                        illegal = false;
                                    }
                                    else
                                    {
                                        System.out.println("cannot do king move with regular piece.");
                                        illegal = true;
                                    }
                                }
                            }
                        }
                        // forces user to jump when it's available
                        else if(mustjump == true)
                        {
                            illegal = true;
                            System.out.println("must jump, pick again");
                        }
                        // does not allow user to make an illegal move
                        else
                        {
                            illegal = true;
                            System.out.println("illegal move, pick again.");
                        }
                    }
                }
                // forces user to pick a black piece
                else
                {
                    illegal = true;
                    System.out.println("no black piece there, pick again.");
                }
            }
        }
    }

    // checks if any color has lost all their pieces
    public static String checkWin (String[][] b)
    {
        int wcounter = 0;
        int bcounter = 0;
        for (int i = 0; i < b.length; i++)
        {
            for (int j = 0; j < b[i].length; j++)
            {
                if(b[i][j].equals("W") || b[i][j].equals("Ẇ"))
                {
                    wcounter++;
                }
                else if (b[i][j].equals("B") || b[i][j].equals("Ḃ"))
                {
                    bcounter++;
                }
            }
        }
        // if a color has no pieces left, the other color wins
        if(wcounter == 0)
        {
            return "W";
        }
        else if(bcounter == 0)
        {
            return "B";
        }
        return null;
    }

    // displays the checker board
    public static void displayBoard(String [][] b)
    {
        for (int i = 0; i < b.length; i++)
        {
            for (int j = 0; j < b[i].length; j++)
            {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    }

}
