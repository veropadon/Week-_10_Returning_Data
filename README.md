# Week-_10_Returning_Data
DIY Project Database CRUD Application

Overview
This application allows users to manage DIY projects. This update focuses on adding a feature that lets users select a project and see its details, including materials, steps, and categories.

Features
1. Select a Project in ProjectsApp:
Introduced a new instance variable curProject of type Project.
New menu option "3) Select a project" lets users pick a project by ID.
The selectProject() method helps in selecting and displaying a project's details.
printOperations() updated to show the currently selected project or a message if none is selected.
2. ProjectService Updates:
The fetchProjectById() method fetches project details by its ID and throws NoSuchElementException for missing projects.
3. ProjectDao Enhancements:
Enabled fetching project details along with associated materials, steps, and categories in a transaction.
Separate methods retrieve materials, steps, and categories for a given project.
4. Testing:
After manual insertion of test records in the database, test the select a project functionality to ensure data retrieval is accurate.
Usage
ProjectsApp:
Start the application.
Choose "3) Select a project" from the menu.
Input a valid project ID when prompted.
Observe project details on successful selection or an error message otherwise.
Database Testing:
In your database tool (e.g., DBeaver or MySQL CLI), manually insert categories, projects, materials, steps, and project_category links.
Run the application to test data retrieval.
Recommendations:
Make sure to catch and handle exceptions, logging them for traceability.
Implement unit and integration tests for robustness.
After implementation, consider a code review and test the entire application flow in a test environment.
