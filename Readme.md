# ? License Plate Generator - Technical Challenge

This project implements an alphanumeric license plate generator.

The application transforms a long integer into a unique alphanumeric combination using base conversion logic.

---

## ? Functional Overview

The generator takes a `long` number between `0` and `36^6 - 1` (`2176782335`) and returns a 6-character string using digits `0-9` and uppercase letters `A-Z`.

| Index        | Plate   |
|--------------|---------|
| 0            | 000000  |
| 35           | 00000Z  |
| 36           | 000010  |
| 46655        | 000ZZZ  |
| 2176782335   | ZZZZZZ  |

It also validates the input and throws an exception if the index is out of bounds.

---

## ?? Technologies Used

- ? Java 17
- ? Gradle
- ? JUnit 5
- ? JaCoCo

---
