# SQLInjectionDetector

`SQLInjectionDetector` is a simple Java utility that helps identify potential SQL injection attempts in user input by matching it against a list of known suspicious SQL patterns using regular expressions.

## 📋 Features

* Detects common SQL injection patterns such as:

  * `' OR '1'='1`
  * SQL comments (`--`)
  * SQL keywords like `SELECT`, `DROP`, `UNION`, `INSERT`, `DELETE`, etc.
* Case-insensitive matching
* Easy to extend with new patterns

## 🚀 Getting Started

### Prerequisites

* Java 8 or higher
* Any Java IDE or a terminal to compile and run Java code

### Usage

1. **Clone or copy the code**
2. **Compile the file:**

```bash
javac SQLInjectionDetector.java
```

3. **Run the program:**

```bash
java SQLInjectionDetector
```

### Sample Output

```
Input: "admin' --" | Suspicious: true
Input: "test'; DROP TABLE users; --" | Suspicious: true
Input: "normalInput" | Suspicious: false
Input: "' OR 1=1 --" | Suspicious: true
Input: "SELECT * FROM users" | Suspicious: true
```

## 🧠 How It Works

The `isSQLInjection` method iterates through a list of regular expressions (`PATTERNS`) that represent known SQL injection attack signatures. It uses Java's `Pattern` and `Matcher` classes to scan for these patterns in user input.

If a match is found, it returns `true`, indicating a potential SQL injection. Otherwise, it returns `false`.

## 🛠️ Customization

You can add or remove patterns in the `PATTERNS` array to fine-tune the detector based on the security needs of your application.

```java
private static final String[] PATTERNS = {
    "...",  // Add your own regex here
};
```

## ⚠️ Disclaimer

This utility is intended for educational purposes and as a basic demonstration. It is **not** a substitute for proper input sanitization, parameterized queries (prepared statements), or other secure coding practices.

---
