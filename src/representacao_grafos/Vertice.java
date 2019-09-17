
package representacao_grafos;


public class Vertice
{
    private double X, Y;
    private int Rotulo;

    public Vertice(double X, double Y, int Rotulo)
    {
        this.X = X;
        this.Y = Y;
        this.Rotulo = Rotulo;
    }

    public Vertice()
    {
    }

    public double getX()
    {
        return X;
    }

    public void setX(double X)
    {
        this.X = X;
    }

    public double getY()
    {
        return Y;
    }

    public void setY(double Y)
    {
        this.Y = Y;
    }

    public int getRotulo()
    {
        return Rotulo;
    }

    public void setRotulo(int Rotulo)
    {
        this.Rotulo = Rotulo;
    }
    
    @Override
    public String toString()
    {
        return "Vertice{" + "X = " + X + ", Y = " + Y + '}';
    }
    
    
}
