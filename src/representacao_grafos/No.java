package representacao_grafos;

import java.util.ArrayList;
import java.util.List;
import representacao_grafos.Vertice;

/**
 *
 * @author tulio
 */
public class No 
{
    private int n;
    private Vertice[] Info;
    private No[] Filhos;
    
    No(int n)
    {
         this.n = n;
         Info = new Vertice[n - 1];
         Filhos = new No[n];
    }
    
    
    public int getN()
    {
        return n;
    }

    public void setN(int n)
    {
        this.n = n;
    }

    public Vertice[] getInfo()
    {
        return Info;
    }

    public void setInfo(Vertice[] Info)
    {
        this.Info = Info;
    }
    
    public Vertice getInfoAt(int index)
    {
        if(index < Info.length)
            return Info[index];
        return null;
    }
    
    public void setInfoAt(Vertice info, int index)
    {
        Info[index] = info;
    }
    
    public No[] getFilhos()
    {
        return Filhos;
    }

    public void setFilhos(No[] Filhos)
    {
        this.Filhos = Filhos;
    }
}
