# GitHub Submission Checklist

Use this checklist to ensure your project meets all requirements before submission.

## ✅ Required Files

- [ ] `README.md` - Complete project documentation
- [ ] `app/` folder - Source code
- [ ] `screenshots/` folder with:
  - [ ] `login_screen.png`
  - [ ] `chat_screen.png`
  - [ ] `firestore_console.png`
- [ ] `.gitignore` - Properly configured (excludes google-services.json)
- [ ] `FIREBASE_SETUP.md` - Setup instructions
- [ ] `google-services.json.template` - Template file (NOT actual config)

## ✅ Functional Requirements

- [ ] Firebase project created and configured
- [ ] User authentication implemented:
  - [ ] Email/Password registration
  - [ ] Email/Password login
  - [ ] Anonymous authentication
- [ ] Basic chat UI:
  - [ ] Login screen
  - [ ] Chat screen
  - [ ] Message input field
  - [ ] Send button
  - [ ] Message list (RecyclerView)
- [ ] Real-time message display
- [ ] Sender name/email shown
- [ ] Message timestamps displayed
- [ ] Logout functionality

## ✅ Code Quality

- [ ] Code is properly formatted
- [ ] No compilation errors
- [ ] No hardcoded sensitive data
- [ ] Proper package structure
- [ ] ViewBinding used correctly
- [ ] Firebase SDK properly integrated

## ✅ Documentation

- [ ] README.md includes:
  - [ ] Project description
  - [ ] Features list
  - [ ] Technologies used
  - [ ] Setup instructions
  - [ ] Firebase configuration steps
  - [ ] Usage guide
  - [ ] Screenshots
  - [ ] Project structure
  - [ ] Author information
- [ ] Code comments where necessary
- [ ] Clear variable and function names

## ✅ Firebase Configuration

- [ ] Firebase project created
- [ ] Android app registered in Firebase
- [ ] Authentication enabled (Email/Password + Anonymous)
- [ ] Firestore database created
- [ ] Security rules configured
- [ ] `google-services.json` downloaded (but NOT committed to repo)

## ✅ Screenshots

- [ ] Login screen screenshot taken
- [ ] Chat screen with messages screenshot taken
- [ ] Firestore console screenshot taken
- [ ] All screenshots are clear and readable
- [ ] Screenshots placed in `screenshots/` folder
- [ ] No sensitive information visible in screenshots

## ✅ Git & GitHub

- [ ] Repository created: `MobileDev-[YourName]`
- [ ] All files committed
- [ ] `google-services.json` NOT committed (check .gitignore)
- [ ] Repository pushed to GitHub
- [ ] Repository is accessible (public or shared with instructor)
- [ ] Commit messages are clear and descriptive

## ✅ Testing

- [ ] App builds successfully
- [ ] App runs without crashes
- [ ] Registration works
- [ ] Login works
- [ ] Anonymous login works
- [ ] Messages can be sent
- [ ] Messages appear in real-time
- [ ] Messages stored in Firestore
- [ ] Logout works
- [ ] Tested on emulator/device

## ✅ Security

- [ ] Firestore security rules implemented
- [ ] Only authenticated users can access chat
- [ ] No API keys in source code
- [ ] `google-services.json` in .gitignore
- [ ] No sensitive data committed

## ✅ Optional Features (Bonus)

- [ ] User profile display
- [ ] Message deletion
- [ ] Image sharing
- [ ] Push notifications
- [ ] Typing indicators
- [ ] Online status
- [ ] Private messaging
- [ ] Message search

## 📝 Pre-Submission Steps

1. **Clean Build**
   ```bash
   ./gradlew clean
   ./gradlew build
   ```

2. **Test on Fresh Device**
   - Uninstall app
   - Reinstall and test all features

3. **Verify Screenshots**
   - Check all 3 screenshots are present
   - Ensure they're properly named
   - Verify they're clear and readable

4. **Review README**
   - Update author name
   - Update GitHub username
   - Add student ID
   - Check all links work

5. **Final Git Check**
   ```bash
   git status
   git log --oneline
   ```

6. **Push to GitHub**
   ```bash
   git add .
   git commit -m "Final submission: Firebase Chat App"
   git push origin main
   ```

## 📤 Submission

- [ ] GitHub repository URL submitted
- [ ] Repository is accessible
- [ ] All requirements met
- [ ] Screenshots visible in repository
- [ ] README.md displays correctly on GitHub

## 🎯 Grading Criteria Reference

Based on the handout requirements:

1. **Firebase Integration (30%)**
   - Project created and connected ✓
   - Authentication working ✓
   - Firestore configured ✓

2. **Functionality (40%)**
   - User can register/login ✓
   - Messages can be sent ✓
   - Messages display in real-time ✓
   - Basic UI implemented ✓

3. **Documentation (20%)**
   - README.md complete ✓
   - Setup instructions clear ✓
   - Screenshots included ✓

4. **Code Quality (10%)**
   - Clean code structure ✓
   - Proper naming conventions ✓
   - No errors ✓

## ✨ Final Check

Before submitting, ask yourself:

- Can someone clone my repo and run the app by following my README?
- Are all screenshots present and clear?
- Is my code clean and well-organized?
- Have I tested all features?
- Is my Firebase project properly configured?

If you answered YES to all questions, you're ready to submit! 🚀

---

**Good luck with your submission!** 🎓
