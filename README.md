# **BST vs. TreeSet Benchmark in Java**
**Developed by ShouNLAK**  

---

## 🔍 **Overview**  
This project benchmarks the performance of a custom **Binary Search Tree (BST)** against Java's built-in **`TreeSet`**, focusing on key operations under different conditions:  

📌 **Regular Case:** Balanced operations with **O(log n)** performance.  
📌 **Worst Case:** BST degrades to **O(n)** when unbalanced, while `TreeSet` remains **O(log n)** consistently.  

<div align="center">
    <img src="https://github.com/user-attachments/assets/4a6d94cf-bebf-4441-be18-02ce2a5e8199" alt="GeeksforGeeks Image">
    <br>
    <b>From <a href="https://www.geeksforgeeks.org/what-does-big-o-olog-n-complexity-mean/">GeeksforGeeks</a></b>
</div>


⚠️ _This project is a student endeavor; results may not reflect industrial-grade precision._

---

## 📋 **Table of Contents**
- [🔍 Overview](#overview)  
- [📊 Benchmark Details](#benchmark-details)  
- [🚀 How to Run](#how-to-run)  
- [❓ Q & A](#Q-&-A)
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

## ❓ **Q & A**

🔸 **Q:** Why compare BST vs. TreeSet?

**A:** BST is a fundamental data structure in computer science, but Java’s TreeSet offers built-in balancing. This benchmark helps analyze their performance in real-world scenarios.

🔸 **Q:** What is the worst-case scenario for BST?

**A:** If data is inserted in an almost sorted order, the BST becomes a **skewed tree** (similar to a linked list), degrading performance to **O(n)** instead of **O(log n)**.

### Worst-Case Scenario: BST vs. TreeSet  

| **TreeSet** (Self-Balancing) | **BST** (Unbalanced) |
|-----------------------------|----------------------|
| ![TreeSet](https://github.com/user-attachments/assets/d3fc1d59-f961-48a2-a0ab-0e4fdf5b4c37) | ![BST](https://github.com/user-attachments/assets/f2f05078-c74d-4298-b98f-b2d28c8c4ad3) |
| **Maintains O(log n)** even with sorted insertions | **Degrades to O(n)** when inserted in order |


🔸 **Q:** Why does TreeSet maintain better performance?

**A:** TreeSet uses a **Red-Black Tree**, a self-balancing binary search tree that ensures **O(log n)** complexity for **insertion, search, and deletion** operations.

🔸 **Q:** Does the benchmark consider memory usage?

**A:** This version primarily focuses on execution speed. Future improvements could integrate memory profiling.

🔸 **Q:** Can I use this for production-level analysis?

**A:** Since this is a student project, results might not be precise enough for high-stakes applications. However, it serves as a solid learning tool.

---

⚡ _Use this benchmark as a learning tool for further optimization._  
Let me know if you’d like additional formatting enhancements!

