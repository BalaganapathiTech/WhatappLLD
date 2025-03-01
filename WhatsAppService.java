package Practice.whatsapp;

import java.sql.*;
import java.util.*;
public class WhatsAppService {
    private Connection conn;
    public WhatsAppService() {
        try {
            String url = "jdbc:mysql://localhost:3306/WhatsAppDB";
            String user = "root";
            String password = "**********#";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Database connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed!");
        }
    }
    public boolean registerUser(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean sendMessage(int senderId, int receiverId, String message) {
        try {
            String encryptedMessage = EncryptionUtil.encrypt(message);

            String sql = "INSERT INTO messages (sender_id, receiver_id, message) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, senderId);
            pstmt.setInt(2, receiverId);
            pstmt.setString(3, encryptedMessage);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void viewMessages(int userId) {
        try {
            String query = "SELECT sender_id, message FROM messages WHERE receiver_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            System.out.println("📩 Your Messages:");
            boolean hasMessages = false;

            while (rs.next()) {
                hasMessages = true;
                int senderId = rs.getInt("sender_id");
                String encryptedMessage = rs.getString("message");

                String decryptedMessage = EncryptionUtil.decrypt(encryptedMessage);

                System.out.println("From User " + senderId + ": " + decryptedMessage);
            }

            if (!hasMessages) {
                System.out.println("No messages found.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error retrieving messages");
            e.printStackTrace();
        }
    }
    public boolean postStory(int userId, String story) {
        String query = "INSERT INTO stories (user_id, story) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, story);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void viewStories() {
        String query = "SELECT u.username, s.story, s.timestamp FROM stories s " +
                "JOIN users u ON s.user_id = u.user_id ORDER BY s.timestamp DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getString("username") + " posted: " + rs.getString("story") + " (" + rs.getTimestamp("timestamp") + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}