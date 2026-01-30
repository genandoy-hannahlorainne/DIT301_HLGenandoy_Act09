# Quick Start Guide

Get your Firebase Chat App running in 5 minutes!

## Prerequisites
- Android Studio installed
- Android device or emulator
- Google account for Firebase

## Setup Steps

### 1. Firebase Console Setup (2 minutes)

1. Go to https://console.firebase.google.com/
2. Create new project → Name it "firebase-chat-app"
3. Add Android app:
   - Package: `com.example.cloudfirebaseintegrationformobileapps`
   - Download `google-services.json`
4. Enable Authentication:
   - Go to Authentication → Sign-in method
   - Enable "Email/Password" and "Anonymous"
5. Create Firestore Database:
   - Go to Firestore Database
   - Create database in "Test mode"

### 2. Project Setup (1 minute)

1. Clone/Open this project in Android Studio
2. Copy `google-services.json` to `app/` folder
3. Sync Gradle files

### 3. Run the App (1 minute)

1. Click Run button in Android Studio
2. Select your device/emulator
3. Wait for app to install and launch

### 4. Test the App (1 minute)

**Register a User:**
- Email: `test@example.com`
- Password: `password123`
- Click "Register"

**Send Messages:**
- Type a message
- Click "Send"
- See it appear in real-time!

**Test on Multiple Devices:**
- Open app on another device
- Login with different account
- Messages sync in real-time!

## That's It! 🎉

You now have a working real-time chat app with Firebase!

## Next Steps

- Read [FIREBASE_SETUP.md](FIREBASE_SETUP.md) for detailed configuration
- Check [README.md](README.md) for full documentation
- Customize the UI and add features
- Take screenshots for your submission

## Common Issues

**App crashes?** → Check `google-services.json` is in `app/` folder

**Can't login?** → Verify Email/Password is enabled in Firebase Console

**No messages?** → Check internet connection and Firestore rules

## Need Help?

See [FIREBASE_SETUP.md](FIREBASE_SETUP.md) troubleshooting section or ask your instructor.
