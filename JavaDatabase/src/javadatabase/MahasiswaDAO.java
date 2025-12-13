package javadatabase;

import java.sql.*;
import java.util.*;

public class MahasiswaDAO {

    public void insert(Mahasiswa mhs) {
        String sql = "INSERT INTO mahasiswa (nim, nama, tahunmasuk, jenis, sks, biaya) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DbConnection.connect(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mhs.getNim());
            ps.setString(2, mhs.getNama());
            ps.setInt(3, mhs.getTahunMasuk());
            ps.setString(4, mhs.getjenis());
            ps.setInt(5, mhs.getsks());
            ps.setLong(6, mhs.hitungBiaya());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Mahasiswa mhs) {
        String sql = "UPDATE mahasiswa SET nim=?, nama=?, tahunmasuk=?, jenis=?, sks=?, biaya=? WHERE id=?";
        try (Connection con = DbConnection.connect(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mhs.getNim());
            ps.setString(2, mhs.getNama());
            ps.setInt(3, mhs.getTahunMasuk());
            ps.setString(4, mhs.getjenis());
            ps.setInt(5, mhs.getsks());
            ps.setLong(6, mhs.hitungBiaya());
            ps.setInt(7, mhs.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM mahasiswa WHERE id=?";
        try (Connection con = DbConnection.connect(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa ORDER BY id ASC";

        try (Connection con = DbConnection.connect(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String nim = rs.getString("nim");
                int tahun = rs.getInt("tahunmasuk");
                int sks = rs.getInt("sks");

                String jenis = rs.getString("jenis");
                if (jenis == null || jenis.isEmpty()) {
                    jenis = "Reguler";
                }

                Mahasiswa mhs;
                switch (jenis) {
                    case "Beasiswa":
                        mhs = new MahasiswaBeasiswa(nama, nim, tahun, sks);
                        break;
                    case "Internasional":
                        mhs = new MahasiswaInternasional(nama, nim, tahun, sks);
                        break;
                    default:
                        mhs = new MahasiswaReguler(nama, nim, tahun, sks);
                        break;
                }

                mhs.setId(id);
                mhs.setjenis(jenis);
                mhs.setsks(sks);

                list.add(mhs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
