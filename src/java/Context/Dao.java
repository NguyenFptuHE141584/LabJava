/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Context;

import Model.Account;
import Model.Category;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Foxxy
 */
public class Dao {

    Connection conn = null;// connect with sql sever
    PreparedStatement ps = null;//throw command from netbean to sql sever
    ResultSet rs = null;// get returned results

    public Account login(String user, String pass) {
        String querry = "select * from Account where [username] = ? and [password] = ? ";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String querry = "Select CategoryId ,CategoryName from Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String querry = "select ProductId,ProductName,Price from Product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCategoryId(String id) {
        List<Product> list = new ArrayList<>();
        String querry = "select ProductId,ProductName,Price from Product where CategoryId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addProduct(int productId, String productName,double Price,int categoryId) {
        String querry = "insert into Product values(?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, productId);
            ps.setString(2, productName);
            ps.setDouble(3, Price);
            ps.setInt(4, categoryId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void editProduct(String productName ,double  price,int categoryId,int productId) {
        String querry = "update Product set ProductName=?,Price=?,CategoryId=? where ProductId =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, productName);
            ps.setDouble(2, price);
            ps.setInt(3, categoryId);
            ps.setInt(4, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void deleteProduct(int productId) {
        String querry = "delete from Product where ProductId=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

//    public static void main(String[] args) {
//        Dao dao = new Dao();
//       dao.editProduct("jdshas", 432, 3, 14);
//
//    }   

}
