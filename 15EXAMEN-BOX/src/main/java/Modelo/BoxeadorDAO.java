/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author deadpooy
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoxeadorDAO {
    
    public void agregar(Boxeador b) throws SQLException, Exception{
        String sql = "INSERT INTO boxeadores (id, nombre, edad, peso, categoria, nacionalidad, "
                   + "peleas_ganadas, peleas_perdidas, peleas_empatadas, gimnasio, mano_dominante) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, b.getId());
            ps.setString(2, b.getNombre());
            ps.setInt(3, b.getEdad());
            ps.setDouble(4, b.getPeso());
            ps.setString(5, b.getCategoria());
            ps.setString(6, b.getNacionalidad());
            ps.setInt(7, b.getPeleasGanadas());
            ps.setInt(8, b.getPeleasPerdidas());
            ps.setInt(9, b.getPeleasEmpatadas());
            ps.setString(10, b.getGimnasio());
            ps.setString(11, b.getManoDominante());
            
            ps.executeUpdate();
        }
    }

    public void actualizar(Boxeador b) throws SQLException, Exception{
        String sql = "UPDATE boxeadores SET nombre=?, edad=?, peso=?, categoria=?, nacionalidad=?, "
                   + "peleas_ganadas=?, peleas_perdidas=?, peleas_empatadas=?, gimnasio=?, mano_dominante=? "
                   + "WHERE id=?";
        
        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, b.getNombre());
            ps.setInt(2, b.getEdad());
            ps.setDouble(3, b.getPeso());
            ps.setString(4, b.getCategoria());
            ps.setString(5, b.getNacionalidad());
            ps.setInt(6, b.getPeleasGanadas());
            ps.setInt(7, b.getPeleasPerdidas());
            ps.setInt(8, b.getPeleasEmpatadas());
            ps.setString(9, b.getGimnasio());
            ps.setString(10, b.getManoDominante());
            ps.setInt(11, b.getId());
            
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException, Exception{
        String sql = "DELETE FROM boxeadores WHERE id = ?";
        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Boxeador> listarTodos() throws SQLException, Exception{
        List<Boxeador> lista = new ArrayList<>();
        String sql = "SELECT * FROM boxeadores ORDER BY id";
        
        try(Connection con = ConexionBD.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            
            while(rs.next()){
                Boxeador b = new Boxeador(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getDouble("peso"),
                    rs.getString("categoria"),
                    rs.getString("nacionalidad"),
                    rs.getInt("peleas_ganadas"),
                    rs.getInt("peleas_perdidas"),
                    rs.getInt("peleas_empatadas"),
                    rs.getString("gimnasio"),
                    rs.getString("mano_dominante")
                );
                lista.add(b);
            }
        }
        return lista;
    }

    public Boxeador buscarPorId(int id) throws SQLException, Exception{
        String sql = "SELECT * FROM boxeadores WHERE id = ?";
        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Boxeador(
                    rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad"),
                    rs.getDouble("peso"), rs.getString("categoria"), rs.getString("nacionalidad"),
                    rs.getInt("peleas_ganadas"), rs.getInt("peleas_perdidas"),
                    rs.getInt("peleas_empatadas"), rs.getString("gimnasio"),
                    rs.getString("mano_dominante")
                );
            }
        }
        return null;
    }
}
