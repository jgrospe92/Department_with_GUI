# Department System With GUI

# Table of Contents
- [Department System With GUI](#department-system-with-gui)
- [Table of Contents](#table-of-contents)
  - [How to Run the Program (mac)](#how-to-run-the-program-mac)
  - [How to Run the Program (windows)](#how-to-run-the-program-windows)
- [Project By](#project-by)
## How to Run the Program (mac)
- Mac Version (VSCODE)
 - Download java jdk  latest.
 - For M1 user download jdk v17 from Azul.com
 - Download the latest javafx SDK (18-ea+8) aarch64 from openjfx.io.
 - Extract it somewhere you can easily access.
 - Configure your Java-run time(cmd + shift + p) and make sure you are running the correct jdk.
 - Configure the launch.json.
   - Add this line to the configuration "vmArgs": "--module-path /path to your javafx lib --add-modules javafx.controls,javafx.fxml",
   - Be sure to put the right path.
 - In the bottom left you will see JAVA PROJECTS.
   - Navigate and look for the Referenced Libraries then click the plus sign to add your javafx jar files. There should be total of 8 jar files.
 - Run the App.java
  
## How to Run the Program (windows)
- Mac Version (VSCODE)
 - Download java jdk  latest.
 - Download the latest javafx SDK (18-ea+8) aarch64 from openjfx.io.
 - Extract it somewhere you can easily access.
 - Configure your Java-run time(ctrl + shift + p) and make sure you are running the correct jdk.
 - Configure the launch.json.
   - Add this line to the configuration  "vmArgs": "--module-path \"path to the javafx lib" --add-modules javafx.controls,javafx.fxml",
   - Be sure to put the right path.
 - In the bottom left you will see JAVA PROJECTS.
   - Navigate and look for the Referenced Libraries then click the plus sign to add your javafx jar files. There should be total of 8 jar files.
 - Run the App.java

## Project By
  -   Jeffrey
  -   Philip
