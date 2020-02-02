/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import conexaoBD.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelBean.Combustivel;

/**
 *
 * @author Talyson
 */
public class ProdutoDAO {
    
    public void create(Combustivel p){

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO combustivel(idColuna,dataInicio,dataFinal,regiao,"
                    + "estado,produto,numeroPostos,unidadeMedida,precoMedioRevenda,desvioPadraoRevenda,"
                    + "precoMinimoRevenda,precoMaximoRevenda,margemMediaRevenda,coefVariacaoRevenda,"
                    + "precoMedioDistribuicao,desvioPadraoDistribuicao,precoMinimoDistribuicao,"
                    + "precoMaximoDistribuicao,coefVariacaoDistribuicao,mes,ano) VALUES(?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1,p.getIdColuna());
            stmt.setString(2,p.getDataInicio());
            stmt.setString(3,p.getDataFinal());
            stmt.setString(4,p.getRegiao());
            stmt.setString(5,p.getEstado());
            stmt.setString(6,p.getProduto());
            stmt.setString(7,p.getNumeroPostos());
            stmt.setString(8,p.getUnidadeMedida());
            stmt.setString(9,p.getPrecoMedioRevenda());
            stmt.setString(10,p.getDesvioPadraoRevenda());
            stmt.setString(11,p.getPrecoMinimoRevenda());
            stmt.setString(12,p.getPrecoMaximoRevenda());
            stmt.setString(13,p.getMargemMediaRevenda());
            stmt.setString(14,p.getCoefVariacaoRevenda());
            stmt.setString(15,p.getPrecoMedioDistribuicao());
            stmt.setString(16,p.getDesvioPadraoDistribuicao());
            stmt.setString(17,p.getPrecoMinimoDistribuicao());
            stmt.setString(18,p.getPrecoMaximoDistribuicao());
            stmt.setString(19,p.getCoefVariacaoDistribuicao());
            stmt.setString(20,p.getMes());
            stmt.setString(21,p.getAno());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Combustivel> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;  
        ResultSet rs = null;
        
        List<Combustivel> combustiveis = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM combustivel");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Combustivel combustivel  = new Combustivel();
                
                combustivel.setIdColuna(rs.getString("idColuna"));
                combustivel.setDataInicio(rs.getString("dataInicio"));
                combustivel.setDataFinal(rs.getString("dataFinal"));
                combustivel.setRegiao(rs.getString("regiao"));
                combustivel.setEstado(rs.getString("estado"));
                combustivel.setProduto(rs.getString("produto"));
                combustivel.setNumeroPostos(rs.getString("numeroPostos"));
                combustivel.setUnidadeMedida(rs.getString("unidadeMedida"));
                combustivel.setPrecoMedioRevenda(rs.getString("precoMedioRevenda"));
                combustivel.setDesvioPadraoRevenda(rs.getString("desvioPadraoRevenda"));
                combustivel.setPrecoMinimoRevenda(rs.getString("precoMinimoRevenda"));
                combustivel.setPrecoMaximoRevenda(rs.getString("precoMaximoRevenda"));
                combustivel.setMargemMediaRevenda(rs.getString("margemMediaRevenda"));
                combustivel.setCoefVariacaoRevenda(rs.getString("coefVariacaoRevenda"));
                combustivel.setPrecoMedioDistribuicao(rs.getString("precoMedioDistribuicao"));
                combustivel.setDesvioPadraoDistribuicao(rs.getString("desvioPadraoDistribuicao"));
                combustivel.setPrecoMinimoDistribuicao(rs.getString("precoMinimoDistribuicao"));
                combustivel.setPrecoMaximoDistribuicao(rs.getString("precoMaximoDistribuicao"));
                combustivel.setCoefVariacaoDistribuicao(rs.getString("coefVariacaoDistribuicao"));
                combustivel.setMes(rs.getString("mes"));
                combustivel.setAno(rs.getString("ano"));
                
                combustiveis.add(combustivel);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Exibir: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return combustiveis;
    }
    
}
