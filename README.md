# 🧮 Programmable Complex Calculator

> A scientific programmable calculator supporting complex numbers, stack operations, and variables, developed as a university project for the **Software Engineering** course (Academic Year 2023/2024) at the University of Salerno (Unisa).

---

## 👥 Collaborators
- **Anzivino Giuseppe Fabrizio** — [@GiuseppeAnzivino](https://github.com/GiuseppeAnzivino)
- **Borrelli Simone** — [@GitHub_Username](https://github.com/GitHub_Username)
- **Buongiorno Aldo** — [@GitHub_Username](https://github.com/GitHub_Username)
- **Calabrese Raffaele** — [@GitHub_Username](https://github.com/GitHub_Username)

---

## 📋 Table of Contents
- [About the Project](#-about-the-project)
- [Project Planning & Methodology](#-project-planning--methodology)
- [Project Documentation (`/docs`)](#-project-documentation-docs)
- [Architecture & Design Patterns](#-architecture--design-patterns)
- [Tech Stack & Implementation](#-tech-stack--implementation)
- [Testing & Quality Assurance](#-testing--quality-assurance)
- [Key Features & Requirements](#-key-features--requirements)
- [Video Demo](#-video-demo)

---

## 🚀 About the Project
This project implements a fully functional scientific calculator designed around a **stack-based architecture** and following a rigorous **waterfall development model**. It handles complex numbers (with real and imaginary parts in Cartesian notation) and executes operations sequentially by pulling operands from the stack and pushing results back. 

The software engineering lifecycle encompassed complete project planning, WBS (Work Breakdown Structure) creation, Gantt scheduling, requirements elicitation, detailed UML design, unit/functional testing, and clean Java implementation.

---

## 📊 Project Planning & Methodology
- **Development Model:** Waterfall model (structured macro-phases: Planning, Requirements Engineering, System Design, Implementation, and Testing).
- **Scheduling & Tracking:** Managed via Gantt charts and Work Breakdown Structures (WBS) (using GanttPRO and dedicated tracking documents) to ensure strict adherence to milestones.
- **Traceability:** Maintained through a comprehensive Traceability Matrix linking requirements, design artifacts, and test cases across the lifecycle.

---

## 📂 Project Documentation (`/docs`)
The complete software engineering documentation is organized chronologically following the waterfall lifecycle and is stored inside the `docs/` directory:

1. **[01_Software_Project_Planning.pdf](docs/01_Software_Project_Planning.pdf)**: Project organization, WBS, Gantt scheduling, and resource allocation.
2. **[02_Software_Project_Requisiti.pdf](docs/02_Software_Project_Requisiti.pdf)**: Requirements elicitation, use cases, and functional specifications.
3. **[03_Software_Project_Design.pdf](docs/03_Software_Project_Design.pdf)**: System architecture (Shared Repository), UML class/sequence diagrams, activity/state diagrams, and code metrics (LCOM and Coupling).
4. **[04_Software_Project_Implementation.pdf](docs/04_Software_Project_Implementation.pdf)**: Implementation details, UI design with JavaFX Scene Builder, and traceability matrix updates.
5. **[05_Software_Project_Testing.pdf](docs/05_Software_Project_Testing.pdf)**: Comprehensive test planning, functional end-to-end test cases (FTC), and automated JUnit unit test suites (UTC) for the core model.

---

## 🏗️ Architecture & Design Patterns
- **Shared Repository Architecture:** The system relies on a centralized persistent component layout to facilitate data sharing across modules.
- **UML Modeling:** Extensive design phase incorporating **Class Diagrams**, **Sequence Diagrams** (for operands insertion, operations, stack manipulation, and variable management), **Activity Diagrams**, and **State Machine Diagrams**.
- **Code Metrics:** Analyzed via LCOM (Lack of Cohesion of Methods) and Coupling metrics to evaluate system modularity and dependencies stemming from shared data structures.

---

## 🛠️ Tech Stack & Implementation
- **Language & Build Tool:** Java, managed via **Maven** (`pom.xml`) for dependency handling and project building.
- **IDE:** NetBeans
- **UI Framework:** JavaFX, designed using **JavaFX Scene Builder 2.0** (supporting dual interfaces: Standard Calculator and Variables View).
- **Core Components:**
  - `FXMLDocumentController`: Manages UI interactions and event handling.
  - `Parser`: Handles string-to-complex conversions, syntax validation, and command routing.
  - `Stack`: Manages stack data structures (Deque) and manipulation commands.
  - `Operation`: Implements arithmetic and algebraic logic.
  - `VarMap`: Manages the 26 variable memory registers (`a` to `z`).
  - Custom Exception classes (`EmptyStackException`, `FullStackException`, `ArithmeticException`, `OverflowException`, `InputException`, `VarException`).

---

## 🧪 Testing & Quality Assurance
- **Test Planning:** Comprehensive verification focusing heavily on the core computational model and data structures, complemented by manual GUI and functional interaction testing.
- **Functional Test Cases (FTC):** End-to-end scenarios validating arithmetic flows (`FTC-01`), stack manipulations (`FTC-02`), and variable memory operations (`FTC-03`) along with proper error handling (e.g., division by zero, empty stack).
- **Automated Unit Tests (JUnit):** Exhaustive test suites covering all core classes with 100% passing results:
  - `ComplexTest`: Validates real/imaginary getters, string formatting, zero checks, basic arithmetic (+, -, *, /), square roots (`sqrt`), and sign inversion (`reverse`).
  - `OperationTest`: Verifies correct execution of operations directly through the stack layer and proper exception throwing.
  - `ParserTest`: Tests string tokenization, number checks (`isComplex`, `isRealPart`, `isJPart`), parsing logic, and syntax exception handling.
  - `StackTest`: Ensures stack behavior under `clear`, `drop`, `dup`, `swap`, and `over` commands including edge cases on empty stacks.
  - `VarMapTest`: Tests variable storage, stack-to-variable (`>var`) and variable-to-stack (`<var`) transfers, arithmetic variable updates (`+var`, `-var`), and mapping string outputs.

---

## ✨ Key Features & Requirements

### 1. Complex Numbers & Basic Operations
- Support for complex numbers in Cartesian notation (e.g., `7.2+4.9j`, treating pure real numbers as numbers with a zero imaginary part).
- Core arithmetic operations: 
  - `+` (Addition), `-` (Subtraction), `*` (Multiplication), `/` (Division)
  - `sqrt` (Square root), `+-` (Invert sign)

### 2. Stack Manipulation Commands
- Stack visualization displaying at least the top **12 elements**.
- `clear`: Removes all elements from the stack.
- `drop`: Removes the top element.
- `dup`: Duplicates the top element.
- `swap`: Exchanges the last two elements.
- `over`: Pushes a copy of the second-to-last element.

### 3. Variables Memory (26 Registers)
- Supports 26 variables named from `a` to `z` with a dedicated variables interface screen.
- Operations:
  - `>x`: Pops the top stack value and saves it into variable `x`.
  - `<x`: Pushes the value of variable `x` onto the stack.
  - `+x`: Adds the top stack value to variable `x`.
  - `-x`: Subtracts the top stack value to variable `x`.

---

## 📺 Video Demo

Watch a practical demonstration of the calculator and graphical user interface:

[![Calculator Video Demo](https://img.youtube.com/vi/FplfppbxDv4/maxresdefault.jpg)](https://youtu.be/FplfppbxDv4)

*(If you prefer to download or view the raw file directly, you can find it in the [`assets/demo.mp4`](assets/demo.mp4) folder).*