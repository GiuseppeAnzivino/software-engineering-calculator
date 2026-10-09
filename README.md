# 🧮 Programmable Complex Calculator

> A scientific programmable calculator supporting complex numbers, stack operations, and variables, developed as a university project for the **Software Engineering** course (Academic Year 2023/2024) at the University of Salerno (Unisa).

---

## 👥 Collaborators
* **Anzivino Giuseppe Fabrizio** — [@GiuseppeAnzivino](https://github.com/GiuseppeAnzivino)
* **Borrelli Simone** — [@GitHub_Username](https://github.com/GitHub_Username)
* **Buongiorno Aldo** — [@GitHub_Username](https://github.com/GitHub_Username)
* **Calabrese Raffaele** — [@GitHub_Username](https://github.com/GitHub_Username)

---

## 📋 Table of Contents
- [About the Project](#-about-the-project)
- [Project Planning & Methodology](#-project-planning--methodology)
- [Key Features & Requirements](#-key-features--requirements)

---

## 🚀 About the Project
This project implements a fully functional scientific calculator designed around a **stack-based architecture** and following a rigorous **waterfall development model**. It handles complex numbers (with real and imaginary parts in Cartesian notation) and executes operations sequentially by pulling operands from the stack and pushing results back. 

The software engineering lifecycle encompassed complete project planning, WBS (Work Breakdown Structure) creation, Gantt scheduling, requirements elicitation, detailed UML design, unit/functional testing, and clean Java implementation.

---

## 📊 Project Planning & Methodology
* **Development Model:** Waterfall model (structured macro-phases: Planning, Requirements Engineering, System Design, Implementation, and Testing).
* **Scheduling & Tracking:** Managed via Gantt charts and Work Breakdown Structures (WBS) to ensure strict adherence to project milestones and delivery constraints.
* **Traceability:** Maintained through a comprehensive Traceability Matrix linking requirements, design artifacts, and test cases.

---

## ✨ Key Features & Requirements

### 1. Complex Numbers & Basic Operations
* Support for complex numbers in Cartesian notation (e.g., `7.2+4.9j`, treating pure real numbers as numbers with a zero imaginary part).
* Core arithmetic operations: 
  * `+` (Addition), `-` (Subtraction), `*` (Multiplication), `/` (Division)
  * `sqrt` (Square root), `+-` (Invert sign)

### 2. Stack Manipulation Commands
* Stack visualization displaying at least the top **12 elements**.
* `clear`: Removes all elements from the stack.
* `drop`: Removes the top element.
* `dup`: Duplicates the top element.
* `swap`: Exchanges the last two elements.
* `over`: Pushes a copy of the second-to-last element.

### 3. Variables Memory (26 Registers)
* Supports 26 variables named from `a` to `z` with a dedicated variables interface screen.
* Operations:
  * `>x`: Pops the top stack value and saves it into variable `x`.
  * `<x`: Pushes the value of variable `x` onto the stack.
  * `+x`: Adds the top stack value to variable `x`.
  * `-x`: Subtracts the top stack value from variable `x`.
