# Scientific Calculator (NetBeans / Maven / JavaFX 8 version)

A scientific calculator written in Java with JavaFX (FXML), developed for a university course using **Apache NetBeans**.

This is the original version of the project: a NetBeans **Maven** project designed for **JDK 8 with JavaFX bundled**. With newer JDKs (11+), JavaFX is no longer part of the JDK, so running the project with them fails unless JavaFX is added separately.

## Requirements

| Component | Version |
|---|---|
| Apache NetBeans | 17 or later (tested with 31) |
| JDK to run NetBeans | Bundled with the installer from Friends of Apache NetBeans (Temurin 26), or any JDK 17+ |
| JDK to build and run the project | **JDK 8 with JavaFX** (e.g. Zulu JDK FX 8 or Liberica Full JDK 8) |

NetBeans and the project use two different JDKs: one runs the IDE, the other compiles and runs the calculator. Maven is already bundled with NetBeans, so you don't need to install it separately.

## 1. Install NetBeans

The easiest way is to use the ready-to-go installers from [Friends of Apache NetBeans](https://installers.friendsofapachenetbeans.org/). Each package includes Apache NetBeans together with a JDK (Temurin), so the IDE works out of the box and you don't need to install a separate JDK to run it.

Note that these are community builds, not official Apache Software Foundation releases. The official binaries are available at <https://netbeans.apache.org/front/main/download/>, but they require a JDK 17+ already installed on your system.

### Linux (Ubuntu/Debian)

Download the `.deb` package (x64) and install it:

```bash
sudo apt install ./apache-netbeans_31-1_amd64.deb
```

### Windows

Download and run `Apache-NetBeans-31.exe`, then follow the setup wizard.

### macOS

Download the `.pkg` for your architecture (Apple Silicon or Intel) and open it.

> This JDK is only used to run the IDE. The calculator needs a separate **JDK 8 with JavaFX**, installed in the next step.

## 2. Install a JDK 8 with JavaFX

### Linux / macOS with SDKMAN (recommended)

```bash
curl -s "https://get.sdkman.io" | bash
source ~/.sdkman/bin/sdkman-init.sh
sdk list java | grep -i "fx"
sdk install java 8.0.502.fx-zulu
```

If the identifier `8.0.502.fx-zulu` is no longer available, pick any `8.0.xxx.fx-zulu` version from the list.

When asked **"Set as default?"**, answer `n`. If it ends up being set as default anyway (this happens with some SDKMAN versions), go back to your system Java with:

```bash
rm ~/.sdkman/candidates/java/current
hash -r
```

then open a new terminal.

The JDK is installed in:

```
~/.sdkman/candidates/java/8.0.502.fx-zulu
```

Check that JavaFX is included:

```bash
find ~/.sdkman/candidates/java/8.0.502.fx-zulu -name "jfxrt.jar"
```

It should print a path like `.../jre/lib/ext/jfxrt.jar`.

### Manual installation (any OS)

1. Go to <https://www.azul.com/downloads/> and filter by: **Java 8**, your operating system, **JDK FX**.
2. Download the archive (`.tar.gz`, `.zip` or installer) and extract it to a stable folder, e.g. `~/jdks/` or `C:\Java\`.
3. Make sure `jre/lib/ext/jfxrt.jar` exists inside the extracted folder.

Alternatively, you can use **BellSoft Liberica Full JDK 8**, which also includes JavaFX.

## 3. Register the JDK 8 in NetBeans

1. Start NetBeans.
2. **Tools → Java Platforms → Add Platform...**
3. Choose **Java Standard Edition** and click Next.
4. Select the **root folder** of the JDK 8 (not `jfxrt.jar` and not the `jre` subfolder), for example:
```
   /home/<user>/.sdkman/candidates/java/8.0.502.fx-zulu
```
   Folders starting with a dot are hidden: type the path manually in the *File Name* field.
5. Next → Finish. **JDK 1.8** will appear in the list.
6. Close.

## 4. Open the project

1. Clone the repository and navigate into the version folder:
```bash
   git clone <repository-url>
   cd scientific-calculator/v1_Netbeans
```
2. In NetBeans: **File → Open Project...**
3. Select the v1_Netbeans folder (the one containing pom.xml, with the Maven icon) and click Open Project.

## 5. Configure the project

Right-click the project → **Properties**:

- **Build → Compile → Java Platform**: `JDK 1.8`

Then:

1. **Run → Clean and Build Project**. The *Output* panel should end with `BUILD SUCCESS`.
2. **Run → Run Project** to start the calculator.

The main class is `Calcolatrice.ScientificCalculator`, already configured in `pom.xml`.

> During the build you may see the warning `Parameter 'mainClass' is unknown for plugin 'maven-compiler-plugin'`. It is harmless and does not affect the build.

## Troubleshooting

**`Error: JavaFX runtime components are missing, and are required to run this application`**
The project is being run with a JDK that does not include JavaFX (typically the JDK bundled with NetBeans). In *Properties → Build → Compile*, set **Java Platform** to `JDK 1.8` (the one with FX), then Clean and Build and run again.

**`JDK 1.8` does not appear in the Java Platform list**
Register it first (section 3) and check that the folder you selected contains `jre/lib/ext/jfxrt.jar`.

**Compilation errors such as `package javafx... does not exist`**
Same cause: the project is not using the JDK 8 with JavaFX.

**`java -version` shows Java 8 in every terminal**
SDKMAN set JDK 8 as the default. See the `rm ~/.sdkman/candidates/java/current` command in section 2.

## Project structure

```
.
├── .gitignore
└── v1_Netbeans/
    ├── pom.xml
    └── src/
        ├── main/
        │   ├── java/Calcolatrice/
        │   │   ├── Exceptions/          custom exceptions
        │   │   ├── Complex.java
        │   │   ├── FXMLDocumentController.java
        │   │   ├── Operation.java
        │   │   ├── Parser.java
        │   │   ├── ScientificCalculator.java
        │   │   ├── Stack.java
        │   │   └── VarMap.java
        │   └── resources/Calcolatrice/
        │       ├── FXMLDocument.fxml
        │       └── unisa.png
        └── test/java/Calcolatrice/      JUnit tests
```