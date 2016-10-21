package br.senac.tads3.testeweb;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import org.apache.derby.client.am.DateTime;

public class ConexaoDerby {
    private Connection conn = null;
    private Statement  sql  = null;
    
    private void Conectar(){
        
        try{
            //Pegando o drive do Derby
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            // estabelecendo conexão com o banco
            //conn = DriverManager.getConnection("jdbc:derby:agendabd");
            //conn = DriverManager.getConnection("jdbc:derby:agendabd;create=true;");
            conn = DriverManager.getConnection("jdbc:derby:agendabd;create=true;");

            if(conn == null){
                System.out.println("Criando bando de dados local");
            }
         
            // System.out.println("Conectado com sucesso");
            // System.out.println("-----------------------------------------");
           CriarTabelas();
            
        }catch(ClassNotFoundException | SQLException Err){
            //System.out.println("Erro ao tentar conectar em Bando de dados localdb" + Err);
        } 
    }
    
    public void CriarTabelas(){
        // Criando tabela
        try{
            sql = conn.createStatement();

            //sql.executeUpdate("DROP TABLE TB_CONTATO");

            sql.executeUpdate("" + "CREATE TABLE TB_CONTATO ("
                                 + "ID_CONTATO BIGINT  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_CONTATO PRIMARY KEY,"
                                 + "DT_NASCIMENTO DATE NOT NULL,"
                                 + "NM_CONTATO VARCHAR(100) NOT NULL,"
                                 + "VL_TELEFONE VARCHAR(16),"
                                 + "VL_EMAIL VARCHAR(100),"
                                 + "DT_CADASTRO DATE not null"
                                 + ")");

            System.out.println("Tabela criada com sucesso");
            System.out.println("-----------------------------------------");
        }catch(Exception Err){
            //System.out.println("Erro ao tentar criar tabela. "+Err);
        }
    }
   
    public void Incluir(String nome, String DataNascimento, String telefone, String email){
        // inserindo dados
        try{
            Conectar();
            
            sql = conn.createStatement();
            
            Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
            
            String strQuery = "INSERT INTO TB_CONTATO (NM_CONTATO,DT_NASCIMENTO,VL_TELEFONE,VL_EMAIL, DT_CADASTRO) VALUES "
                            + "('" + nome + "',"
                            + "'" + DataNascimento + "',"
                            + "'" + telefone       + "',"
                            + "'" + email          + "'," 
                            + "'" + dataDeHoje.toString() + "')";
            
            // System.out.println(strQuery);
            
            sql.executeUpdate(strQuery);

            System.out.println("Dados inseridos com sucesso");
            System.out.println("-----------------------------------------");
        }catch(Exception Err){
            System.out.println("Erro ao tentar inserir dados. "+Err);
        }
    }
    
    public ArrayList<Pessoa> Listar(){
        // mostrando dados
        
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        try{
            
            Conectar();
            
            sql = conn.createStatement();
            
            System.out.println("listando dados");
            System.out.println("-----------------------------------------");

            ResultSet get = sql.executeQuery("SELECT * FROM TB_CONTATO");

            while(get.next()){
            
                Pessoa _pessoa = new Pessoa();
                
                _pessoa.id = get.getString("ID_CONTATO");
                _pessoa.nome = get.getString("NM_CONTATO");
                _pessoa.dataNascimento = get.getString("DT_NASCIMENTO");
                _pessoa.telefone = get.getString("VL_TELEFONE");
                _pessoa.email    = get.getString("VL_EMAIL");
                _pessoa.dataCadastro   = get.getString("DT_CADASTRO");
                
                pessoas.add(_pessoa);
                
                int ID = get.getInt("ID_CONTATO");
                String nome = get.getString("NM_CONTATO");
                String dataNascimento = get.getString("DT_NASCIMENTO");
                String Telefone = get.getString("VL_TELEFONE");
                String email = get.getString("VL_EMAIL");
                String dataCadastro = get.getString("DT_CADASTRO");
                
                System.out.println(_pessoa.id +", "+ _pessoa.nome +", "+_pessoa.dataNascimento + ", " + _pessoa.telefone + ", " + email + ", " + _pessoa.dataCadastro);
            }
            System.out.println("-----------------------------------------");
        }catch(Exception Err){
            System.out.println("Erro ao tentar imprimir dados. "+Err);
        }
        
        return pessoas;
    }
   
    public void Excluir(){
        try{
            Conectar();
            
            sql = conn.createStatement();
            
            sql.executeUpdate("DELETE FROM TB_CONTATO");
            
            System.out.println("Dados deletados");
            System.out.println("-----------------------------------------");
            
        }catch(Exception Err){
            System.out.println("Erro ao tentar imprimir dados. " + Err);
        }
    }
}




