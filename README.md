# Assignment Counting Analysis

A Java-based static analysis tool that uses the **Soot framework** to count assignment statements in methods of a given class.

## Features

- **Static Analysis**: Analyzes Java bytecode to count assignment statements.
- **Soot Integration**: Leverages the Soot framework for bytecode manipulation and analysis.
- **JUnit Testing**: Includes unit tests to validate the analysis.

## Project Structure

- `src/main/java` : Contains the main implementation of the analysis.
- `src/test/java` : Contains unit tests and sample classes for testing.

## Prerequisites

- **Java**: Version 8 or higher.
- **Maven**: For dependency management and build automation.

## Installation

1. Clone the repository:

```bash
git clone <repository-url>
cd <repository-folder>
````

2. Build the project using Maven:

```bash
mvn clean install
```

## Example

Given the following method in `Test.java`:

```java
public void example() {
    int x = 1;
    int y = 2;
    x = y + 3;
    y = x;
}
```

The analysis will count **4 assignment statements**.

## Tests

```bash
mvn test
```

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

## License

This project is licensed under the **MIT License**.
