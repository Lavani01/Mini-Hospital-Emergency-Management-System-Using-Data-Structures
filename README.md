# Mini Hospital Emergency Management System

## CIT300 - Data Structures and Algorithms

### Individual Mid Assignment

---

## 1. Project Overview

The Mini Hospital Emergency Management System is a Java-based console application designed to manage basic hospital emergency operations using fundamental data structures.

The system demonstrates how different data structures can be applied to solve practical hospital management problems such as storing patient records, managing emergency patients, maintaining treatment history, and recording previous patient visits.

The project uses four main data structures:

- Binary Search Tree (BST)
- Queue
- Stack
- Singly Linked List

Each data structure is selected according to the type of operation it is most suitable for.

---

## 2. Project Objectives

The main objectives of this project are:

- To implement and demonstrate four fundamental data structures using Java.
- To manage patient records efficiently using a Binary Search Tree.
- To manage emergency patients according to First In, First Out (FIFO) using a Queue.
- To maintain completed treatment records using a Stack following Last In, First Out (LIFO).
- To maintain patient visit history using a Singly Linked List.
- To integrate all data structures into a single working hospital management system.
- To demonstrate practical applications of data structures in a real-world scenario.

---

## 3. Data Structures Used

### 3.1 Binary Search Tree - Patient Records

The Binary Search Tree is used to store patient records using the Patient ID as the key.

Each patient record contains:

- Patient ID
- Patient Name
- Age
- Contact Number
- Medical Condition

The BST supports:

- Insertion of patients
- Searching for a patient
- Deleting a patient
- In-order traversal

The in-order traversal displays patient records in ascending order of Patient ID.

---

### 3.2 Queue - Emergency Patient Management

A Queue is used to manage patients waiting for emergency treatment.

The queue follows the FIFO (First In, First Out) principle.

Supported operations include:

- Enqueue - Add a patient to the waiting queue
- Dequeue - Remove the next patient for treatment
- Display waiting patients
- Check whether the queue is empty
- Check whether the queue is full

This structure is suitable because emergency patients should generally be handled according to their arrival order in this simplified system.

---

### 3.3 Stack - Treatment History

A Stack is used to maintain completed treatment records.

The Stack follows the LIFO (Last In, First Out) principle.

Each treatment record contains:

- Patient ID
- Patient Name
- Doctor Name
- Treatment
- Treatment Date

Supported operations include:

- Push - Add a completed treatment record
- Pop - Remove the most recent treatment record
- Display treatment history
- Check whether the stack is empty
- Check whether the stack is full

The Stack allows the most recently completed treatment to be accessed first.

---

### 3.4 Singly Linked List - Patient Visit History

A Singly Linked List is used to maintain previous hospital visits for patients.

Each visit contains:

- Visit ID
- Visit Date
- Doctor Name
- Diagnosis
- Treatment

Supported operations include:

- Add a visit
- Search for a visit
- Remove a visit
- Display visit history

The linked list allows visit records to be dynamically maintained without requiring a fixed-size collection.

---

## 4. System Features

The system provides a menu-driven console interface with the following main features:

1. Register New Patient
2. Search Patient
3. Delete Patient
4. Display All Patients
5. Add Patient to Emergency Queue
6. Treat Next Emergency Patient
7. Display Waiting Patients
8. Complete Treatment
9. View Treatment History
10. Add Patient Visit
11. Remove Patient Visit
12. Search Patient Visit
13. Display Patient Visit History
0. Exit

---

## 5. Project Structure

The project is organized into separate Java classes according to their responsibilities.

```text
MiniHospitalEmergencySystem
│
├── src
│   └── hospital
│       ├── Patient.java
│       ├── PatientNode.java
│       ├── PatientBST.java
│       ├── BSTTest.java
│       │
│       ├── PatientQueue.java
│       ├── QueueTest.java
│       │
│       ├── TreatmentRecord.java
│       ├── TreatmentStack.java
│       ├── StackTest.java
│       │
│       ├── Visit.java
│       ├── VisitNode.java
│       ├── VisitHistory.java
│       ├── VisitHistoryTest.java
│       │
│       └── Main.java
│
├── README.md
└── .gitignore