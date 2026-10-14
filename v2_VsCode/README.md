# Scientific Calculator (Visual Studio Code / Maven version)

A scientific calculator written in Java with JavaFX (FXML), developed for a university course.

This is the **second version** of the project: it is designed to be opened, built and run with **Visual Studio Code** and **Maven** on **Linux**.

## Why this version exists

The first version (`v1_Netbeans`) was developed with Apache NetBeans. On Linux, running it ran into incompatibilities between the JavaFX version, the JDK and the operating system, which made the project hard to build and launch reliably from the IDE.

To solve this, the **original `pom.xml` was modified** and the project was moved to Visual Studio Code, with Maven used directly from the terminal:

- The JavaFX and build configuration in the `pom.xml` was adapted for Linux.
- The **`javafx-maven-plugin`** was added, so the application can be launched with `mvn javafx:run`, using `Calcolatrice.ScientificCalculator` as main class.

The application source code (calculator, parser, stack, variables, etc.) **does not change**: only the way the project is configured, built and run changes.

## Requirements

| Component | Version |
|---|---|
| Visual Studio Code | latest stable version |
| JDK to build and run the project | **JDK 8 with JavaFX** (e.g. Zulu JDK FX 8 or Liberica Full JDK 8) |
| Maven | 3.6 or later (installed with `apt`) |

Unlike the NetBeans version, Maven is not bundled with the IDE, so it must be installed separately (see section 4).

## 1. Install Visual Studio Code

### Linux (Ubuntu/Debian)

Download the `.deb` package (x64) from <https://code.visualstudio.com/download> and install it:

```bash
sudo apt install ./code_*_amd64.deb
```

Alternatively, with snap:

```bash
sudo snap install code --classic
```

### Windows

Download and run the installer from <https://code.visualstudio.com/download>, then follow the setup wizard.

### macOS

Download the `.zip` for your architecture (Apple Silicon or Intel), extract it and drag **Visual Studio Code** into the *Applications* folder.

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

## 3. Install the VS Code extensions

Start VS Code, open the **Extensions** view (`Ctrl+Shift+X`) and install:

| Extension | Purpose |
|---|---|
| **Extension Pack for Java** (Microsoft) | Java support: editor, debugging, JUnit tests, project management. Includes *Maven for Java* |
| **UML Generator for Java** | Generates the class diagram from the source code (optional) |
| **Markdown Preview Mermaid Support** | Preview of Mermaid diagrams in `.md` files (optional) |

The main extensions can also be installed from the terminal:

```bash
code --install-extension vscjava.vscode-java-pack
code --install-extension bierner.markdown-mermaid
```

Restart VS Code when the installation is finished.

## 4. Install Maven

```bash
sudo apt update
sudo apt install maven
```

Check the installation:

```bash
mvn -version
```

## 5. Open the project

1. Clone the repository and navigate into the version folder:
```bash
   git clone <repository-url>
   cd scientific-calculator/v2_VSCode
```
2. In VS Code: **File → Open Folder...**
3. Select the v2_VSCode folder (the one containing pom.xml) and click OK.

If VS Code asks *"Do you trust the authors of the files in this folder?"*, choose **Yes, I trust the authors**. The first time, the Java extension imports the Maven project: wait until the status bar at the bottom no longer shows any operation in progress.

## 6. Build and run the project

Open the integrated terminal (**Terminal → New Terminal**). It must be opened in the folder containing `pom.xml`, and it must use the **JDK 8 with JavaFX** installed in section 2. If you installed it with SDKMAN and did not set it as default, enable it in the current terminal:

```bash
sdk use java 8.0.502.fx-zulu
```

Check that Maven is using it:

```bash
mvn -version
```

Then build the project:

```bash
mvn clean compile
```

The output should end with `BUILD SUCCESS`. Then start the calculator:

```bash
mvn javafx:run
```

The main class is `Calcolatrice.ScientificCalculator`, already configured in `pom.xml`.

To run the unit tests (optional):

```bash
mvn test
```

## Troubleshooting

**`mvn: command not found`**
Maven is not installed. Run `sudo apt install maven` (section 4).

**`Error: JavaFX runtime components are missing, and are required to run this application`**
Maven is running with a JDK that does not include JavaFX (typically the system JDK). Enable the JDK 8 with FX in the terminal (`sdk use java 8.0.502.fx-zulu`), check it with `mvn -version`, then run `mvn clean compile` and `mvn javafx:run` again.

**Compilation errors such as `package javafx... does not exist`**
Same cause: Maven is not using the JDK 8 with JavaFX.

**`No plugin found for prefix 'javafx'`**
The command is being run in the wrong folder, or the `pom.xml` does not contain the `javafx-maven-plugin`. Make sure you are in the folder containing the `pom.xml` of version 2.

**`java -version` shows Java 8 in every terminal**
SDKMAN set JDK 8 as the default. See the `rm ~/.sdkman/candidates/java/current` command in section 2.

**VS Code reports errors on `javafx.*` but Maven builds without problems**
The Java extension has not imported the project yet or is not using the right JDK. From the Command Palette (`Ctrl+Shift+P`) run **Java: Clean Java Language Server Workspace** and restart VS Code.

## Project structure

```
.
├── .gitignore
└── v2_VSCode/
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
```