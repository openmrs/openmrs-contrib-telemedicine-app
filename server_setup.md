# Server Setup for creating a low privilege user
#### Aim is to create such a user role that has the minimum privileges required to create a patient via an API call only.
Please follow the steps listed below in order
1. Log in to the server as a user with administrative permissions.
2. Go to System Adimistration -> Advanced Administartion.
3. Under the Users section open Manage Roles -> Add Role.
4. A form appears which asks for the following entries. Fill them with the provided values <br>
     
     * **Role**         :  telemedicine low privilege user
     * **Description**  :  a low privilege role that can only register patients via API calls
     * **Inherited Roles** : leave all boxes unchecked
     * **Privileges** : Check the privileges listed below
         * Add Patients
         * App: patient list
         * Get Patients
 5. Now the user role has been created. We just need to create a User with this user role.
 6. Repeat steps 1 and 2.
 7. Under Users section open Manage Users -> Add User.
 8. Click the next button under the create person heading.
 9. Fill the Demographic Info section as per your choice.
 10. Leave the add as a Provider checkbox unchecked.
 11. Choose any set of credentials for user login purpose.
 12. Check the role you just created above and click Save User.
 13. Log out and log in again, but with these credentials, just to check if the user was created successfully.
 
 The user you just created is a user that has only the privilege of registering a patient via API calls. 
 You can use these credentials in your web or mobile client for API authentication purpose. 
