package javadatabase;

import java.sql.*;
import java.util.*;

public class MahasiswaDAO {

    public void insert(Mahasiswa mhs) {
        String sql = "INSERT INTO mahasiswa (nim, nama, tahunmasuk) VALUES (?, ?, ?)";
        try (Connection con = DbConnection.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mhs.getNim());
            ps.setString(2, mhs.getNama());
            ps.setInt(3, mhs.getTahunMasuk());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Mahasiswa mhs) {
        String sql = "UPDATE mahasiswa SET nim=?, nama=?, tahunmasuk=? WHERE id=?";
        try (Connection con = DbConnection.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mhs.getNim());
            ps.setString(2, mhs.getNama());
            ps.setInt(3, mhs.getTahunMasuk());
            ps.setInt(4, mhs.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM mahasiswa WHERE id=?";
        try (Connection con = DbConnection.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa ORDER BY id ASC";

        try (Connection con = DbConnection.connect();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Mahasiswa(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("nim"),
                        rs.getInt("tahunmasuk")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
