# Scientific Calculator (Executable JAR version)

This folder contains the **ready-to-run** version of the Scientific Calculator, packaged as an executable JAR. No IDE, Maven or build step is needed: just a Java runtime with JavaFX.

For the source code and build instructions, see `v1_Netbeans` (NetBeans) and `v2_VSCode` (VS Code / Maven).

## Contents

| File | Purpose |
|---|---|
| `ScientificCalculator.jar` | The executable application |
| `ScientificCalculator.bat` | Launcher for **Windows** (double-click) |
| `ScientificCalculator.command` | Launcher for **macOS** (double-click) |
| `ScientificCalculator.desktop` | Launcher for **Linux** (desktop entry) |

## Requirements

| Component | Version |
|---|---|
| Java runtime | **JRE/JDK 8 with JavaFX** (e.g. Zulu JDK FX 8 or Liberica Full JDK 8) |

The application uses JavaFX, which is **not** included in standard JDK/JRE distributions after Java 8. A regular system Java (e.g. OpenJDK 11/17/21) will fail to start the application.

To install a JDK 8 with JavaFX, follow section 2 of the `v2_VSCode` README (SDKMAN or manual installation from <https://www.azul.com/downloads/>).

Check that JavaFX is included:

```bash
find <path-to-jdk> -name "jfxrt.jar"
```

It should print a path like `.../jre/lib/ext/jfxrt.jar`.

## Running the application

### From the terminal (any OS)

Make sure `java -version` reports a JDK 8 with JavaFX, then:

```bash
java -jar ScientificCalculator.jar
```

If you installed the JDK with SDKMAN and did not set it as default:

```bash
sdk use java 8.0.502.fx-zulu
java -jar ScientificCalculator.jar
```

### Windows

Double-click `ScientificCalculator.bat`.

### macOS

Double-click `ScientificCalculator.command`.

If macOS blocks it because it comes from an unidentified developer, right-click the file, choose **Open**, then confirm. If it does not run, make it executable first:

```bash
chmod +x ScientificCalculator.command
```

### Linux

Make the launcher executable and run it:

```bash
chmod +x ScientificCalculator.desktop
./ScientificCalculator.desktop
```

On some desktop environments you also need to right-click the file and choose **Allow Launching** (GNOME) before it can be started by double-click.

## Troubleshooting

**`Error: JavaFX runtime components are missing, and are required to run this application`**
Java is running with a JDK that does not include JavaFX. Use a JDK 8 with JavaFX (see Requirements) and check it with `java -version`.

**The launcher does nothing or closes immediately**
Run `java -jar ScientificCalculator.jar` from a terminal in this folder to see the error message.

**`Permission denied` on `.command` or `.desktop`**
The file is not executable. Run `chmod +x <file>`.

**`java: command not found`**
Java is not installed or not in your `PATH`. Install a JDK 8 with JavaFX (see Requirements).

## Notes

This version contains **only the compiled application**: the source code is unchanged and lives in the `v1_Netbeans` and `v2_VSCode` folders. To modify or rebuild the project, use one of those versions.