
# ArI_Android_Projects
# ArI_Android_Projects
## Archer InfoTech - Online Classes App with SQLite Database
### Project Overview
- Archer InfoTech is an Android app designed to provide users with information on various programming and web development courses. Users can browse course details, manage their profiles, register for classes, and handle payment information. This version of the app uses SQLite for local data storage, enabling offline access and fast data retrieval.

### Features
- Homepage: Displays details of courses, including C, C++, Java, Web Development, HTML, CSS, JavaScript, and C#.
- Admission Page: Allows users to register for courses and save details locally.
- Profile Page: Users can manage their profile information.
- Payment Page: Handles payment information stored locally for easy tracking.
- SQLite Integration: Provides a lightweight, local database solution for managing user data, course information, and payment records.
- Tech Stack
- Programming Language: Java
- Database: SQLite (Local Database)

### Usage
- Homepage: Displays a list of available courses with information stored in the SQLite database.
- Admission Page: Register for courses and save details locally for offline access.
- Profile Page: Update user profile information, which is stored in SQLite for quick access.
- Payment Page: Store and manage payment records locally in the SQLite database.
- The DatabaseHelper.java class includes methods for databases

### Future Enhancements
- Add support for data synchronization when online.
- Implement data encryption for sensitive user and payment information.
- Expand the database to support additional features, such as course assessments and feedback.

### Screenshots
<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/spalshScreen.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/registration1.jpeg" alt =" "> 

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/registration2.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/signIn.jpeg" alt = " ">


<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/admissionForm.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/cardPayment.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/courseList.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/courseList2.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/courseSyllabus.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/emiPayment.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/letsStart1.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/letsStart2.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/letsStart3.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/letsStart4.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/paymentPage.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/paymentPage2.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/profile.jpeg" alt = " ">

<img src="https://github.com/ArcherInfotechInhouseTraining/ArI_Android_Projects/blob/main/Batch%201/Pallavi/Project%201%20using%20SQLite/Output%20Screenshots/upiPage.jpeg" alt = " ">

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

