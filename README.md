# MediTrack - Clinic & Appointment Management System

## Overview

MediTrack is a Java-based Clinic and Appointment Management System built to practice core Java, Object-Oriented Programming, Design Patterns, Collections Framework, Generics, Exception Handling, and other fundamental Java concepts.

The system allows management of doctors, patients, appointments, and billing operations while demonstrating important OOP principles such as inheritance, encapsulation, polymorphism, abstraction, interfaces, and design patterns like Singleton, Factory, and Observer.

The primary goal of this project is to strengthen Java fundamentals and low-level design skills rather than build a production-ready healthcare application.

---

## Features

### Patient Management

* Add and remove patients
* Search patients by:

    * ID
    * Name
    * Age
* Maintain patient records

### Doctor Management

* Add and remove doctors
* Search doctors by:

    * ID
    * Name
    * Specialization

### Appointment Management

* Create appointments
* Cancel appointments
* View appointment details
* Track appointment status using enums

### Billing System

* Generate bills for appointments
* Support multiple bill types
* Tax calculation through the Payable interface
* Factory Pattern for bill creation

### Notifications

* Appointment notifications using Observer Pattern
* Email notifications
* SMS notifications

### Search Functionality

* Dynamic search implementation using the Searchable interface
* Method overloading for multiple search criteria

---

## OOP Concepts Demonstrated

### Encapsulation

* Private fields with getters and setters
* Validation through utility classes

### Inheritance

* Person → Doctor
* Person → Patient

### Polymorphism

* Method overloading
* Method overriding
* Runtime method dispatch

### Abstraction

* Abstract MedicalEntity class
* Interface-based design

### Interfaces

* Searchable
* Payable

### Enums

* AppointmentStatus
* Specialization
* BillType

### Generics

* Generic DataStore<T> implementation

### Exception Handling

* Custom exceptions
* Input validation
* Business rule enforcement

---

## Design Patterns Used

### Singleton Pattern

Used for generating unique IDs throughout the application.

### Factory Pattern

Used for creating different bill types without exposing object creation logic.

### Observer Pattern

Used for appointment notification handling through SMS and Email observers.

---

## Project Structure

```text
com.airtribe.meditrack
│
├── Entity
├── Services
├── Utils
├── Interfaces
├── Exceptions
├── Constansts
├── test
└── Main
```

---

## Technologies Used

* Java
* Collections Framework
* Generics
* Enums
* Exception Handling
* Design Patterns
* Object-Oriented Programming

---

## Learning Objectives

This project was built to practice:

* Java Fundamentals
* OOP Principles
* SOLID Design Concepts
* Collections Framework
* Generics
* Exception Handling
* Design Patterns
* Low-Level Design
* Clean Code Practices
