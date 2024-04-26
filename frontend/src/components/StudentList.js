import React, { useState, useEffect } from 'react';
import axios from 'axios';

const StudentList = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    try {
      console.log("Fetching students...");
      const response = await axios.get('http://localhost:8080/students');
      console.log("Received response:", response);
      const responseData = response.data;
      console.log("Data received:", responseData);
      setStudents(responseData);
      console.log("Got the students:", responseData);
    } catch (error) {
      console.error('Error fetching students:', error);
    }
  };

  return (
    <div>
      <h2>Student List</h2>
      <ul>
        {students.map(student => (
          <li key={student.usn}>
            USN: {student.usn} <br />
            First Name: {student.firstName !== null ? student.firstName : 'null'} <br />
            Last Name: {student.lastName !== null ? student.lastName : 'null'} <br />
            Email: {student.email !== null ? student.email : 'null'} <br />
            DOB: {student.dob !== null ? student.dob : 'null'} <br />
            Age: {student.age !== null ? student.age : 'null'}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default StudentList;
