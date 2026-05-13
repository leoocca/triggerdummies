# Trigger APKs

Five invisible Android apps for use as automation triggers. Each app launches, immediately finishes, and shows no UI — but its launch is still registered by the OS, so macro apps like **Tasker**, **MacroDroid**, or **Automate** can fire on the "app launched" event.

Designed to be invoked by **Gemini** (or any voice assistant) using the app's display name: *"Open Trigger One"*, etc.

## What you get

Five APKs, each with a unique package name and label:

| App label     | Package name           | Output file                       |
|---------------|------------------------|-----------------------------------|
| Trigger One   | `com.triggers.one`     | `Trigger-Trigger1-release.apk`    |
| Trigger Two   | `com.triggers.two`     | `Trigger-Trigger2-release.apk`    |
| Trigger Three | `com.triggers.three`   | `Trigger-Trigger3-release.apk`    |
| Trigger Four  | `com.triggers.four`    | `Trigger-Trigger4-release.apk`    |
| Trigger Five  | `com.triggers.five`    | `Trigger-Trigger5-release.apk`    |

## How to build (no local install needed)

1. Create a new GitHub repo (public or private — both work).
2. Push this entire folder to it:
   ```
   git init
   git add .
   git commit -m "Initial commit"
   git branch -M main
   git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO.git
   git push -u origin main
   ```
3. Go to the **Actions** tab on GitHub. The "Build Trigger APKs" workflow will run automatically (~3–5 min).
4. When it's green, click the run, scroll to **Artifacts**, and download `trigger-apks.zip`.
5. Unzip — you'll have 5 APK files.

## How to install on your phone

1. Email or transfer the APKs to your phone.
2. Enable **Install unknown apps** for your file manager (Settings → Apps → [file manager] → Install unknown apps).
3. Tap each APK to install. They'll appear in your app drawer as Trigger One through Trigger Five with the default Android icon.

## How to use with Gemini + a macro app

1. In your macro app (Tasker / MacroDroid / Automate), create a profile triggered by **Application Launched** → pick e.g. *Trigger One*.
2. Set the action you want (toggle a switch, send an intent, run a Shortcut, etc.).
3. Tell Gemini: *"Open Trigger One"* — it'll launch the app, the launch is registered, the macro fires.

> **Tip:** Gemini sometimes asks "which app?" the first time. Pick the trigger app once and it usually remembers.

## Customizing names

Edit `app/build.gradle` — change the `resValue "string", "app_name", "..."` line in each flavor block. You can also change the `applicationId` if you want different package names. Push and the workflow rebuilds.

## Adding more triggers

Duplicate a `triggerN { ... }` block in `app/build.gradle` with a new flavor name, new applicationId, and new label. Up to ~20 flavors works fine.

## Notes

- APKs are signed with the **debug keystore** so they install cleanly without unsigned-package warnings. Fine for personal sideloading; not suitable for Play Store distribution (not the goal here).
- `Theme.NoDisplay` + `finish()` in `onCreate` means no window is ever drawn — no flash, no splash.
- minSdk 24 (Android 7.0+), targetSdk 34 (Android 14).
