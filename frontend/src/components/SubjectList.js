// SubjectList.js

import React, { useState, useEffect } from 'react';
import axios from 'axios';

const SubjectList = () => {
  const [subjects, setSubjects] = useState([]);

  useEffect(() => {
    fetchSubjects();
  }, []);

  const fetchSubjects = async () => {
    try {
      console.log("Fetching subjects...");
      const response = await axios.get('http://localhost:8080/subjects/');
      console.log("Received response:", response);
      const responseData = response.data;
      console.log("Data received:", responseData);
      setSubjects(responseData);
      console.log("Got the subjects:", responseData);
    } catch (error) {
      console.error('Error fetching subjects:', error);
    }
  };

  return (
    <div>
      <h2>Subject List</h2>
      <ul>
        {subjects.map(subject => (
          <li key={subject.subjectID}>
            Subject ID: {subject.subjectID} <br />
            Subject Name: {subject.subjectName !== null ? subject.subjectName : 'null'} <br />
            Description: {subject.description !== null ? subject.description : 'null'}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default SubjectList;
