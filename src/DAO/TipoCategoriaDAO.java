package DAO;

import ConexionDB.ConexionOracle;
import DTO.TipoCategoriaDTO;
import DTO.TipoDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bena
 */
public class TipoCategoriaDAO {
   private TipoDTO tipo;
   ConexionOracle conn = new ConexionOracle();
   Connection conexion;
  
   public TipoCategoriaDAO(){
   
   }
   
   public List<TipoCategoriaDTO> getAll() throws SQLException{
       
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        this.conexion = this.conn.connect();
        
        String sql = "SELECT * FROM TIPO_CATEGORIA WHERE habilitado=?";

        List<TipoCategoriaDTO> listaTiposCategoria;
        listaTiposCategoria = new ArrayList<> ();
        pst = (OraclePreparedStatement) conexion.prepareStatement(sql);
        pst.setInt(1, 0);
        rs = (OracleResultSet) pst.executeQuery();
        while(rs.next()){
            // con estas lineas se revisa el resultado de la query
            // campo id
            int id = rs.getInt(1);
            // campo email
            String nombre = rs.getString(2);
            // campo password
            String codTipoCat = rs.getString(3);
            // campo password
            TipoCategoriaDTO tipoCat = new TipoCategoriaDTO(
                    id,
                    nombre,
                    codTipoCat
            );
            listaTiposCategoria.add(tipoCat);
        }
        this.conexion.close();
        return listaTiposCategoria;
   }
   
   public TipoCategoriaDTO getByCode(String SearchCodTipoCat) throws SQLException{
       OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        this.conexion = this.conn.connect();
        
        String sql = "SELECT * FROM "
                + "TIPO_CATEGORIA "
                + "WHERE "
                + "habilitado=? "
                + "AND "
                + "cod_categoria=?";

        pst = (OraclePreparedStatement) conexion.prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, SearchCodTipoCat);
        rs = (OracleResultSet) pst.executeQuery();
        TipoCategoriaDTO tipoCat = new TipoCategoriaDTO();
        while(rs.next()){
            // con estas lineas se revisa el resultado de la query
            // campo id
            int id = rs.getInt(1);
            // campo email
            String nombre = rs.getString(2);
            // campo password
            String codTipoCat = rs.getString(3);
            // campo password
            tipoCat.setId(id);
            tipoCat.setCodTipoCat(codTipoCat);
            tipoCat.setNombre(nombre);
            
            
            
        }
        this.conexion.close();
        return tipoCat;
   }
   
   public boolean add(String codTipoCat, String nombre) throws SQLException{
        boolean success = false;
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        this.conexion = this.conn.connect();

        String sql = "INSERT INTO TIPO_CATEGORIA(cod_categoria, nombre, habilitado) VALUES(?, ?,  ?)";
        pst = (OraclePreparedStatement) conexion.prepareStatement(sql);
        pst.setString(1, codTipoCat);
        pst.setString(2, nombre);
        pst.setInt(3, 0);
        int result = pst.executeUpdate();
        this.conexion.close();
        if(result == 1){
            success = true;
        }
        return success;

   }
   
   public boolean update(String OldCodTipoCat, String newCodTipoCat, String nombre) throws SQLException{
        boolean success = false;
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        this.conexion = this.conn.connect();

        String sql = "UPDATE TIPO_CATEGORIA SET cod_categoria=?, nombre=? WHERE cod_categoria=?";
        pst = (OraclePreparedStatement) conexion.prepareStatement(sql);
        pst.setString(1, newCodTipoCat);
        pst.setString(2, nombre);
        pst.setString(3, OldCodTipoCat);
        int result = pst.executeUpdate();
        this.conexion.close();
        if(result == 1){
            success = true;
        }
        return success;

   }
   
   public boolean disabledByCode(String codTipoCat) throws SQLException{
        boolean success = false;
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        this.conexion = this.conn.connect();

        String sql = "UPDATE TIPO_CATEGORIA SET habilitado=? WHERE cod_categoria=?";
        pst = (OraclePreparedStatement) conexion.prepareStatement(sql);
        pst.setInt(1, 1);
        pst.setString(2, codTipoCat);
        int result = pst.executeUpdate();
        this.conexion.close();
        if(result == 1){
            success = true;
        }
        return success;
   }
    
}
