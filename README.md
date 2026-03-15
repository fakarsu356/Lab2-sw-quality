# SENG 272 - Lab Assignment 2: Software System Quality Evaluation

## Objective
This project is a Java-based measurement tool designed to evaluate the quality of various software systems (Web, Mobile, Enterprise) within the scope of the **ISO/IEC 25010** standard (SQuaRE - System and Software Quality Requirements and Evaluation). It uses concrete metrics defined in the **ISO/IEC 25023** standard to calculate, classify, and report quality dimensions using Object-Oriented Programming (OOP) principles and the Java Collections Framework.

## Learning Outcomes & Technologies Used
* **Java OOP Principles:** Encapsulation (private fields, getters/setters), Inheritance, and `toString()` overriding.
* **Collections Framework:** * `ArrayList`: For dynamically managing collections of criteria and quality dimensions.
  * `HashMap`: For structuring and providing fast access to software systems based on their categories (e.g., Web, Mobile).
* **Quality Standards:** Implementation of ISO/IEC 25010 characteristics and ISO/IEC 25023 measurable metric formulas.

## Project Structure
```text
Lab2-sw-quality/
├── src/
│   ├── Criterion.java
│   ├── QualityDimension.java
│   ├── SWSystem.java
│   ├── SWSystemData.java
│   └── Main.java
├── .gitignore
└── README.md
Quality Evaluation Logic
The application converts raw measured values into normalized scores between 1.0 and 5.0.

If higher values are better: score = 1 + (measuredValue - minValue) / (maxValue - minValue) * 4
If lower values are better: score = 5 - (measuredValue - minValue) / (maxValue - minValue) * 4

ISO 25010 Characteristic,ISO 25023 Metric Name,Direction,Unit,Formula Summary
Functional Suitability,Functional Completeness Ratio,Higher,%,Implemented functions / Planned functions × 100
Functional Suitability,Functional Correctness Ratio,Higher,%,Correct-output tests / Total tests × 100
Reliability,Availability Ratio,Higher,%,Uptime / (Uptime + Downtime) × 100
Reliability,Defect Density,Lower,defect/KLOC,Defects found / 1000 LOC
Performance Efficiency,MTBF (Mean Time Between Failures),Higher,hours,Total operation time / Number of failures
Performance Efficiency,Response Time,Lower,ms,Average end-to-end response time
Performance Efficiency,Throughput,Higher,req/s,Requests processed per second
Performance Efficiency,CPU Utilisation Ratio,Lower,%,CPU used / Total CPU × 100
Usability,Task Completion Rate,Higher,%,Completed tasks / Total attempted tasks × 100
Usability,User Error Rate,Lower,%,Error operations / Total operations × 100
Security,Security Test Coverage,Higher,%,Passed security tests / Total security tests × 100
Security,Vulnerability Count,Lower,count,Number of detected vulnerabilities
Maintainability,Test Coverage Ratio,Higher,%,Tested LOC / Total LOC × 100
Maintainability,Cyclomatic Complexity (avg),Lower,score,Average cyclomatic complexity per module


Scores are then clamped between 1.0 and 5.0 and rounded to the nearest 0.5. Dimension scores are calculated using the weighted average of their respective metrics.
