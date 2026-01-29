# Firebase Setup Guide

Complete step-by-step guide to set up Firebase for this chat application.

## Step 1: Create Firebase Project

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Click **"Add project"** or **"Create a project"**
3. Enter project name: `firebase-chat-app` (or your preferred name)
4. Click **Continue**
5. (Optional) Enable Google Analytics
6. Click **Create project**
7. Wait for project creation to complete
8. Click **Continue**

## Step 2: Add Android App to Firebase

1. In Firebase Console, click the **Android icon** to add an Android app
2. Enter the following details:
   - **Android package name**: `com.example.cloudfirebaseintegrationformobileapps`
   - **App nickname** (optional): `Firebase Chat App`
   - **Debug signing certificate SHA-1** (optional for now)
3. Click **Register app**

## Step 3: Download Configuration File

1. Click **Download google-services.json**
2. Save the file
3. Copy `google-services.json` to your project's `app/` directory
   ```
   YourProject/
   └── app/
       └── google-services.json  ← Place here
   ```
4. Click **Next** and **Continue to console**

## Step 4: Enable Firebase Authentication

1. In Firebase Console, click **Authentication** in the left menu
2. Click **Get started** (if first time)
3. Go to **Sign-in method** tab
4. Enable **Email/Password**:
   - Click on **Email/Password**
   - Toggle **Enable** switch
   - Click **Save**
5. Enable **Anonymous**:
   - Click on **Anonymous**
   - Toggle **Enable** switch
   - Click **Save**

## Step 5: Create Firestore Database

1. In Firebase Console, click **Firestore Database** in the left menu
2. Click **Create database**
3. Select **Start in test mode** (for development)
   - This allows read/write access for 30 days
   - We'll update security rules later
4. Click **Next**
5. Choose a **Cloud Firestore location** (closest to your users)
6. Click **Enable**
7. Wait for database creation

## Step 6: Configure Firestore Security Rules

1. In Firestore Database, click the **Rules** tab
2. Replace the default rules with:

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Allow authenticated users to read and write to chats collection
    match /chats/{messageId} {
      allow read: if request.auth != null;
      allow write: if request.auth != null 
                   && request.resource.data.sender is string
                   && request.resource.data.message is string
                   && request.resource.data.timestamp is number;
    }
  }
}
```

3. Click **Publish**

### Security Rules Explanation:
- `request.auth != null` - Only authenticated users can access
- Validates that messages have required fields (sender, message, timestamp)
- Prevents unauthorized data manipulation

## Step 7: (Optional) Enable Firebase Cloud Messaging

1. In Firebase Console, click **Cloud Messaging** in the left menu
2. Note your **Server key** and **Sender ID** for future use
3. No additional setup required for basic functionality

## Step 8: Verify Setup in Android Studio

1. Open your project in Android Studio
2. Ensure `google-services.json` is in the `app/` folder
3. Sync Gradle files (File → Sync Project with Gradle Files)
4. Build the project
5. Run the app on an emulator or device

## Step 9: Test the Application

### Test Authentication:
1. Launch the app
2. Click **Register** with a test email and password
3. Verify successful registration and navigation to chat screen

### Test Anonymous Login:
1. Logout from the app
2. Click **Continue as Guest**
3. Verify successful login

### Test Chat Functionality:
1. Send a test message
2. Verify message appears in the chat
3. Check Firebase Console → Firestore Database → chats collection
4. Verify message is stored with correct fields

### Test Real-Time Sync:
1. Open app on two devices/emulators
2. Login with different accounts
3. Send message from one device
4. Verify it appears on the other device in real-time

## Troubleshooting

### Issue: "google-services.json not found"
**Solution**: Ensure the file is in `app/` directory, not in project root

### Issue: "Default FirebaseApp is not initialized"
**Solution**: 
- Check that `google-services.json` is present
- Verify `google-services` plugin is applied in `app/build.gradle.kts`
- Clean and rebuild project

### Issue: Authentication fails
**Solution**:
- Verify Email/Password is enabled in Firebase Console
- Check internet connection
- Review error messages in Logcat

### Issue: Firestore permission denied
**Solution**:
- Verify security rules are published
- Ensure user is authenticated before accessing Firestore
- Check that rules allow authenticated access

### Issue: Messages don't appear in real-time
**Solution**:
- Check internet connection
- Verify Firestore listener is properly set up
- Check Logcat for errors

## Production Considerations

Before deploying to production:

1. **Update Security Rules**:
   - Implement more restrictive rules
   - Add user-specific permissions
   - Validate data more thoroughly

2. **Environment Configuration**:
   - Use different Firebase projects for dev/staging/prod
   - Never commit `google-services.json` to public repos
   - Add to `.gitignore`

3. **Enable App Check**:
   - Protect against abuse
   - Verify requests come from your app

4. **Monitor Usage**:
   - Set up billing alerts
   - Monitor Firestore usage
   - Track authentication metrics

## Additional Resources

- [Firebase Documentation](https://firebase.google.com/docs)
- [Firebase Android Setup](https://firebase.google.com/docs/android/setup)
- [Firestore Security Rules](https://firebase.google.com/docs/firestore/security/get-started)
- [Firebase Authentication](https://firebase.google.com/docs/auth)

## Support

If you encounter issues:
1. Check Firebase Console for error messages
2. Review Android Studio Logcat
3. Consult Firebase documentation
4. Ask your instructor or teaching assistant
