**WhatsApp Clone - Secure Messaging System (Java, JDBC, MySQL)**
🚀 A simple WhatsApp-like messaging system with **End-to-End Encryption (AES)** using **Java, JDBC, and MySQL**.

---

**📌 Features**
✅ **User Registration** – Users can sign up with a username & password.  
✅ **End-to-End Encrypted Messaging** – Messages are securely stored & only readable by the intended recipient.  
✅ **View Messages** – Retrieve & decrypt received messages.  
✅ **Post & View Stories** – Users can share stories visible to all.  
✅ **Secure Storage** – Data is stored in MySQL using JDBC.

---

**🛠️ Technologies Used**
- **Programming Language:** Java  
- **Database:** MySQL  
- **JDBC:** For database connectivity  
- **Security:** AES Encryption for secure messaging  
- **GitHub:** Version control  

---

**📥 Installation & Setup**
1️⃣ **Clone the Repository**  
```bash
git clone https://github.com/yourusername/whatsapp-clone.git
cd whatsapp-clone
```
2️⃣ **Setup MySQL Database**
- Create a database named `whatsapp_db`.
- Run the provided SQL script (`schema.sql`) to set up tables.

3️⃣ **Configure Database Connection**
- Update `DBConfig.java` with your MySQL credentials:
```java
private static final String URL = "jdbc:mysql://localhost:3306/whatsapp_db";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

4️⃣ **Run the Application**
```bash
javac -d . src/*.java
java Practice.whatsapp.Main
```

---

**📌 How It Works**
### **1️⃣ User Registration**
```plaintext
Enter Username: BalaGanapathi
Enter Password: ********
✅ User registered successfully!
```

**2️⃣ Send an Encrypted Message**
```plaintext
Enter Sender ID: 1
Enter Receiver ID: 2
Enter Message: Hello, how are you?
📩 Message sent successfully!
```

**3️⃣ View Messages (Decrypted)**
```plaintext
Enter Your User ID: 2
📩 Your Messages:
From User 1: Hello, how are you?
```

---

**🔐 Security (End-to-End Encryption)**
- Messages are encrypted using **AES encryption** before storing in the database.  
- Only the **recipient** can decrypt and read the message.  
- Ensures **privacy & security** of user communications.  

---

**📜 Database Schema (MySQL)**
```sql
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE messages (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT,
    receiver_id INT,
    encrypted_message TEXT,
    FOREIGN KEY (sender_id) REFERENCES users(user_id),
    FOREIGN KEY (receiver_id) REFERENCES users(user_id)
);
```

---

**📌 Future Enhancements**
✅ Real-time messaging using WebSockets  
✅ Multimedia support (images, videos)  
✅ User status & last seen  
✅ Friend requests & blocking  

---

**💡 Contributing**
1. Fork the repo  
2. Create a new branch (`feature-branch`)  
3. Commit your changes  
4. Open a pull request  

---

**📜 License**
This project is **open-source** and available under the **MIT License**.

📬 **Questions?** Feel free to raise an issue or contact me! 🚀
