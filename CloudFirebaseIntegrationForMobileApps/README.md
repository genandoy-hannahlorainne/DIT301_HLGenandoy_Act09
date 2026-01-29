# Firebase Chat Application

A real-time chat application built with Firebase Authentication and Cloud Firestore for Android.

## 🎉 Project Status: Complete and Ready!

**→ See [PROJECT_COMPLETE.md](PROJECT_COMPLETE.md) for what's included and next steps**

## 📚 Documentation

**New to this project?** Start here: **[INDEX.md](INDEX.md)** - Complete documentation guide

**Quick Links:**
- 🚀 [Quick Start (5 min)](QUICKSTART.md)
- 📖 [Complete Beginner's Guide](GETTING_STARTED.md)
- 🔧 [Firebase Setup](FIREBASE_SETUP.md)
- ❌ [Troubleshooting](TROUBLESHOOTING.md)
- ✅ [Submission Checklist](SUBMISSION_CHECKLIST.md)

---

## 📱 Features

- **User Authentication**
  - Email/Password registration and login
  - Anonymous authentication (Guest mode)
  - Secure Firebase Authentication integration

- **Real-Time Chat**
  - Send and receive messages instantly
  - Real-time message synchronization using Firestore
  - Display sender name/email and timestamps
  - Auto-scroll to latest messages

- **User Interface**
  - Clean and modern Material Design UI
  - Login/Registration screen
  - Chat screen with message list
  - Logout functionality

## 🛠 Technologies Used

- **Kotlin** - Primary programming language
- **Firebase Authentication** - User authentication
- **Cloud Firestore** - Real-time NoSQL database
- **Firebase Cloud Messaging** - Push notifications (configured)
- **Material Design Components** - UI components
- **ViewBinding** - Type-safe view access
- **RecyclerView** - Efficient message list display

## 📋 Prerequisites

Before running this application, you need to:

1. Create a Firebase project at [Firebase Console](https://console.firebase.google.com/)
2. Add an Android app to your Firebase project
3. Download the `google-services.json` file
4. Place it in the `app/` directory of this project

## 🔧 Firebase Setup Instructions

### 1. Create Firebase Project

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Click "Add project"
3. Enter project name: `firebase-chat-app`
4. Follow the setup wizard

### 2. Add Android App

1. In Firebase Console, click "Add app" → Android
2. Enter package name: `com.example.cloudfirebaseintegrationformobileapps`
3. Download `google-services.json`
4. Place it in `app/` folder

### 3. Enable Authentication

1. Go to **Authentication** → **Sign-in method**
2. Enable **Email/Password**
3. Enable **Anonymous** authentication

### 4. Create Firestore Database

1. Go to **Firestore Database**
2. Click **Create database**
3. Start in **Test mode** (for development)
4. Choose a location

### 5. Configure Firestore Security Rules

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /chats/{messageId} {
      allow read: if request.auth != null;
      allow write: if request.auth != null;
    }
  }
}
```

## 📦 Installation

1. Clone this repository
```bash
git clone https://github.com/YourUsername/MobileDev-YourName.git
cd MobileDev-YourName
```

2. Add `google-services.json` to `app/` directory

3. Open project in Android Studio

4. Sync Gradle files

5. Run the application

## 🚀 Usage

### Login/Register
- Enter email and password to register a new account
- Use existing credentials to login
- Or click "Continue as Guest" for anonymous access

### Chat
- Type your message in the input field
- Click "Send" to post the message
- Messages appear in real-time for all users
- Click menu → "Logout" to sign out

## 📸 Screenshots

### Login Screen
![Login Screen](screenshots/login_screen.png)

### Chat Screen
![Chat Screen](screenshots/chat_screen.png)

### Firestore Console
![Firestore Console](screenshots/firestore_console.png)

## 📁 Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/cloudfirebaseintegrationformobileapps/
│   │   │   ├── LoginActivity.kt          # Authentication screen
│   │   │   ├── ChatActivity.kt           # Main chat screen
│   │   │   ├── ChatAdapter.kt            # RecyclerView adapter
│   │   │   ├── Message.kt                # Data model
│   │   │   └── MainActivity.kt           # Original main activity
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_login.xml    # Login UI
│   │   │   │   ├── activity_chat.xml     # Chat UI
│   │   │   │   └── item_message.xml      # Message item layout
│   │   │   └── menu/
│   │   │       └── chat_menu.xml         # Chat menu (logout)
│   │   └── AndroidManifest.xml
│   └── google-services.json              # Firebase configuration
└── build.gradle.kts
```

## 🔐 Security Considerations

- Firebase Authentication handles password hashing and security
- Firestore security rules restrict access to authenticated users only
- Never commit `google-services.json` to public repositories (add to `.gitignore`)
- Use environment-specific configurations for production

## 🐛 Common Issues

### Issue: App crashes on startup
**Solution**: Ensure `google-services.json` is in the `app/` directory

### Issue: Authentication fails
**Solution**: Check that Email/Password provider is enabled in Firebase Console

### Issue: Messages don't appear
**Solution**: Verify Firestore security rules allow authenticated users to read/write

### Issue: Build fails
**Solution**: Sync Gradle files and ensure all dependencies are downloaded

## 📚 Learning Outcomes

This project demonstrates:
- ✅ Cloud backend integration in mobile apps
- ✅ Firebase Authentication implementation
- ✅ Real-time data synchronization with Firestore
- ✅ NoSQL database structure and queries
- ✅ RecyclerView with real-time updates
- ✅ Material Design UI implementation
- ✅ Understanding of BaaS (Backend-as-a-Service)

## 🔮 Future Enhancements

- [ ] Push notifications with FCM
- [ ] User profiles with avatars
- [ ] Image sharing in chat
- [ ] Private messaging between users
- [ ] Message deletion and editing
- [ ] Online/offline status indicators
- [ ] Typing indicators
- [ ] Message read receipts

## 📄 License

This project is for educational purposes as part of Mobile Development coursework.

## 👤 Author

**[Your Name]**
- GitHub: [@YourUsername](https://github.com/YourUsername)
- Student ID: [Your Student ID]

## 🙏 Acknowledgments

- Firebase Documentation
- Android Developers Guide
- Material Design Guidelines
- Course Instructor and Teaching Assistants
