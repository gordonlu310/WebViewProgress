# WebViewProgress
An App Inventor non-visible extension that detects the progress loading of the WebViewer.

Made by Gordon Lu (AICODE). For details, please read my website: https://sites.google.com/view/appinventor-aicode/my-extensions/webviewprogress

:date: Release date: March 8, 2022 8:20 AM (Asia/Hong_Kong)

:package: Package name: com.gordonlu.webviewprogress.aix

All language support: English, French

🕐 Version: 1

📖 **Documentation**

>**ProgressChanged** (**ProgressionModifiee**)
>
>![image](https://user-images.githubusercontent.com/88015331/157641268-61fe61fe-9c16-4cb1-bf10-66cdfa36319f.png)
>
>![image](https://user-images.githubusercontent.com/88015331/157641647-6e64f7ac-d821-4362-9aa6-e598e984fa7f.png)
>
>This event is fired when the progress of the WebViewer has changed.
>
>Note: currently, there still isn't a method to detect which WebViewer's progress has changed. Hence, better use one WebViewProgress extension for each WebViewer.
>
>*Parameters:* progress (progres) = number (int)

>**ApplyProgressChangedListener** (**SuivreLaProgression**)
>
>![image](https://user-images.githubusercontent.com/88015331/157641612-71eb7564-81cb-472d-b4ab-f7d1b0c79688.png)
>
>![image](https://user-images.githubusercontent.com/88015331/157641680-c33bdce0-6211-42f5-838f-5a779a6da45f.png)
>
>Listens to all web viewer loading changes and fires the ProgressChanged event when it changes.
>
>*Parameters:* webViewer (afficheurWeb) = component

📁 **Contributors**

- Taken from https://stackoverflow.com/a/47885692/17802442 in Stack Overflow. Thank you!
