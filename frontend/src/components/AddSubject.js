import React, { useState } from 'react';
import axios from 'axios';

const AddSubject = ({ onAdd }) => {
  const [subjectID, setsubjectID] = useState('');
  const [subjectName, setsubjectName] = useState('');
  const [description, setDescription] = useState('');

  const handleSubmit = async event => {
    event.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/subjects', {
        subjectID,
        subjectName,
        description
      });
      onAdd(response.data);
      setsubjectID('');
      setsubjectName('');
      setDescription('');
    } catch (error) {
      console.error('Error adding subject:', error);
    }
  };

  return (
    <div>
      <h2>Add Student</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          placeholder="Subject ID"
          value={subjectID}
          onChange={event => setsubjectID(event.target.value)}
        />
        <input
          type="text"
          placeholder="Subject Name"
          value={subjectName}
          onChange={event => setsubjectName(event.target.value)}
        />
        <input
          type="text"
          placeholder="Description"
          value={description}
          onChange={event => setDescription(event.target.value)}
        />
        <button type="submit">Add</button>
      </form>
    </div>
  );
};

export default AddSubject;
