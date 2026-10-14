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

# Scientific Calculator - Software Engineering Project (Group 06)

## UML Class Diagram

The repository includes the original `.cdg` class diagram file (`UML/CalcolatriceScientifica_ProgettoIngSW_Gruppo06.cdg`) located under the legacy NetBeans project folder. Since modern versions of Apache NetBeans no longer support the legacy visual UML plugin, this file is preserved strictly as a historical artifact (opening as raw XML).

### Modern Class Diagram Generation
To provide an accurate and up-to-date visual representation of the current codebase without manual transcription errors, the class diagram was reverse-engineered directly from the Java source files (`v1_Netbeans/src/main/java/Calcolatrice`) using the **UML Generator for Java** extension in VS Code.

The structure extracted has been mapped to the **Mermaid** diagram below for native rendering on GitHub:

```mermaid
classDiagram
    direction TB

    class Operation {
        -Deque~Complex~ stack
        +Operation(Deque~Complex~ stack)
        +insert(Complex num) void
        +add() void
        +sub() void
        +times() void
        +division() void
        +sqrt() void
        +reverse() void
    }

    class OverflowException {
        +OverflowException()
        +OverflowException(String msg)
    }

    class InputException {
        +InputException()
        +InputException(String msg)
    }

    class EmptyStackException {
        +EmptyStackException()
        +EmptyStackException(String msg)
    }

    class ArithmeticException {
        +ArithmeticException()
        +ArithmeticException(String msg)
    }

    class VarException {
        +VarException()
        +VarException(String msg)
    }

    class Parser {
        -Stack buffer
        -VarMap variable
        -Operation operation
        +Parser(Deque~Complex~ stack)
        +isComplex(String s) String
        +isRealPart(String s) String
        +isJPart(String s) String
        +parse(String input, String svolgi) void
        +checkerNumber(String s) void
        +checkerVar(String s) void
        +varMapToString() String
    }

    class FXMLDocumentController {
        -Deque~Complex~ stack
        -Parser parser
        -TextArea TextStandard
        -TextArea labelStandard
        -TextArea TextVariabili
        -TextArea labelVariabili
        -TextArea StackStandard
        ~initialize() void
        ~pointAction(ActionEvent event) void
        ~zeroAction(ActionEvent event) void
        ~oneAction(ActionEvent event) void
        ~twoAction(ActionEvent event) void
        ~threeAction(ActionEvent event) void
        ~fourAction(ActionEvent event) void
        ~fiveAction(ActionEvent event) void
        ~sixAction(ActionEvent event) void
        ~sevenAction(ActionEvent event) void
        ~eightAction(ActionEvent event) void
        ~nineAction(ActionEvent event) void
        ~addAction(ActionEvent event) void
        ~subAction(ActionEvent event) void
        ~reverseAction(ActionEvent event) void
        ~divAction(ActionEvent event) void
        ~timesAction(ActionEvent event) void
        ~sqrtAction(ActionEvent event) void
        ~clearAction(ActionEvent event) void
        ~dropAction(ActionEvent event) void
        ~dupAction(ActionEvent event) void
        ~swapAction(ActionEvent event) void
        ~overAction(ActionEvent event) void
        ~delAction(ActionEvent event) void
        ~acAction(ActionEvent event) void
        ~enterAction(ActionEvent event) void
        ~ac1Action(ActionEvent event) void
        ~posAction(ActionEvent event) void
        ~negAction(ActionEvent event) void
        ~aAction(ActionEvent event) void
        ~bAction(ActionEvent event) void
        ~cAction(ActionEvent event) void
        ~dAction(ActionEvent event) void
        ~eAction(ActionEvent event) void
        ~fAction(ActionEvent event) void
        ~gAction(ActionEvent event) void
        ~hAction(ActionEvent event) void
        ~iAction(ActionEvent event) void
        ~jAction(ActionEvent event) void
        ~kAction(ActionEvent event) void
        ~lAction(ActionEvent event) void
        ~mAction(ActionEvent event) void
        ~nAction(ActionEvent event) void
        ~oAction(ActionEvent event) void
        ~pAction(ActionEvent event) void
        ~qAction(ActionEvent event) void
        ~rAction(ActionEvent event) void
        ~sAction(ActionEvent event) void
        ~tAction(ActionEvent event) void
        ~uAction(ActionEvent event) void
        ~vAction(ActionEvent event) void
        ~wAction(ActionEvent event) void
        ~xAction(ActionEvent event) void
        ~yAction(ActionEvent event) void
        ~zAction(ActionEvent event) void
        ~varToStackAction(ActionEvent event) void
        ~stackToVarAction(ActionEvent event) void
        ~addVarAction(ActionEvent event) void
        ~subVarAction(ActionEvent event) void
        +toString() String
    }

    class Complex {
        -double realPart
        -double jPart
        +Complex(double realPart, double jPart)
        +getRealPart() double
        +getJPart() double
        +toString() String
        -round(double n) double
        +isZero() boolean
        +add(Complex num) Complex
        +sub(Complex num) Complex
        +times(Complex num) Complex
        +division(Complex num) Complex
        +sqrt() Complex
        +reverse() Complex
    }

    class Stack {
        -Deque~Complex~ stack
        +Stack(Deque~Complex~ stack)
        +clear() void
        +drop() void
        +dup() void
        +swap() void
        +over() void
    }

    class ScientificCalculator {
        +start(Stage stage) void
        +main(String[] args) void
    }

    class VarMap {
        -TreeMap~Character, Complex~ variable
        -Deque~Complex~ stack
        +VarMap(Deque~Complex~ stack)
        +getValue(char key) Complex
        +stackToVar(char key) void
        +varToStack(char key) void
        +addVar(char key) void
        +subVar(char key) void
        +toString() String
    }

    Operation o-- Complex
    Parser *-- Stack
    Parser *-- VarMap
    Parser *-- Operation
    FXMLDocumentController o-- Complex
    FXMLDocumentController *-- Parser
    Complex ..> Complex
    Stack o-- Complex
    VarMap o-- Complex