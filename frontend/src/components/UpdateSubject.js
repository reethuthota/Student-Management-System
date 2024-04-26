import React, { useState } from 'react';
import axios from 'axios';

const UpdateSubject = () => {
  const [id, setId] = useState('');
  const [updateSubjectName, setUpdateSubjectName] = useState(false);
  const [updateDescription, setUpdateDescription] = useState(false);
  const [newSubjectName, setNewSubjectName] = useState('');
  const [newDescription, setNewDescription] = useState('');

  const handleSubmit = async event => {
    event.preventDefault();
    try {
      const updates = {};
      if (updateSubjectName) updates.subjectName = newSubjectName;
      if (updateDescription) updates.description = newDescription;
      
      const response = await axios.put(`http://localhost:8080/subjects/${id}`, updates);

      console.log('Updated subject:', response.data);
      // Add any additional logic you want to perform after updating the subject
    } catch (error) {
      console.error('Error updating subject:', error);
    }
  };

  return (
    <div>
      <h2>Update Subject</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Enter subject ID"
          value={id}
          onChange={event => setId(event.target.value)}
          required
        />
        <div>
          <label>
            <input
              type="checkbox"
              checked={updateSubjectName}
              onChange={() => setUpdateSubjectName(!updateSubjectName)}
            />
            Update Subject Name
          </label>
          {updateSubjectName && (
            <input
              type="text"
              placeholder="Enter new subject name"
              value={newSubjectName}
              onChange={event => setNewSubjectName(event.target.value)}
            />
          )}
        </div>
        <div>
          <label>
            <input
              type="checkbox"
              checked={updateDescription}
              onChange={() => setUpdateDescription(!updateDescription)}
            />
            Update Description
          </label>
          {updateDescription && (
            <input
              type="text"
              placeholder="Enter new description"
              value={newDescription}
              onChange={event => setNewDescription(event.target.value)}
            />
          )}
        </div>
        <button type="submit">Update Subject</button>
      </form>
    </div>
  );
};

export default UpdateSubject;
