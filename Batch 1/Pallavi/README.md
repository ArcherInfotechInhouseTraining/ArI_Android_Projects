# ArI_Android_Projects
## Archer InfoTech - Online Classes App
### Project Overview
- Archer InfoTech is an Android app designed to provide users with information on a variety of online programming and web development courses. Users can explore course - details, manage their profiles, register for classes, and make secure payments. The app integrates Firebase for real-time database management and user authentication, - while also utilizing SQLite for local data storage.

### Features
- Homepage: Displays details of courses, including C, C++, Java, Web Development, HTML, CSS, JavaScript, and C#.
- Admission Page: Allows users to enroll in courses by providing necessary details.
- Profile Page: Users can manage their profile information.
- Payment Page: Enables users to make secure payments for course enrollment.
- Firebase Integration: Handles user authentication, online database management, and payment processing.
- SQLite Database: Provides local data storage for offline access and faster data retrieval.
- Tech Stack
- Programming Language: Java
- Databases:
- Firebase Realtime Database: Manages user data and payments.
- SQLite: Stores local data for offline access.
- Authentication: Firebase Authentication

### Database Structure
#### Firebase
- User Data: Stores user information, profiles, and course enrollments.
- Payments: Manages user transactions for course payments.
#### SQLite
- Courses Table:
- course_id (INTEGER, Primary Key) - Unique ID for each course.
- course_name (TEXT) - Name of the course.
- description (TEXT) - Description of the course.
- duration (TEXT) - Duration of the course.
- User Info Table:
- user_id (INTEGER, Primary Key) - Unique ID for each user.
- name (TEXT) - Name of the user.
- email (TEXT) - Email address of the user.
- course_id (INTEGER, Foreign Key) - ID of the course the user is enrolled in.
