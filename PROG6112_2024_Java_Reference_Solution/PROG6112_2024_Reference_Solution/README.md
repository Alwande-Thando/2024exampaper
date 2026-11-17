# PROG6112 Programming 1B — 2024 Reference Solution

This archive is for the **2024 paper** (movie tickets / cinema GUI), not the 2025 product-sales paper.

## Projects
- `Question1_MovieSales`: monthly January–March ticket sales for Napoleon and Oppenheimer, totals, top movie, interface/class, and JUnit tests.
- `Question2_CinemaGUI`: Swing GUI with movie selection, ticket count/price, 14% VAT, report generation and `report.txt` saving, validation, interface/class, and JUnit tests.

## Open and run
Each folder is a separate Maven project. Open the folder containing its `pom.xml` in NetBeans or IntelliJ. Use JDK 17+ and run:
```bash
mvn test
mvn package
```
Run the GUI with:
```bash
mvn exec:java
```
The report is saved as `report.txt` in the current working directory.

## Notes
- Q1 data is taken from the supplied paper: Napoleon = 3000, 1500, 1700; Oppenheimer = 3500, 1200, 1600.
- Q2 movie choices are Napoleon, Oppenheimer, and Damsel. VAT is 14%, as specified in the 2024 paper.
- The paper specifies interfaces with particular method signatures; these are retained.
- This is a worked reference solution. Review the code, run it in your IDE, and make sure you can explain each part. Follow your lecturer's guidance about disclosure and permitted use of AI assistance.
