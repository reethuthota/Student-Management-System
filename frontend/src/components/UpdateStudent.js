import React, { useState } from 'react';
import axios from 'axios';

const UpdateStudent = () => {
  const [id, setId] = useState('');
  const [updateFirstName, setUpdateFirstName] = useState(false);
  const [updateLastName, setUpdateLastName] = useState(false);
  const [updateEmail, setUpdateEmail] = useState(false);
  const [updateDob, setUpdateDob] = useState(false);
  const [updateAge, setUpdateAge] = useState(false);
  const [newFirstName, setNewFirstName] = useState('');
  const [newLastName, setNewLastName] = useState('');
  const [newEmail, setNewEmail] = useState('');
  const [newDob, setNewDob] = useState('');
  const [newAge, setNewAge] = useState('');

  const handleSubmit = async event => {
    event.preventDefault();
    try {
      const updates = {};
      if (updateFirstName) updates.firstName = newFirstName;
      if (updateLastName) updates.lastName = newLastName;
      if (updateEmail) updates.email = newEmail;
      if (updateDob) updates.dob = newDob;
      if (updateAge) updates.age = newAge;
      
      const response = await axios.put(`http://localhost:8080/students/${id}`, updates);

      console.log('Updated student:', response.data);
      // Add any additional logic you want to perform after updating the student
    } catch (error) {
      console.error('Error updating student:', error);
    }
  };

  return (
    <div>
      <h2>Update Student</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Enter student ID"
          value={id}
          onChange={event => setId(event.target.value)}
          required
        />
        <div>
          <label>
            <input
              type="checkbox"
              checked={updateFirstName}
              onChange={() => setUpdateFirstName(!updateFirstName)}
            />
            Update First Name
          </label>
          {updateFirstName && (
            <input
              type="text"
              placeholder="Enter new first name"
              value={newFirstName}
              onChange={event => setNewFirstName(event.target.value)}
            />
          )}
        </div>
        <div>
          <label>
            <input
              type="checkbox"
              checked={updateLastName}
              onChange={() => setUpdateLastName(!updateLastName)}
            />
            Update Last Name
          </label>
          {updateLastName && (
            <input
              type="text"
              placeholder="Enter new last name"
              value={newLastName}
              onChange={event => setNewLastName(event.target.value)}
            />
          )}
        </div>
        <div>
          <label>
            <input
              type="checkbox"
              checked={updateEmail}
              onChange={() => setUpdateEmail(!updateEmail)}
            />
            Update Email
          </label>
          {updateEmail && (
            <input
              type="email"
              placeholder="Enter new email"
              value={newEmail}
              onChange={event => setNewEmail(event.target.value)}
            />
          )}
        </div>
        <div>
          <label>
            <input
              type="checkbox"
              checked={updateDob}
              onChange={() => setUpdateDob(!updateDob)}
            />
            Update Date of Birth
          </label>
          {updateDob && (
            <input
              type="date"
              placeholder="Enter new date of birth"
              value={newDob}
              onChange={event => setNewDob(event.target.value)}
            />
          )}
        </div>
        <div>
          <label>
            <input
              type="checkbox"
              checked={updateAge}
              onChange={() => setUpdateAge(!updateAge)}
            />
            Update Age
          </label>
          {updateAge && (
            <input
              type="number"
              placeholder="Enter new age"
              value={newAge}
              onChange={event => setNewAge(event.target.value)}
            />
          )}
        </div>
        <button type="submit">Update Student</button>
      </form>
    </div>
  );
};

export default UpdateStudent;
