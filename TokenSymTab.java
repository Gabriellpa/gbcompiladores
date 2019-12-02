import java.util.Hashtable;
import java.lang.String;
import java.util.ArrayList;

public class TokenSymTab
{

    private static Hashtable tabela = new Hashtable();

    private static ArrayList<Integer> intComp = new ArrayList();
    private static ArrayList<Integer> bolCom = new ArrayList();

    public static void InserirSimbolo(Token identificador, int tipo)
    {
        int tipoIdent1 = 0;
        try
        {

            tipoIdent1 = (Integer)tabela.get(identificador.image);
        }
        catch(Exception e)
        {
         
        }

        if(tipoIdent1 != 0){
            System.out.println("Variavel "+identificador.image+ " ja esta declarada");
        }else
        {
            tabela.put(identificador.image, tipo);
        }

    }

    public static void SetTables()
    {
        intComp.add(16);
        intComp.add(18);
        bolCom.add(17);	
		bolCom.add(19);
		bolCom.add(20);
    }
	
	    public static String checkExist(Token token)
    {
        if(tabela.get(token.image) != null){
			return " ";
		}else {
			return "Error: Identificador " + token.image + " 4 Nao foi declarado Linha: "  + token.beginLine +"\r\n";
		}
    }
	
	

    public static String checkAtrib(Token TokenIni, Token TokenAtt, String as)
    {
        int tipoIdent1 = 0;
        int tipoIdent2;        
        try
        {

            tipoIdent1 = (Integer)tabela.get(TokenIni.image);
        }
        catch(Exception e)
        {
            return "Error: Identificador " + TokenIni.image + " 3 Nao foi declarado Linha: "  + TokenIni.beginLine +"\r\n";
        }

        if(TokenAtt.kind == 21) // identificador
        {
            try
            {
                tipoIdent2 = (Integer) tabela.get(TokenAtt.image); // pega da tabela
            }
            catch(Exception e)
            {
				
                return "Error: Identificador " + TokenAtt.image + " 2 Nao foi declarado Linha: " + TokenIni.beginLine +"\r\n";
            }
        }
        else if(TokenAtt.kind == 20 ||  TokenAtt.kind == 18 ||  TokenAtt.kind == 19){
            tipoIdent2 = TokenAtt.kind;
		}
        else{
            tipoIdent2 = 0;
		}
        if(tipoIdent1 == 16)
        {
            if(intComp.contains(tipoIdent2))
                return " ";
            else
                return "Error:Nao se pode converter " + TokenAtt.image + " 1 para inteiro Linha: " + TokenIni.beginLine+"\r\n";
        }else if (tipoIdent1 == 18){

            if(intComp.contains(tipoIdent2))
                return " ";
            else
                return "Error:Nao se pode converter " + TokenAtt.image + " 2 para inteiro Linha: " + TokenIni.beginLine+"\r\n";
        }else if(tipoIdent1 == 17){
            if(bolCom.contains(tipoIdent2))
                return " ";
            else
                return "Error:Nao se pode converter " + TokenAtt.image + " 3 para boolean Linha: " + TokenIni.beginLine+"\r\n";
        }
        else
        {
            return "Identificador " + TokenIni.image + " 1 nao foi declarado" + "Linha: " + TokenIni.beginLine+"\r\n";
        }
    }
}






