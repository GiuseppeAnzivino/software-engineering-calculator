# Scientific Calculator (NetBeans / JavaFX 8 version)

A scientific calculator written in Java with JavaFX (FXML), developed for a university course using **Apache NetBeans**.

This is the "legacy" version: a NetBeans **Ant** project designed for **JDK 8 with JavaFX bundled**. With newer JDKs (11+), JavaFX is no longer part of the JDK and the project will not compile without changes.

## Requirements

| Component | Version |
|---|---|
| Apache NetBeans | 17 or later (tested with 31) |
| JDK to run NetBeans | Bundled with the installer from Friends of Apache NetBeans (Temurin 26), or any JDK 17+ |
| JDK to build the project | **JDK 8 with JavaFX** (e.g. Zulu JDK FX 8 or Liberica Full JDK 8) |

NetBeans and the project use two different JDKs: one runs the IDE, the other compiles and runs the calculator.

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

> This JDK is only used to run the IDE. The calculator project needs a separate **JDK 8 with JavaFX**, installed in the next step.

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

1. Clone the repository:
```bash
   git clone https://github.com/AldoBuongiorno/scientific-calculator.git
```
2. In NetBeans: **File → Open Project...**
3. Select the `ScientificCalculator` folder (the one with the NetBeans cup icon, **not** `nbproject`) and click *Open Project*.

> The **Projects** tab only shows *Source Packages* and *Libraries*. The `nbproject/` folder and `build.xml` are visible in the **Files** tab.

## 5. Configure the project

Right-click the project → **Properties**:

- **Libraries → Java Platform**: `JDK 1.8`
- **Libraries → Source/Binary Format**: `JDK 8`
- **Libraries → Classpath / Modulepath**: leave empty (JavaFX comes from JDK 8)
- **Run → Main Class**: `scientificcalculator.ScientificCalculator`

Then:

1. **Run → Clean and Build Project**. The *Output* panel should end with `BUILD SUCCESSFUL`.
2. **Run → Run Project** to start the calculator.

## Troubleshooting

**Red error icons on classes / `package javafx... does not exist`**
The project is using a JDK without JavaFX. In *Properties → Libraries*, check that the Java Platform is `JDK 1.8` (the one with FX).

**The "Browse JavaFX Application Classes" dialog is empty**
The build failed, so there are no classes to show. Fix the compilation errors first.

**NetBeans modifies `nbproject/project.properties` as soon as I open the project**
This happens when the project is opened with a JDK other than 8. Before committing, check with:
```bash
git diff ScientificCalculator/nbproject/project.properties
```
If it only contains local paths or lines added by the IDE, undo the changes with:
```bash
git restore ScientificCalculator/nbproject/project.properties
```

**`java -version` shows Java 8 in every terminal**
SDKMAN set JDK 8 as the default. See the `rm ~/.sdkman/candidates/java/current` command in section 2.

## Project structure

```
ScientificCalculator/
├── nbproject/                  NetBeans (Ant) configuration
├── src/
│   ├── scientificcalculator/   main application
│   └── fxmlprove/              FXML experiments
├── build.xml
└── manifest.mf
```