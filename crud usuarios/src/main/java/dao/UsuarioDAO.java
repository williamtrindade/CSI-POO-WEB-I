/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author mathe
 */
public class UsuarioDAO {
    
    //AUTENTICAR USUARIO
    public Usuario login(String email, String senha) throws Exception {
        
        Usuario usuario = null;
        
        try(Connection connection = new ConectaDB().getConexao()){
            
            String sql = "SELECT * FROM usuario WHERE email =? AND senha =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setEmail(resultSet.getString("email"));
                    usuario.setNome(resultSet.getString("nome"));
                    usuario.setSenha(resultSet.getString("senha"));
                    usuario.setSobrenome(resultSet.getString("sobrenome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    //SALVAR 
    public boolean salvarUsuario(Usuario usuario) throws ClassNotFoundException {
        boolean retorno = false;
        
        try(Connection connection = new ConectaDB().getConexao()){
        
            if(usuario.getId() > 0) {
                
                String sql = "UPDATE usuario SET nome = ?,sobrenome=?,email=?,senha=? "
                        + " WHERE id = ?;";
                        
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, usuario.getNome());
                    preparedStatement.setString(2, usuario.getSobrenome());
                    preparedStatement.setString(3, usuario.getEmail());
                    preparedStatement.setString(4, usuario.getSenha());
                    preparedStatement.setInt(5, usuario.getId());
                preparedStatement.executeUpdate();
                
            } else {
                String sql = "INSERT INTO usuario(id,nome,sobrenome,email,senha) "
                        + " values(DEFAULT,?,?,?,?);";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, usuario.getNome());
                    preparedStatement.setString(2, usuario.getSobrenome());
                    preparedStatement.setString(3, usuario.getEmail());
                    preparedStatement.setString(4, usuario.getSenha());
                preparedStatement.execute();
            }
            retorno = true;
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
    }
    
    public List<Usuario> getUsuarios() throws ClassNotFoundException {
        List<Usuario> usuarios = new ArrayList<>();
        
        try(Connection connection = new ConectaDB().getConexao()){
            
            String sql = "SELECT * FROM usuario;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setNome(resultSet.getString("nome"));
                    usuario.setSobrenome(resultSet.getString("sobrenome"));
                    usuario.setEmail(resultSet.getString("email"));
                    usuario.setSenha(resultSet.getString("senha"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public Usuario getUsuario(int idUsuario) throws ClassNotFoundException {
        Usuario usuario = null;
        try(Connection connection = new ConectaDB().getConexao()){
            
            String sql = "SELECT * FROM usuario WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setNome(resultSet.getString("nome"));
                    usuario.setSobrenome(resultSet.getString("sobrenome"));
                    usuario.setEmail(resultSet.getString("email"));
                    usuario.setSenha(resultSet.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public boolean deletarUsuario(int idUsuario) throws ClassNotFoundException{
        boolean retorno = false;
        
        try(Connection connection = new ConectaDB().getConexao()){
            
            String sql = "DELETE FROM usuario WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idUsuario);
            preparedStatement.execute();
            retorno = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
    }
    
}
