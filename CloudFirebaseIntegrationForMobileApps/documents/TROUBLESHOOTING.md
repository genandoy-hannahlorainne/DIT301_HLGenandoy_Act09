# Troubleshooting Guide

Common issues and their solutions for the Firebase Chat App.

## Build & Setup Issues

### ❌ Error: "google-services.json not found"

**Symptoms:**
- Build fails with missing google-services.json error
- Gradle sync fails

**Solutions:**
1. Download `google-services.json` from Firebase Console
2. Place it in `app/` directory (NOT project root)
3. File structure should be:
   ```
   YourProject/
   ├── app/
   │   ├── google-services.json  ← HERE
   │   └── build.gradle.kts
   └── build.gradle.kts
   ```
4. Sync Gradle files again

---

### ❌ Error: "Default FirebaseApp is not initialized"

**Symptoms:**
- App crashes on startup
- Error in Logcat about FirebaseApp

**Solutions:**
1. Verify `google-services.json` is in correct location
2. Check that plugin is applied in `app/build.gradle.kts`:
   ```kotlin
   plugins {
       id("com.google.gms.google-services")
   }
   ```
3. Clean and rebuild:
   ```bash
   ./gradlew clean
   ./gradlew build
   ```
4. Restart Android Studio

---

### ❌ Error: "Failed to resolve: com.google.firebase:firebase-..."

**Symptoms:**
- Gradle sync fails
- Firebase dependencies not found

**Solutions:**
1. Check internet connection
2. Add Google repository in `settings.gradle.kts`:
   ```kotlin
   dependencyResolutionManagement {
       repositories {
           google()
           mavenCentral()
       }
   }
   ```
3. Sync Gradle files
4. Invalidate caches: File → Invalidate Caches → Invalidate and Restart

---

## Authentication Issues

### ❌ Error: "Authentication failed" or "Sign-in failed"

**Symptoms:**
- Login/Register buttons don't work
- Error toast appears
- User not authenticated

**Solutions:**
1. **Check Firebase Console:**
   - Go to Authentication → Sign-in method
   - Verify Email/Password is ENABLED
   - Verify Anonymous is ENABLED (if using guest mode)

2. **Check Internet Connection:**
   - Ensure device/emulator has internet access
   - Test with browser

3. **Check Email Format:**
   - Use valid email format: `user@example.com`
   - Password must be at least 6 characters

4. **Check Logcat:**
   - Look for specific error messages
   - Common errors:
     - "INVALID_EMAIL" → Fix email format
     - "WEAK_PASSWORD" → Use longer password
     - "EMAIL_EXISTS" → User already registered

---

### ❌ Error: "User is null after authentication"

**Symptoms:**
- Authentication succeeds but user is null
- Can't access user email

**Solutions:**
1. Check authentication state:
   ```kotlin
   val currentUser = FirebaseAuth.getInstance().currentUser
   if (currentUser != null) {
       // User is signed in
   }
   ```
2. Wait for authentication to complete before accessing user
3. Use `addOnCompleteListener` properly

---

## Firestore Issues

### ❌ Error: "PERMISSION_DENIED: Missing or insufficient permissions"

**Symptoms:**
- Can't read or write messages
- Firestore operations fail
- Error in Logcat about permissions

**Solutions:**
1. **Check Security Rules:**
   - Go to Firebase Console → Firestore Database → Rules
   - Verify rules allow authenticated access:
   ```javascript
   rules_version = '2';
   service cloud.firestore {
     match /databases/{database}/documents {
       match /chats/{messageId} {
         allow read, write: if request.auth != null;
       }
     }
   }
   ```
   - Click "Publish"

2. **Check Authentication:**
   - Ensure user is logged in before accessing Firestore
   - Verify `FirebaseAuth.getInstance().currentUser != null`

3. **Check Collection Name:**
   - Ensure you're using "chats" collection (matches security rules)

---

### ❌ Messages don't appear in real-time

**Symptoms:**
- Messages only appear after app restart
- No real-time updates
- Have to refresh manually

**Solutions:**
1. **Check Listener Setup:**
   ```kotlin
   firestore.collection("chats")
       .orderBy("timestamp", Query.Direction.ASCENDING)
       .addSnapshotListener { snapshots, error ->
           // Handle updates
       }
   ```

2. **Check Internet Connection:**
   - Real-time requires active connection
   - Test on different network

3. **Check Firestore Rules:**
   - Ensure read permission is granted

4. **Check Logcat:**
   - Look for listener errors
   - Check for network errors

---

### ❌ Messages appear in wrong order

**Symptoms:**
- Newest messages at top instead of bottom
- Random message order

**Solutions:**
1. **Add Timestamp Index:**
   - Go to Firebase Console → Firestore Database → Indexes
   - Create index on "chats" collection, "timestamp" field

2. **Check Query:**
   ```kotlin
   .orderBy("timestamp", Query.Direction.ASCENDING)
   ```

3. **Ensure Timestamp is Set:**
   ```kotlin
   "timestamp" to System.currentTimeMillis()
   ```

---

## UI Issues

### ❌ RecyclerView doesn't show messages

**Symptoms:**
- Chat screen is blank
- Messages in Firestore but not displayed

**Solutions:**
1. **Check Adapter Setup:**
   ```kotlin
   chatAdapter = ChatAdapter(messages)
   recyclerView.adapter = chatAdapter
   recyclerView.layoutManager = LinearLayoutManager(this)
   ```

2. **Check Data Binding:**
   - Verify ViewBinding is enabled
   - Check layout file exists

3. **Check notifyDataSetChanged:**
   ```kotlin
   messages.clear()
   messages.addAll(newMessages)
   chatAdapter.notifyDataSetChanged()
   ```

4. **Check Layout Visibility:**
   - Ensure RecyclerView is visible
   - Check constraints in layout file

---

### ❌ Keyboard covers input field

**Symptoms:**
- Can't see what you're typing
- Input field hidden behind keyboard

**Solutions:**
1. **Add to AndroidManifest.xml:**
   ```xml
   <activity
       android:name=".ChatActivity"
       android:windowSoftInputMode="adjustResize" />
   ```

2. **Or use:**
   ```xml
   android:windowSoftInputMode="adjustPan"
   ```

---

## Runtime Issues

### ❌ App crashes on send button click

**Symptoms:**
- App crashes when sending message
- Error in Logcat

**Solutions:**
1. **Check Null Safety:**
   ```kotlin
   val currentUser = auth.currentUser ?: return
   val messageText = binding.etMessage.text.toString()
   if (messageText.isEmpty()) return
   ```

2. **Check Firestore Initialization:**
   ```kotlin
   firestore = FirebaseFirestore.getInstance()
   ```

3. **Check Button Listener:**
   ```kotlin
   binding.btnSend.setOnClickListener {
       sendMessage()
   }
   ```

---

### ❌ App crashes on startup

**Symptoms:**
- App immediately crashes after launch
- Error in Logcat

**Solutions:**
1. **Check Logcat for Stack Trace:**
   - Look for the actual error message
   - Find the line number causing crash

2. **Common Causes:**
   - Missing `google-services.json`
   - ViewBinding not initialized
   - Firebase not initialized
   - Layout file missing

3. **Debug Steps:**
   ```kotlin
   try {
       // Your code
   } catch (e: Exception) {
       Log.e("ChatApp", "Error: ${e.message}", e)
   }
   ```

---

## Network Issues

### ❌ "Unable to resolve host" error

**Symptoms:**
- Network operations fail
- Can't connect to Firebase

**Solutions:**
1. **Check Internet Permission:**
   ```xml
   <uses-permission android:name="android.permission.INTERNET" />
   ```

2. **Check Network Connection:**
   - Enable WiFi/Mobile data
   - Test with browser

3. **Check Emulator Network:**
   - Restart emulator
   - Check emulator network settings

---

## Testing Issues

### ❌ Can't test real-time sync

**Symptoms:**
- Only have one device
- Can't see real-time updates

**Solutions:**
1. **Use Multiple Emulators:**
   - Create 2 AVDs in Android Studio
   - Run app on both
   - Login with different accounts

2. **Use Emulator + Physical Device:**
   - Run on emulator and phone simultaneously

3. **Use Firebase Console:**
   - Manually add messages in Firestore
   - Watch them appear in app

---

## Debugging Tips

### Enable Detailed Logging

```kotlin
// In your Activity
companion object {
    private const val TAG = "ChatActivity"
}

// Use throughout code
Log.d(TAG, "Sending message: $messageText")
Log.e(TAG, "Error: ${e.message}", e)
```

### Check Firebase Console

1. **Authentication:**
   - See registered users
   - Check authentication methods

2. **Firestore:**
   - View stored messages
   - Check data structure
   - Verify timestamps

3. **Usage:**
   - Monitor read/write operations
   - Check for errors

### Use Android Studio Debugger

1. Set breakpoints in your code
2. Run in debug mode
3. Step through code execution
4. Inspect variable values

---

## Still Having Issues?

1. **Check Logcat:**
   - Filter by your package name
   - Look for red error messages
   - Read stack traces carefully

2. **Clean and Rebuild:**
   ```bash
   ./gradlew clean
   ./gradlew build
   ```

3. **Invalidate Caches:**
   - File → Invalidate Caches → Invalidate and Restart

4. **Check Firebase Status:**
   - Visit [Firebase Status Dashboard](https://status.firebase.google.com/)

5. **Review Documentation:**
   - [Firebase Android Docs](https://firebase.google.com/docs/android/setup)
   - [Firestore Docs](https://firebase.google.com/docs/firestore)

6. **Ask for Help:**
   - Provide error messages from Logcat
   - Describe what you've tried
   - Share relevant code snippets
   - Contact instructor or TA

---

## Prevention Tips

✅ **Always check Logcat** - Most errors have clear messages

✅ **Test incrementally** - Test each feature as you build it

✅ **Use try-catch** - Handle errors gracefully

✅ **Validate input** - Check for null/empty values

✅ **Follow setup guide** - Don't skip steps

✅ **Keep Firebase Console open** - Monitor data in real-time

✅ **Use version control** - Commit working code frequently

---

**Remember:** Most issues are configuration-related. Double-check your Firebase setup! 🔧
