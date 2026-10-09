# 🧮 Programmable Complex Calculator

> A scientific programmable calculator supporting complex numbers, stack operations, and variables, developed as a university project for the **Software Engineering** course at the University of Salerno (Unisa).

---

## 📋 Table of Contents
- [About the Project](#-about-the-project)
- [Key Features](#-key-features)

---

## 🚀 About the Project
This project implements a fully functional scientific calculator designed around a **stack-based architecture**. It handles complex numbers (with real and imaginary parts in Cartesian notation) and executes operations sequentially by pulling operands from the stack and pushing results back. 

The development followed rigorous software engineering practices, moving from project planning and requirements engineering to detailed UML design, unit/functional testing, and clean Java implementation.

---

## ✨ Key Features

### 1. Complex Numbers & Basic Operations
* Support for complex numbers in Cartesian notation (e.g., `7.2+4.9j`, or pure real numbers like `42`).
* Core arithmetic operations: 
  * `+` (Addition), `-` (Subtraction), `*` (Multiplication), `/` (Division)
  * `sqrt` (Square root), `+-` (Invert sign)

### 2. Stack Manipulation Commands
* `clear`: Clears all elements from the stack.
* `drop`: Removes the top element.
* `dup`: Duplicates the top element.
* `swap`: Swaps the last two elements.
* `over`: Pushes a copy of the second-to-last element.

### 3. Variables Memory (26 Registers)
* Supports 26 variables named from `a` to `z`.
* Operations:
  * `>x`: Pops the top stack value and saves it into variable `x`.
  * `<x`: Pushes the value of variable `x` onto the stack.
  * `+x`: Adds the top stack value to variable `x`.
  * `-x`: Subtracts the top stack value from variable `x`.
