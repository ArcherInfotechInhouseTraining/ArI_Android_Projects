###Archer InfoTech - Online Classes App

###Project Overview

The Archer InfoTech app is designed to offer users a comprehensive platform for exploring various online programming and web development courses. Users can easily browse course details, manage their profiles, enroll in classes, and process secure payments. This application leverages Firebase for real-time database management and user authentication, alongside SQLite for local data storage.

###Key Features
Homepage: A user-friendly interface displaying a variety of courses, including:

C
C++
Java
Web Development
HTML
CSS
JavaScript
C#

Admission Page: Users can enroll in courses by filling out the necessary details.

Profile Page: Manage and update user profile information.

Payment Page: Facilitates secure payment processing for course registrations.

Firebase Integration: Handles user authentication and manages online databases for user data and payment processing.

SQLite Database: Ensures local data storage for offline access and rapid data retrieval.

###Tech Stack
Programming Language: Java

Databases:
Firebase Realtime Database: Manages user data and payment transactions.
SQLite: Provides local data storage for offline access.

Authentication: Firebase Authentication

###Database Structure

Firebase
User Data: Stores user profiles and course enrollments.
Payments: Manages transactions related to course payments.

SQLite
Courses Table:

course_id (INTEGER, Primary Key): Unique identifier for each course.
course_name (TEXT): Name of the course.
description (TEXT): Brief description of the course.
duration (TEXT): Duration of the course.

User Info Table:
user_id (INTEGER, Primary Key): Unique identifier for each user.
name (TEXT): User's name.
email (TEXT): User's email address.
course_id (INTEGER, Foreign Key): Identifier for the course the user is enrolled in.