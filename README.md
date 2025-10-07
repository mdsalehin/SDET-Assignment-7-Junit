# JUnit Web Automation & Data Scraping Project

### Overview
This project demonstrates **real-world web automation and data extraction** using **Java**, **JUnit**, and **Selenium WebDriver**.  
It automates form submission, validates input data, and scrapes live stock market tables — all while making complex tasks simple and error-free.

---

##  Project Modules

###  Web Form Automation (Digital Unite)
**Goal:** Automatically fill and validate a learner registration form.  
**Link:** [Digital Unite Practice Webform](https://www.digitalunite.com/practice-webform-learners)

**Automation Steps:**
1. Open the webpage and accept cookies automatically.  
2. Fill out all fields: Name, Phone, Date, Email, and Description.  
3. Upload a file dynamically.  
4. Scroll to the submit button and submit the form.  
5. Assert that all submitted data matches expected values.

**Key Features:**
- Dynamic date handling with format conversion (`MM/dd/yyyy`).  
- Uses **JavaScriptExecutor** for scrolling and element interaction.  
- Validates every field using **JUnit Assertions**.  
- Automates cookie acceptance seamlessly.  

**Files:**  
- `MyJunit.java` → Main automation and assertion logic  
- `AcceptCookiesExample.java` → Cookie automation demo  
- `Utils.java` → Helper for scrolling actions  

---

###  Live Data Scraping (DSE Bangladesh)
**Goal:** Extract and store live share market data efficiently.  
**Link:** [DSE Latest Share Prices](https://dsebd.org/latest_share_price_scroll_by_value.php)

**Automation Steps:**
1. Navigate to the live stock table.  
2. Extract all rows and columns dynamically.  
3. Print data in a structured format using “|” as separator.  
4. Save the entire table to a text file for later use.

**Key Features:**
- Handles hundreds of rows and columns automatically.  
- Saves cleanly formatted data into `cellValuesText.txt`.  
- Fully automated using ChromeDriver.  
- Sample output:


1 | CVOPRL      | 201.8 | 209.5 | 191   | 201.8 | 191.2 | 10.6 | 6,520     | 271.8290 | 1,344,844 |
2 | SONALIPAPR  | 295.3 | 314.9 | 289   | 295.3 | 307.4 | -12.1| 6,013     | 252.9130 | 832,019   |
3 | RUPALILIFE  | 126.3 | 132   | 125   | 126.3 | 125.3 | 1    | 5,440     | 251.3230 | 1,954,925 |
4 | PRAGATIINS  | 80.7  | 84.4  | 75.2  | 80.7  | 77.7  | 3    | 4,324     | 207.9790 | 2,573,491 |
5 | KBPPWBIL    | 148.1 | 151.6 | 145   | 148.1 | 144.6 | 3.5  | 3,959     | 193.2880 | 1,296,964 |
...
395 | ATCSLGF    | 0     | 0     | 0     | 7.5   | 7.5   | --   | 0         | 0.0000   | 0         |
396 | BDSERVICE  | 0     | 0     | 0     | 5.2   | 5.2   | --   | 0         | 0.0000   | 0         |
397 | SAVAREFR   | 0     | 0     | 0     | 215.5 | 215.5 | --   | 0         | 0.0000   | 0         |




**Files:**  
- `storeValues.java` → Scraping and file writing logic  

---

## 🛠 Technologies Used
| Category | Tools & Libraries |
|----------|------------------|
| Language | Java |
| Testing Framework | JUnit 5 |
| Automation | Selenium WebDriver |
| Browser | Google Chrome |
| IDE | IntelliJ IDEA / Eclipse / VS Code |
| File Operations | Java I/O (FileWriter) |

---
##  How It Works (In Simple Terms)
Think of it as a **digital assistant**:  
- It fills forms accurately, checks every field, and submits them.  
- Then, it collects live stock prices from a website and stores them neatly.  
- No human effort, no errors, just fast, reliable results.

## **Project Structure:**  
```text
├── JunitAutomationProject/
│   ├── MyJunit.java               # Web form automation + validation
│   ├── storeValues.java           # Data scraping + file writing
│   ├── AcceptCookiesExample.java  # Cookie acceptance demo
│   ├── Utils.java                 # Scroll helper
└── resources/
    ├── cellValuesText.txt         # Scraped data output





