
package representacao_grafos;

public class Aresta
{
    private double XI, XF, YI, YF;
    private int Valor;
    private String Tipo;

    public Aresta()
    {
    }
    
    public Aresta(double XI, double XF, double YI, double YF, int Valor, String Tipo)
    {
        this.XI = XI;
        this.XF = XF;
        this.YI = YI;
        this.YF = YF;
        this.Valor = Valor;
        this.Tipo = Tipo;
    }

    public double getXI()
    {
        return XI;
    }

    public void setXI(double XI)
    {
        this.XI = XI;
    }

    public double getXF()
    {
        return XF;
    }

    public void setXF(double XF)
    {
        this.XF = XF;
    }

    public double getYI()
    {
        return YI;
    }

    public void setYI(double YI)
    {
        this.YI = YI;
    }

    public double getYF()
    {
        return YF;
    }

    public void setYF(double YF)
    {
        this.YF = YF;
    }

    public int getValor()
    {
        return Valor;
    }

    public void setValor(int Valor)
    {
        this.Valor = Valor;
    }

    public String getTipo()
    {
        return Tipo;
    }

    public void setTipo(String Tipo)
    {
        this.Tipo = Tipo;
    }

    public boolean isDigrafo()
    {
        if(Tipo.equalsIgnoreCase("DIGRAFO"))
            return true;
        return false;
    }

    @Override
    public String toString()
    {
        return "Aresta{" + "XI=" + XI + ", XF=" + XF + ", YI=" + YI + ", YF=" + YF + ", Valor=" + Valor + ", Tipo=" + Tipo + '}';
    }
    
    
}
