package representacao_grafos;

import com.sun.prism.paint.Color;
import java.awt.Paint;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeSet;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polyline;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable
{

    private Label label;
    @FXML
    private TableView<tabela> matrizAdj;
    @FXML
    private TableView<tabela> matrizInc;
    @FXML
    private Canvas telaCanvas;
    @FXML
    private TableView<tabela> ListaAdjacente;

    private int flag = -1, Rini = 0;
    private double xini = 0, yini = 0;
    private ArrayList<Vertice> vertices;
    private GraphicsContext ctx;

    double px[], py[];
    @FXML
    private TableColumn<?, String> LinhaP;
    @FXML
    private TableColumn<?, String> LinhaP2;
    @FXML
    private TableColumn<?, String> LinhaP3;

    @FXML
    private TableColumn<?, String> col1;
    @FXML
    private TableColumn<?, String> col2;
    @FXML
    private TableColumn<?, String> col3;
    @FXML
    private TableColumn<?, String> col4;
    @FXML
    private TableColumn<?, String> col5;
    @FXML
    private TableColumn<?, String> col6;
    @FXML
    private TableColumn<?, String> col7;
    @FXML
    private TableColumn<?, String> col8;
    @FXML
    private TableColumn<?, String> col9;
    @FXML
    private TableColumn<?, String> col10;

    @FXML
    private TableColumn<?, String> Lcol1;
    @FXML
    private TableColumn<?, String> Lcol2;
    @FXML
    private TableColumn<?, String> Lcol3;
    @FXML
    private TableColumn<?, String> Lcol4;
    @FXML
    private TableColumn<?, String> Lcol5;
    @FXML
    private TableColumn<?, String> Lcol6;
    @FXML
    private TableColumn<?, String> Lcol7;
    @FXML
    private TableColumn<?, String> Lcol8;
    @FXML
    private TableColumn<?, String> Lcol9;
    @FXML
    private TableColumn<?, String> Lcol10;

    @FXML
    private TableColumn<?, String> MIcol1;
    @FXML
    private TableColumn<?, String> MIcol2;
    @FXML
    private TableColumn<?, String> MIcol3;
    @FXML
    private TableColumn<?, String> MIcol4;
    @FXML
    private TableColumn<?, String> MIcol5;
    @FXML
    private TableColumn<?, String> MIcol6;
    @FXML
    private TableColumn<?, String> MIcol7;
    @FXML
    private TableColumn<?, String> MIcol8;
    @FXML
    private TableColumn<?, String> MIcol9;
    @FXML
    private TableColumn<?, String> MIcol10;

    int m[][] = new int[10][10];
    int Lm[][] = new int[10][10];
    int Mi[][] = new int[100][100];

    tabela t[] = new tabela[10];
    tabela Lt[] = new tabela[10];
    tabela Mit[] = new tabela[100];

    int contL[] = new int[20];

    int contaLigaMit = 0;
    int MA[][];
    int LA[][];
    int MI[][];
    @FXML
    private RadioButton btLigVal;
    @FXML
    private Label Resposta;

    boolean EhGrafos = true;
    @FXML
    private RadioButton btGrafo;
    @FXML
    private RadioButton btDigrafo;
    @FXML
    private Button btPintar;
    @FXML
    private Button btPontoArt;
    @FXML
    private Label labelMI;
    @FXML
    private Label labelMA;
    
    private NArea Tree;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        Tree = new NArea();
        
        vertices = new ArrayList<Vertice>();
        ctx = telaCanvas.getGraphicsContext2D();
        LinhaP.setCellValueFactory(new PropertyValueFactory<>("linha"));
        Lcol1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        Lcol2.setCellValueFactory(new PropertyValueFactory<>("col2"));
        Lcol3.setCellValueFactory(new PropertyValueFactory<>("col3"));
        Lcol4.setCellValueFactory(new PropertyValueFactory<>("col4"));
        Lcol5.setCellValueFactory(new PropertyValueFactory<>("col5"));
        Lcol6.setCellValueFactory(new PropertyValueFactory<>("col6"));
        Lcol7.setCellValueFactory(new PropertyValueFactory<>("col7"));
        Lcol8.setCellValueFactory(new PropertyValueFactory<>("col8"));
        Lcol9.setCellValueFactory(new PropertyValueFactory<>("col9"));
        Lcol10.setCellValueFactory(new PropertyValueFactory<>("col10"));

        btGrafo.setSelected(true);
        px = new double[3];
        py = new double[3];

        LinhaP3.setCellValueFactory(new PropertyValueFactory<>("linha"));
        col1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        col2.setCellValueFactory(new PropertyValueFactory<>("col2"));
        col3.setCellValueFactory(new PropertyValueFactory<>("col3"));
        col4.setCellValueFactory(new PropertyValueFactory<>("col4"));
        col5.setCellValueFactory(new PropertyValueFactory<>("col5"));
        col6.setCellValueFactory(new PropertyValueFactory<>("col6"));
        col7.setCellValueFactory(new PropertyValueFactory<>("col7"));
        col8.setCellValueFactory(new PropertyValueFactory<>("col8"));
        col9.setCellValueFactory(new PropertyValueFactory<>("col9"));
        col10.setCellValueFactory(new PropertyValueFactory<>("col10"));

        LinhaP2.setCellValueFactory(new PropertyValueFactory<>("linha"));
        MIcol1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        MIcol2.setCellValueFactory(new PropertyValueFactory<>("col2"));
        MIcol3.setCellValueFactory(new PropertyValueFactory<>("col3"));
        MIcol4.setCellValueFactory(new PropertyValueFactory<>("col4"));
        MIcol5.setCellValueFactory(new PropertyValueFactory<>("col5"));
        MIcol6.setCellValueFactory(new PropertyValueFactory<>("col6"));
        MIcol7.setCellValueFactory(new PropertyValueFactory<>("col7"));
        MIcol8.setCellValueFactory(new PropertyValueFactory<>("col8"));
        MIcol9.setCellValueFactory(new PropertyValueFactory<>("col9"));
        MIcol10.setCellValueFactory(new PropertyValueFactory<>("col10"));
        //  MI = new int[contaLigaMit][vertices.size()];

    }

    @FXML
    private void evtCriaVertice(MouseEvent event)
    {
        btDigrafo.setDisable(true);
        btGrafo.setDisable(true);
        if (vertices.size() < 10 && colidiu(event.getX() - 15, event.getY() - 15) == -1)//desenha vetice
        {
            vertices.add(new Vertice(event.getX() - 15, event.getY() - 15, vertices.size() + 1));

            ctx.setStroke(javafx.scene.paint.Paint.valueOf("#000000"));
            ctx.setFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            for (int k = 0; k < 5; k++)
            {
                ctx.strokeOval(event.getX() - 15, event.getY() - 15, 30, 30);
            }

            ctx.setFill(javafx.scene.paint.Color.BLACK);
            ctx.fillText(String.valueOf(vertices.get(vertices.size() - 1).getRotulo()), event.getX() - 3, event.getY() + 3);
            ctx.setFill(javafx.scene.paint.Paint.valueOf("#ffffff"));

            int c = 0;

            for (; c <= vertices.size() - 1; c++)
            {
                if (c == 0)
                {
                    col1.setVisible(true);
                    Lcol1.setVisible(true);
                    MIcol1.setVisible(true);
                } else if (c == 1)
                {
                    col2.setVisible(true);
                    Lcol2.setVisible(true);
                    MIcol2.setVisible(true);
                } else if (c == 2)
                {
                    col3.setVisible(true);
                    Lcol3.setVisible(true);
                    MIcol3.setVisible(true);
                } else if (c == 3)
                {
                    col4.setVisible(true);
                    Lcol4.setVisible(true);
                    MIcol4.setVisible(true);
                } else if (c == 4)
                {
                    col5.setVisible(true);
                    Lcol5.setVisible(true);
                    MIcol5.setVisible(true);
                } else if (c == 5)
                {
                    col6.setVisible(true);
                    Lcol6.setVisible(true);
                    MIcol6.setVisible(true);
                } else if (c == 6)
                {
                    col7.setVisible(true);
                    Lcol7.setVisible(true);
                    MIcol7.setVisible(true);
                } else if (c == 7)
                {
                    col8.setVisible(true);
                    Lcol8.setVisible(true);
                    MIcol8.setVisible(true);
                } else if (c == 8)
                {
                    col9.setVisible(true);
                    Lcol9.setVisible(true);
                    MIcol9.setVisible(true);
                } else if (c == 9)
                {
                    col10.setVisible(true);
                    Lcol10.setVisible(true);
                    MIcol10.setVisible(true);
                }
            }

/////////////////////////////////////////////////////////////////recupera os numeros da MA
            if (MA == null)
            {
                MA = new int[vertices.size()][vertices.size()];

                for (int i = 0; i < vertices.size(); i++)
                {
                    for (int j = 0; j < vertices.size(); j++)
                    {
                        MA[i][j] = 0;

                    }
                }
            } else
            {
                int[][] aux = new int[vertices.size()][vertices.size()];

                for (int i = 0; i < vertices.size(); i++)
                {
                    for (int j = 0; j < vertices.size(); j++)
                    {
                        aux[i][j] = 0;

                    }
                }

                for (int i = 0; i < vertices.size() - 1; i++)
                {
                    for (int j = 0; j < vertices.size() - 1; j++)
                    {
                        aux[i][j] = MA[i][j];
                    }
                }
                MA = aux;
            }

            ///////////////////////////////////////////////////////////////////recupera numeros da LA
            if (LA == null)
            {
                LA = new int[vertices.size()][vertices.size()];

                for (int i = 0; i < vertices.size(); i++)
                {
                    for (int j = 0; j < vertices.size(); j++)
                    {
                        LA[i][j] = 0;

                    }
                }
            } else
            {
                int[][] aux = new int[vertices.size()][vertices.size()];

                for (int i = 0; i < vertices.size(); i++)
                {
                    for (int j = 0; j < vertices.size(); j++)
                    {
                        aux[i][j] = 0;

                    }
                }

                for (int i = 0; i < vertices.size() - 1; i++)
                {
                    for (int j = 0; j < vertices.size() - 1; j++)
                    {
                        aux[i][j] = LA[i][j];
                    }
                }
                LA = aux;
            }

//////////////////////////////////////////////////////////////////////////recupera os numeros da MI
            if (MI == null)
            {
                MI = new int[contaLigaMit][vertices.size()];

                for (int i = 0; i < contaLigaMit; i++)
                {
                    for (int j = 0; j < vertices.size(); j++)
                    {
                        System.out.println("1[" + i + "," + j + "]");
                        MI[i][j] = 0;

                    }
                }
            } else
            {
                int[][] aux = new int[contaLigaMit][vertices.size()];

                for (int i = 0; i < contaLigaMit; i++)
                {
                    for (int j = 0; j < vertices.size(); j++)
                    {
                        System.out.println("2[" + i + "," + j + "]");
                        aux[i][j] = 0;

                    }
                }

                for (int i = 0; i < contaLigaMit; i++)
                {
                    for (int j = 0; j < vertices.size(); j++)
                    {
                        System.out.println("3[" + i + "," + j + "]");
                        aux[i][j] = MI[i][j];
                    }
                }
                MI = aux;
            }

//////////////////////////////////////////////////////////////////////////
            matrizAdj.getItems().clear();

            for (int rol = 0; rol < vertices.size(); rol++)
            {
                t[rol] = new tabela(rol + 1 + "");
                for (int joj = 0; joj < vertices.size(); joj++)
                {
                    if (MA[rol][joj] == 0)
                    {
                        t[rol].insere(joj, "0");
                    } else
                    {
                        t[rol].insere(joj, MA[rol][joj] + "");
                    }
                    //  System.out.println(rol + " " + joj);

                }
                matrizAdj.getItems().add(t[rol]);

            }

            //// 
            ListaAdjacente.getItems().clear();

            for (int rol = 0; rol < vertices.size(); rol++)
            {
                Lt[rol] = new tabela(rol + 1 + "");
                for (int joj = 0; joj < vertices.size(); joj++)
                {
                    if (LA[rol][joj] == 0)
                    {
                        Lt[rol].insere(joj, "");
                    } else
                    {
                        Lt[rol].insere(joj, LA[rol][joj] + "");
                    }
                }
                ListaAdjacente.getItems().add(Lt[rol]);

            }

            ///////////////////
            matrizInc.getItems().clear();

            for (int rol = 0; rol < contaLigaMit; rol++)
            {
                //  Mit[rol]=new tabela("");
                for (int joj = 0; joj < contaLigaMit; joj++)
                {
                    if (MI[rol][joj] == 0)
                    {
                        Mit[rol].insere(joj, "0");
                    } else
                    {
                        Mit[rol].insere(joj, Mi[rol][joj] + "");
                    }
                }
                matrizInc.getItems().add(Mit[rol]);

            }
            ////

        } else if (colidiu(event.getX() - 15, event.getY() - 15) != -1 && flag == -1)//seleciona o primeiro vertice
        {
            int f = colidiu(event.getX() - 15, event.getY() - 15);

            ctx.setStroke(javafx.scene.paint.Paint.valueOf("#ff0000"));
            for (int k = 0; k < 5; k++)
            {
                ctx.strokeOval(vertices.get(f).getX(), vertices.get(f).getY(), 30, 30);
            }
            xini = vertices.get(f).getX() + 15;//-x vai pra esquerda
            yini = vertices.get(f).getY() + 15;
            Rini = vertices.get(f).getRotulo();
            flag = 1;
        } else if (flag != -1 && Rini - 1 != colidiu(event.getX() - 15, event.getY() - 15))//liga
        {
            int r = colidiu(event.getX() - 15, event.getY() - 15);
            ctx.setStroke(javafx.scene.paint.Paint.valueOf("#318518"));
            ctx.strokeLine(xini, yini, vertices.get(r).getX() + 15, vertices.get(r).getY() + 15);

            String valor = "1";

            if (btLigVal.isSelected())
            {
                valor = JOptionPane.showInputDialog(null, "Valor da aresta ");
            }

            if (MA[Rini - 1][vertices.get(r).getRotulo() - 1] > 0)//liga dupla
            {
                LinhaP.setVisible(false);
                col1.setVisible(false);
                col2.setVisible(false);
                col3.setVisible(false);
                col4.setVisible(false);
                col5.setVisible(false);
                col6.setVisible(false);
                col7.setVisible(false);
                col8.setVisible(false);
                col9.setVisible(false);
                col10.setVisible(false);

                ctx.strokeLine(xini + 10, yini - 10, vertices.get(r).getX() + 5, vertices.get(r).getY() + 5);

                int arroz;
                for (arroz = 0; arroz < contaLigaMit && !Mit[arroz].linha.equals(Rini + "," + vertices.get(r).getRotulo()); arroz++)
                {
                }

                Mit[arroz].insere(vertices.get(r).getRotulo() - 1, (Integer.parseInt(valor) * 2) + "");
                if (EhGrafos)
                {
                    Mit[arroz].insere(Rini - 1, (Integer.parseInt(valor) * 2) + "");
                } else
                {
                    Mit[arroz].insere(Rini - 1, ("-" + Integer.parseInt(valor) * 2) + "");
                }

            } else
            {

                if (EhGrafos)
                {
                    Mit[contaLigaMit++] = new tabela(Rini + "," + vertices.get(r).getRotulo());

                    Mit[contaLigaMit - 1].insere(vertices.get(r).getRotulo() - 1, valor);
                    Mit[contaLigaMit - 1].insere(Rini - 1, valor);
                } else
                {
                    Mit[contaLigaMit++] = new tabela(Rini + "," + vertices.get(r).getRotulo());

                    Mit[contaLigaMit - 1].insere(vertices.get(r).getRotulo() - 1, valor);
                    Mit[contaLigaMit - 1].insere(Rini - 1, "-" + valor);
                }

            }

            if (valor != "1")
            {
                ctx.strokeText(valor, (xini + vertices.get(r).getX()) / 2, (yini + vertices.get(r).getY()) / 2);
            }

            /// DESENHA TRIANGULO
            ctx.setFill(javafx.scene.paint.Color.GREEN);

            if (!EhGrafos)
            {
                setaSeta(xini, yini, vertices.get(r).getX(), vertices.get(r).getY()); //angulo da seta
                ctx.fillPolygon(px, py, 3);
            }

            //    ctx.fillPolygon(px, py, 3);
            // ctx.strokeLine(vertices.get(r).getX()-10, vertices.get(r).getY() - 10, vertices.get(r).getX(), vertices.get(r).getY());
            // ctx.strokeLine(vertices.get(r).getX(), vertices.get(r).getY(), vertices.get(r).getX()- 15, vertices.get(r).getY());
            // ctx.strokeLine(vertices.get(r).getX()- 15, vertices.get(r).getY(), vertices.get(r).getX()-15, vertices.get(r).getY() - 15);
            ctx.fill();
            ctx.setFill(javafx.scene.paint.Color.WHITE);
            ctx.setStroke(javafx.scene.paint.Paint.valueOf("#000000"));
            ctx.fillOval(xini - 15, yini - 15, 30, 30);

            ctx.fillOval(vertices.get(r).getX(), vertices.get(r).getY(), 30, 30);

            for (int k = 0; k < 5; k++)
            {
                ctx.strokeOval(xini - 15, yini - 15, 30, 30);
            }

            for (int k = 0; k < 5; k++)
            {
                ctx.strokeOval(vertices.get(r).getX(), vertices.get(r).getY(), 30, 30);
            }

            ctx.setFill(javafx.scene.paint.Color.BLACK);
            ctx.fillText(String.valueOf(vertices.get(r).getRotulo()), vertices.get(r).getX() + 15 - 3, vertices.get(r).getY() + 15 + 3);
            ctx.fillText(String.valueOf(Rini), xini - 3, yini + 3);

            ctx.setFill(javafx.scene.paint.Paint.valueOf("#ffffff"));

            //  matrizAdj.getItems().add(vertices.get(3));
            flag = -1;

            matrizAdj.getItems().clear();
            ListaAdjacente.getItems().clear();
            matrizInc.getItems().clear();

            if (EhGrafos)
            {
                Lt[Rini - 1].insere(contL[Rini - 1]++, vertices.get(r).getRotulo() + " | " + valor);
                Lt[vertices.get(r).getRotulo() - 1].insere(contL[vertices.get(r).getRotulo() - 1]++, Rini + " | " + valor);

                t[Rini - 1].insere(vertices.get(r).getRotulo() - 1, valor);
                t[vertices.get(r).getRotulo() - 1].insere(Rini - 1, valor);

                MA[Rini - 1][vertices.get(r).getRotulo() - 1] = Integer.parseInt(valor);
                MA[vertices.get(r).getRotulo() - 1][Rini - 1] = Integer.parseInt(valor);

                LA[Rini - 1][contL[Rini - 1] - 1] = vertices.get(r).getRotulo();
                LA[vertices.get(r).getRotulo() - 1][contL[vertices.get(r).getRotulo() - 1] - 1] = Rini;
            } else
            {

                Lt[Rini - 1].insere(contL[Rini - 1]++, vertices.get(r).getRotulo() + " | " + valor);
                t[Rini - 1].insere(vertices.get(r).getRotulo() - 1, valor);
                MA[Rini - 1][vertices.get(r).getRotulo() - 1] = Integer.parseInt(valor);
                LA[Rini - 1][contL[Rini - 1] - 1] = vertices.get(r).getRotulo();
            }

            System.out.println(contaLigaMit - 1);
            System.out.println(vertices.get(r).getRotulo() - 1);

            System.out.println("P[" + (contaLigaMit - 1) + "," + (vertices.get(r).getRotulo() - 1) + "]");

            // MI[contaLigaMit-1][vertices.get(r).getRotulo()-1]=1;
            // MI[contaLigaMit-1][Rini-1]=1;
            for (int k = 0; k < vertices.size(); k++)
            {

                matrizAdj.getItems().add(t[k]);
                ListaAdjacente.getItems().add(Lt[k]);
            }

            for (int k = 0; k < contaLigaMit; k++)
            {

                matrizInc.getItems().add(Mit[k]);
            }

        } else//Recursivo
        if (flag != -1 && Rini - 1 == colidiu(event.getX() - 15, event.getY() - 15))
        {

            ctx.setStroke(javafx.scene.paint.Color.GREEN);

            String valor = "1";

            if (btLigVal.isSelected())
            {
                valor = JOptionPane.showInputDialog(null, "Valor da aresta ");
            }

            if (valor != "1")
            {
                ctx.strokeText(valor, xini + 30, yini);
            }

            ctx.setFill(javafx.scene.paint.Color.WHITE);
            int r = colidiu(event.getX() - 15, event.getY() - 15);
            ctx.setStroke(javafx.scene.paint.Paint.valueOf("#318518"));

            ctx.setStroke(javafx.scene.paint.Paint.valueOf("#000000"));

            ctx.strokeOval(xini - 5, yini - 5, 30, 30);

            ctx.fillOval(vertices.get(r).getX(), vertices.get(r).getY(), 30, 30);

            for (int k = 0; k < 5; k++)
            {
                ctx.strokeOval(xini - 15, yini - 15, 30, 30);
            }

            ctx.fillOval(xini - 15, yini - 15, 30, 30);
            ctx.setFill(javafx.scene.paint.Color.BLACK);
            ctx.fillText(String.valueOf(vertices.get(r).getRotulo()), vertices.get(r).getX() + 15 - 3, vertices.get(r).getY() + 15 + 3);
            ctx.fillText(String.valueOf(Rini), xini - 3, yini + 3);

            ctx.setFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            LA[Rini - 1][contL[Rini - 1]] = vertices.get(r).getRotulo();
            Mit[contaLigaMit++] = new tabela(Rini + "," + Rini);

            Mit[contaLigaMit - 1].insere(Rini - 1, valor);
            //MI[contaLigaMit-1][Rini-1]=1;

            flag = -1;

            matrizInc.getItems().clear();
            matrizAdj.getItems().clear();
            ListaAdjacente.getItems().clear();

            t[vertices.get(r).getRotulo() - 1].insere(vertices.get(r).getRotulo() - 1, valor);

            Lt[Rini - 1].insere(contL[Rini - 1]++, Rini + " | " + valor);

            MA[Rini - 1][Rini - 1] = 1;

            for (int k = 0; k < vertices.size(); k++)
            {
                ListaAdjacente.getItems().add(Lt[k]);
                matrizAdj.getItems().add(t[k]);
            }
            for (int k = 0; k < contaLigaMit; k++)
            {

                matrizInc.getItems().add(Mit[k]);
            }
        }
    }

    private int colidiu(double x, double y)
    {
        int colidiu = -1;

        for (int i = 0; i < vertices.size(); i++)
        {
            if (vertices.get(i).getX() > x - 30 && vertices.get(i).getX() < x + 30)
            {
                if (vertices.get(i).getY() > y - 30 && vertices.get(i).getY() < y + 30)
                {
                    colidiu = i;
                }
            }
        }
        return colidiu;
    }

    public void analisa()
    {
        //simples
        boolean flag = true;
        String Resp = "";
        for (int i = 0; i < vertices.size(); i++)
        {
            if (MA[i][i] != 0)
            {
                flag = false;
            }
        }
        if (flag)
        {
            Resp += "Simples, ";
        } else
        {
            Resp += "Não Simples, ";
        }
        //completo 
        if (EhGrafos)//!graflag) //se é grafo
        {
            boolean SeEhCompleto = true;

            for (int i = 0; i < vertices.size(); i++)
            {
                for (int j = 0; j < vertices.size(); j++)
                {
                    if (i != j && MA[i][j] == 0)
                    {
                        SeEhCompleto = false;
                    }
                }
            }
            if (SeEhCompleto)
            {
                Resp += "Completo K-  " + vertices.size() + ", ";

            } else
            {
                Resp += "Não Completo, ";
            }
        } else
        {
            boolean SeEhCompleto = true;

            for (int i = 0; i < vertices.size(); i++)
            {
                for (int j = i; j < vertices.size(); j++)
                {

                    System.out.println("i = " + i + "j = " + j);
                    if (i != j && MA[i][j] == 0 && MA[j][i] == 0)
                    {
                        SeEhCompleto = false;
                    }
                }
            }
            if (SeEhCompleto)
            {
                Resp += "Completo K-  " + vertices.size() + ", ";
            } else
            {
                Resp += "Não Completo, ";
            }
        }

        //regular   
        if (true)//!graflag) //se é grafo
        {
            boolean SeEhRegular = true;
            int cont[] = new int[20];

            for (int i = 0; i < vertices.size(); i++)
            {
                for (int j = 0; j < vertices.size(); j++)
                {
                    System.out.print(LA[i][j] + " ");
                    if (LA[i][j] != 0)
                    {
                        cont[i]++;
                    }

                }
                System.out.println("");
            }

            for (int i = 0; i < vertices.size() - 1; i++)
            {
                System.out.println("AAA" + cont[i]);
                System.out.println("AAA" + cont[i + 1]);

                if (cont[i] != cont[i + 1])
                {
                    SeEhRegular = false;
                }
            }

            if (SeEhRegular)
            {
                Resp += "Regular de grau " + cont[0];

            } else
            {
                Resp += "Não Regular ";
            }

        } else
        {
            boolean SeEhRegular = true;
            int cont[] = new int[20];

            for (int i = 0; i < vertices.size(); i++)
            {
                for (int j = i; j < vertices.size(); j++)
                {

                    if (MA[i][j] != 0 || MA[j][i] != 0)
                    {
                        cont[i]++;
                    }

                }
                System.out.println("");
            }
            
            for (int i = 0; i < vertices.size() - 1; i++)
            {
                System.out.println("AAA" + cont[i]);
                System.out.println("AAA" + cont[i + 1]);

                if (cont[i] != cont[i + 1])
                {
                    SeEhRegular = false;
                }
            }
            if (SeEhRegular)
            {
                Resp += "Regular de grau " + cont[0];

            } else
            {
                Resp += "Não Regular ";
            }
        }
        Resposta.setText(Resp);
    }

    @FXML
    private void btClassificar(ActionEvent event)
    {
        analisa();
    }

    @FXML
    private void btGrafos(ActionEvent event)
    {
        btDigrafo.setSelected(false);
        btGrafo.setSelected(true);
        EhGrafos = true;
    }

    @FXML
    private void btDigrafos(ActionEvent event)
    {
        btDigrafo.setSelected(true);
        btGrafo.setSelected(false);
        EhGrafos = false;
    }

    public void setaSeta(double x1, double y1, double x2, double y2)
    {
        double offset = 2;
        if (x1 < x2)
        {
            if (y1 > y2)//>^
            {
                px[0] = (x2 - x1) / offset + x1;
                py[0] = (y1 - y2) / offset + y2;
                px[1] = px[0] - 15;
                py[1] = py[0];
                px[2] = px[0];
                py[2] = py[0] + 15;

            } else if (y1 < y2)//>v
            {
                px[0] = (x2 - x1) / offset + x1;
                py[0] = (y2 - y1) / offset + y1;
                px[1] = px[0] - 15;
                py[1] = py[0];
                px[2] = px[0];
                py[2] = py[0] - 15;
            } else//>
            {
                px[0] = (x2 - x1) / offset;
                py[0] = y1;
                px[1] = px[0] - 10;
                py[1] = py[0] - 10;
                px[2] = px[0] - 10;
                py[2] = py[0] + 10;

            }

        } else if (x1 > x2)
        {

            if (y1 < y2)//v<
            {
                px[0] = (x1 - x2) / offset + x2;
                py[0] = (y2 - y1) / offset + y1;
                px[1] = px[0] + 15;
                py[1] = py[0];
                px[2] = px[0];
                py[2] = py[0] - 15;

            } else if (y1 > y2)//^<
            {
                px[0] = (x1 - x2) / offset + x2;
                py[0] = (y1 - y2) / offset + y2;
                px[1] = px[0] + 15;
                py[1] = py[0];
                px[2] = px[0];
                py[2] = py[0] + 15;

            } else//<
            {
                px[0] = (x1 - x2) / offset;
                py[0] = y1;
                px[1] = px[0] - 10;
                py[1] = py[0] - 10;
                px[2] = px[0] - 10;
                py[2] = py[0] + 10;
            }

        } else if (x1 == x2)
        {
            if (y1 > y2)//^
            {
                px[0] = x1;
                py[0] = (y1 - y2) / offset + y2;
                px[1] = px[0] - 10;
                py[1] = py[0] - 10;
                px[2] = px[0] - 10;
                py[2] = py[0] + 10;

            } else //v
            {
                px[0] = x1;
                py[0] = (y2 - y1) / offset + y1;
                px[1] = px[0] - 10;
                py[1] = py[0] - 10;
                px[2] = px[0] - 10;
                py[2] = py[0] + 10;

            }
        }
    }

    private int Maior()
    {
        int cont;
        int maiori = 0;
        int maior = 0;
        for (int i = 0; i < vertices.size(); i++)
        {
            cont = 0;
            for (int j = 0; j < vertices.size(); j++)
            {
                if (MA[i][j] != 0)
                {
                    cont++;
                }
                if (cont > maior)
                {
                    maior = cont;
                    maiori = i;
                }
            }
        }
        return maiori;
    }

    @FXML
    private void btPintarAct(ActionEvent event)
    {
        int maior = Maior();
        int selecionado = maior;
        int mPinta[][] = new int[vertices.size()][vertices.size()];
        int numCor = 0;

//        for (int i = 0; i < vertices.size(); i++) 
//        {
//            ctx.setFill(javafx.scene.paint.Paint.valueOf("#00ff00"));
//        ctx.fillOval(vertices.get(i).getX(), vertices.get(i).getY(), 30, 30);
//        // ctx.strokeText(vertices.get(i).getRotulo()+"", (vertices.get(i).getX()+15), (vertices.get(i).getY()+15));
//         ctx.setFill(javafx.scene.paint.Paint.valueOf("#000000"));
//         ctx.fillText(String.valueOf(vertices.get(i).getRotulo()), vertices.get(i).getX() + 12, vertices.get(i).getY() + 18);
//         
//            
//        }
//        
//        for (int j = 1; j < vertices.size() - 1; j++) 
//        {
//         //LA[0][j]= 0;
//         
//         
//           ctx.setFill(javafx.scene.paint.Paint.valueOf("#ff0000"));
//        ctx.fillOval(vertices.get(LA[0][j]).getX(), vertices.get(LA[0][j]).getY(), 30, 30);
//        // ctx.strokeText(vertices.get(i).getRotulo()+"", (vertices.get(i).getX()+15), (vertices.get(i).getY()+15));
//         ctx.setFill(javafx.scene.paint.Paint.valueOf("#000000"));
//         ctx.fillText(String.valueOf(vertices.get(LA[0][j]).getRotulo()), vertices.get(LA[0][j]).getX() + 12, vertices.get(LA[0][j]).getY() + 18);
//        }
//        
        String[] cores = new String[10];

        cores[0] = "#ff7070";
        cores[1] = "#7088ff";
        cores[2] = "#70ff81";
        cores[3] = "#fffd70";
        cores[4] = "#f570ff";
        cores[5] = "#bf70ff";
        cores[6] = "#70f1ff";
        cores[7] = "#ffcd70";
        cores[8] = "#692a65";
        cores[9] = "#2a6945";

        labelMA.setText("Matriz de coloração");

        /////////// monta matriz
        System.out.println("" + Maior());
        // selecionado++;
        int k = 0;
        do
        {
            int f = 0;
            System.out.println("selecionado" + selecionado);
            while (mPinta[selecionado][f] != 0)
            {
                System.out.println("sele/f" + mPinta[selecionado][f]);
                f++;
            }

            if (f > numCor)
            {
                numCor = f;
            }
            System.out.println("selecionadoBBBBBBBBB" + selecionado);
            System.out.println("F" + f);
            System.out.println(mPinta[selecionado][f]);
            mPinta[selecionado][f] = f + 1;
            System.out.println(mPinta[selecionado][f]);

            for (int j = 0; j < vertices.size(); j++)
            {
                if (MA[selecionado][j] > 0)
                {
                    mPinta[j][f] = -1;//f??
                }
                System.out.println("AAAAAAAAAAAAa" + MA[selecionado][j]);
            }
            selecionado++;
            if (selecionado >= vertices.size())
            {
                selecionado = 0;
            }

            k++;
            for (int i = 0; i < vertices.size(); i++)
            {
                for (int j = 0; j < numCor + 1; j++)
                {
                    System.out.print("" + mPinta[i][j]);

                }
                System.out.println("");
            }
        } while (selecionado != maior);
        //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        matrizInc.getItems().clear();
        matrizAdj.getItems().clear();
        for (int i = 0; i < vertices.size(); i++)
        {
            for (int j = 0; j < vertices.size(); j++)
            {
                t[i].insere(j, "");
            }
        }

        for (int i = 0; i < vertices.size(); i++)
        {
            for (int j = 0; j < numCor + 1; j++)
            {
                if (mPinta[i][j] != -1)
                {
                    t[i].insere(j, mPinta[i][j] + "");
                } else
                {
                    t[i].insere(j, "X");
                }
            }
        }

        for (int t = 0; t < vertices.size(); t++)
        {

            matrizAdj.getItems().add(this.t[t]);
        }

        // matrizInc = MI;
        System.out.println("AQUIIIII");

        //exibe matriz
        for (int i = 0; i < vertices.size(); i++)
        {
            for (int j = 0; j < numCor + 1; j++)
            {
                System.out.print("" + mPinta[i][j]);

            }
            System.out.println("");
        }

        //Pinta
        int maiordaLinha = 0;
        int pamonha = 0;
        int maiorCor = 0;
        for (int i = 0; i < vertices.size(); i++)
        {
            maiordaLinha = 0;
            for (int j = 0; j < numCor + 1; j++)
            {
                if (mPinta[i][j] > maiordaLinha)
                {
                    maiordaLinha = mPinta[i][j];
                }

            }
            ctx.setFill(javafx.scene.paint.Paint.valueOf(cores[maiordaLinha - 1]));
            ctx.fillOval(vertices.get(pamonha).getX(), vertices.get(pamonha).getY(), 30, 30);
            ctx.setFill(javafx.scene.paint.Paint.valueOf("#000000"));
            ctx.fillText(String.valueOf(vertices.get(pamonha).getRotulo()), vertices.get(pamonha).getX() + 12, vertices.get(pamonha).getY() + 18);
            pamonha++;

            if (maiordaLinha > maiorCor)
            {
                maiorCor = maiordaLinha;
            }

        }
        Resposta.setText("O menor numero de cores para pintar esse grafo é " + maiorCor);

        for (int i = maiorCor + 1; i < vertices.size() + 1; i++)
        {
            if (i == 1)
            {
                col1.setVisible(false);
            }
            if (i == 2)
            {
                col2.setVisible(false);
            }
            if (i == 3)
            {
                col3.setVisible(false);
            }
            if (i == 4)
            {
                col4.setVisible(false);
            }
            if (i == 5)
            {
                col5.setVisible(false);
            }
            if (i == 6)
            {
                col6.setVisible(false);
            }
            if (i == 7)
            {
                col7.setVisible(false);
            }
            if (i == 8)
            {
                col8.setVisible(false);
            }
            if (i == 9)
            {
                col9.setVisible(false);
            }
            if (i == 10)
            {
                col10.setVisible(false);
            }
        }
    }

    private boolean tem(int a, int[] b)
    {
        for (int i = 0; i < b.length; i++)
        {
            if (b[i] == a)
            {
                return true;
            }
        }
        return false;
    }

    @FXML
    private void btPontoAct(ActionEvent event)
    {
        int vetArv[] = new int[10];
        int vet1[] = new int[10];
        int vet2[] = new int[10];
        int vet3[] = new int[10];
        int cont = 0;

        vetArv[cont++] = 1;
        int j = 0;

        for (int i = 0; i < vertices.size(); i++)
        {
            System.out.println("AAAAAAA" + MA[j][i]);
            System.out.println(i);
            if (MA[j][i] > 0 && !tem(i + 1, vetArv))
            {

                vetArv[cont++] = i + 1;
                j = i;
                i = -1;
            }
        }

        for (int k = 0; k < vertices.size(); k++)
        {
            System.out.println(" A " + vetArv[k]);
        }
    }

}
