# Private Tuition Classes Admission App - Design Documentation

## 1. Introduction
This document outlines the design specifications for the Private Tuition Classes Admission App. The app provides students with a seamless experience for browsing courses, enrolling in classes, and managing their profiles.

---

## 2. User Roles
- **Student**: Can browse courses, apply for admission, and manage profiles.
- **Admin**: Can manage courses, view student enrollments, and approve or reject admissions.

---

## 3. App Pages Overview

1. Splashscreen and Login/Signup Page      |-> Swastik
2. Home Page                               |-> Vishwajeet
3. Course List Page                        |-> Pooja
4. Course Detail Page                      |-> Pooja
5. Admission Form Page                     |-> Vishwajeet
6. Payment Page                            |-> Pallavi
7. Profile Page                            |-> Sagar
8. Admin Dashboard                         |-> Pallavi

---

## 4. Page Designs

### 4.1 Login/Signup Page
- **Purpose**: Allow users to log in or sign up.
- **Components**:
  - Input fields for Email and Password.
  - Login and Sign-Up buttons.
  - Option for password reset.
  - Social media login options (optional).

- **Design Elements**:
  - Form layout: Centered on the page.
  - Buttons: Distinct colors for Login (e.g., blue) and Sign-Up (e.g., green).
  - Validation: Real-time error messages for incorrect email or password.

### 4.2 Home Page
- **Purpose**: Display general information and featured courses.
- **Components**:
  - Navigation bar with links to Courses, Profile, and Logout.
  - Featured Courses section (carousel or grid).
  - Search bar for finding courses.
  - Footer with contact information.

- **Design Elements**:
  - Clean layout with clear sections for courses.
  - User-friendly navigation with icons for quick access.

### 4.3 Course List Page
- **Purpose**: Display all available courses.
- **Components**:
  - Filter options (e.g., by subject, class, duration).
  - Course cards with brief descriptions (Title, Duration, Fees).
  - "Apply Now" button for each course.

- **Design Elements**:
  - Grid layout for displaying courses.
  - Filter panel on the left side (optional).
  - Hover effect on course cards for interactivity.

### 4.4 Course Detail Page
- **Purpose**: Show detailed information about a selected course.
- **Components**:
  - Course title, duration, and detailed description.
  - Instructor's name and profile link.
  - Admission requirements.
  - "Apply Now" button leading to the admission form.

- **Design Elements**:
  - Detailed sections with collapsible panels for additional information (like syllabus).
  - Call-to-action prominently displayed.

### 4.5 Admission Form Page
- **Purpose**: Allow students to submit their application for a course.
- **Components**:
  - Input fields: Full name, email, phone, previous education, preferred batch.
  - Dropdowns for course selection.
  - Upload section for documents (optional).
  - "Submit Application" button.

- **Design Elements**:
  - Multi-step form if there are multiple steps involved (personal info, documents, confirmation).
  - Validation for required fields.

### 4.6 Payment Page
- **Purpose**: Allow students to pay for their courses after admission approval.
- **Components**:
  - Display course fees and breakdown.
  - Payment methods: Credit/Debit card, UPI, or Net Banking.
  - Payment summary and confirmation section.

- **Design Elements**:
  - Secure layout with payment icons and trust symbols.
  - Clear breakdown of fees and taxes.

### 4.7 Profile Page
- **Purpose**: Let students manage their personal information and view their enrolled courses.
- **Components**:
  - User details (name, email, phone).
  - List of enrolled courses with their status.
  - Edit Profile button to update information.
  - Log out button.

- **Design Elements**:
  - Minimalistic layout with clear sections for personal info and course history.
  - Action buttons for editing profile details.

### 4.8 Admin Dashboard
- **Purpose**: Allow the admin to manage courses and student enrollments.
- **Components**:
  - Overview section for total students, courses, and admissions.
  - Course management: Add/Edit/Delete courses.
  - Admission requests list: Approve/Reject.
  - User management panel.

- **Design Elements**:
  - Sidebar navigation for managing different sections.
  - Dashboard cards for key metrics like active students and pending admissions.
  - Data tables for course and student management with filtering options.

---

## 5. Navigation Flow

1. **Login/Signup** → **Home Page** → **Course List Page** → **Course Detail Page** → **Admission Form** → **Payment Page** → **Confirmation Page**
2. **Profile Page** accessible from the Home Page.
3. **Admin Dashboard** accessible for Admin role only.

---

## 6. Responsive Design

- **Mobile View**:
  - Collapsible navbar with a hamburger menu.
  - Stack elements vertically for better scrolling.
  - Touch-friendly buttons and form fields.

---

## 7. Color Scheme & Typography

- **Primary Colors**: #1d8599, #f7c12c , White (#FFFFFF), #049b88.
- **Secondary Colors**: Green (#28A745) for action buttons, Red (#FF6347) for warnings/errors.
- **Typography**: 
  - Headings: `Roboto`, 24px bold.
  - Body Text: `Poppins`, 16px regular.

---

## 8. Accessibility

- Ensure all buttons are accessible via keyboard.
- Include `aria-label` for navigation links.
- High contrast for text and background for readability.
- Support screen readers by labeling form inputs and buttons properly.

---

## 9. Conclusion
This document outlines the essential pages, components, and design principles for the Private Tuition Classes Admission App. It ensures a user-friendly experience for both students and administrators while maintaining responsive and accessible design practices.
