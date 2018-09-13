/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionDB.ConexionOracle;
import DTO.TipoCategoriaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import DTO.TipoDTO;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Bena
 */
public class TipoDAO {
   private TipoDTO tipo;
   ConexionOracle conn = new ConexionOracle();
   Connection conexion;
  
   public TipoDAO(){
   
   }
   
   public List<TipoDTO> getAll() throws SQLException{
       
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        this.conexion = this.conn.connect();
        
        String sql = "SELECT * FROM TIPO WHERE habilitado=?";

        List<TipoDTO> listaTipos;
        listaTipos = new ArrayList<> ();
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
            String codTipo = rs.getString(3);
            // campo password
            TipoDTO tipo = new TipoDTO(id, nombre, codTipo);
            listaTipos.add(tipo);
        }
        this.conexion.close();
        return listaTipos;
   }
   
   public List<TipoDTO> getAllWithCat() throws SQLException{
       
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        this.conexion = this.conn.connect();
        
        String sql = "SELECT " +
                     "t.id, t.cod_tipo, t.nombre, tc.id, tc.cod_categoria, tc.nombre " +
                     "FROM TIPO t " +
                     "JOIN TIPO_CATEGORIA TC " +
                     "ON t.id_categoria = tc.id " +
                     "WHERE t.habilitado=?";
                

        List<TipoDTO> listaTipos;
        listaTipos = new ArrayList<> ();
        pst = (OraclePreparedStatement) conexion.prepareStatement(sql);
        pst.setInt(1, 0);
        rs = (OracleResultSet) pst.executeQuery();
        while(rs.next()){
            // Datos Tipo
            int id = rs.getInt(1);
            String codTipo = rs.getString(2);
            String nombre = rs.getString(3);
            // Datos Categoria
            int id_categoria = rs.getInt(4);
            String nombre_categoria = rs.getString(5);
            String cod_categoria= rs.getString(6);
            
            TipoCategoriaDTO categoria = new TipoCategoriaDTO(
                    id_categoria,
                    nombre_categoria,
                    cod_categoria
            );
            TipoDTO tipo = new TipoDTO(id, codTipo, nombre, categoria);
            listaTipos.add(tipo);
        }
        this.conexion.close();
        return listaTipos;
   }
   
   public TipoDTO getByCode(String SearchCodTipo) throws SQLException{
       
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        this.conexion = this.conn.connect();
        
        String sql = "SELECT * FROM TIPO WHERE cod_tipo=?";
        
        TipoDTO tipo = new TipoDTO();
        pst = (OraclePreparedStatement) conexion.prepareStatement(sql);
        pst.setString(1, SearchCodTipo);
        rs = (OracleResultSet) pst.executeQuery();
        while(rs.next()){
            // con estas lineas se revisa el resultado de la query
            // campo id
            int id = rs.getInt(1);
            // campo email
            String nombre = rs.getString(2);
            // campo password
            String codTipo = rs.getString(3);
            // campo password
            tipo.setId(id);
            tipo.setNombre(nombre);
            tipo.setCodTipo(codTipo);
        }
        this.conexion.close();
        return tipo;
   }
   
   public boolean add(String codTipo, String nombre, int id_categoria) throws SQLException{
        boolean success = false;
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        this.conexion = this.conn.connect();
        
        String sql = "INSERT INTO TIPO(cod_tipo, nombre, id_categoria, habilitado) VALUES(?, ?, ?, ?)";
        pst = (OraclePreparedStatement) conexion.prepareStatement(sql);
        pst.setString(1, codTipo);
        pst.setString(2, nombre);
        pst.setInt(3, id_categoria);
        pst.setInt(4, 0);
        int result = pst.executeUpdate();
        System.out.println(result);
        this.conexion.close();
        if(result == 1){
            success = true;
        }
        return success;
   }
   
   public boolean update(int id, String nombre, String codTipo) throws SQLException{
        boolean success = false;
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        this.conexion = this.conn.connect();
        
        String sql = "UPDATE Tipo SET nombre=?, cod_tipo=? WHERE id=?";
        pst = (OraclePreparedStatement) conexion.prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, codTipo);
        pst.setInt(3, id);
        int result = pst.executeUpdate();
        System.out.println(result);
        this.conexion.close();
        if(result == 1){
            success = true;
        }
        return success;
   }
   
   public boolean disabledByCodTipo(String codTipo) throws SQLException{
        System.out.println(codTipo);
        boolean success = false;
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        this.conexion = this.conn.connect();
        
        String sql = "UPDATE TIPO SET habilitado=? WHERE cod_tipo=?";
        pst = (OraclePreparedStatement) conexion.prepareStatement(sql);
        pst.setInt(1, 1);
        pst.setString(2, codTipo);
        int result = pst.executeUpdate();
        this.conexion.close();
        if(result == 1){
            success = true;
        }
        System.out.println(result);
        return success;
   }
}
