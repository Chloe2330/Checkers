package checkers;

public class pieces 
{
	private int xCor;
    private int yCor;
    private boolean king;
    private String color;

    public pieces()
    {
        xCor = 0;
        yCor = 0;
        king = false;
        color = null;
    }

    public pieces( int x, int y, boolean b, String c)
    {
        xCor = x;
        yCor = y;
        king = b;
        color = c;
    }

    public int getX()
    {
        return xCor;
    }

    public int getY()
    {
        return yCor;
    }

    public boolean kingStatus()
    {
        return king;
    }

    public String getC()
    {
        return color;
    }

    public void setX(int x)
    {
        xCor = x;
    }

    public void setY(int y)
    {
        yCor = y;
    }

    public void makeKing(boolean k)
    {
        king = k;
    }

    public void setX(String c)
    {
        color = c;
    }

    public static String[][] placePiece(pieces a, String[][]b)
    {
        if(a.getC().equals("white"))
        {
            b[a.getX() - 1][2*a.getY()-1] = "W";
            if(a.kingStatus() == true)
            {
                b[a.getX() - 1][2*a.getY()-1] = "Ẇ";
            }
        }
        if(a.getC().equals("black"))
        {
            b[a.getX() - 1][2*a.getY()-1] = "B";
            if(a.kingStatus() == true)
            {
                b[a.getX() - 1][2*a.getY()-1] = "Ḃ";
            }
        }

        return b;
    }
}
