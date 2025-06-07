# **BST vs. TreeSet Benchmark in Java**
**Developed by ShouNLAK**  

---

## 🔍 **Overview**  
This project benchmarks the performance of a custom **Binary Search Tree (BST)** against Java's built-in **`TreeSet`**, focusing on key operations under different conditions:  

📌 **Regular Case:** Balanced operations with **O(log n)** performance.  
📌 **Worst Case:** BST degrades to **O(n)** when unbalanced, while `TreeSet` remains **O(log n)** consistently.  

⚠️ _This project is a student endeavor; results may not reflect industrial-grade precision._

---

## 📋 **Table of Contents**
- [🔍 Overview](#overview)  
- [📊 Benchmark Details](#benchmark-details)  
- [🚀 How to Run](#how-to-run)  

---

## 📊 **Benchmark Details**  
✔️ **User-Defined Test Size** – Specify the number of elements to process.  
✔️ **Warm-Up Phase** – Minimizes JIT overhead for accurate timing.  
✔️ **Timed Operations:**  
   - ⏳ **Insertion** – Adding elements  
   - 🔎 **Finding** – Searching for elements  
   - ❌ **Deletion** – Removing elements  

Each operation is executed **30 times**, with an **average runtime summary** displayed for clarity.

✔️ **Detailed Summary** – Results formatted with tables, bullet points & highlights.  
✔️ **User-Friendly UI** – Well-structured outputs for **easy readability**.

---

## 🚀 **How to Run**  
💻 **Step 1: Clone the Repository**  
```bash
git clone https://github.com/ShouNLAK/BSTvsTreeSet.git
cd BSTvsTreeSet
```

🔨 **Step 2: Build the Project**  
- **Using Gradle:**  
  ```bash
  ./gradlew build
  ```
- **Using Maven:**  
  ```bash
  mvn clean install
  ```

▶️ **Step 3: Run the Application**  
```bash
java -jar build/libs/BSTvsTreeSet.jar
```

✏️ **Step 4: Follow On-Screen Prompts**  
- Enter the test size  
- Benchmark runs for **Insertion**, **Finding**, & **Deletion**  
- Results summary displayed  

---

⚡ _Use this benchmark as a learning tool for further optimization._  
Let me know if you’d like additional formatting enhancements!

