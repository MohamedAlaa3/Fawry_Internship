# Hospital System API - Java Spring Boot Project

This Java Spring Boot project is a healthcare system that provides RESTful APIs for managing hospitals, doctors, patients, and drug prescriptions. The system allows hospitals to employ multiple doctors, assigns each patient to a specific doctor, tracks drug prescriptions for patients, and manages patient records.

<img width="619" alt="Screenshot 2023-09-26 at 2 47 01 PM" src="https://github.com/MohamedAlaa3/Fawry_Internship/assets/93541421/48fda3de-a609-4bce-a6c4-90b5aac1a352">



## Features

- Create, read, update, and delete hospitals.
- Create, read, update, and delete doctors.
- Assign patients to doctors.
- Record drug prescriptions for patients.
- Retrieve patient records and medication history.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Maven (for dependency management)
- RESTful API architecture

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (Java 8).
- Maven installed.
- Your preferred IDE (e.g., IntelliJ IDEA, Eclipse) with Spring Boot support.

## API Endpoints

### Hospitals

- **Retrieve All Hospitals**
   - HTTP Method: GET
   - Endpoint: `/api/v1/hospital`
   - Description: Retrieve a list of all hospitals.
   - Example Request: `GET /api/v1/hospital`
   - Example Response: A JSON array containing a list of hospitals.

- **Retrieve Hospital by ID**
   - HTTP Method: GET
   - Endpoint: `/api/v1/hospital/{id}`
   - Description: Retrieve a specific hospital by its ID.
   - Example Request: `GET /api/v1/hospital/1`
   - Example Response: A JSON object representing the hospital with the specified ID.

- **Delete Hospital by ID**
   - HTTP Method: DELETE
   - Endpoint: `/api/v1/hospital/delete/{id}`
   - Description: Delete a hospital by its ID.
   - Example Request: `DELETE /api/v1/hospital/delete/1`
   - Example Response: No content (204 status code) if the hospital is successfully deleted.

- **Update Hospital Name by ID**
   - HTTP Method: PUT
   - Endpoint: `/api/v1/hospital/{id}/updateName`
   - Description: Update the name of a hospital by its ID. The new name should be provided in the request body as a JSON string.
   - Example Request:
     - HTTP Method: PUT
     - Endpoint: `/api/v1/hospital/1/updateName`
     - Request Body: `{ "newName": "New Hospital Name" }`
   - Example Response: A JSON object representing the updated hospital.

- **Add Hospital**
   - HTTP Method: POST
   - Endpoint: `/api/v1/hospital/add`
   - Description: Create a new hospital. The hospital details should be provided in the request body as a JSON object.
   - Example Request:
     - HTTP Method: POST
     - Endpoint: `/api/v1/hospital/add`
     - Request Body:
       ```json
       {
           "name": "New Hospital",
           // Other hospital properties
       }
       ```
   - Example Response: No content (201 status code) if the hospital is successfully created.

### Doctors

- **Retrieve All Doctors**
   - HTTP Method: GET
   - Endpoint: `/api/v1/doctor`
   - Description: Retrieve a list of all doctors.
   - Example Request: `GET /api/v1/doctor`
   - Example Response: A JSON array containing a list of doctors.

- **Retrieve Doctor by ID**
   - HTTP Method: GET
   - Endpoint: `/api/v1/doctor/{id}`
   - Description: Retrieve a specific doctor by their ID.
   - Example Request: `GET /api/v1/doctor/1`
   - Example Response: A JSON object representing the doctor with the specified ID.

- **Delete Doctor by ID**
   - HTTP Method: DELETE
   - Endpoint: `/api/v1/doctor/delete/{id}`
   - Description: Delete a doctor by their ID.
   - Example Request: `DELETE /api/v1/doctor/delete/1`
   - Example Response: No content (204 status code) if the doctor is successfully deleted.

- **Update Doctor's Name by ID**
   - HTTP Method: PUT
   - Endpoint: `/api/v1/doctor/{id}/updateName`
   - Description: Update the name of a doctor by their ID. The new name should be provided in the request body as a JSON string.
   - Example Request:
     - HTTP Method: PUT
     - Endpoint: `/api/v1/doctor/1/updateName`
     - Request Body: `{ "newName": "Dr. New Name" }`
   - Example Response: A JSON object representing the updated doctor.

- **Add New Doctor**
   - HTTP Method: POST
   - Endpoint: `/api/v1/doctor/add`
   - Description: Create a new doctor. The doctor's details should be provided in the request body as a JSON object.
   - Example Request:
     - HTTP Method: POST
     - Endpoint: `/api/v1/doctor/add`
     - Request Body:
       ```json
       {
           "name": "Dr. John Doe",
           // Other doctor properties
       }
       ```
   - Example Response: No content (201 status code) if the doctor is successfully created.

These endpoints allow you to perform CRUD (Create, Read, Update, Delete) operations on hospital and doctor entities in your system. You can adapt these endpoints as needed for your application's requirements and add error handling and validation as necessary.

## How to Run

1. Clone this repository to your local machine.
2. Open the project in your preferred IDE.
3. Build the project using Maven.
4. Run the application.

## Usage

You can use your preferred API client (e.g., Postman) to interact with the endpoints and manage hospitals, doctors, patients, and drug prescriptions.


## Acknowledgments

- Special thanks to the Spring Boot and Java communities for their excellent resources and documentation.

## Contact

If you have any questions or suggestions, please feel free to [contact us](mailto:mohamed.mohamed32@msa.edu.eg).

Enjoy using the Healthcare System API!
